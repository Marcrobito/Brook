package dev.eighteentech.brook.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FullWidthButton(
    onClick: () -> Unit = {}
) {
    FullWidthRow {
        Button(
            onClick = { onClick() },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            contentPadding = PaddingValues(),
        ) {
            Box(
                modifier = Modifier
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color(0xFFFFA02A),
                                Color(0xFFFD6B0B)
                            )
                        )
                    ),
                //.then(modifier),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Enable Google Fit",
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 40.dp, vertical = 24.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
fun FullWidthButtonPreview() {
    FullWidthButton()
}