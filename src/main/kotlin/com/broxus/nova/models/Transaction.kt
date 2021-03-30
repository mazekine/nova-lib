package com.broxus.nova.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Transaction (
    @Expose val id: String,
    @Expose val value: String,
    @Expose val currency: String,
    @Expose val fromUserAddress: String,
    @Expose val fromAddressType: String,
    @Expose val fromWorkspaceId: String,
    @Expose val toUserAddress: String,
    @Expose val toAddressType: String,
    @Expose val toWorkspaceId: String,
    @Expose val kind: TransactionKind,
    @Expose val state: TransactionState,
    @Expose @SerializedName("gid") val groupId: String,
    @Expose val applicationId: String?,
    @Expose val createdAt: Long,
    @Expose val updatedAt: Long
)
