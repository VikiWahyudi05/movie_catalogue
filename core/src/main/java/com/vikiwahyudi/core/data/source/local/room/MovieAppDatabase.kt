package com.vikiwahyudi.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [com.vikiwahyudi.core.data.source.local.entity.MovieEntity::class, com.vikiwahyudi.core.data.source.local.entity.TvShowEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MovieAppDatabase : RoomDatabase() {
    abstract fun movieDBAppDao(): com.vikiwahyudi.core.data.source.local.room.MovieDBAppDao
}