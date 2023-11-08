package lotto.validation

enum class BonusNumberValidation(private val errorMessage: String) {
    ERROR_MESSAGE("Validation Start"),
    EMPTY_NUMBER("[ERROR] 값을 입력해 주세요."),
    INCLUDE_BLANK("[ERROR] 공백을 제외하고 입력해 주세요"),
    BONUS_MORE_ONE("[ERROR] 보너스 번호는 하나만 입력 가능합니다."),
    OUT_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    fun getErrorMessage(bonusNumber: String) {
        when {
            bonusNumber.isEmpty() -> throw IllegalArgumentException(EMPTY_NUMBER.errorMessage)
            bonusNumber.contains(",") -> throw IllegalArgumentException(BONUS_MORE_ONE.errorMessage)
            bonusNumber.contains(" ") -> throw IllegalArgumentException(INCLUDE_BLANK.errorMessage)
            bonusNumber.toInt() !in (1..45) -> throw IllegalArgumentException(OUT_NUMBER_RANGE.errorMessage)
        }
    }
}