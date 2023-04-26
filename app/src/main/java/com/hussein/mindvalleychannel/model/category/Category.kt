package com.hussein.mindvalleychannel.model.category

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class Category(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")val id:Int=0,
    var `data`: Data
)