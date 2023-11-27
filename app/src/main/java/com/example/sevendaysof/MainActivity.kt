package com.example.sevendaysof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sevendaysof.ui.theme.SevenDaysOfTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import com.example.sevendaysof.data.Animal
import com.example.sevendaysof.data.AnimalData

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SevenDaysOfTheme {
                  Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnimalList()
                }
            }
        }
    }
}
@Composable
fun AnimalList() {
    val animals = AnimalData.animals

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(animals) { animal ->
            AnimalCard(animal)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalCard(animal: Animal) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        onClick = { /* Handle card click */ }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Image(
                painter = painterResource(id = animal.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = MaterialTheme.shapes.medium)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                // Display the name from the resource ID
                Text(
                    text = stringResource(id = animal.nameResourceId),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Display the tip
                Text(
                    text = stringResource(id = animal.tipResourceId),
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AnimalListPreview() {
    SevenDaysOfTheme {

        AnimalList()
    }
}

@Preview(showBackground = true)
@Composable
fun AnimalCardPreview() {
    SevenDaysOfTheme  {
        AnimalCard(Animal(R.string.cat, R.drawable.guineapig, R.string.cat_tip))
    }
}
