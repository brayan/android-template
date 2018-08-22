package br.com.sailboat.template.data.dao

import android.arch.persistence.room.*
import br.com.sailboat.template.data.model.EntityData

@Dao
interface EntityDao {

    @Insert
    fun insert(entity: EntityData): Long

    @Delete
    fun delete(entity: EntityData)

    @Update
    fun update(entity: EntityData)

    @Query("SELECT * FROM Entity")
    fun getAll(): List<EntityData>

    @Query("SELECT * FROM Entity WHERE Entity.id = :entityId")
    fun getEntity(entityId: Long): EntityData
}