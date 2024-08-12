package com.golenyaeva.coreui.kit.cardactivity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.golenyaeva.core_ui.R

sealed class CardActivitiesModel(
    @StringRes open val titleRes: Int,
    @DrawableRes open val image: Int,

    ) {
    data class Yoga(
        @StringRes override val titleRes: Int = R.string.activities_yoga,
        @DrawableRes override val image: Int = R.drawable.ic_yoga,
    ) : CardActivitiesModel(titleRes, image)

    data class Walk(
        @StringRes override val titleRes: Int = R.string.activities_walk,
        @DrawableRes override val image: Int = R.drawable.ic_walk,
    ) : CardActivitiesModel(titleRes, image)

    data class Run(
        @StringRes override val titleRes: Int = R.string.activities_run,
        @DrawableRes override val image: Int = R.drawable.ic_run,
    ) : CardActivitiesModel(titleRes, image)

    data class Doctor(
        @StringRes override val titleRes: Int = R.string.activities_doctor,
        @DrawableRes override val image: Int = R.drawable.ic_doctor,
    ) : CardActivitiesModel(titleRes, image)

    data class Relax(
        @StringRes override val titleRes: Int = R.string.activities_relax,
        @DrawableRes override val image: Int = R.drawable.ic_relax,
    ) : CardActivitiesModel(titleRes, image)

    data class Stress(
        @StringRes override val titleRes: Int = R.string.activities_stress,
        @DrawableRes override val image: Int = R.drawable.ic_stress,
    ) : CardActivitiesModel(titleRes, image)

    data class Meeting(
        @StringRes override val titleRes: Int = R.string.activities_meeting,
        @DrawableRes override val image: Int = R.drawable.ic_meeting,
    ) : CardActivitiesModel(titleRes, image)

    data class Excitement(
        @StringRes override val titleRes: Int = R.string.activities_excitement,
        @DrawableRes override val image: Int = R.drawable.ic_excitement,
    ) : CardActivitiesModel(titleRes, image)

    data class Cardio(
        @StringRes override val titleRes: Int = R.string.activities_cardio,
        @DrawableRes override val image: Int = R.drawable.ic_cardio,
    ) : CardActivitiesModel(titleRes, image)
}
