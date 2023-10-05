package com.example.ieseljust.whatsdam

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val name = itemView.findViewById(R.id.msg_text) as TextView

    // Enllacem les dades del contacte amb la vista
    fun bind(msg: Message) {
        name.text = msg.msg
    }

}