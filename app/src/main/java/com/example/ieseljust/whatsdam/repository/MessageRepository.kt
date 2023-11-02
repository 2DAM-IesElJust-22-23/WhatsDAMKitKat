package com.example.ieseljust.whatsdam.repository

import com.example.ieseljust.whatsdam.model.Message
import com.example.ieseljust.whatsdam.model.MessageData

class MessageRepository private constructor() {
    companion object {
        private var INSTANCE: MessageRepository? = null

        fun getInstance(): MessageRepository {
            if (INSTANCE == null) {
                INSTANCE = MessageRepository()
            }
            return INSTANCE!!
        }
    }

    fun getMessages() = MessageData.getMessages()
    fun getNumMessg() = MessageData.getNumMessg()
    fun addMessage(e: Message): Boolean = MessageData.addMessage(e)
    fun remove(m: Message): Int = MessageData.remove(m)
}