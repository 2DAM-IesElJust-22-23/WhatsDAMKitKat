package com.example.ieseljust.whatsdam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterMessage : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // S'invoca quan es crea un nou viewholder
        val inflater = LayoutInflater.from(parent.context)
        val vista=inflater.inflate(R.layout.my_msg_viewholder, parent,false);
        return MessageViewHolder(vista)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // (holder as MessageViewHolder).bind(MessageData.msg[position]);
    }

    override fun getItemCount(): Int {
    //    return Message.msg.size
    }
}