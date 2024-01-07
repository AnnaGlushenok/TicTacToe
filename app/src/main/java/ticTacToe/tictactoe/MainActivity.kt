package ticTacToe.tictactoe

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size
import ticTacToe.tictactoe.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var field = Array(3) {
        Array(3) { 0 }
    }
    private var active: Int = TicTacToe.CROSS
    private lateinit var ticTacToe: TicTacToe
    private lateinit var map: Map<String, ImageButton>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ticTacToe = TicTacToe(field)
        map = mapOf(
            "00" to binding.btn1,
            "01" to binding.btn2,
            "02" to binding.btn3,
            "10" to binding.btn4,
            "11" to binding.btn5,
            "12" to binding.btn6,
            "20" to binding.btn7,
            "21" to binding.btn8,
            "22" to binding.btn9
        )
        map.forEach { el ->
            el.value.setOnClickListener {
                step(
                    el.key[0].digitToInt(),
                    el.key[1].digitToInt(),
                    el.value
                )
            }
        }
        binding.newGameBtn.setOnClickListener {
            field = Array(3) {
                Array(3) { 0 }
            }
            clear()
        }
    }

    private fun step(i: Int, j: Int, view: View) {
        field[i][j] = if (field[i][j] == 0) active else return

        active = when (active) {
            TicTacToe.CROSS -> {
                (view as ImageButton).setImageResource(R.drawable.cross)
                binding.step.setImageResource(R.drawable.circle)
                TicTacToe.CIRCLE
            }

            TicTacToe.CIRCLE -> {
                (view as ImageButton).setImageResource(R.drawable.circle)
                binding.step.setImageResource(R.drawable.cross)
                TicTacToe.CROSS
            }

            else -> {
                0
            }
        }

        val win = ticTacToe.checkWin(field)
        if (win[0] != null)
            colorWin(win as Array<Point>)
    }

    private fun colorWin(win: Array<Point>) {
        val colorId: Int
        val imageId: Int
        if (field[win[0].i][win[0].j] == TicTacToe.CROSS) {
            colorId = R.color.light_red
            imageId = R.drawable.cross
        } else {
            colorId = R.color.light_blue
            imageId = R.drawable.circle
        }

        win.forEach {
            val btn: ImageButton = map[it.i.toString() + it.j.toString()]!!
            btn.setImageResource(imageId)
            btn.backgroundTintList = ContextCompat.getColorStateList(this, colorId)
        }
        map.values.forEach { it.isClickable = false }
        binding.konfetti.build()
            .addColors(Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE)
            .setDirection(0.0, 500.0)
            .setSpeed(1f, 7f)
            .setFadeOutEnabled(true)
            .setTimeToLive(100)
            .addShapes(Shape.Circle, Shape.Square)
            .addSizes(Size(12))
            .setPosition(-50f, binding.konfetti.width + 50f, -50f, binding.konfetti.height + 50f)
            .streamFor(500, 700L)
    }

    private fun clear() =
        map.values.forEach { el ->
            el.setImageResource(0)
            el.backgroundTintList = null
            el.colorFilter = null
            el.isClickable = true
        }
}
