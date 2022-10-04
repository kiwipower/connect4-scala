package connect4.unit

import connect4.{Board, Player}
import org.scalatest.matchers.should.Matchers._
import org.scalatest.funspec.AnyFunSpec

class BoardSpec extends AnyFunSpec {

  it("draws an empty board") {
    new Board().draw() shouldBe
      """ 1 2 3 4 5 6 7
        |---------------
        || | | | | | | |
        || | | | | | | |
        || | | | | | | |
        || | | | | | | |
        || | | | | | | |
        || | | | | | | |
        |---------------""".stripMargin
  }

  it("player 1 chooses a column") {
    val board = new Board()
    board.play(Player('X', "P1"), 1)
    board.draw() shouldBe
      """ 1 2 3 4 5 6 7
        |---------------
        || | | | | | | |
        || | | | | | | |
        || | | | | | | |
        || | | | | | | |
        || | | | | | | |
        ||X| | | | | | |
        |---------------""".stripMargin
  }

}
