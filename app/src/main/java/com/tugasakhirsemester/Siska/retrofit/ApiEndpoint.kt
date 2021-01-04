package com.tugasakhirsemester.Siska.retrofit

import com.tugasakhirsemester.Siska.MainModel
import retrofit2.Call
import retrofit2.http.*

interface ApiEndpoint {

    @GET("indonesia") //hanya mengambil 1 endpoint yaitu data Indonesia dari API kawalcorona.com
    fun getData(): Call<List<MainModel>> //request data yang berupa arraylist
}