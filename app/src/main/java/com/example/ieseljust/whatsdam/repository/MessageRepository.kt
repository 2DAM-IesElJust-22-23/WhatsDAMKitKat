package com.example.ieseljust.whatsdam.repository

import com.example.ieseljust.whatsdam.model.MessageData;
import com.example.ieseljust.whatsdam.model.Message;


class MessageRepository private constructor(){
    //singleton is here baby
    companion object{
        /***
         * per a implementar el patró SINGLETON 'sutilitza companion object l'equivalent a static d eJAVA. Despŕes instanciarem el repositori (INSTANCE)
         * #1: Instanciem la clase
         *
         *
         *
         * ***/
        //#1
        private var INSTANCE: MessageRepository? = null;

        fun getInstance(): MessageRepository{
            if(INSTANCE == null){
                INSTANCE = MessageRepository()
            }
            return INSTANCE!!
        }

    }
    //listMessage
    fun listMessage() = MessageData.messages;
    //CountMess
    fun getNumMessg() = MessageData.messages.size;
    //addMsg
    fun add(message: Message) = MessageData.addMessage(message);
    //RemoveMiss
    //fun remove(m: Message) = MessageData.remove(m);
}