package com.jono.learning

import scala.collection._

class GameBoard {
  val ROW_LENGTH = 3;
  val board = mutable.Buffer(
    "", "", "",
    "", "", "",
    "", "", "")

  def getOcupier(row: Integer, column: Integer) {
    board(getIndex(row, column))
  }

  def setOccupier(row: Integer, column: Integer, value: String) {
    if (board(getIndex(row, column)) == "") {
      board(getIndex(row, column)) = value
    }
    isBoardFull()
  }

  def isBoardFull(): Boolean = {
    board.foreach(e => if (e == "") { return false })
    return true
  }

  def getIndex(row: Integer, column: Integer): Integer = {
    return (row - 1) * ROW_LENGTH + (column - 1)
  }

  def checkforWinner(player: String): Boolean =
    {
      var result = false;
      if ((board(0) == player && board(1) == player && board(2) == player) ||
        (board(3) == player && board(4) == player && board(5) == player) ||
        (board(6) == player && board(7) == player && board(8) == player) ||
        (board(0) == player && board(3) == player && board(6) == player) ||
        (board(1) == player && board(4) == player && board(7) == player) ||
        (board(2) == player && board(5) == player && board(8) == player) ||
        (board(0) == player && board(4) == player && board(8) == player) ||
        (board(2) == player && board(4) == player && board(6) == player)) {
        result = true;
      }

      return result
    }

  def printBoard() {
    println(board(0) + "\t" + board(1) + "\t" + board(2))
    println(board(3) + "\t" + board(4) + "\t" + board(5))
    println(board(6) + "\t" + board(7) + "\t" + board(8))
  }
}