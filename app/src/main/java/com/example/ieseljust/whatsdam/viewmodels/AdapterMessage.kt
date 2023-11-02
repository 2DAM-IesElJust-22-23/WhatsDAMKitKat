package com.example.ieseljust.whatsdam.viewmodels

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ieseljust.whatsdam.R
import com.example.ieseljust.whatsdam.repository.MessageRepository

class AdapterMessage : RecyclerView.Adapter<MessageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.my_msg_viewholder, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(MessageRepository.getInstance().getMessages()[position])
    }

    override fun getItemCount(): Int {
        return MessageRepository.getInstance().getNumMessg()
    }
}