package com.example.ieseljust.whatsdam.controller

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ieseljust.whatsdam.entity.MessageData
import com.example.ieseljust.whatsdam.controller.MessageViewHolder
import com.example.ieseljust.whatsdam.R

class AdapterMessage : RecyclerView.Adapter<MessageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.my_msg_viewholder, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = MessageData.messages[position]
        holder.bind(message)
    }

    override fun getItemCount(): Int {
        return MessageData.messages.size
    }
}