import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.Socket

class CommunicationManager {

    private val port = 9999
    private var server: String = ""
    private var listenPort: Int? = null

    suspend fun sendServer(msg: String): JSONObject = withContext(Dispatchers.IO) {
        val socket = Socket(server, port)
        val outputStream = socket.getOutputStream()
        val inputStream = socket.getInputStream()

        outputStream.write(msg.toByteArray(Charsets.UTF_8))
        val response = inputStream.bufferedReader().use { it.readText() }

        socket.close()

        return@withContext JSONObject(response)
    }

    suspend fun prepareListener() {
        listenPort = findFreePort()

        GlobalScope.launch(Dispatchers.IO) {
            val serverSocket = listenPort?.let { ServerSocket(it) }

            serverSocket?.accept()?.let { clientSocket ->
                val input = clientSocket.getInputStream().bufferedReader().use { it.readText() }
                processNotification(input)

                clientSocket.getOutputStream().write("{'status':'ok'}".toByteArray(Charsets.UTF_8))
                clientSocket.close()
            }
        }
    }

    private fun processNotification(s: String) {
        val json = JSONObject(s)
        val type = json.getString("type")

        if (type == "message") {
            val message = json.getString("message")
            // Assuming you have a reference to the MessagesRepository
            MessagesRepository.getInstance().addMessage(message)
        }
    }

    private suspend fun findFreePort(): Int {
        // Implement logic to find a free port dynamically
        // For simplicity, you can use a fixed port or any other logic here
        return 12345
    }
}
