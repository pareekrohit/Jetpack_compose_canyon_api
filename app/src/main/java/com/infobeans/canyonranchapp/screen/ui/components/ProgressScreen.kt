package com.infobeans.canyonranchapp.screen.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.infobeans.canyonranchapp.ui.theme.Chocolate500

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(name = "ProgressScreen")
fun ProgressScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(),
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
            shape = RoundedCornerShape(28.dp),
            containerColor = Color.White
        ) {
            Column(
                modifier = Modifier.padding(40.dp)
            ) {
                CircularProgressIndicator(color = Chocolate500)
            }
        }
    }
}
