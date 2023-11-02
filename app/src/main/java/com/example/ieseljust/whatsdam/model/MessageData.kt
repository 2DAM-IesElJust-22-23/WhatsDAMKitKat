package com.example.ieseljust.whatsdam.model

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
