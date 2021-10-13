import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateTax_masterCard() {
        //arrange
        val typeOfCard = "masterCard"
        val transferAmountPerMonth = 0
        val payment = 490_000_00

        //act
        val result = calculateTax(
            typeOfCard = typeOfCard,
            transferAmountPerMonth = transferAmountPerMonth,
            payment = payment
        )



        //assert
        assertEquals(296000, result)
    }

    @Test
    fun calculateTax_Visa() {
        //arrange
        val typeOfCard = "visa"
        val transferAmountPerMonth = 100_000_00
        val payment = 490_000_00

        //act
        val result = calculateTax(
            typeOfCard = typeOfCard,
            transferAmountPerMonth = transferAmountPerMonth,
            payment = payment
        )

        //assert
        assertEquals(367500, result)
    }

    @Test
    fun calculateTax_Vkpay() {
        //arrange
        val typeOfCard = "Vkpay"
        val transferAmountPerMonth = 100_000_00
        val payment = 490_000_00

        //act
        val result = calculateTax(
            typeOfCard = typeOfCard,
            transferAmountPerMonth = transferAmountPerMonth,
            payment = payment
        )

        //assert
        assertEquals(0, result)
    }


    @Test
    fun calculateTax_overLimit() {
        //arrange
        val typeOfCard = "Vkpay"
        val transferAmountPerMonth = 300_000_00
        val payment = 490_000_00

        //act
        val result = calculateTax(
            typeOfCard = typeOfCard,
            transferAmountPerMonth = transferAmountPerMonth,
            payment = payment
        )

        //assert
        assertEquals(-1, result)
    }







    @Test
    fun taxMasterCard() {
        //arrange
        val payment = 100_000_00

        //act
        val result = taxMasterCard(

            payment = payment
        )

        //assert
        assertEquals(62000, result)
    }

    @Test
    fun taxVisaCard() {
        //arrange
        val payment = 100_000_00

        //act
        val result = taxVisaCard(

            payment = payment
        )

        //assert
        assertEquals(75000, result)
    }

    @Test
    fun taxVkPay() {
        //arrange
        val payment = 10_000_00
        val transferAmountPerMonth = 20_000_00

        //act
        val result = taxVkPay(

            payment = payment,
            transferAmountPerMonth = transferAmountPerMonth
        )

        //assert
        assertEquals(0, result)
    }
}