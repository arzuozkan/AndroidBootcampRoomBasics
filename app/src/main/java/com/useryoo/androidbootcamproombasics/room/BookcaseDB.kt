package com.useryoo.androidbootcamproombasics.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BookModel::class],version = 1)
abstract class BookcaseDB: RoomDatabase() {
    abstract fun bookcaseDAO():BookcaseDAO

    companion object{
        private var INSTANCE:BookcaseDB? =null
        fun getBookcaseDB(context:Context):BookcaseDB?{
            if(INSTANCE==null){
                INSTANCE= Room.databaseBuilder(
                    context,
                    BookcaseDB::class.java,
                    "bookCase.db").allowMainThreadQueries().build()
            }
            return INSTANCE
        }
    }
}