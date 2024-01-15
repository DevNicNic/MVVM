package com.nicnicdev.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nicnicdev.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel // essa variavél será inicializada depois

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater) // faz com que tenhamos acesso ao xml
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener(this)

        viewModel =
            ViewModelProvider(this)[MainViewModel::class.java] //instânciando a viewModel, isso garante q o ciclo de vida da viewModel sera igual ao da mainActivity

        setObserver()
    // binding.textWelcome.text = "Olá"
    //atribuição de dados para nossa inteface (simples)
    // porém nós queremos que nossa viewModel faça isso
    }

    override fun onClick(v: View) {  //pega os dados do usuario, e certifica que o botão foi clicado
        if(v.id == R.id.button_login){
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()

            viewModel.doLogin(email, password) //manda esses dados pra viewModel na função doLogin que fara a verificação
        }
    }

    private fun setObserver (){
        viewModel.welcome().observe(this, Observer {  // esta função esta observando tudo o que acontece na função  welcome....
            binding.textWelcome.text = it // it = String que vamos receber.
        })
        viewModel.login().observe(this, Observer {
            if(it) {
                Toast.makeText(applicationContext, "SUCESSO!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, "FALHA!", Toast.LENGTH_LONG).show()

            }

        })



        }
    }


