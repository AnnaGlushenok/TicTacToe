package ticTacToe.tictactoe

import org.junit.Assert.assertArrayEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTest {
    @Test
    fun checkHorizontalLinesTest() {
        val test1 = TicTacToe(
            arrayOf(
                arrayOf(0, 0, 0),
                arrayOf(0, 0, 0),
                arrayOf(0, 0, 0)
            )
        )
        val test2 = TicTacToe(
            arrayOf(
                arrayOf(1, 1, 1),
                arrayOf(0, 0, 0),
                arrayOf(0, 0, 0)
            )
        )
        val test3 = TicTacToe(
            arrayOf(
                arrayOf(0, 0, 0),
                arrayOf(1, 1, 1),
                arrayOf(0, 0, 0)
            )
        )
        val test4 = TicTacToe(
            arrayOf(
                arrayOf(0, 0, 0),
                arrayOf(0, 0, 0),
                arrayOf(-1, -1, -1)
            )
        )

        val array1 = arrayOfNulls<Point>(3)
        val array2 = arrayOf(Point(0, 0), Point(0, 1), Point(0, 2))
        val array3 = arrayOf(Point(1, 0), Point(1, 1), Point(1, 2))
        val array4 = arrayOf(Point(2, 0), Point(2, 1), Point(2, 2))

        val answer1 = test1.checkLines()
        val answer2 = test2.checkLines()
        val answer3 = test3.checkLines()
        val answer4 = test4.checkLines()
        assertArrayEquals(array1, answer1)
        assertArrayEquals(array2, answer2)
        assertArrayEquals(array3, answer3)
        assertArrayEquals(array4, answer4)
    }

    @Test
    fun checkVerticalLinesTest() {
        val test1 = TicTacToe(
            arrayOf(
                arrayOf(0, 0, 0),
                arrayOf(0, 0, 0),
                arrayOf(0, 0, 0)
            )
        )
        val test2 = TicTacToe(
            arrayOf(
                arrayOf(-1, 0, 0),
                arrayOf(-1, 0, 0),
                arrayOf(-1, 0, 0)
            )
        )
        val test3 = TicTacToe(
            arrayOf(
                arrayOf(0, 1, 0),
                arrayOf(0, 1, 0),
                arrayOf(0, 1, 0)
            )
        )
        val test4 = TicTacToe(
            arrayOf(
                arrayOf(0, 0, -1),
                arrayOf(0, 0, -1),
                arrayOf(0, 0, -1)
            )
        )

        val array1 = arrayOfNulls<Point>(3)
        val array2 = arrayOf(Point(0, 0), Point(1, 0), Point(2, 0))
        val array3 = arrayOf(Point(0, 1), Point(1, 1), Point(2, 1))
        val array4 = arrayOf(Point(0, 2), Point(1, 2), Point(2, 2))

        val answer1 = test1.checkLines()
        val answer2 = test2.checkLines()
        val answer3 = test3.checkLines()
        val answer4 = test4.checkLines()
        assertArrayEquals(array1, answer1)
        assertArrayEquals(array2, answer2)
        assertArrayEquals(array3, answer3)
        assertArrayEquals(array4, answer4)
    }

    @Test
    fun checkDiagonalTest() {
        val test1 = TicTacToe(
            arrayOf(
                arrayOf(1, 0, 0),
                arrayOf(0, 1, 0),
                arrayOf(0, 0, 1)
            )
        )
        val test2 = TicTacToe(
            arrayOf(
                arrayOf(0, 0, -1),
                arrayOf(0, -1, 0),
                arrayOf(-1, 0, 0)
            )
        )

        val array1 = arrayOf(Point(0, 0), Point(1, 1), Point(2, 2))
        val array2 = arrayOf(Point(0, 2), Point(1, 1), Point(2, 0))

        val answer1 = test1.checkDiagonal()
        val answer2 = test2.checkDiagonal()

        assertArrayEquals(array1, answer1)
        assertArrayEquals(array2, answer2)
    }

    @Test
    fun checkWinTest() {
        val ticTacToe = TicTacToe(Array(3) {
            Array(3) { 0 }
        })
        ticTacToe.checkWin(Array(3) {
            Array(3) { 0 }
        })
    }
}
