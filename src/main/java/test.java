import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class test {

    public static void bmpTest() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PParamonov\\IdeaProjects\\SeleniumTwitch\\drivers\\chromedriver.exe");
//        BrowserMobProxy proxy = new BrowserMobProxyServer();
//        proxy.start(0);
//        int port = proxy.getPort(); // get the JVM-assigned port
//        // Selenium or HTTP client configuration goes here

        // start the proxy
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(0);

        // get the Selenium proxy object
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        // configure it as a desired capability
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

        // start the browser up
        WebDriver driver = new ChromeDriver(capabilities);

        // enable more detailed HAR capture, if desired (see CaptureType for the complete list)
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

        // open yahoo.com
        driver.get("https://www.twitch.tv/moby812");
    }
}