package ticTacToe.tictactoe

class TicTacToe(private var field: Array<Array<Int>>) {
    companion object {
        val CROSS: Int = -1
        val CIRCLE: Int = 1
    }

    fun checkLines(): Array<Point?> {
        val win: Array<Point?> = arrayOfNulls(3)
        for (i in field.indices) {
            if (field[i][0] != 0 && field[i][0] == field[i][1] && field[i][1] == field[i][2]) {
                win[0] = Point(i, 0)
                win[1] = Point(i, 1)
                win[2] = Point(i, 2)
            }
        }
        for (i in field.indices) {
            if (field[0][i] != 0 && field[0][i] == field[1][i] && field[1][i] == field[2][i]) {
                win[0] = Point(0, i)
                win[1] = Point(1, i)
                win[2] = Point(2, i)
            }
        }
        return win
    }

    fun checkDiagonal(): Array<Point?> {
        val win: Array<Point?> = arrayOfNulls(3)
        if (field[0][0] != 0 && field[0][0] == field[1][1] && field[1][1] == field[2][2]) {
            win[0] = Point(0, 0)
            win[1] = Point(1, 1)
            win[2] = Point(2, 2)
        }
        if (field[0][2] != 0 && field[0][2] == field[1][1] && field[1][1] == field[2][0]) {
            win[0] = Point(0, 2)
            win[1] = Point(1, 1)
            win[2] = Point(2, 0)
        }
        return win
    }

    fun checkWin(arrays: Array<Array<Int>>): Array<Point?> {
        field = arrays
        var win = checkLines()
        if (win[0] == null)
            win = checkDiagonal()

        return win
    }
}