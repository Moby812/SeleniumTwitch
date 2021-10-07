import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PParamonov\\IdeaProjects\\SeleniumTwitch\\drivers\\chromedriver.exe");
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("91.77.162.117:8080");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("proxy", proxy);
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://api.ipify.org/");

//        driver.manage().window().maximize();
//        driver.quit();
    }
}