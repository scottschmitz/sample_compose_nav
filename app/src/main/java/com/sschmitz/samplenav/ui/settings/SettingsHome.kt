package com.sschmitz.samplenav.ui.settings

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sschmitz.samplenav.R
import com.sschmitz.samplenav.ui.Route
import com.sschmitz.samplenav.ui.ext.switchTabs
import com.sschmitz.samplenav.ui.theme.SamplenavTheme

@Composable
fun SettingsHome(
  toSettingsDetails: () -> Unit,
  toHomeDetailsBroken: () -> Unit,
  toHomeDetailsFixed: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(modifier = modifier) {
    Text(
      text = stringResource(id = R.string.settings_overview_title),
      style = MaterialTheme.typography.headlineMedium
    )

    Spacer(modifier = Modifier.height(24.dp))

    Button(onClick = toSettingsDetails) {
      Text(text = stringResource(id = R.string.settings_overview_to_settings_details))
    }

    Spacer(modifier = Modifier.height(8.dp))

    Button(onClick = toHomeDetailsBroken) {
      Text(text = stringResource(id = R.string.settings_overview_to_home_details_broken))
    }

    Spacer(modifier = Modifier.height(8.dp))

    Button(onClick = toHomeDetailsFixed) {
      Text(text = stringResource(id = R.string.settings_overview_to_home_details_fixed))
    }
  }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewSettingsHome() {
  SamplenavTheme {
    SettingsHome(
      toSettingsDetails = { },
      toHomeDetailsBroken = { },
      toHomeDetailsFixed = { },
      modifier = Modifier.fillMaxSize().padding(16.dp)
    )
  }
}
