package com.example.youtubeapi2.model
data class ErrorResponse(
    val errorBody: ErrorBody? = null
)
data class ErrorBody (
    val code: Int? = null,
    val message: String? = null
)