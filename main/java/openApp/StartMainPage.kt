package openApp

import TestFunctions.clickToElement
import screens.Onboarding
import java.util.concurrent.TimeUnit

object StartMainPage {
    fun startMainPage() {
        try {

            clickToElement(
                Onboarding.selectRusButton.androidAccessibilityId,
                LocatorType.ACCESSIBILITY_ID
            ) //выбор кнопки рус
            clickToElement(
                Onboarding.nextButton.androidAccessibilityId,
                LocatorType.ACCESSIBILITY_ID
            ) // нажать на кнопку далее
            // clickToElement(locator = "Далее", locatorType = LocatorType.ACCESSIBILITY_ID) // то же что и выше
            TimeUnit.SECONDS.sleep(5)
            clickToElement(
                Onboarding.pickupButton.androidAccessibilityId,
                LocatorType.ACCESSIBILITY_ID
            ) // нажать на кноку самовывоз
            clickToElement(
                Onboarding.errorCheckButton.androidAccessibilityId,
                LocatorType.ACCESSIBILITY_ID
            ) // поиск несуществующей кнопки try catch

        } catch (err: org.openqa.selenium.NoSuchElementException) {
            println("Поймана ошибка поиска одного из элементов при прохождении этапа открытия главного экрана приложения")
        }

        TimeUnit.SECONDS.sleep(5)
    }
}