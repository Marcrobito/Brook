package dev.eighteentech.brook.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.eighteentech.brook.R
import dev.eighteentech.brook.entities.PressureMeasure
import dev.eighteentech.brook.ui.components.FullWidthButton
import dev.eighteentech.brook.ui.components.ItemListView
import dev.eighteentech.brook.ui.components.LastSyncTitle
import dev.eighteentech.brook.ui.theme.BrookTheme

@Composable
fun MainView() {
    BrookTheme {
        // A surface container using the 'background' color from the theme
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.bg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                LastSyncTitle()
                ItemListView(content = measureList)
                FullWidthButton()
            }
        }
    }
}

val measureList =
    listOf(
        PressureMeasure(120.0, 80.0, 1642674077000),
        PressureMeasure(125.0, 80.0, 1642674077000))


@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
fun MainViewPreview() {
    MainView()
}