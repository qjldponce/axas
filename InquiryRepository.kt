package com.example.prelim.data

import androidx.lifecycle.LiveData

class InquiryRepository(private val inquiryDao: InquiryDao) {

    val readAllData: LiveData<List<Inquiry>> = inquiryDao.readAllData()

    suspend fun addInquiry(inquiries: Inquiry){
        inquiryDao.addInquiry(inquiries)
    }
}