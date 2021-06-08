package com.mazekine.nova.models

import com.google.gson.annotations.Expose

/**
 * Output model from sendTransfer method
 *
 * @property id Id of transaction. UUID ver. 4 rfc
 */
data class InternalTransaction(
    @Expose val id: String
)
