package com.example.room

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.room.model.UsuarioModel
import com.example.room.repository.UsuarioDataBase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Instancia de Room
        val usuarioDatabase = UsuarioDataBase.getDataBase(this).usuarioDAO()//Aqui estamos instanciando a classe do Room, ao mesmo tempo que estamos retornando a classe de usuarioDao


        usuarioDatabase.updateUser(UsuarioModel().apply {
            this.id_usuario = 1
            this.nome = "Mateus"
            this.idade = 23
        })

        usuarioDatabase.deleteUser(UsuarioModel().apply {
            this.id_usuario = 9
        })

        val retornoSelectMultiplo = usuarioDatabase.getAll()//Retorna todos os registros

        for(item in retornoSelectMultiplo){
            Log.d("Retorno Múltiplo", "id_usuario: ${item.id_usuario}, nome: ${item.nome}, idade: ${item.idade}")
        }
    }
}