fun main() {
    println("=== Rock Paper Scissors ===")
    var player = 0
    var computer = 0
    var tries = 0

    while (tries < 3) {
        println("\n--- Round ${tries + 1} ---")
        val playerChoice = getChoice()
        val computerChoice = (1..3).random()
        
        println("You: ${getMove(playerChoice)} | Computer: ${getMove(computerChoice)}")
        
        when {
            playerChoice == computerChoice -> println("Tie!")
            playerChoice % 3 + 1 == computerChoice -> {
                println("You win!")
                player++
            }
            else -> {
                println("Computer wins!")
                computer++
            }
        }
        println("Score: You $player - Computer $computer")
        tries++
    }

    println("\n=== FINAL ===")
    println("You: $player | Computer: $computer")
    println(when {
        player > computer -> "JUSTICE! YOU WIN!"
        computer > player -> "COMPUTER WINS!"
        else -> "FAIR TIE!"
    })
}

fun getChoice(): Int {
    while (true) {
        println("1-Rock 2-Paper 3-Scissors")
        print("Your choice: ")
        readln().toIntOrNull()?.takeIf { it in 1..3 }?.let { return it }
        println("Invalid! Enter 1-3")
    }
}

fun getMove(choice: Int) = when(choice) {
    1 -> "Rock"
    2 -> "Paper" 
    else -> "Scissors"
}