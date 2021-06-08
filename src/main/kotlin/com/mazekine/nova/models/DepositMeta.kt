package com.mazekine.nova.models

import com.google.gson.annotations.Expose

data class DepositMeta(
    @Expose val currency: String,
    @Expose val min: String? = null,
    @Expose val max: String? = null,
    @Expose val scale: Int? = null
)
