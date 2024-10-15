package data

class TicketPro : Intermediario {
    override fun calcularPrecio(eventPrice: Double): Double {

        return eventPrice.times(1.02)

    }
}