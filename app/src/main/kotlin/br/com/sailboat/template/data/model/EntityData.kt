package br.com.sailboat.template.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName = "Entity")
data class EntityData(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @NonNull val name: String,
    @NonNull val description: String,
    val quantity: Int,
    val price: Double,
    val enabled: Boolean,
    val dateTime: String
)