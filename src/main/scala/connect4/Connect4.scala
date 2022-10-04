package connect4

case class Player(sign: Char, name: String)

sealed trait GameState
case object Playing extends GameState
case object Draw extends GameState
case class Winner(sign: Char) extends GameState

class Board(private val board: Array[Array[String]]) {

  def this() = this(Array.fill(6, 7)(" "))

  def draw(): String = {
    val columnNumbers = " 1 2 3 4 5 6 7"
    val horizontalSeparator = "---------------"

    s"""|$columnNumbers
        |$horizontalSeparator
        |${board.map(_.mkString("|", "|", "|")).mkString("\n|")}
        |$horizontalSeparator""".stripMargin
  }

  def play(p: Player, column: Int): Either[String, Board] = Right(new Board(board)) //TODO

  def gameState: GameState = Playing //TODO
}