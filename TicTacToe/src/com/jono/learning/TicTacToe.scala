package com.jono.learning

object TicTacToe extends App {

  var hasWinner = false
  var hasTie = false
  var board = new GameBoard
  var player = "X"
  var WinningPlayer = ""
  while (hasWinner == false && hasTie == false) {
    println("Player " + player + " Enter your row and column")
    val row = Console.readInt();
    val col = Console.readInt();
    board.setOccupier(row, col, player)
    val isBoardFull = board.isBoardFull()
    var boardResult = board.checkforWinner(player)
    board.printBoard()
    if (isBoardFull) {
      if (boardResult == false && board.checkforWinner("O") == false) {
        hasTie = true
        println("TIE GAME")
      }
    }
    if (boardResult) {
      WinningPlayer = "X"
      hasWinner = true
    } else if (board.checkforWinner("O")) {
      WinningPlayer = "O"
      hasWinner = true
    }

    if (hasWinner) {
      println("Winner is Player: " + WinningPlayer)
    } else {
      if (player == "X") {
        player = "O"
      } else {
        player = "X"
      }
    }

  }

}