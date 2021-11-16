package com.useryoo.androidbootcamproombasics.room

import androidx.room.*

@Dao
interface BookcaseDAO {
    @Insert
    fun addBook(book:BookModel)

    @Update
    fun updateBook(book: BookModel)

    @Delete
    fun deleteBook(book: BookModel)

    @Query("SELECT * FROM bookcase")
    fun allBooks():List<BookModel?>
}