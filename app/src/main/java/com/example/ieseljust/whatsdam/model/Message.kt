package com.example.ieseljust.whatsdam.model

import java.io.Serializable

data class Message(
    //control de l'usuari
    var username: String,
    //control de el text
    var text: String,
    //Control de l'hora
    var time: String
): Serializable