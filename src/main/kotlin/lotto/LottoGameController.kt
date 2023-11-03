package lotto

class LottoGameController {
    private val seller = Seller()
    private val input = Input()

    fun startLottoGame() {
        val lottoPapers = seller.sellLotto(input.inputMoney())
        printLotto(lottoPapers)

        val winningNumber = createWinningNumber()
    }

    private fun printLotto(lottoPaper: List<Lotto>) {
        println("\n${getLottoCount(lottoPaper)}${USER_LOTTO}")
        lottoPaper.forEach {
            it.printNumbers()
        }
    }

    private fun createWinningNumber(): WinningNumber = WinningNumber(input.inputWinningNumber())

    companion object {
        private var USER_LOTTO = "개를 구매했습니다."
        fun getLottoCount(lottoPaper: List<Lotto>): Int = lottoPaper.size

    }
}