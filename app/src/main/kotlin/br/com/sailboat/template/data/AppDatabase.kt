package br.com.sailboat.template.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.sailboat.template.data.dao.EntityDao
import br.com.sailboat.template.data.model.EntityData

@Database(entities = [(EntityData::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        val DATABASE_NAME = "database.db"
    }

    abstract fun entityDao(): EntityDao

}