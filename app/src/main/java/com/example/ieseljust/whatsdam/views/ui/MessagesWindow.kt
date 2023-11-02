import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ieseljust.whatsdam.databinding.ActivityMessagesWindowBinding
import com.example.ieseljust.whatsdam.model.Message
import com.example.ieseljust.whatsdam.viewmodels.AdapterMessage
import com.example.ieseljust.whatsdam.viewmodels.MessageViewModel
import java.text.DateFormat
import com.example.ieseljust.whatsdam.R
import java.util.Date

class MessagesWindow : AppCompatActivity() {
    // Aplicamos viewBinding
    private lateinit var binding: ActivityMessagesWindowBinding
    private val viewModel = MessageViewModel(application)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessagesWindowBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Capturamos los intentos
        val nickname = intent.getStringExtra("nickname")
        val serverAddress = intent.getStringExtra("serverAddress")

        // Trabajo con TextView
        val connectionInfoTextView = binding.connectionInfoTextView

        // Utilizamos recursos de cadena para mostrar el texto
        val connectionInfo = getString(R.string.connected_text, serverAddress, nickname)
        connectionInfoTextView.text = connectionInfo

        // Botón enviar
        val sendBtn = binding.sendMessage
        // Texto del mensaje
        val messageEditText = binding.MessageText
        val recyclerView = binding.MessagesRecyclerView
        recyclerView.adapter = AdapterMessage()
        recyclerView.layoutManager = LinearLayoutManager(this)

        sendBtn.setOnClickListener {
            try {
                // Convertir / Analizar el mensaje a texto para controlarlo
                val textDelMensaje = messageEditText.text.toString()
                // Si el mensaje no está vacío
                if (textDelMensaje.isNotBlank()) {
                    // Obtener la hora en el formato adecuado
                    val horaActual = DateFormat.getTimeInstance(DateFormat.SHORT).format(Date())

                    // Crear una instancia del mensaje con la hora
                    val mensaje = Message("NombreUsuario", textDelMensaje, horaActual)

                    // Agregar el mensaje a la lista
                    viewModel.addMessage(mensaje)

                    // Estética del texto
                    messageEditText.text.clear()

                    // Desplazamiento deseado
                    recyclerView.scrollToPosition(viewModel.adaptador.value?.itemCount?.minus(1) ?: 0)
                }
            } catch (e: Exception) {
                e.printStackTrace() // Imprimir la excepción en el logcat
            }
        }
    }

    // private val eventListener: (Message, View) -> Boolean = { _, _ -> false }
}
