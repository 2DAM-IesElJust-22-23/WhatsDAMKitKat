package com.example.ieseljust.whatsdam.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ieseljust.whatsdam.model.Message
import com.example.ieseljust.whatsdam.repository.MessageRepository

class MessageViewModel {
    private val repository: MessageRepository = MessageRepository.getInstance()
    private val _messages = MutableLiveData<List<Message>>()
    val messages: LiveData<List<Message>> get() = _messages

    init {
        // Inicializar la lista de mensajes desde el repositorio
        _messages.value = repository.listMessage()
    }

    fun addMessage(message: Message) {
        // Agregar el mensaje al repositorio
        repository.add(message)
        // Actualizar la lista de mensajes
        _messages.value = repository.listMessage()
    }
}