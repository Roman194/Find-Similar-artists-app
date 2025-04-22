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
        404 -> "{$errorNumber}: Artist not found."
        409 -> "{$errorNumber}: Invalid or unrecognized parameter."
        700 -> "{$errorNumber}: Network error."
        in 400..499 -> "{$errorNumber}: Client error."
        in 500..599 -> "{$errorNumber}: Server error."
        else -> "{$errorNumber}: Unknown error."
    } + errorMessage + errorCause
