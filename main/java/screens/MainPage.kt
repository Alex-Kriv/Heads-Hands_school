package screens

object MainPage {

    val mainPageButton = ScreenConstructor(
        androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]",
        elementName = "Кнопка возвращения на главный экран"
    )

    val hotDishButton = ScreenConstructor(
        androidAccessibilityId = "Горячее",
        elementName = "Выбор подраздела \"Горячее\"",
    )

     val snacksButton = ScreenConstructor(
         androidAccessibilityId = "Закуски",
         elementName = "Выбор подраздела \"Закуски\"",
     )

    val soupsButton = ScreenConstructor(
        androidAccessibilityId = "Супы",
        elementName = "Выбор подраздела \"Супы\"",
    )

    val pastaButton = ScreenConstructor(
        androidAccessibilityId = "Паста",
        elementName = "Выбор подраздела \"Паста\"",
    )

    val sandwichButton = ScreenConstructor(
        androidAccessibilityId = "Сендвичи",
        elementName = "Выбор подраздела \"Сендвичи\"",
    )
}