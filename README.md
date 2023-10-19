**Per a fer el exercici ens hem fixat a l'exercici de contactes(agenda)**

**Recursos necesaris per a fer l'activitat:**
Sen's proporciona dos layouts més a aules, el cual tenim my view holder window i un altre. Que afegirem a la carpeta layouts junt als altres xml.

**Estructura de Vistes y entitats (Tal volta siga important separar les vistes, les entitats i els controladors MVC)**
controller
    |_AdapterMessageController.kt
    |_MainActivityController.kt
    |_MessagesWindowController.kt
    |_MessagesViewController.kt
entity
    |_MessageData
    |_Message

**AdapterMessage es un adaptador creat per als missatges com a intermediari**
Necesitarem al create oncreateviewholder deguem pasarli la vista, unflar la vista i retornar la creació en la vista
En onbindVienwholder deurem pasar la posicio del missatge
Necesitarem un contador per al tamany de els missatges 

**Que deu tindre Message?**
Es una data class que deu contindre les variables de les dades a treballar a el missatge

**MessageViewHolder será utilitzada per treballar amb el missatge , primer capturant-lo per el id per tal de modificar i mostrar el missatge**

**L'objecte MessageData, que deu contindre?**
Deu contindre una funció per afegir un nou missatge, i la variable que pertany a la llista de message. Esta llista es mutable, per el motiu de que variará

**Canvis a MessageWindows, el controlador de els missatges**
treballem amb AdapterMessage(), i amb el messageRecyclerView, entonces deurem capturarlo en una variable, pasar el recyclerView per l'adaptador i pasarlo per el LayoutManager.

Desprès de que acó siga correcte, hi deurem de capturar el botó d'enviar, per tal de que al enviar es capture el text de el missatge, parsetjar-lo a String i si no etá buit, pasaem l'hora amb el format, i el missatge

**Canvis a Activity_message_Window.xml**
Deurem implementar el recyclerView ací, d'aquesta manera, i tenint encompte que aquest será el seu identificador:
    ´´´<androidx.recyclerview.widget.RecyclerView
        android:id="@+id/MessagesRecyclerView"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintTop_toBottomOf="@+id/connectionInfoTextView"
        app:layout_constraintBottom_toTopOf="@+id/MessageText"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />´´´

**Desprès aquest será introduir el my_msg_view_holder.xml proporcionat (no hi farem ningun canvi ací)**

