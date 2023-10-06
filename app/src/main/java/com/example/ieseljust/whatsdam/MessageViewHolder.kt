package com.example.ieseljust.whatsdam

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val messageText: TextView = itemView.findViewById(R.id.msg_text)

    fun bind(message: Message) {
        messageText.text = message.text
    }
}