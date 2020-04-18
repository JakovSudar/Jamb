class ResultChecker(val game: Game) {


    fun showResults(){
        if(checkJamb()) println("Jamb!")
        if(checkPoker()) println("Poker!")
        if(checkScale()) println("Skala!")
    }

    fun checkJamb(): Boolean{
        return game.dices.groupingBy { it.value }.eachCount().any { it.value > 4 }

    }
    fun checkPoker(): Boolean{
        return game.dices.groupingBy { it.value }.eachCount().any { it.value > 3 }
    }

    fun checkScale(): Boolean{
        //var sorted = game.dices.sortedBy { it.value }
        var sorted = game.dices.map {it.value}
        println(sorted)
        var scaleCount=0
        if(1 in sorted && 2 in sorted && 3 in sorted && 4 in sorted && 5 in sorted){
            return true
        }else if(2 in sorted && 3 in sorted && 4 in sorted && 5 in sorted && 6 in sorted){
            return true
        }
         return false
    }
}