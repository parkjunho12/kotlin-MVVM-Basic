package com.android.mvvmtest


import android.content.ContentValues
import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.android.mvvmtest.Model.DataModel
import com.android.mvvmtest.Model.response.ReqHeader
import com.android.mvvmtest.Model.response.ReqSVC0000
import com.android.mvvmtest.viewmodel.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.coroutineScope
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.test.inject
import org.koin.test.mock.declareMock
import org.mockito.ArgumentCaptor
import org.mockito.BDDMockito.given
import org.mockito.Mockito.*
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException


class MainIntroCaseTest: AbstractKoinTest(){

    fun <T> LiveData<T>.getOrAwaitValue(
        time: Long = 2,
        timeUnit: TimeUnit = TimeUnit.SECONDS
    ): T {
        var data: T? = null
        val latch = CountDownLatch(1)
        val observer = object : Observer<T> {
            override fun onChanged(o: T?) {
                data = o
                latch.countDown()
                this@getOrAwaitValue.removeObserver(this)
            }
        }

        this.observeForever(observer)

        // Don't wait indefinitely if the LiveData is not set.
        if (!latch.await(time, timeUnit)) {
            throw TimeoutException("LiveData value was never set.")
        }

        @Suppress("UNCHECKED_CAST")
        return data as T
    }

    val MainViewModel: MainViewModel by inject()

    @Test
    fun isIntroIn() {
        val reqHeader = ReqHeader("SVC0000")
        val reqBody = ReqSVC0000("PartnerLicence")

       MainViewModel.addDispos(reqHeader, reqBody)
        MainViewModel.responseString.getOrAwaitValue()
        assertEquals(MainViewModel.responseString.value, "Cool")
    }

}