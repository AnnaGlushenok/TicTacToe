package ticTacToe.tictactoe

class Point(val i: Int,  val j: Int) {
    override fun equals(other: Any?): Boolean {
        val obj = (other as Point)
        return this.i == obj.i && this.j == obj.j
    }
}