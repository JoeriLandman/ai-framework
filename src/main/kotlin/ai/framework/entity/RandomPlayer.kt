package ai.framework.entity

import ai.framework.game.BoterKaasEierenBoard
import java.util.*

class RandomPlayer(val user: User): Player() {
    companion object {
        private val ran = Random()
    }

    override fun name(): String {
        return "Random"
    }

    override fun makeMove(request: MoveRequest): MoveResponse {
        val options = LinkedList<Pair<Int, Int>>()
        val board: BoterKaasEierenBoard = request.board as BoterKaasEierenBoard

        for (row in 0..2) {
            for (column in 0..2) {
                if (board.state[row][column] == -1) {
                    options.add(row to column)
                }
            }
        }

        val choice = options[ran.nextInt(options.size)]

        return request.answer(hashMapOf("row" to choice.first, "column" to choice.second))
    }
}