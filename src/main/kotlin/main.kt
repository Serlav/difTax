//fun main() {
  //  calculateTax("masterCard", 0, 500_000_00)
//}

fun calculateTax(
    typeOfCard: String = "vkPay",
    transferAmountPerMonth: Int = 0,
    payment: Int
): Int {
    if (transferAmountPerMonth + payment < 600_000_00) {
        val tax = when (typeOfCard) {
            "masterCard" -> taxMasterCard(payment)
            "visa" -> taxVisaCard(payment)
            "VkPay" -> taxVkPay(payment, transferAmountPerMonth)
            else -> 0
        }
        val paymentPlusTax = (payment + tax) / 100
        val totalPerMonth = transferAmountPerMonth / 100 + paymentPlusTax


        println("Перевод через $typeOfCard на сумму $paymentPlusTax руб.  выполнен")
        println("С учетом комиссии $tax коп.")
        println("В этом месяце переведено $totalPerMonth руб.")
        println()

        return tax

    } else println("Превышен лимит перевода в месяц")
    return -1
}

fun taxMasterCard(payment: Int): Int {
    val tax = if (payment > 75_000_00)
        payment * 0.006 + 20_00
    else 0
    return tax.toInt()
}

fun taxVisaCard(payment: Int): Int {
    val tax = if (payment * 0.0075 > 35_00) {
        payment * 0.0075
    } else {
        35_00
    }
    return tax.toInt()
}

fun taxVkPay(payment: Int, transferAmountPerMonth: Int): Int {
    val tax = if (payment < 15_000_00 && transferAmountPerMonth < 40_000_00) {
        0
    } else {    //тут надо как то по другому
        2
    }
    return tax
}