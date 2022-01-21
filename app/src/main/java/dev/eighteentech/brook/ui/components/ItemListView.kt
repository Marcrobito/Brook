package dev.eighteentech.brook.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.eighteentech.brook.entities.PressureMeasure

@Composable
fun ItemListView(content: List<PressureMeasure>) {
    LazyColumn(
        //contentPadding = PaddingValues(all = 8.dp),
        modifier= Modifier.fillMaxHeight(0.75f),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(content) { item ->
            BloodPressureItem(item)
        }
    }
}