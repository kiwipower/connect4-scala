package connect4

import cats.effect.{IO, IOApp}
import cats.syntax.all._

import scala.io.StdIn
import scala.util.matching.Regex

object GameRunner extends IOApp.Simple {

  private val p1 = Player('X', "Player1")
  private val p2 = Player('O', "Player2")
  private val selectColumn: Regex = "([1-7])".r

  def dropCoin(b: Board, currentPlayer: Player, column: String): Either[String, Board] = column match {
    case selectColumn(c) => b.play(currentPlayer, c.toInt)
    case _ => Left(s"Select a column from 1-7: not '$column'")
  }

  def swapPlayer(p: Player): Player = if (p == p1) p2 else p1

  def eval(command: String, board: Board, p: Player): IO[Unit] =
    if (command == null) IO.unit else dropCoin(board, p, command) match {
      case Left(err)                          => IO(println(s"Err: $err"))                                        *> loop(board, p)
      case Right(b) if b.gameState == Playing => IO(println(b.draw()))                                            *> loop(b, swapPlayer(p))
      case Right(b)                           => IO(println(s"Game finished as ${b.gameState} : \n${b.draw()}"))  *> IO.unit
    }

  def loop(board: Board, p: Player): IO[Unit] =
    for {
      _           <- IO(print(s"> Choose a column ${p.name}: "))
      line        <- IO(StdIn.readLine)
      _           <- eval(line, board, p)
    } yield ()

  def run: IO[Unit] = loop(new Board(), p1)
}