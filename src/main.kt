
fun main(){
    var numToLock = 0
    var play = true
    val dice1 = Dice()
    val dice2 = Dice()
    val dice3 = Dice()
    val dice4 = Dice()
    val dice5 = Dice()
    val dice6 = Dice()
    var diceList = mutableListOf<Dice>(dice1,dice2,dice3,dice4,dice5,dice6)
    var dicesToLock = mutableListOf<Int>()
    var game = Game(diceList)
    var resultChecker = ResultChecker(game)

    while(play) {
        game.rollDices()
        game.showDicesValues()
        resultChecker.showResults()

        var successInput = false
        while(!successInput){
            println("Enter number of dices to lock: ")
            numToLock = readLine()!!.toInt()
            if(numToLock>6 || numToLock<0){
                println("You can lock from 0 to 6 dices")
            }else successInput = true
        }
        for (i in 1..numToLock) {
            successInput= false
            while (!successInput) {
                println("Enter " + i + ". dice to lock: ")
                val n = readLine()!!.toInt()
                if (n > 6 || n < 1) {
                    println("Please enter number in range of 1 to 6")
                }else if(n in dicesToLock) {
                    println("Already locked!")
                }
                else {
                    successInput = true
                    dicesToLock.add(n)
                }
            }
            successInput = false
        }

        game.lockDices(dicesToLock)
        println("Second rolling")
        game.rollDices()
        game.showDicesValues()
        resultChecker.showResults()
        game.unlockAllDices()
        dicesToLock.clear()
        println("Another game?[y/n]")
        var anotherGame = readLine()
        if(anotherGame=="n"){
            play = false
        }
    }
}