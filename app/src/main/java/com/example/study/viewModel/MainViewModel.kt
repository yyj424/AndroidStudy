package com.example.study.viewModel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application){
    var main_txt : ObservableField<String> = ObservableField("main_default")
    //여기서 data binding 생김
    //viewmodel이 application 클래스인지? > 처음 실행 여부 확인 필요
    fun onClick() {
        main_txt.set(Math.random().toString())
    }
}