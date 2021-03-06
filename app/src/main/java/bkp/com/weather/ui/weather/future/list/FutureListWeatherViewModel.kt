package bkp.com.weather.ui.weather.future.list

import androidx.lifecycle.ViewModel
import bkp.com.weather.data.provider.UnitProvider
import bkp.com.weather.data.repository.ForecastRepository
import bkp.com.weather.internal.lazyDeferred
import bkp.com.weather.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureListWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weatherEntries by lazyDeferred {
        forecastRepository.getFutureWeatherList(LocalDate.now(), super.isMetricUnit)
    }
}