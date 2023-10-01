package com.example.ieseljust.whatsdam


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ieseljust.whatsdam.databinding.ActivityMainBinding
import java.io.IOException
import java.lang.Object

class MainActivity : AppCompatActivity() {
    // Aplying the viewBinding
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        // Guardem l'estat
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // val inputValue = idUser.text.toString()
        //val editextnick = findViewById<EditText>(R.id.nickNameText)
        //val edittextadress = findViewById<EditText>(R.id.serverAddressText)
        //val btnConect = findViewById<Button>(R.id.buttonConnect)
        val editextnick = binding.nickNameText
        val edittextadress = binding.serverAddressText
        val btnConect = binding.buttonConnect

        btnConect.setOnClickListener{
            // El que s'ha passat per formulari s'enmagatzema com a string a la variable
            val nickname = editextnick.text.toString()
            val serverAddress = edittextadress.text.toString()

            // Comprobem que s'introdueix el que toca, i mitjançant intents pasem els valors
            if ( binding.nickNameText.text.toString()!= "" && binding.serverAddressText.text.toString() == binding.serverAddressText.text.toString()){
                val intent = Intent(this, MessagesWindow::class.java)
                intent.putExtra("nickname", nickname)
                intent.putExtra("serverAddress", serverAddress)
                startActivity(intent)
            } else{
                IOException("Datos incorrectos")
            }
        }
    }



    // Api -31
    // Vull utilitzar esta perque tinc api 24
    public static final Pattern IP_ADDRESS


    // Api +31
    public static boolean isNumericAddress (String adrress)



}