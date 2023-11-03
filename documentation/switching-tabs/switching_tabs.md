# Sample Compose Navigation

The standard android compose navigation seems to work well for basic functionality with a `NavigationBar`, but when I wanted to navigate from a screen inside of one `NavigationBarItem` to another it all started to unravel quickly. After several hours of debugging, testing, and retrying, I had a [sample project](https://github.com/scottschmitz/sample_compose_nav), a [bug report](https://issuetracker.google.com/issues/247860930), and a headache.

### So what was the problem?

Navigating from one "tab" to a "route" within another tab was causing havoc. In the gif below you can see that by navigating to Settings -> To Home Details, tapping on the Settings button repeatedly appears to do nothing.

![](./broken.gif)

_(Code for this gif available within the repo at tag: [bug_ticket_created](https://github.com/scottschmitz/sample_compose_nav/tree/bug_ticket_created))_

Well, of course it's not doing nothing, but it sure looks that way. In reality, it is attempting to navigate to the route it's already on. The graph/navigation has become confused and tapping Settings no results in an attempted navigation to `/home/details`, where you just so happen to already be.

### So how did I get into this problem?

In basically every piece of documentation you will likely find this exact setup for adding a `BottomNavigationItem` to your `NavigationBar`.
```
BottomNavigationItem(
  icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
  label = { Text(stringResource(screen.resourceId)) },
  selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
  onClick = {
    navController.navigate(screen.route) {
      // Pop up to the start destination of the graph to
      // avoid building up a large stack of destinations
      // on the back stack as users select items
      popUpTo(navController.graph.findStartDestination().id) {
        saveState = true
      }

      // Avoid multiple copies of the same destination when
      // reselecting the same item
      launchSingleTop = true

      // Restore state when reselecting a previously selected item
      restoreState = true
    }
  }
)
```

Also, in just about every piece of documentation you will see calls like the one below as the implementation for traversing your graph.

```
navController.navigate("home/details")
```

For the most part this all seems to work great. However, when navigating to a route associated with a different `NavigationBarItem` it all starts to unravel.

Notably, the following things will happen:
1. You will notice that the `NavigationBarItem` has successfully transitioned to the `NavigationBarItem` as expected with the highlighting correctly in place. _This is great!_
1. Attempting to navigate back to the origin `NavigationBarItem` will _appear to do nothing. Uh-oh!_
1. Pressing/Gesturing back will pop up in the current `NavigationBarItem` route. _Again, this seems good?_
1. Now, tapping on the origin `NavigationBarItem` will now be usable. _Wait, what!?_

This last step is the part that was confusing me the most. If I removed the screen from the stack, all of my navigation resumed working again. After a while, I thought maybe it was a bug in how the state was being restored. I attempted a workaround - what if my tab just always reset when it was switched to. I modified my logic to set `restoreState = false`. It felt wrong, but it worked as I expected. But knowing that this was not a long term solution, I created the previously mentioned [sample project](https://github.com/scottschmitz/sample_compose_nav), [bug ticket](https://issuetracker.google.com/issues/247860930), and hoped for the best. Fortunately I got a reply quickly, but unfortunately (or fortunately depending on your outlook) they reported that it's not a bug at all.

> If you want to emulate swapping to another tab, make sure to use the exact same flags as your `BottomNav` uses to actually swap from the back stack associated with one tab to the back stack associated with the other tab.

### So how did I fix it?

It was quickly obvious that when I was switching tabs via the `BottomNav`, I was doing a bunch of extra work that wasn't happening when I was attempting to navigate via a button press. Specifically the following flags:
```
// Pop up to the start destination of the graph to
// avoid building up a large stack of destinations
// on the back stack as users select items
popUpTo(navController.graph.findStartDestination().id) {
  saveState = true
}

// Avoid multiple copies of the same destination when
// reselecting the same item
launchSingleTop = true

// Restore state when reselecting a previously selected item
restoreState = true
```

It became clear that all of my arguments needed to be shared as this was likely going to be a common occurrence not only in this app, but probably any other app I write using navigation-compose, so I created an extension on the `NavHostController`. Anytime I intend for my application to switch tabs (and within my `BottomNavigationItem.onClick`) instead of just calling navigate I use the extension `switchTabs(route)`.

```
fun NavHostController.switchTabs(route: String) {
  navigate(route) {
    // Pop up to the start destination of the graph to
    // avoid building up a large stack of destinations
    // on the back stack as users select items
    popUpTo(graph.findStartDestination().id) {
      saveState = true
    }
    // Avoid multiple copies of the same destination when
    // reselecting the same item
    launchSingleTop = true
    // Restore state when reselecting a previously selected item
    restoreState = true
  }
}
```

```
NavigationBarItem(
  ...
  onClick = { navController.switchTabs(tree.route) }
)
```

```
 Button(onClick = { navController.switchTabs(Route.HOME_DETAILS) }) {
  ...
}
```

And, behold! Functioning navigation!

![](./fixed.gif)

[View the sample project on GitHub.](https://github.com/scottschmitz/sample_compose_nav)
