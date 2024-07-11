package com.golenyaeva.healthtouch.screen.homescreen

sealed class MeasureUiModel(
    open val value: Int,
) {
    data class BPM(override val value: Int) : MeasureUiModel(value)

    data class HRV(override val value: Int) : MeasureUiModel(value)
}
