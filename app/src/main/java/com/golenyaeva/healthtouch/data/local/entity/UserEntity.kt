package com.golenyaeva.healthtouch.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.golenyaeva.healthtouch.data.local.entity.UserEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME, primaryKeys = ["first_name", "last_name"])
data class UserEntity(
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "height") val height: Int,
    @ColumnInfo(name = "weight") val weight: Int,
) {
    companion object {
        const val TABLE_NAME = "user"
    }
}
