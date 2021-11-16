package com.useryoo.androidbootcamproombasics.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookcase")
data class BookModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int=0,

    @ColumnInfo(name = "book name")
    var bookName:String,

    @ColumnInfo(name = "author")
    var author:String
){

}
