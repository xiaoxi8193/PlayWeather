package com.zj.weather.ui.view.weather.widget

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qweather.sdk.bean.weather.WeatherNowBean
import com.zj.weather.R
import com.zj.weather.room.entity.CityInfo

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HeaderWeather(
    fontSize: TextUnit,
    topPadding: Dp,
    cityInfo: CityInfo,
    weatherNow: WeatherNowBean.NowBaseBean?,
    isLand: Boolean = false
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = topPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "${cityInfo.city} ${cityInfo.name}",
            fontSize = 30.sp,
            color = MaterialTheme.colors.primary
        )

        Text(
            text = "${weatherNow?.text ?: stringResource(id = R.string.default_weather)}  ${weatherNow?.temp ?: "0"}℃",
            modifier = Modifier.padding(top = 5.dp, bottom = 10.dp),
            fontSize = if (isLand) 45.sp else fontSize,
            color = MaterialTheme.colors.primary
        )
    }
}

@Preview(showBackground = false, name = "未收起时的头部")
@Composable
fun HeaderWeatherPreview() {
    val nowBean = WeatherNowBean.NowBaseBean()
    nowBean.text = "多云"
    nowBean.temp = "25"
    HeaderWeather(45.sp, 0.dp, CityInfo(name = "测试"), nowBean)
}