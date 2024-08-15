package com.golenyaeva.healthtouch.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.golenyaeva.healthtouch.data.local.dao.UserDao
import com.golenyaeva.healthtouch.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
