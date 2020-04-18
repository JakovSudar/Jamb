class Game {

    var dices = listOf<Dice>()

    public constructor(dices: List<Dice>){
        this.dices = dices
    }

    fun rollDices(){
        for(dice in this.dices){
            dice.roll()
        }
    }
    fun setDicesTo(num:Int){
        for(dice in this.dices){
            dice.value = num
        }
    }
    fun lockDices(indexes : List<Int>){
        for (index in indexes){
            dices[index-1].lockDice()
        }
    }
    fun unlockAllDices(){
        for ( dice in this.dices){
            dice.unlockDice()
        }
    }
    fun showDicesValues(){
        var i = 1
        for (dice in this.dices){
            println("Dice"+i+" val: " + dice.value )
            i++
        }
    }
}