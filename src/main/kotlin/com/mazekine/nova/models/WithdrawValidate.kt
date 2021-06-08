package com.mazekine.nova.models

import com.google.gson.annotations.Expose

/**
 * This method allows you to check the validity of the address in the blockchain network at the indicated cryptocurrency.
 *
 * @property blockchainAddress Blockchain address
 * @property currency Currency identifier or ticker. Can contain more than 3 letters
 */
data class WithdrawValidate(
    @Expose val blockchainAddress: String,
    @Expose val currency: String
)
