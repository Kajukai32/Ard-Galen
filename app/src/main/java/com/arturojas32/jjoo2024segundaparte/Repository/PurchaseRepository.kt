package repositories

import data.Purchase

object PurchaseRepository {

    private val purchases = mutableListOf<Purchase>()

    init {
        purchases.add(Purchase(1L, 1504L, 1L, 350.50, "2024-04-10", "14A"))
        purchases.add(Purchase(2L, 1504L, 4L, 100.75, "2024-04-15", "22B"))
        purchases.add(Purchase(3L, 1504L, 7L, 250.50, "2024-05-01", "10C"))
        purchases.add(Purchase(4L, 1504L, 10L, 50.00, "2024-05-10", "5D"))
        purchases.add(Purchase(5L, 1504L, 3L, 1350.15, "2024-05-20", "8E"))
        purchases.add(Purchase(6L, 2802L, 2L, 20.30, "2024-06-05", "13F"))
        purchases.add(Purchase(7L, 2802L, 9L, 450.75, "2024-06-10", "3G"))
        purchases.add(Purchase(8L, 2802L, 2L, 500.00, "2024-06-15", "6H"))
        purchases.add(Purchase(9L, 1510L, 6L, 350.50, "2024-06-20", "9I"))
        purchases.add(Purchase(10L, 1510L, 5L, 150.00, "2024-06-25", "11J"))
    }

    fun add(purchase: Purchase) {

        purchases.add(purchase)
    }

    fun get(): List<Purchase> {

        return purchases
    }
}