package br.com.sailboat.template.domain

interface Logger {
    fun d(msg: String)
    fun e(tr: Throwable)
    fun e(msg: String, tr: Throwable)
}