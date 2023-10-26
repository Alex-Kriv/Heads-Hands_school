import GlobalVarlables.androidDriver
import TestFunctions.clickToElement
import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import openApp.StartMainPage.startMainPage
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterClass
import org.testng.annotations.AfterMethod
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeSuite
import screens.Onboarding.errorCheckButton
import screens.Onboarding.nextButton
import screens.Onboarding.pickupButton
import screens.Onboarding.selectRusButton
import java.net.URL
import java.time.Duration
import java.util.concurrent.TimeUnit

open class MainActivity {
    @BeforeSuite //
    fun installDriver() {
        // пока не понимаю как это убрать в отдельный класс, только если засунуть в обьект как startMainPage
        val capabilities = DesiredCapabilities()
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14")
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a")
        capabilities.setCapability(MobileCapabilityType.APP, "/users/admin/apps/app-profile.apk")
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2")
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "starter.school.client")
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "starter.school.client.MainActivity")
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true)

        val url = URL("http://127.0.0.1:4723/")

        androidDriver = AndroidDriver(url, capabilities) // устанавливаем аппиум драйвер для андроид
        // передавая ранее заданные параметры (capabilities)

        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)) //почему-то сломалось само по себе,

        startMainPage()
    }

    @AfterSuite // закрываем драйвер, но как оставить приложение в конечном состоянии?

    fun quitDriver() {
        androidDriver.quit()
    }

    @BeforeClass
    fun beforeClass(){

    }

    @AfterClass
    fun afterClass(){

    }

    @BeforeMethod
    fun launceApp(){
        androidDriver.activateApp(BUNDLE_ID)
        TimeUnit.SECONDS.sleep(5)
    }

    @AfterMethod
    fun closeApp() {
        androidDriver.terminateApp(BUNDLE_ID)
        TimeUnit.SECONDS.sleep(5)
    }

    companion object{
        const val BUNDLE_ID = "starter.school.client"
    }
}