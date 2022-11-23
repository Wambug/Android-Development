package com.example.patienttracker.remote.patient

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PatientApi {
   @POST("patient")
   fun login(@Body dataModel: LoginModel?):Call<LoginModel>?
}