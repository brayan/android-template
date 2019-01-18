package br.com.sailboat.template.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import br.com.sailboat.template.data.dao.EntityDao
import br.com.sailboat.template.data.model.EntityData

@Database(entities = [(EntityData::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        val DATABASE_NAME = "database.db"

        fun build(context: Context) : AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME)
                .build()
        }
    }

    abstract fun entityDao(): EntityDao

}