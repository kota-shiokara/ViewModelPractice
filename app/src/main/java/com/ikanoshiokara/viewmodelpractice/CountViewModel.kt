package com.ikanoshiokara.viewmodelpractice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {
    var score : MutableLiveData<Int> = MutableLiveData()
    fun initScore() {
        score.value = 0
    }
}