package com.example.jhf_weather.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jhf_weather.R
import com.example.jhf_weather.models.DayForecast
import com.example.jhf_weather.ui.theme.PurpleGrey40
import com.example.jhf_weather.viewModels.ForecastViewModel
import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.TimeZone
import kotlin.math.roundToInt

@Composable
fun ForecastItemView(forecast: DayForecast) {
    val myDateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMM d")
    val myTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("h:mma")
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.weight(0.05f)) {WeatherConditionIcon(url = forecast.weatherIconUrl) }
        Text(text = LocalDateTime.ofInstant(Instant.ofEpochSecond(forecast.date), TimeZone.getDefault().toZoneId()).format(myDateFormatter).toString(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.size(8.dp))
        Column(modifier = Modifier) {
            Text(text = (stringResource(id = R.string.temp_label) + forecast.daytimeTemp.roundToInt() + stringResource(id = R.string.degF)),
                style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.size(8.dp))
            Row(modifier = Modifier) {
                Text(text = (stringResource(id = R.string.daily_high) + forecast.maxTemp.roundToInt() + stringResource(id = R.string.degF)),
                style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = (stringResource(id = R.string.daily_low) + forecast.minTemp.roundToInt() + stringResource(id = R.string.degF)),
                style = MaterialTheme.typography.bodyMedium)
            }
        }
        Spacer(modifier = Modifier.size(8.dp))
        Column(modifier = Modifier) {
            Text(text = (stringResource(id = R.string.sunrise) + LocalDateTime.ofInstant(Instant.ofEpochSecond(forecast.sunrise), TimeZone.getDefault().toZoneId()).format(myTimeFormatter).toString()),
            style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = (stringResource(id = R.string.sunset) + LocalDateTime.ofInstant(Instant.ofEpochSecond(forecast.sunset), TimeZone.getDefault().toZoneId()).format(myTimeFormatter).toString()),
            style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForecastList(viewModel: ForecastViewModel = hiltViewModel(), zip: String?) {

    val forecastZip: State<String> = viewModel.userZip.observeAsState(initial = "55119")


    val multi = viewModel.multiForecast.observeAsState()
    LaunchedEffect(Unit) {
        viewModel.validateZip(zip)
        viewModel.viewAppeared()
    }
    Column {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.button_text) + " for " + forecastZip.value,
                    style = MaterialTheme.typography.titleSmall,
                    color = Color(red = 200, green = 200, blue = 200),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)

                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = PurpleGrey40)
        )

        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp), verticalArrangement = Arrangement.SpaceBetween) {
            items(items = multi.value?.forecastList ?: listOf()) {
                ForecastItemView(forecast = it)
                Spacer(modifier = Modifier.size(12.dp))
            }
        }
    }
}
