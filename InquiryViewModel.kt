package com.example.prelim.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InquiryViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Inquiry>>
    private val repository: InquiryRepository

    init {
        val inquiryDao = InquiryDatabase.getDatabase(application).inquiryDao()
        repository = InquiryRepository(inquiryDao)
        readAllData = repository.readAllData
    }

    fun addInquiry(inquiries: Inquiry){
        viewModelScope.launch(Dispatchers.IO){
            repository.addInquiry(inquiries)
        }
    }
}