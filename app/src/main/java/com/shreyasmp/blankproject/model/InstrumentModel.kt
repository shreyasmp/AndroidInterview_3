package com.shreyasmp.blankproject.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InstrumentModel(
    val id: String? = null,
    val name: String? = null,
    val ticker: String? = null,
    val instrument_type: String? = null,
    val current_price: Double,
    val previous_price: Double,
    val description: String? = null
): Parcelable
