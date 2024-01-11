package com.nicnicdev.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nicnicdev.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel // essa variavél será inicializada depois

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater) // faz com que tenhamos acesso ao xml
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this)[MainViewModel::class.java] //instânciando a viewModel, isso garante q o ciclo de vida da viewModel sera igual ao da mainActivity

        setObserver()
    // binding.textWelcome.text = "Olá"
    //atribuição de dados para nossa inteface (simples)
    // porém nós queremos que nossa viewModel faça isso
    }

    private fun setObserver (){
        viewModel.welcome().observe(this, Observer {  // esta função esta observando tudo o que acontece na função  welcome....
            binding.textWelcome.text = it // it = String que vamos receber.
        })
    }
}