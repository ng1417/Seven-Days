package com.example.sevendaysof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.sevendaysof.data.Animal
import com.example.sevendaysof.data.AnimalData
import com.example.sevendaysof.data.AnimalData.animals
import com.example.sevendaysof.ui.theme.SevenDaysOfTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SevenDaysOfTheme {
                  Surface(
                    modifier = Modifier.fillMaxSize(),
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
fun AnimalCard(
    animal: Animal,
    modifier: Modifier = Modifier
) {
    var isCardClicked by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { isCardClicked = !isCardClicked },

       // onClick = { /* Handle card click */ }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            ) {
                AnimalIcon(animal.imageResourceId, animal.descriptionId)

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            dimensionResource(R.dimen.padding_small))
                                .animateContentSize(animationSpec = spring(
                                    dampingRatio = Spring.DampingRatioHighBouncy,
                                    stiffness = Spring.StiffnessMediumLow
                                )
                        ),
                ) {
                    AnimalNames(animal.nameResourceId)

                    Spacer(modifier = Modifier.height(4.dp))

                    if (isCardClicked) {
                        AnimalTips(
                            animal.tipResourceId,
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AnimalIcon(
    @DrawableRes imageResourceId: Int,
    @StringRes descriptionId: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .clip(MaterialTheme.shapes.medium),
        contentScale = ContentScale.Crop,
        painter = painterResource(imageResourceId),
        contentDescription = stringResource(descriptionId),
    )
}

@Composable
fun AnimalNames(
    @StringRes nameResourceId: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(nameResourceId),
        style = MaterialTheme.typography.headlineLarge
    )
}

@Composable
fun AnimalTips(
    @StringRes tipResourceId: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(tipResourceId),
            style = MaterialTheme.typography.bodyLarge
        )
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
//                Image(
//                    modifier = Modifier
//                        .size(dimensionResource(R.dimen.image_size))
//                        .padding(dimensionResource(R.dimen.padding_small)),
////                    painter = painterResource(R.drawable.ic_woof_logo),
////                    contentDescription = null
//                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayMedium
                )
            }
        },
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AnimalListPreview() {
    SevenDaysOfTheme(useDarkTheme = false){
        SevenDaysApp()
    }
}
