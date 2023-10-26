package com.example.ieseljust.whatsdam.viewmodels

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.ieseljust.whatsdam.R
import com.example.ieseljust.whatsdam.model.Message

class AdapterMessage(
    val context: Context,
    val eventListener: (Message, View) -> Boolean,
    private val viewModel: MessageViewModel,
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    init {
        viewModel.messages.observe(lifecycleOwner, Observer {
            notifyDataSetChanged()
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.my_msg_viewholder, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MessageViewHolder).bind(
            viewModel.messages.value!![position],
            eventListener)
    }

    override fun getItemCount(): Int {
        return viewModel.messages.value?.size ?: 0
    }
}
