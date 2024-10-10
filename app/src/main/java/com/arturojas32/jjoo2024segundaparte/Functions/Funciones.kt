package functions

import android.content.Context
import android.widget.Toast
import data.Country
import data.Elite
import data.Event
import data.Intermediario
import data.MenuDeOpciones
import data.Purchase
import data.TicketPro
import data.UltimateEvent
import data.User
import repositories.EventRepository
import repositories.EventRepository.getById
import repositories.MedalTableRepository
import repositories.PurchaseRepository
import java.lang.System.currentTimeMillis
import java.time.LocalDate

fun Creditos() {

    println("Saliendo...")
    println("Programación móvil 1 - 2024")
    println("Cátedra: Brian Bayarri - Aylén Hoz")
    println("Trabajo práctico - Parte 1 - Olimpiadas 2024")
    println("Grupo: Rock && Code")
    println("Integrantes: Mucci Natalia, Olivera Christian, Olmedo Arturo")
}

fun menu(usuario: User) {

    var opcionMenu: MenuDeOpciones
    var opcionClase: MenuDeOpciones
    var option: Int?
    val ticketId: Long

    println("Elija una opcion por favor->")
    do {
        for (option in MenuDeOpciones.entries) {
            println("${option.opcion} ${option.descripcion}")
        }
        option = readlnOrNull()?.toIntOrNull()

        if (option !in 1..5) println("INGRESE UNA OPCION VALIDA")

    } while (option !in 1..5)
    opcionMenu = MenuDeOpciones.entries.find { it.opcion == option }!!


    when (opcionMenu) {

        MenuDeOpciones.MEDALLERO -> mostrarMedallero(MedalTableRepository.get(), usuario)
        MenuDeOpciones.MOSTRAREVENTOS -> mostrarEventosDisp(EventRepository.get(), usuario)
        MenuDeOpciones.HISTORIALCOMPRAS -> verHistorial(usuario)
        MenuDeOpciones.COMPRARENTRADA -> menuDeCompra(usuario)
        MenuDeOpciones.SALIR -> Creditos()
    }

}


fun menuDeCompra(usuario: User) {


    var idEvento: Long?
    var nroAsiento: String?
    var IntermSeleccionado: Intermediario?
    var indexMenuSeleccionado: Int?
    val generateIdPurchase: () -> Long = { currentTimeMillis() }
    val actualizarMoney: (User, Double) -> Unit = { user: User, d: Double ->
        println("Saldo anterior a la compra ${user.money}")
        user.money = user.money.minus(d)
        println("saldo posterior a la compra ${user.money}")
    }
    val precioFinal: Double
    val idPurchase = generateIdPurchase()


    do {
        println("Ingrese el id del evento al que desea asistir->")
//        mostrarEventosDisp(EventRepository.get(), usuario)
        idEvento = readlnOrNull()?.toLong()

    } while (EventRepository.get().filter { it.id == idEvento }.isEmpty() || idEvento == null)

    println("Con cual de nuestros servicios le gustaria realizar la compra?->")
    println("1 - TicketPro (2% de comision)")
    println("2 - Elite (1% de comision entre las 20:00 y la 23:59, 3% fuera de de horario)")
    println("3 - UltimateEvent (3% los fines de semana, 0.75% de lunes a viernes)")
    println("4 - Ir al menu anterior")
    indexMenuSeleccionado = readlnOrNull()?.toIntOrNull()

    IntermSeleccionado = when (indexMenuSeleccionado) {

        1 -> TicketPro()
        2 -> Elite()
        3 -> UltimateEvent()
        else -> null
    }
    if (IntermSeleccionado == null) menu(usuario)
    precioFinal = IntermSeleccionado!!.calcularPrecio(getById(idEvento).price)

    try {

        if (precioFinal > usuario.money) {
            throw IllegalArgumentException("Insuficientes fondos")


        } else {
            println("..muy bien ahora por favor elija un numero de asiento, por ej el 18B ->")

            do {
                nroAsiento = readlnOrNull()?.uppercase()
                if (nroAsiento == null || nroAsiento == "") println("Numero de asiento no valido, intente nuevamente")

            } while (nroAsiento == null || nroAsiento == "")

            PurchaseRepository.add(
                Purchase(
                    id = idPurchase,
                    userId = usuario.id,
                    eventId = idEvento,
                    amount = precioFinal,
                    createdDate = Currentdate(),
                    seat = nroAsiento
                )
            )
            actualizarMoney(usuario, precioFinal)
            println("Compra del boleto con el id $idPurchase realizada exitosamente..\n")
            menu(usuario)

        }
    } catch (e: IllegalArgumentException) {
        println("IllegalArgumentException: ${e.message.toString()}")
        menu(usuario)
    }
}

fun verHistorial(user: User) {

    var historial =
        PurchaseRepository.get().filter { it.userId == user.id }.sortedBy { it.createdDate }
    for (purchase in historial) {
        println(
            " Fecha de compra: ${purchase.createdDate}\n Total de la compra: ${purchase.amount}\n" +
                    " EventId: ${purchase.eventId}\n Id de la compra: ${purchase.id}\n Asiento: ${purchase.seat}\n ID de Usuario: ${purchase.userId}\n"
        )
    }
    menu(user)

}

fun mostrarMedallero(lista: List<Country>, usuario: User) {

    for (country in lista) {
        println("Posicion : ${country.position} ,Pais: ${country.name} \nMedallas: Oro: ${country.goldMedals}, Plata: ${country.silverMedals}, Bronce: ${country.bronzeMedals} \n")
//        println("Posicion : ${country.position} ,Pais: ${country.name} ,Id: ${country.id} \nMedallas,Oro: ${country.goldMedals}, Plata: ${country.silverMedals}, Bronce: ${country.bronzeMedals} ")
    }
    println("Volviendo al menu\n")
    menu(usuario)

}

fun mostrarEventosDisp(lista: List<Event>, usuario: User) {

    println("Eventos disponibles-> \n")
    for (evento: Event in lista) {

        println("Id: ${evento.id}, Fecha : ${evento.date},Hora: ${evento.hour},Lugar: ${evento.place}, Precio: ${evento.price} ")
    }

    println("\nVolviendo al menu\n")
    menu(usuario)

}


fun Currentdate(): String = LocalDate.now().toString()

fun displayToast(msg: String, contextCompat: Context) {

    Toast.makeText(contextCompat, msg, Toast.LENGTH_SHORT).show()

}