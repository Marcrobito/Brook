package dev.eighteentech.brook.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun FullWidthRow(
    arrangement: Arrangement.HorizontalOrVertical = Arrangement.Center,
    backgroundColor: Color = Color.Transparent,
    padding:Dp = 4.dp,
    content: @Composable() () -> Unit,
) {
    Row(
        horizontalArrangement = arrangement,
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding)
            .background(backgroundColor)
    ) {
        content()
    }
}

@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
fun FullWidthRowPreview() {
    FullWidthRow {
        LastSyncTitle("Hello")
    }
}