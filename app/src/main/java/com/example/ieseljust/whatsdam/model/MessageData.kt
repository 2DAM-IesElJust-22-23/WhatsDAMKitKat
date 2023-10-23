package com.example.ieseljust.whatsdam.model

object MessageData {
    val messages: MutableList<Message> = mutableListOf()

    fun addMessage(message: Message) {
        messages.add(message)
    }
}