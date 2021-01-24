package com.ikanoshiokara.viewmodelpractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextViewModel: ViewModel() {
    private val _submittedText = MutableLiveData<String>().also { mutableLiveData ->
        mutableLiveData.value = "出力"
    }
    val submittedText: LiveData<String> get() = _submittedText

    fun submitText(text: String){
        _submittedText.value = text
    }
}