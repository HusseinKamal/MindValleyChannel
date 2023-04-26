package com.hussein.mindvalleychannel.model.channel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "channel")
data class Channel(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")val id:Int=0,
    var `data`: Data
)