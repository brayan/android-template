package br.com.sailboat.template.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface EntityApi {

    @GET("entities.json")
    fun entities(): Call<List<EntityRemoteModel>>

}