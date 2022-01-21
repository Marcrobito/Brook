package dev.eighteentech.brook.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LastSyncTitle(date: String = "") {
    FullWidthRow{
        Text(text = "Last Google Fit Sync: $date", color = Color.White)
    }
}

@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
fun LastSyncTitlePreview() {
    LastSyncTitle("Hello")
}