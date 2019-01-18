package br.com.sailboat.template.domain

@SuppressWarnings
abstract class UseCase<out Type> where Type : Any {
    abstract fun execute(): Type
    operator fun invoke() = execute()
}