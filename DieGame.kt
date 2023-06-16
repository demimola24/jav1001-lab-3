package game

fun main() {
    testCreateAndRoll()
    //testCreateAndUpdateNumberOfSides()
    //test5OfAKind()
}


fun testCreateAndRoll() {
    //Create die with 10 sides
    val die = Die(DefaultSideType.TEN)

    println("Rolling d${die.valueNumberOfSides} die with initial side up as [${die.valueSideUp}]...")
    die.roll()
    println("Side up value for d${die.valueNumberOfSides} is now: [${die.valueSideUp}]")
    println()
}

fun testCreateAndUpdateNumberOfSides() {
    //Create die with 20 sides
    val die = Die(ColorType.ORANGE, DefaultSideType.TWENTY)
    die.showHighestValue()

    //Update Sides to custom value of 33
    println("Update highest value to 33")
    die.valueNumberOfSides = 33
    die.showHighestValue()
}


fun test5OfAKind() {
    //Create die with 20 sides
    var count = 0
    val expected = 5
    var foundAnsCheck = true
    println("Creating 5 d6...")
    val dieList = listOf(Die(), Die(), Die(), Die(), Die())
    val mutableList = mutableListOf<Int>()

    do {
        dieList.forEach {
            it.roll()
            foundAnsCheck = (it.valueSideUp == expected) && foundAnsCheck
            //To store rolled values
            mutableList.add(it.valueSideUp) 
        }
        //To show rolled values
        println(mutableList)
        mutableList.clear()
        count++
    } while (!foundAnsCheck)
    println("YAHTZEE! It took $count rolls")
}
