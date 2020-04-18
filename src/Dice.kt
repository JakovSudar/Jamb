import java.util.concurrent.ThreadLocalRandom

class Dice {
    public var value = 0
    var locked = false

    fun roll(){
        if(!locked)
            this.value = ThreadLocalRandom.current().nextInt(1, 7)
    }
    fun lockDice(){
        this.locked = true
    }
    fun unlockDice(){
        this.locked = false
    }
}