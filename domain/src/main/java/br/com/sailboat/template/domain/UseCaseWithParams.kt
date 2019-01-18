package br.com.sailboat.template.domain

@SuppressWarnings
abstract class UseCaseWithParams<in Params, out Type> where Type : Any {
    abstract fun execute(params: Params): Type
    operator fun invoke(params: Params) = execute(params)
}