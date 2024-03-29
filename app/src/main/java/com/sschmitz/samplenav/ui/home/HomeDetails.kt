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
fun HomeDetails(
  toExtraDetails: () -> Unit,
  modifier: Modifier
) {
  Column(modifier = modifier) {
    Text(
      text = stringResource(id = R.string.home_details_title),
      style = MaterialTheme.typography.headlineMedium
    )

    Spacer(modifier = Modifier.height(24.dp))

    Button(onClick = toExtraDetails ) {
      Text(text = stringResource(id = R.string.home_details_to_extra_details))
    }
  }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewHomeDetails() {
  SamplenavTheme {
    HomeDetails(
      toExtraDetails = {},
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    )
  }
}
