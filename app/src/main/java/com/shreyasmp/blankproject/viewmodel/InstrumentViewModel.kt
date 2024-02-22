package com.shreyasmp.blankproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shreyasmp.blankproject.model.InstrumentModel
import com.shreyasmp.blankproject.respository.InstrumentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InstrumentViewModel(private val repository: InstrumentRepository) : ViewModel() {

    private val _instrumentList: MutableLiveData<List<InstrumentModel>> = MutableLiveData()
    val instrumentList: LiveData<List<InstrumentModel>> = _instrumentList

    init {
        fetchInstrumentList()
    }

    private fun fetchInstrumentList() {

        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                repository.getInstruments()
            }
            _instrumentList.value = result?.value
        }
    }
}