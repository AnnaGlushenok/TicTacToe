package ticTacToe.tictactoe

class TicTacToe(private val field: Array<Array<Int>>) {
    companion object {
        val CROSS: Int = -1
        val CIRCLE: Int = 1
    }

    fun checkLines(): Array<Point> {
        val win = arrayOf(Point(0, 0), Point(0, 0), Point(0, 0))
        for (i in field.indices) {
            for (j in field[i].indices - 1) {
                if (field[i][j] != 0 && field[i][j] == field[i][j + 1]) {
                    win[j] = Point(i, j)
                    return win
                }
            }
        }
        return win
    }

    fun checkDiagonal(): Array<Point> {
        val win = arrayOf(Point(0, 0), Point(0, 0), Point(0, 0))

        return win
    }

    fun checkWin(arrays: Array<Array<Int>>): Int {
        checkDiagonal()
        checkLines()
        return CROSS
    }
}