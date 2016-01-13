var compare = function(choice1, choice2) {
    if (choice1 === choice2) {
        return "It's a tie.";
        console.log("It's a tie.");
    } else if (choice1 === "rock") {
        switch (choice2) {
            case "scissors":
            case "lizard":
                return "You win!";
                break;
            case "paper":
            case "spock":
                return "You lose.";
                break;
        }
    } else if (choice1 === "scissors") {
        switch (choice2) {
            case "paper":
            case "lizard":
                return "You win!";
                break;
            case "rock":
            case "spock":
                return "You lose.";
                break;
        }
    } else if (choice1 === "paper") {
        switch (choice2) {
            case "rock":
            case "spock":
                return "You win!";
                break;
            case "scissors":
            case "lizard":
                return "You lose.";
                break;
        }
    } else if (choice1 === "lizard") {
        switch (choice2) {
            case "spock":
            case "paper":
                return "You win!";
                break;
            case "scissors":
            case "rock":
                return "You lose.";
                break;
        }
    } else if (choice1 === "spock") {
        switch (choice2) {
            case "scissors":
            case "rock":
                return "You win!";
                break;
            case "paper":
            case "lizard":
                return "You lose.";
                break;
        }
    } else {
        switch (choice2) {
            case "scissors":
            case "rock":
            case "paper":
            case "lizard":
                return("Wrong data input. Please specify correct figure.");
                break;
        }
    }
};
var game = true;
while (game) {
    var userChoice=prompt("Do you choose rock, paper, scissors, lizard or Spock?").toLowerCase();
    while (userChoice!="rock" && userChoice!="scissors" && userChoice!="paper" && userChoice!="lizard" && userChoice!="spock" && userChoice!=null) {
    userChoice = prompt("Make sure to pick one of those: rock, paper, scissors, lizard or Spock.").toLowerCase();
    }
    if (userChoice === null) {
        game = false;
        break;
    }
    var computerChoice = Math.random(0,1);
    if (computerChoice > 0 && computerChoice <= 0.2) {
        computerChoice = "rock";
    } else if (computerChoice > 0.2 && computerChoice <= 0.4) {
        computerChoice = "paper";
    } else if (computerChoice > 0.4 && computerChoice <= 0.6) {
        computerChoice = "scissors";
    } else if (computerChoice > 0.6 && computerChoice <= 0.8) {
        computerChoice = "lizard";
    } else if (computerChoice > 0.8 && computerChoice <= 1) {
        computerChoice = "spock";
    }
    console.log("You: " + userChoice);
    console.log("Computer: " + computerChoice);
    var gameResult = compare(userChoice,computerChoice);
    console.log(gameResult);
    if (gameResult == "You win!") {
        var endGame = confirm("You win! Wanna play again?");
    } else if (gameResult == "You lose.") {
        var endGame = confirm("You lose. Wanna play again?");
    } else {
        var endGame = confirm("It's a tie! Wanna play again?");
    }
    if (endGame == false) {
        game = false;
    }
}
