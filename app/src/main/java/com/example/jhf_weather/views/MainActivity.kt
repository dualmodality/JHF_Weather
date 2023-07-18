package com.example.jhf_weather.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jhf_weather.R
import com.example.jhf_weather.viewModels.CurrentConditionsViewModel
import com.example.jhf_weather.ui.theme.JHF_WeatherTheme
import com.example.jhf_weather.ui.theme.PurpleGrey40
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            JHF_WeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "CurrentConditions") {
                        composable(route = "CurrentConditions") {
                            CurrentWeather {
                                navController.navigate(route = "Forecast")
                            }
                        }
                        
                        composable(route = "Forecast") {
                            ForecastList()
                        }
                    }

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrentWeather(viewModel: CurrentConditionsViewModel = hiltViewModel(), navTo: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.titleSmall,
                color = Color(red = 200, green = 200, blue = 200),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)

            ) },
           colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = PurpleGrey40)
        )
        Text(
            text = viewModel.currentConditions.value?.locationName ?: "Nowhere",
            style = MaterialTheme.typography.headlineMedium,
            color = PurpleGrey40,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Column (modifier = Modifier.weight(0.6f)){
                Text(
                    text = viewModel.currentConditions.value?.currentTemp.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth()
                )
                Row(modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()) {
                    Text(
                        text = stringResource(id = R.string.feels_like),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .weight(2f)
                            .padding(4.dp)
                    )
                    Spacer(modifier = Modifier)
                    Text(
                        text = viewModel.currentConditions.value?.feelsLike.toString(),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                    )
                }
            }
            Spacer(modifier = Modifier)
            Image(painter = painterResource(id = R.drawable.sunny),
                contentDescription = stringResource(id = R.string.img_description),
                modifier = Modifier
                    .weight(0.4f)
                    .clip(shape = CircleShape)
                    .size(160.dp)
            )
        }
        Row {
            Text(
                text = stringResource(id = R.string.daily_low),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
            Spacer(modifier = Modifier)
            Text(
                text = viewModel.currentConditions.value?.minTemp.toString(),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
        Row {
            Text(
                text = stringResource(id = R.string.daily_high),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            Spacer(modifier = Modifier)
            Text(
                text = viewModel.currentConditions.value?.maxTemp.toString(),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
        Row {
            Text(
                text = stringResource(id = R.string.humidity),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            Spacer(modifier = Modifier)
            Text(
                text = viewModel.currentConditions.value?.humidity.toString(),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
        }
        Row {
            Text(
                text = stringResource(id = R.string.atmos_pressure),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            Spacer(modifier = Modifier)
            Text(
                text = viewModel.currentConditions.value?.pressure.toString(),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )

        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Center) {
            Spacer(modifier = Modifier)
            Button(onClick = navTo) {
                Text(text = stringResource(id = R.string.button_text))
            }
            Spacer(modifier = Modifier)
        }

    }
}
/*
@Preview(showBackground = true)
@Composable
fun CurrentWeatherPreview() {
    JHF_WeatherTheme {
        CurrentWeather(previewVM.currentConditions) {
        }
    }
}

 */
