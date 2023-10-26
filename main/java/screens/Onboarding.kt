package screens

object Onboarding {

    val selectRusButton = ScreenConstructor(
        androidAccessibilityId = "Русский",
        elementName = "Вывод русскоко языка на экране онбординга"
    )

    val nextButton = ScreenConstructor(
        androidAccessibilityId = "Далее",
        elementName = " кнопка далее "
    )

    val pickupButton = ScreenConstructor(
        androidAccessibilityId = "Самовывоз",
        elementName = "Выбор режима \"Самовывоз\""
    )

    val errorCheckButton = ScreenConstructor(
        androidAccessibilityId = "Ключ ошибки",
        elementName = "Данный элемент не найден"
    )

}