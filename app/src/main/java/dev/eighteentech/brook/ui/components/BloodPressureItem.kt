package dev.eighteentech.brook.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.eighteentech.brook.R
import dev.eighteentech.brook.entities.PressureMeasure

@Composable
fun BloodPressureItem(measure: PressureMeasure) {
    FullWidthRow(
        arrangement = Arrangement.SpaceEvenly,
        backgroundColor = Color(0x66FFFFFF),
        padding = 0.dp
    ) {
        val textColor = if (!measure.isHighPressure()) Color.White else Color.Red
        Image(
            painter = painterResource(id = R.drawable.ic_blood_pressure),
            contentDescription = null,
            modifier = Modifier
                .width(50.dp)
                .height(50.dp),
            contentScale = ContentScale.Crop,
        )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.height(50.dp),
        ) {
            Text("Sys: ${measure.systolic}", color = textColor, fontWeight = FontWeight.Bold)
            Text("Dia: ${measure.diastolic}", color = textColor, fontWeight = FontWeight.Bold)
        }
        if (!measure.isHighPressure()) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.height(50.dp),
            ) {
                Text(measure.getDate(), color = Color.White)
            }
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.height(50.dp),
            ) {
                Text(measure.getTime(), color = Color.White)
            }
        } else {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.height(50.dp),
            ) {
                Text(measure.getDate(), color = Color.White)
                Text(measure.getTime(), color = Color.White)
            }
            Image(
                painter = painterResource(id = R.drawable.ic_exclamation_sign),
                contentDescription = null,
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
fun BloodPressureItemNormalPreview() {
    val measure = PressureMeasure(120.0, 80.0, 1642674077000)
    BloodPressureItem(measure)
}

@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
fun BloodPressureItemHighPreview() {
    val measure = PressureMeasure(125.0, 80.0, 1642674077000)
    BloodPressureItem(measure)
}