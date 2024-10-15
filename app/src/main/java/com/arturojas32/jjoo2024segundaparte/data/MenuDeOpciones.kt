package data

enum class MenuDeOpciones(val opcion: Int, val descripcion: String) {
    MEDALLERO(1, ". Mostrar medallero->"),
    HISTORIALCOMPRAS(2, ". Mostrar historial de compras->"),
    COMPRARENTRADA(3, ". Comprar entrada->"),
    MOSTRAREVENTOS(4, ". Mostrar eventos disponibles->"),
    SALIR(5, ". Salir->")
}