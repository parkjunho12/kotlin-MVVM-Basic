package com.android.mvvmtest.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

class ToastMessage : SingleToastEvent<String>() {

    fun observe(owner: LifecycleOwner, observer: (String) -> Unit) {
        super.observe(owner, Observer {
            it?.run{
                observer(it)
            }
        })
    }

}