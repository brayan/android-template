package br.com.sailboat.template.data.remote

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EntityService @Inject constructor(retrofit: Retrofit) : EntityApi {

    private val entityApi by lazy { retrofit.create(EntityApi::class.java) }

    override fun entities() = entityApi.entities()
}