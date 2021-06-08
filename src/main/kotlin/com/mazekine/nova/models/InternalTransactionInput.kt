package com.mazekine.nova.models

import com.google.gson.annotations.Expose

/**
 * The input model for sendTransfer method
 * @property id Id of transaction. UUID ver. 4 rfc
 * @property value Amount of currency. Positive floating point number.
 * @property currency Сurrency identifier or ticker. Can contain more than 3 letters
 * @property fromUserAddress The unique address of the user. Which value to specify the address depends on the addressType. Case sensitive
 * @property fromAddressType User address type. Case sensitive
 * @property fromWorkspaceId Id of workspace. UUID ver. 4 rfc
 * @property toUserAddress The unique address of the user. Which value to specify the address depends on the addressType. Case sensitive
 * @property toAddressType User address type. Case sensitive
 * @property toWorkspaceId Id of workspace. UUID ver. 4 rfc
 * @property applicationId Id of application. Random string
 */
data class InternalTransactionInput(
    @Expose val id: String,
    @Expose val value: String,
    @Expose val currency: String,
    @Expose val fromUserAddress: String,
    @Expose val fromAddressType: String,
    @Expose val fromWorkspaceId: String? = null,
    @Expose val toUserAddress: String,
    @Expose val toAddressType: String,
    @Expose val toWorkspaceId: String? = null,
    @Expose val applicationId: String? = null
)
