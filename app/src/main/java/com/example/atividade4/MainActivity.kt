package com.example.atividade4

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.atividade4.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //lista do spinner
        val sexo = listOf("Masculino","Feminino")

        //Config do adapter
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,sexo)

        //relacionamneto de adapter e spinner
        binding.sexo.adapter = adapter

        binding.botao.setOnClickListener {
            calcular()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun calcular(){
        val idade = binding.entradaIdade.text.toString().toIntOrNull()
        val sexo = binding.sexo.selectedItem.toString()
        binding.inputIdade.helperText = ""
        if(idade == null){
            binding.inputIdade.helperText = "Digite sua idade!"
            return
        }

        if(idade >= 130){
            binding.inputIdade.helperText = "Digite uma idade válida!"
            return
        }

        if(sexo == "Masculino"){
            val tempoRestante = 65 - idade
            if(tempoRestante <= 0){
                binding.resultado.text = "Você já deveria estar aposentado!"
            }
            else {
                binding.resultado.text = "Faltam ${tempoRestante} anos para aposentadoria."
            }
            return
        }
        if(sexo == "Feminino"){
            val tempoRestante = 62 - idade
            if(tempoRestante <= 0){
                binding.resultado.text = "Você já deveria estar aposentado!"
            }
            else {
                binding.resultado.text = "Faltam ${tempoRestante} anos para aposentadoria."
            }
            return
        }

    }
}