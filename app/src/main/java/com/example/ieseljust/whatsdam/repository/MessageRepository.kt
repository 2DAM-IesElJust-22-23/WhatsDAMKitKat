package com.example.ieseljust.whatsdam.repository

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


}