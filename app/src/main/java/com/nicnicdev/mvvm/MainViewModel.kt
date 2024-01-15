package com.nicnicdev.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var textWelcome = MutableLiveData<String>() //possibilita a comunicação da viewModel com a MainActivity
    private var login = MutableLiveData<Boolean>()
    private var personRepository = PersonRepository()

    init {
        textWelcome.value = "Olá"
    }

    fun login (): LiveData<Boolean>{
        return login
    }

    fun welcome () : LiveData<String>{ //expondo ( tornando visivel) a variavel textWelcom através de uma função.
        return textWelcome // ....que por sua vez esta retornando a variavél textWelcome.
    }

    fun doLogin (email: String, password: String ){
        // logica respondavel por validar se meu email e senha estão corretos
         login.value= personRepository.login(email, password)
        //passa o resultado da função login pro value do livedata, isso faz com que o observador receba a informação.

    }
}