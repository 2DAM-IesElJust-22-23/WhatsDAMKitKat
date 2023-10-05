package com.example.ieseljust.whatsdam

object MessageData {
    var message: ArrayList<Message>

    // Definim una llista que contindra els contactes a  afegir al Dataset.
    private var MessageContent: ArrayList<Message>

    init {
        //  Inicialització de la llista de contactes
        message = ArrayList<Message>()

        // I creem la llista amb els contactes per afegir
        val message = Message

        val msg = message
        MessageContent= ArrayList<Message>(listOf(
            msg("Ahsoka Tano"),
            msg("Baylan Skoll"),
            msg("Ezra Bridger"),
            msg("Hera Syndulla"),
            msg("Morgan Elsbert"),
            msg("Sabine Wren"),
            msg("Shin Hati"),
            msg("Gran Almirante Thrawn"),
            msg("Zeb Orrellios"))
        )
    }
}