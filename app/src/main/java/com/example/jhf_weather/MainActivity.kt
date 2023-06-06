package com.example.jhf_weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jhf_weather.ui.theme.JHF_WeatherTheme
import com.example.jhf_weather.ui.theme.PurpleGrey40
import com.example.jhf_weather.ui.theme.PurpleGrey80

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
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.titleSmall,
            color = Color(red = 200, green = 200, blue = 200),
            modifier = Modifier
                .fillMaxWidth()
                .background(PurpleGrey40)
                .padding(8.dp)

        )
        Text(
            text = stringResource(id = R.string.my_location),
            style = MaterialTheme.typography.headlineMedium,
            color = PurpleGrey40,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Column (modifier = Modifier.fillMaxWidth(fraction = 0.6F)){
                Text(
                    text = stringResource(id = R.string.current_temp_data),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                )
                Row(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = stringResource(id = R.string.feels_like),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier)
                    Text(
                        text = stringResource(id = R.string.feels_like_data),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                    )
                }
            }
            Spacer(modifier = Modifier.fillMaxWidth(0.1F))
            Image(painter = painterResource(id = R.drawable.sunny),

                    contentDescription = stringResource(id = R.string.img_description),
                modifier = Modifier.fillMaxWidth()
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