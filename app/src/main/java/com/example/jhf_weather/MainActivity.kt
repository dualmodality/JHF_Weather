package com.example.jhf_weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jhf_weather.ui.theme.JHF_WeatherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JHF_WeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CurrentWeather()
                }
            }
        }
    }
}

@Composable
fun CurrentWeather() {
    Column {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier

        )
        Text(
            text = stringResource(id = R.string.my_location),
            modifier = Modifier
        )
        Row {
            Column {
                Text(
                    text = stringResource(id = R.string.current_temp_data),
                    modifier = Modifier
                )
                Row {
                    Text(
                        text = stringResource(id = R.string.feels_like),
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier)
                    Text(
                        text = stringResource(id = R.string.feels_like_data),
                        modifier = Modifier
                    )
                }
            }
            Image(painter = painterResource(id = R.drawable.sunny),
                    contentDescription = stringResource(id = R.string.img_description)
            )
        }
        Row {
            Text(text = stringResource(id = R.string.daily_low))
            Spacer(modifier = Modifier)
            Text(text = stringResource(id = R.string.daily_low_data))
        }
        Row {
            Text(text = stringResource(id = R.string.daily_high))
            Spacer(modifier = Modifier)
            Text(text = stringResource(id = R.string.daily_high_data))
        }
        Row {
            Text(text = stringResource(id = R.string.humidity))
            Spacer(modifier = Modifier)
            Text(text = stringResource(id = R.string.humidity_data))
        }
        Row {
            Text(text = stringResource(id = R.string.atmos_pressure))
            Spacer(modifier = Modifier)
            Text(text = stringResource(id = R.string.atmos_data))

        }

    }
}

@Preview(showBackground = true)
@Composable
fun CurrentWeatherPreview() {
    JHF_WeatherTheme {
        CurrentWeather()
    }
}