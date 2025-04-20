package com.example.find_similar_artists_app.models.data

data class ErrorResponse(
    val errorNumber: Int,
    val errorMessage: String = "",
    val errorCause: String = "",
){
    companion object{
        fun getValue(code: Int): ErrorResponse {
            return ErrorResponse(code)
        }
    }
}

fun ErrorResponse.toStringType()=
    when(errorNumber){
        404 -> "404: Artist not found."
        409 -> "409: Invalid or unrecognized parameter."
        700 -> "700: Network error."
        in 400..499 -> "4XX: Unknown client error."
        in 500..599 -> "5XX: Unknown server error."
        else -> "Unknown error."
    } + errorMessage + errorCause
