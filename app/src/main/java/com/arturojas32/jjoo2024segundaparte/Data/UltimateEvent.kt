package data


import java.time.DayOfWeek
import java.time.LocalDate

class UltimateEvent : Intermediario {
    override fun calcularPrecio(eventPrice: Double): Double {

        var valorFinal = 0.0
        var currentDay = LocalDate.now().dayOfWeek

        if (currentDay == DayOfWeek.SATURDAY || currentDay == DayOfWeek.SUNDAY) {

            valorFinal = eventPrice.times(1.03)
        } else {
            valorFinal = eventPrice.times(1.0075)
        }

        return valorFinal

    }
}
//ULTIMATEEVENT(3, "Ultimate Event(3% los fines de semana, 0.75% de lunes a viernes)"),