package com.example.ieseljust.whatsdam.viewmodels

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.ieseljust.whatsdam.model.Message
import com.example.ieseljust.whatsdam.repository.MessageRepository

class MessageViewModel(application: Application) : AndroidViewModel(application) {
    private val _adaptador = MutableLiveData<AdapterMessage>().apply {
        value = AdapterMessage()
    }
    val adaptador: MutableLiveData<AdapterMessage> = _adaptador

    fun addMessage(e: Message) {
        if (MessageRepository.getInstance().addMessage(e)) {
            adaptador.value?.notifyItemInserted(MessageRepository.getInstance().getNumMessg() - 1)
        }
    }

    private fun MessageLongClickManager(message: Message, v: View): Boolean {
        val index = MessageRepository.getInstance().remove(message)
        adaptador.value?.notifyItemRemoved(index)
        return true
    }
}
