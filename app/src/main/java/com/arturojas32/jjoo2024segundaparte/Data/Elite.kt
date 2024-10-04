package data

import java.time.LocalTime

class Elite : Intermediario {

    override fun calcularPrecio(eventPrice: Double): Double {

        var valorFinal = 0.0
//        var currentHour: () -> Int = { LocalTime.now().hour }
        var currentHour = LocalTime.now().hour

        if (currentHour in 20..23) {
            valorFinal = eventPrice.times(1.01)
        } else {
            valorFinal.times(1.03)
        }

        return valorFinal
    }
}


//    ELITE(2, "Elite(1% de comision entre las 20:00 y la 23:59, 3% fuera de se horario)"),
