package com.example.ieseljust.whatsdam


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ieseljust.whatsdam.databinding.ActivityMainBinding
import java.io.IOException
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    // Aplying the viewBinding
    private lateinit var binding: ActivityMainBinding

    // Api -31
    // Vull utilitzar esta perque tinc api 24
    private val IP_ADDRESS_PATTERN = Pattern.compile(("^(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])\\." + "(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])\\." + "(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])\\." + "(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])$"))

    override fun onCreate(savedInstanceState: Bundle?) {
        // Guardem l'estat
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val editextnick = binding.nickNameText
        val edittextadress = binding.serverAddressText
        val btnConect = binding.buttonConnect

        btnConect.setOnClickListener{
            val nickname = editextnick.text.toString()
            val serverAddress = edittextadress.text.toString()

            if ( nickname.isNotBlank() && addressValidator(serverAddress)){
                val intent = Intent(this, MessagesWindow::class.java)
                intent.putExtra("nickname", nickname)
                intent.putExtra("serverAddress", serverAddress)
                startActivity(intent)
            } else{
                IOException("Datos incorrectos")
            }
        }

    }

    private fun addressValidator(ip: String) :Boolean{
        return IP_ADDRESS_PATTERN.matcher(ip).matches()
    }
}