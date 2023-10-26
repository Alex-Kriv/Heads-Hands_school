import GlobalVarlables.androidDriver
import io.appium.java_client.AppiumBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Pause
import org.openqa.selenium.interactions.PointerInput
import org.openqa.selenium.interactions.Sequence
import org.openqa.selenium.support.pagefactory.ElementLocator
import org.w3c.dom.Text
import java.time.Duration

object TestFunctions {

    fun clickToElement(locator: String, locatorType: LocatorType){
        // создаем глобальную функцию клика по элементу
        val element = findElement(locator, locatorType)
        element.click()
    }

    fun sendText(locator: String, locatorType: LocatorType, text: String){
        val element = findElement(locator, locatorType)
        element.sendKeys(text)
    }

    fun clearField(locator: String, locatorType: LocatorType){
        val element = findElement(locator, locatorType)
        element.clear()
    }

    /*fun takeCheckCode(){
        val text = androidDriver.pageSource
        //(Введите код из смс&#10; начало), (конец &#10;), сдвиг по ключевым символам/словам
        val textOne = text.substringAfter("Введите код из смс&#10;")
        val textTwo = textOne.substringBefore('&')
    }*/

    fun tapByCoordinates(cordX: Int, cordY: Int) {

        val finger = PointerInput(PointerInput.Kind.TOUCH,"finger")
        val actions = Sequence(finger,1) // сиквенция из силениума

        actions.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), cordX, cordY))
        actions.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
        actions.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))

        androidDriver.perform(listOf(actions))
    }

    fun swipeOnScreen(startCordX: Int, startCordY: Int, moveCordX: Int, moveCordY: Int){

        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")
        val actions = Sequence(finger,1)

        actions.addAction((finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startCordX, startCordY)))
        actions.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
        actions.addAction(Pause(finger, Duration.ofMillis(600)))
        actions.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), moveCordX, moveCordY))
        actions.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))

        androidDriver.perform(listOf(actions))
    }

    fun checkAvailableElement(locator: String, locatorType: LocatorType): Boolean{
        // вот здесь непонятно, почему в примере лекции мы задавали явно значение переменной = false
        // а при подобной реализации переменную обьявлять не нужно?
        // поиск элемента, если найден - тру, если нет - фалс
        val element = findElement(locator, locatorType)
        return element.isEnabled
    }



    private fun findElement(locator: String, locatorType: LocatorType) : WebElement {
        return when (locatorType) {
            //  не понятен синтаксис : webelement
            LocatorType.ID -> androidDriver.findElement(AppiumBy.id(locator))
            LocatorType.XPATH -> androidDriver.findElement(AppiumBy.xpath(locator))
            LocatorType.ACCESSIBILITY_ID ->  androidDriver.findElement(AppiumBy.accessibilityId(locator))
            LocatorType.CLASS_NAME -> androidDriver.findElement(AppiumBy.className(locator))
        }
    }

    }
