package com.example.ieseljust.whatsdam


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ieseljust.whatsdam.databinding.ActivityMessagesWindowBinding
import java.text.SimpleDateFormat
import java.util.Date
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

        //botó enviar
        val sendBtn = binding.sendMessage
        //Trxt del missatge
        val messageEditText = binding.MessageText
        val adapter = AdapterMessage()
        val recyclerView = binding.MessagesRecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        sendBtn.setOnClickListener {
            //Convertim / Parsetgem el missatge a text per a controlarlo
            val messageText = messageEditText.text.toString()
            //Si el missatge no esta buit
            if (messageText.isNotBlank()) {
                // Obtindre l'hora al format adecuat HH:mm
                val horaActual = SimpleDateFormat("HH:mm").format(Date())

                // Crear l'instancia del missatge amb l'hora
                val message = Message("NomUsuari", messageText, horaActual)

                // Agregar el missatge a la llista
                MessageData.addMessage(message)

                // Notifica l canvi d'hora
                adapter.notifyDataSetChanged()

                // Estetica del text
                messageEditText.text.clear()

                // L'scroll demanat
                recyclerView.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }
}