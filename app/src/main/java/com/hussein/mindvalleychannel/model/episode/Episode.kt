package com.hussein.mindvalleychannel.model.episode

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "episode")
data class Episode(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")val id:Int=0,
    var `data`: Data
)