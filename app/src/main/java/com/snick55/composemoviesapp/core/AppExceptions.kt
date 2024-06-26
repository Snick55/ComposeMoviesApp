package com.snick55.composemoviesapp.core

open class AppException(errorMessage: String): java.lang.Exception(errorMessage)

class NoInternetException: AppException("No Internet connection")
class ServerUnavailableException: AppException("Server unavailable")
class EmptyResponseException: AppException("No one movie for ths query")
class TimeOutException: AppException("Timeout... try again later")
class GenericException: AppException("Something went wrong")