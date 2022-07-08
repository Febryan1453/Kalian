package com.febryan.kalian.api

import com.febryan.kalian.model.ResponseKategori
import com.febryan.kalian.model.ResponseUser
import com.febryan.kalian.model.ResponseWisata
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("wisata")
    fun getWisata() : Call<ResponseWisata>

    @GET("kategori")
    fun getKategoriWisata() : Call<ResponseKategori>

    @GET("wisata-per-kategori/{kategori_id}")
    fun getPerKategori(@Path("kategori_id") kategori_id : Int) : Call<ResponseWisata>

    @FormUrlEncoded
    @POST("login")
    fun loginYuk(
        @Field("email") email : String,
        @Field("password") password : String,
    ) : Call<ResponseUser>

    @FormUrlEncoded
    @POST("regis")
    fun regisYuk(
        @Field("name") name : String,
        @Field("email") email : String,
        @Field("phone") phone : String,
        @Field("password") password : String,
        @Field("city") city : String,
    ) : Call<ResponseUser>

}