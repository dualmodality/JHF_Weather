package com.example.jhf_weather

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jhf_weather.ui.theme.PurpleGrey40
import java.time.Instant
import java.time.Instant.ofEpochSecond
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.TimeZone

val ForecastItems: List<DayForecast> = listOf(
    DayForecast(1687899840, 1687860000, 1687903200, ForecastTemp(74F, 60F, 80F), 998F, 63),
    DayForecast(1687924800, 1687946700, 1687989300, ForecastTemp(76F, 65F, 78F), 1002F, 73),
    DayForecast(1688011200, 1688030000, 1688070000, ForecastTemp(77F, 62F, 79F), 987F, 75),
    DayForecast(1688159040, 1688170000, 1688210000, ForecastTemp(72F, 70F, 74F), 1010F,83),
    DayForecast(1688245440, 1688260000, 1688300000, ForecastTemp(83F, 76F, 88F), 994F, 74),
    DayForecast(1688331840, 1688350000, 1688390000, ForecastTemp(72F, 61F, 75F), 1025F, 53),
    DayForecast(1688418240, 1688440000, 1688480000, ForecastTemp(74F, 64F, 94F), 993F, 72),
    DayForecast(1688591040, 1688610000, 1688650000, ForecastTemp(83F, 62F, 86F), 1013F, 91),
    DayForecast(1688677440, 1688690000, 1688730000, ForecastTemp(85F, 67F, 88F), 1000F, 42),
    DayForecast(1688763840, 1688780000, 1688820000, ForecastTemp(88F, 78F, 90F), 996F, 55),
    DayForecast(1688850240, 1688870000, 1688910000, ForecastTemp(91F, 87F, 92F), 1017F, 86),
    DayForecast(1688936640, 1688950000, 1688990000, ForecastTemp(63F, 54F, 65F), 897F, 32),
    DayForecast(1689023040, 1689050000, 1689090000, ForecastTemp(65F, 54F, 68F), 993F, 42),
    DayForecast(1689109440, 1689130000, 1689170000, ForecastTemp(73F, 69F, 77F), 1006F, 52),
    DayForecast(1689195840, 1689220000, 1689260000, ForecastTemp(78F, 72F, 79F), 999F, 61),
    DayForecast(1689368640, 1689380000, 1689420000, ForecastTemp(-12F, -32F, 100F), 900F, 69)
)

@Composable
fun ForecastItemView(forecast: DayForecast) {
    val myDateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMM d")
    val myTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("h:mma")
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = R.drawable.sunny),
            contentDescription = stringResource(id = R.string.img_description),
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(64.dp)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = LocalDateTime.ofInstant(Instant.ofEpochSecond(forecast.date), TimeZone.getDefault().toZoneId()).format(myDateFormatter).toString(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.size(8.dp))
        Column(modifier = Modifier) {
            Text(text = (stringResource(id = R.string.temp_label) + forecast.temp.day + stringResource(id = R.string.degF)),
                style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.size(8.dp))
            Row(modifier = Modifier) {
                Text(text = (stringResource(id = R.string.daily_high) + forecast.temp.max + stringResource(id = R.string.degF)),
                style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = (stringResource(id = R.string.daily_low) + forecast.temp.min + stringResource(id = R.string.degF)),
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
fun ForecastList(forecasts: List<DayForecast>) {
    Column {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.button_text),
                    style = MaterialTheme.typography.titleSmall,
                    color = Color(red = 200, green = 200, blue = 200),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)

                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = PurpleGrey40)
        )

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(items = forecasts) { ForecastItemView(forecast = it) }
        }
    }
}

@Preview
@Composable
fun ForecastScreenPreview() {
    ForecastList(forecasts = ForecastItems)
}