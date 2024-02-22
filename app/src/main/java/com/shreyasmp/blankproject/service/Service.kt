package com.shreyasmp.blankproject.service

import com.shreyasmp.blankproject.model.InstrumentModel
import retrofit2.Response
import retrofit2.http.GET

interface Service {

    @GET("dns-mcdaid/b248c852b743ad960616bac50409f0f0/raw/6921812bfb76c1bea7868385adf62b7f447048ce/instruments.json")
    suspend fun getInstruments(): Response<List<InstrumentModel>>
}