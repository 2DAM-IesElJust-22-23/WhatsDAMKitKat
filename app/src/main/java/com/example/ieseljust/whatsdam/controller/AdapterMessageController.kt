package com.example.ieseljust.whatsdam.controller

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ieseljust.whatsdam.entity.MessageData
import com.example.ieseljust.whatsdam.R

class AdapterMessageController : RecyclerView.Adapter<MessageViewHolderController>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolderController {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.my_msg_viewholder, parent, false)
        return MessageViewHolderController(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolderController, position: Int) {
        val message = MessageData.messages[position]
        holder.bind(message)
    }

    override fun getItemCount(): Int {
        return MessageData.messages.size
    }
}