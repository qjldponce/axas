package com.example.prelim.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface InquiryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addInquiry(inquiry: Inquiry)

    @Query("SELECT * FROM inquiry_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Inquiry>>
}