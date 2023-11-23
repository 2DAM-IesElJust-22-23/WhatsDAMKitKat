class Messages : ViewModel{
    private val _messages = MutableLiveData<ArrayList<Message>>().apply {
        value = ArrayList()
    }

    val messages: MutableLiveData<ArrayList<Message>> = _messages

    fun getMessageAt(position: Int): Message {
        return _messages.value?.get(position) ?: Message("", "")
    }

    fun add(username: String, text: String) {
        _messages.value?.add(Message(username, text))
        // Notificar cambios en LiveData
        _messages.postValue(_messages.value)
    }

    fun sendMessage(message: Message) {
        // Implementa lógica de envío al servidor aquí
    }

    fun size(): Int {
        return _messages.value?.size ?: 0
    }
}
