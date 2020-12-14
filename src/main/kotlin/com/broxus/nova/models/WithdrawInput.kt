package com.broxus.nova.models

import com.google.gson.annotations.Expose

/**
 * This method allows you to create a withdrawal request for a specific user.
 *
 * @property id Id of transaction. UUID ver. 4 rfc
 * @property value Amount of currency. Positive floating point number.
 * @property currency Сurrency identifier or ticker. Can contain more than 3 letters.
 * @property userAddress The unique address of the user. Which value to specify the address depends on the addressType. Case sensitive
 * @property addressType User address type. Case sensitive
 * @property workspaceId Id of workspace. UUID ver. 4 rfc
 * @property blockchainAddress Blockchain address
 * @property applicationId Id of application. Random string
 */
data class WithdrawInput(
    @Expose val id: String,
    @Expose val value: String,
    @Expose val currency: String,
    @Expose val userAddress: String,
    @Expose val addressType: String,
    @Expose val workspaceId: String? = null,
    @Expose val blockchainAddress: String,
    @Expose val applicationId: String? = null
)
