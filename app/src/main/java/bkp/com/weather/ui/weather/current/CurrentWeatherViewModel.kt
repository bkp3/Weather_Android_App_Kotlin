package bkp.com.weather.ui.weather.current

import androidx.lifecycle.ViewModel
import bkp.com.weather.data.provider.UnitProvider
import bkp.com.weather.data.repository.ForecastRepository
import bkp.com.weather.internal.UnitSystem
import bkp.com.weather.internal.lazyDeferred
import bkp.com.weather.ui.base.WeatherViewModel

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(super.isMetricUnit)
    }
}