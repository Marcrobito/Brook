package dev.eighteentech.brook.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.eighteentech.brook.MainViewModel
import dev.eighteentech.brook.R
import dev.eighteentech.brook.entities.FitResult
import dev.eighteentech.brook.entities.FitResult.*
import dev.eighteentech.brook.entities.PressureMeasure
import dev.eighteentech.brook.ui.components.BasicContainer
import dev.eighteentech.brook.ui.components.FullWidthButton
import dev.eighteentech.brook.ui.components.ItemListView
import dev.eighteentech.brook.ui.components.LastSyncTitle
import dev.eighteentech.brook.ui.theme.BrookTheme

@Composable
fun MainView(viewModel: MainViewModel, onClick: () -> Unit) {
    BrookTheme {

        val isNotButtonVisible =
            rememberUpdatedState(viewModel.isPermissionGranted.collectAsState().value)
        val result =
            rememberUpdatedState(viewModel.bloodPressureResult.collectAsState().value)
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
                //ItemListView(content = measureList)
                BloodPressureContent(result.value)
                if (!isNotButtonVisible.value)
                    FullWidthButton(onClick = onClick)
            }
        }
    }
}


@Composable
fun BloodPressureContent(fitResult: FitResult<List<PressureMeasure>>) {
    when (fitResult) {
        is Loading -> BasicContainer {
            CircularProgressIndicator()
        }
        is Fail -> BasicContainer {
            Text(
                text = fitResult.exception.message ?: "Error",
                color = Color.Red,
                fontSize = 18.sp
            )
        }
        is Success -> ItemListView(content = fitResult.data)
        else -> BasicContainer {
            Text(
                text = "Waiting for data",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}

val measureList =
    listOf(
        PressureMeasure(120.0f, 80.0f, 1642674077000),
        PressureMeasure(125.0f, 80.0f, 1642674077000)
    )


@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
fun MainViewPreview() {
    BrookTheme {

        val isButtonVisible =
            rememberUpdatedState(false)
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
                FullWidthButton(onClick = { })
            }
        }
    }
}