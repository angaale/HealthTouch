package com.golenyaeva.healthtouch.screen.homescreen

sealed class MeasuringUiModel(
    open val value: Int,
) {
    data class BPM(override val value: Int) : MeasuringUiModel(value)

    data class HRV(override val value: Int) : MeasuringUiModel(value)
}
