package com.andorid.movie.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.andorid.movie.api.WebService
import com.android.movie.data.Repository
import com.appster.commoncents.viewmodel.ViewModelFactory

object Injection {
    /**
     * Creates an instance of [Repository] based on the [WebService]
     */
    private fun provideRepository(context: Context): Repository {
        return Repository(WebService.create())
    }

    /**
     * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
     * [ViewModel] objects.
     */
    fun provideViewModelFactory(context: Context): ViewModelProvider.Factory {
        return ViewModelFactory(provideRepository(context))
    }


}