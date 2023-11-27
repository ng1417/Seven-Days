package com.example.sevendaysof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
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

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.sevendaysof.data.Animal
import com.example.sevendaysof.data.AnimalData
import com.example.sevendaysof.data.AnimalData.animals

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SevenDaysOfTheme {
                  Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                      SevenDaysApp()
                  }
            }
        }
    }
}


@ExperimentalMaterial3Api
@Composable
fun SevenDaysApp() {
    Scaffold(topBar = {
            TopAppBar()
        }) {it ->
        LazyColumn(contentPadding = it) {
          items(animals) {
              AnimalCard(
                  animal = it,
                  modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
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
            .padding(dimensionResource(R.dimen.padding_small))
    ) {
        items(animals) { animal ->
            AnimalCard(animal)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalCard(
    animal: Animal,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),

        onClick = { /* Handle card click */ }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(animal.imageResourceId),
                    contentDescription = null,
                )

                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            dimensionResource(R.dimen.padding_small)
                        ),
                ) {
                    Text(
                        text = stringResource(id = animal.nameResourceId),
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    // Display the tip - haven't got this animated
                    Text(
                        text = stringResource(id = animal.tipResourceId),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small)),
                    painter = painterResource(R.drawable.ic_action_name),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.text_tips_from_animals),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun AnimalListPreview() {
    SevenDaysOfTheme(useDarkTheme = true){

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
