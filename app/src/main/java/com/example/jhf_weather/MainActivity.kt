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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrentWeather() {
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
            text = stringResource(id = R.string.my_location),
            style = MaterialTheme.typography.headlineMedium,
            color = PurpleGrey40,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Column (modifier = Modifier.weight(0.6f)){
                Text(
                    text = stringResource(id = R.string.current_temp_data),
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
                        text = stringResource(id = R.string.feels_like_data),
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
                text = stringResource(id = R.string.daily_low_data),
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
                text = stringResource(id = R.string.daily_high_data),
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
                text = stringResource(id = R.string.humidity_data),
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
                text = stringResource(id = R.string.atmos_data),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )

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