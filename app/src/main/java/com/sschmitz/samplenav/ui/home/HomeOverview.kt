package com.sschmitz.samplenav.ui.home

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
import com.sschmitz.samplenav.ui.theme.SamplenavTheme

@Composable
fun HomeOverview(
  toDetails: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(modifier = modifier) {
    Text(
      text = stringResource(id = R.string.home_overview_title),
      style = MaterialTheme.typography.headlineMedium
    )

    Spacer(modifier = Modifier.height(24.dp))

    Button(onClick = toDetails ) {
      Text(text = stringResource(id = R.string.home_overview_to_home_details))
    }
  }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewHomeOverview() {
  SamplenavTheme {
    HomeOverview(
      toDetails = {},
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    )
  }
}
