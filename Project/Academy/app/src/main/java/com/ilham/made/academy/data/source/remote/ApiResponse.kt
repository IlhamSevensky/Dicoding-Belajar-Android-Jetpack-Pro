package com.ilham.made.academy.data.source.remote

class ApiResponse<T>(val status: StatusResponse, val body: T, val message: String?) {
    companion object {
        fun <T> success(body: T): ApiResponse<T> = ApiResponse(StatusResponse.SUCCESS, body, null)
 
        fun <T> empty(msg: String, body: T): ApiResponse<T> = ApiResponse(StatusResponse.EMPTY, body, msg)
 
        fun <T> error(msg: String, body: T): ApiResponse<T> = ApiResponse(StatusResponse.ERROR, body, msg)
    }
}