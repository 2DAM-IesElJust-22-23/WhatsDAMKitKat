package com.example.ieseljust.whatsdam


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ieseljust.whatsdam.databinding.ActivityMessagesWindowBinding

class MessagesWindow : AppCompatActivity() {
    // apliquem viewBinding
    private lateinit var binding: ActivityMessagesWindowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessagesWindowBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Capturem els intents
        val nickname = intent.getStringExtra("nickname")
        val serverAddress = intent.getStringExtra("serverAddress")

        // Treball amb Tetxtview
        val connectionInfoTextView = binding.connectionInfoTextView
        connectionInfoTextView.text = "Conectat a $serverAddress com a $nickname"

        // Botó d'enviar
        val sendBtn = binding.sendMessage
        val messageEditText = binding.MessageText
        sendBtn.setOnClickListener {
            // treballem amb el missatge
            val message = messageEditText.text.toString()
            messageEditText.text.clear()
        }
    }
}