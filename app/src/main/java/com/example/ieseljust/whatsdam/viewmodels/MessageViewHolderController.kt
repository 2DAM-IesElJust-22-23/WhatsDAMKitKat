package com.example.ieseljust.whatsdam.viewmodels

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ieseljust.whatsdam.R
import com.example.ieseljust.whatsdam.model.Message

class MessageViewHolderController(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val messageText: TextView = itemView.findViewById(R.id.msg_text)

    fun bind(message: Message) {
        messageText.text = message.text
    }
}