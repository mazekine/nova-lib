package com.mazekine.nova.models

import com.google.gson.annotations.Expose

data class SearchTransactionsInput(
    @Expose val userAddress: String,
    @Expose val addressType: String,
    @Expose val workspaceId: String?,
    @Expose val groupKind: TransactionGroupKind?,
    @Expose val orderBy: TransactionOrderBy?,
    @Expose val from: Long?,
    @Expose val to: Long?,
    @Expose val currency: String?,
    @Expose val state: TransactionState?,
    @Expose val count: Int?,
    @Expose val offset: Int?,
    @Expose val kind: TransactionKind?,
    @Expose val direction: TransactionDirection?,
    @Expose val transactionId: String?
)
