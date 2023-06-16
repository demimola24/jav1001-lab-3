package game

enum class ColorType {
    RED,
    WHITE,
    YELLOW,
    ORANGE,
    BLACK
}

enum class DefaultSideType(val value: Int) {
    SIX(6),
    TEN(10),
    TWENTY(20),
    HUNDRED(100)
}

// Primary constructor is in the class signature
class Die(private val color: ColorType, private val sideType: DefaultSideType) {

    private var sideUp: Int = 1
    private var numberOfSides: Int = sideType.value

    // External sideUp value accessible outside the class.
    var valueSideUp: Int
        get() {
            return sideUp
        }
        set(value) {
            this.sideUp = value
        }

    // External number of sides value accessible outside the class.
    var valueNumberOfSides: Int
        get() {
            return numberOfSides
        }
        set(value) {
            this.numberOfSides = value
            //reset roll
            roll()
        }

    // Called each time we initialize a new Die object.
    init {
        roll()
        println("Created: ${this}")
        println()
    }

    // Secondary constructors
    constructor() : this(ColorType.WHITE, DefaultSideType.SIX)

    constructor(sideType: DefaultSideType) : this(ColorType.WHITE, sideType)


    fun roll() {
        sideUp = (1..numberOfSides).random()
    }

    fun showHighestValue() {
        println("Highest value for d${numberOfSides} die is ${numberOfSides}.")
    }

    override fun toString(): String {
        return "This is a ${color.name.lowercase()} die with $numberOfSides faces and currently showing [$sideUp]."
    }

}
