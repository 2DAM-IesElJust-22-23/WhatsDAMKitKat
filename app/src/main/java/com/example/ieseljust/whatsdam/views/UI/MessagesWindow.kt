package com.example.ieseljust.whatsdam.views.UI

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ieseljust.whatsdam.databinding.ActivityMessagesWindowBinding
import com.example.ieseljust.whatsdam.model.Message
import com.example.ieseljust.whatsdam.model.MessageData
import com.example.ieseljust.whatsdam.viewmodels.AdapterMessage
import com.example.ieseljust.whatsdam.viewmodels.MessageViewModel
import java.text.SimpleDateFormat
import java.util.Date

class MessagesWindow : AppCompatActivity() {
    // apliquem viewBinding
    private lateinit var binding: ActivityMessagesWindowBinding
    private val viewModel = MessageViewModel()

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

        // Botón enviar
        val sendBtn = binding.sendMessage
        // Text del mensaje
        val messageEditText = binding.MessageText
        val recyclerView = binding.MessagesRecyclerView
        recyclerView.adapter = AdapterMessage(this, eventListener, viewModel, this)
        recyclerView.layoutManager = LinearLayoutManager(this)

        sendBtn.setOnClickListener {
            // Convertir / Parsear el mensaje a texto para controlarlo
            val messageText = messageEditText.text.toString()
            // Si el mensaje no está vacío
            if (messageText.isNotBlank()) {
                // Obtener la hora en el formato adecuado HH:mm
                val horaActual = SimpleDateFormat("HH:mm").format(Date())

                // Crear la instancia del mensaje con la hora
                val message = Message("NomUsuari", messageText, horaActual)

                // Agregar el mensaje a la lista
                viewModel.addMessage(message)

                // Estética del texto
                messageEditText.text.clear()

                // Scroll deseado
                recyclerView.scrollToPosition(viewModel.messages.value?.size?.minus(1) ?: 0)
            }
        }
    }

    private val eventListener: (Message, View) -> Boolean = { _, _ -> false }
}
