package screens

object Profile {

    val profileButton = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]",
        elementName = "Кнопка перехода в окно профиля",
    )

    val logInButton = ScreenConstructor(
        androidXPath = "//android.view.View[@content-desc=\"Войти\"]",
        androidAccessibilityId = "Войти",
        elementName = "Кнопка перехода в окно авторизации",
    )

    val enteringNumberBox = ScreenConstructor(
        androidXPath = "//android.view.View[@content-desc=\"Укажите телефон\n" +
                "На него отправим код подтверждения\"]/android.widget.EditText",
        elementName = "Поле ввода номера телефона",
    )

    val takeCodeButton = ScreenConstructor(
        androidAccessibilityId = "Получить код",
        elementName = "Кнопка получить код",
    )

    val sendCodeField = ScreenConstructor(
        androidClassName = "android.widget.EditText",
        elementName = "Поле ввода кода авторизации",
    )

    val exitButton = ScreenConstructor(
        androidAccessibilityId = "Выйти",
        androidXPath = "//android.widget.ImageView[@content-desc=\"Выйти\"]",
        elementName = "Кнопка выйти из профиля"
    )

    val paymentMethod = ScreenConstructor(
        androidXPath = "//android.widget.ImageView[@content-desc=\"Способы оплаты\"]",
        androidAccessibilityId = "Способы оплаты",
        elementName = "Выбрать способ оплаты",
    )
}