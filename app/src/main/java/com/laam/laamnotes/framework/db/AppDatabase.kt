package com.laam.laamnotes.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.laam.laamnotes.framework.db.dao.ImageDao
import com.laam.laamnotes.framework.db.dao.NoteDao
import com.laam.laamnotes.framework.db.entity.ImageEntity
import com.laam.laamnotes.framework.db.entity.NoteEntity

@Database(entities = [NoteEntity::class, ImageEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "note.db"

        fun create(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

    abstract fun noteDao(): NoteDao
    abstract fun imageDao(): ImageDao
}