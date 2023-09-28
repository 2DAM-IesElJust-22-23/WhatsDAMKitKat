package com.example.ieseljust.whatsdam


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ieseljust.whatsdam.databinding.ActivityMainBinding
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // val inputValue = idUser.text.toString()
        val editextnick = findViewById<EditText>(R.id.nickNameText)
        val edittextadress = findViewById<EditText>(R.id.serverAddressText)
        val btnConect = findViewById<Button>(R.id.buttonConnect)

        btnConect.setOnClickListener{
            if ( binding.nickNameText.text.toString()!= "" && binding.serverAddressText.text.toString() == binding.serverAddressText.text.toString()){
                val intent = Intent(this, MessagesWindow::class.java)
            } else{
                IOException("Datos incorrectos")
            }
        }

        /*
        problema de examen:
        var valorText = idNomUsuari.text.toString()

        binding.btConect.setOnClickListener {
            la solucio seria valorText dintre
            log(valorText)
            if (valorText!=""){
                intent ...
                startActivity(intent)
            }
        }
          */

    }
}