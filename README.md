# Sample Comple Navigation Error

### Project Created to Demo Issue for [Bug Ticket 247860930](https://issuetracker.google.com/issues/247860930)

_____

This project demonstrates a bug in the current Android Compose Navigation library. When attempting to navigate into a different nested graph from a `BottomNavigationItem` the entire tab will become useless.

To create the issue.

1. Switch to the Settings Tab
1. Tap Home Details
1. Verify that the screen changes successfully to the Home Details and the bottom navigation updates as well
1. Verify that the Settings Tab no longer does anything when pressed

The workaround appears to be setting `restoreState = false` despite all of the documentation listing setting it to `true`

