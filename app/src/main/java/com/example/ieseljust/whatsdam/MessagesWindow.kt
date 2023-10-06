package com.example.ieseljust.whatsdam


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ieseljust.whatsdam.databinding.ActivityMessagesWindowBinding
import androidx.recyclerview.widget.RecyclerView
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

        val sendBtn = binding.sendMessage
        val messageEditText = binding.MessageText
        val recyclerView = binding.MessageRecyclerView
        val adapter = AdapterMessage()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        sendBtn.setOnClickListener {
            val messageText = messageEditText.text.toString()
            if (messageText.isNotBlank()) {
                val message = Message("NombreUsuario", messageText)
                MessageData.addMessage(message)
                adapter.notifyDataSetChanged()
                messageEditText.text.clear()

                // Hacer scroll hacia el último mensaje
                recyclerView.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }
}