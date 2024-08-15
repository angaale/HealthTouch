package com.golenyaeva.healthtouch.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.golenyaeva.healthtouch.data.local.entity.UserEntity

@Dao
interface UserDao {

    @Insert
    fun insert(vararg user: UserEntity)

    @Query("SELECT * FROM ${UserEntity.TABLE_NAME}")
    fun get(): UserEntity?
}
