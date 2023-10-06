package com.example.ieseljust.whatsdam

object MessageData {
    val messages: MutableList<Message> = mutableListOf()

    fun addMessage(message: Message) {
        messages.add(message)
    }
}