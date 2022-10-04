package connect4

import scala.collection.mutable.ArrayBuffer

case class Player(sign: Char, name: String)

sealed trait GameState

case object Playing extends GameState

case object Draw extends GameState
case class Winner(sign: Char) extends GameState

class Board(private val board: ArrayBuffer[ArrayBuffer[String]]) {

  def this() = this(ArrayBuffer.fill(7, 6)(" "))

  def draw(): String = {
    val columnNumbers = " 1 2 3 4 5 6 7"
    val horizontalSeparator = "---------------"

    s"""|$columnNumbers
        |$horizontalSeparator
        |${board.transpose.map(_.mkString("|", "|", "|")).mkString("\n|")}
        |$horizontalSeparator""".stripMargin
  }

  def play(p: Player, column: Int): Either[String, Board] = Right(new Board(board)) //TODO

  def gameState: GameState = Playing //TODO
}