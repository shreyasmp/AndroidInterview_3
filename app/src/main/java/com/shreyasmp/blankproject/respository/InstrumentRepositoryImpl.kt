package com.shreyasmp.blankproject.respository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shreyasmp.blankproject.model.InstrumentModel
import com.shreyasmp.blankproject.service.Service

interface InstrumentRepository {
    suspend fun getInstruments(): LiveData<List<InstrumentModel>>?
}

class InstrumentRepositoryImpl(private val service: Service) : InstrumentRepository {

    override suspend fun getInstruments(): LiveData<List<InstrumentModel>>? {
        val instrumentList = MutableLiveData<List<InstrumentModel>>()
        return try {
            val results = service.getInstruments()
            if (results.isSuccessful && results.body() != null) {
                instrumentList.postValue(results.body())
                return instrumentList
            } else {
                return null
            }
        } catch (exc: Exception) {
            return null;
        }
    }
}