package com.example.prelim.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Inquiry::class], version = 1, exportSchema = false)
abstract class InquiryDatabase: RoomDatabase() {

    abstract fun inquiryDao(): InquiryDao

    companion object{
        @Volatile
        private var INSTANCE: InquiryDatabase? = null

        fun getDatabase(context: Context): InquiryDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InquiryDatabase::class.java,
                    "inquiry_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}