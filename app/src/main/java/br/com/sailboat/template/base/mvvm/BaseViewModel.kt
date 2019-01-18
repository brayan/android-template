package br.com.sailboat.template.base.mvvm

import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.Main
import kotlinx.coroutines.experimental.launch

abstract class BaseViewModel : ViewModel() {

    private val asyncJobs: MutableList<Job> = mutableListOf()

    fun launchMain(block: suspend () -> Unit) {
        val job: Job = GlobalScope.launch(Dispatchers.Main) {
            block.invoke()
        }
        asyncJobs.add(job)
        job.invokeOnCompletion { asyncJobs.remove(job) }
    }

    fun cancelAllAsync() {
        val asyncJobsSize = asyncJobs.size

        if (asyncJobsSize > 0) {
            for (i in asyncJobsSize - 1 downTo 0) {
                asyncJobs[i].cancel()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        cancelAllAsync()
    }

}