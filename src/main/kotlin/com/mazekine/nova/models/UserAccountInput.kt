package com.mazekine.nova.models

import com.google.gson.annotations.Expose

data class UserAccountInput (
    @Expose val userAddress: String,
    @Expose val addressType: String,
    @Expose val workspaceId: String?
)