package com.example.ieseljust.whatsdam.model

import java.io.Serializable

data class Message(
    //control de l'usuari
    var username: String,
    //control de el text
    var text: String,
    //Control de l'hora
    var time: String
): Serializable

object MessageData {
    private val MessageData = mutableListOf<Message>()

    fun addMessage(message: Message): Boolean {
        return MessageData.add(message)
    }

    fun getMessage(position: Int) = MessageData[position]
    fun getMessages() = MessageData
    fun getNumMessg() = MessageData.size
    fun getLastMessg() = MessageData.size - 1
    fun remove(m: Message): Int {
        val index = MessageData.indexOf(m)
        if (index != -1) {
            MessageData.removeAt(index)
        }
        return index
    }
}
