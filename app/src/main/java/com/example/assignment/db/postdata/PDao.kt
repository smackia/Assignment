package com.example.assignment.db.postdata

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assignment.data.model.D
import org.jetbrains.annotations.NotNull

@Dao
interface PDao {

    @NotNull
    @Query("Select * from D")
    fun getPostData(): List<D>?


    @Query("DELETE FROM D")
    fun deleteAll()


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(co: List<D>)

}