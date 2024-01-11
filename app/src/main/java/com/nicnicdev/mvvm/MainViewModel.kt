package com.nicnicdev.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var textWelcome = MutableLiveData<String>() //possibilita a comunicação da viewModel com a MainActivity

    init {
        textWelcome.value = "Olá"
    }

    fun welcome () : LiveData<String>{ //expondo ( tornando visivel) a variavel textWelcom através de uma função.
        return textWelcome // ....que por sua vez esta retornando a variavél textWelcome.
    }
}