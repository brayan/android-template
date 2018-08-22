package br.com.sailboat.template.domain

@SuppressWarnings
abstract class UseCase<in Params, out Type> where Type : Any {

    abstract fun execute(params: Params): Type

}