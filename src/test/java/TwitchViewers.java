import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TwitchViewers {
    public static void main(String[] args) {
        List<Connects> connectsList = Connects.listConnect();
        Proxy proxy = new Proxy();

        List<Users> usersList = Users.listUser();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PParamonov\\IdeaProjects\\SeleniumTwitch\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("incognito");        //включить браузер в режиме инкогнито
        options.addExtensions(new File("C:\\Users\\PParamonov\\IdeaProjects\\SeleniumTwitch\\drivers\\0.3.1_0.crx"));
        List<WebDriver> drivers = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        System.out.println("Сколько зрителей запустить? \nДоступно : " + usersList.size());
        Options.count = scan.nextInt();

        for (int i = 0; i < Options.count; i++) {
            System.out.println("Выполняется подключение зрителем: " + (i + 1));
            proxy.setHttpProxy(connectsList.get(i).hostPort);
            options.setCapability("proxy", proxy);

            drivers.add(new ChromeDriver(options));
            drivers.get(i).get("http://api.ipify.org/");



            drivers.get(i).get(Options.url);
            drivers.get(i).manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
            System.out.println("Открыт линк: " + Options.url);

            drivers.get(i).findElement(By.xpath(Options.enterSite)).click();
            drivers.get(i).findElement(By.xpath(Options.enterLogin)).sendKeys(usersList.get(i).login);
            System.out.println("Логин: " + usersList.get(i).login);
            drivers.get(i).findElement(By.xpath(Options.enterPassword)).sendKeys(usersList.get(i).password);
            System.out.println("Пароль: " + usersList.get(i).password);
            drivers.get(i).findElement(By.xpath(Options.enterAuth)).click();
            drivers.get(i).findElement(By.xpath(Options.enterAuthCode));            //тут может выскачить проверка по кубикам

            WebDriver driverEmail = new ChromeDriver();
            driverEmail.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driverEmail.get(Options.urlMail);
            driverEmail.findElement(By.xpath(Options.mailLogin)).sendKeys(usersList.get(i).emailName);
            driverEmail.findElement(By.xpath(Options.mailDatList)).click();
            driverEmail.findElement(By.xpath("//*[@value='" + usersList.get(i).emailDat + "']")).click();
            driverEmail.findElement(By.xpath(Options.mailButtonAuth)).click();
            driverEmail.findElement(By.xpath(Options.mailPassword)).sendKeys(usersList.get(i).password);
            driverEmail.findElement(By.xpath(Options.mailEnter)).click();

            System.out.println("Выполнен вход на почту: " + usersList.get(i).emailName + usersList.get(i).emailDat);
            String verificationCode = "ничего не нашлось";
            if (driverEmail.findElements(By.xpath(Options.searchMailEng)).size() > 0) {
                System.out.println("Ищем англ версию письма");
                verificationCode = driverEmail.findElement(By.xpath(Options.searchMailEng)).getAttribute("innerHTML");
                System.out.println("было считанно: " + verificationCode);
            } else if (driverEmail.findElements(By.xpath(Options.searchMailRu)).size() > 0) {
                System.out.println("Ищем рус версию письма");
                verificationCode = driverEmail.findElement(By.xpath(Options.searchMailRu)).getAttribute("innerHTML");
                System.out.println("было считанно: " + verificationCode);
            } else {
                System.out.println("Код верификации не нашёлся..");
            }
            verificationCode = verificationCode.substring(0, verificationCode.indexOf(' '));
            verificationCode = verificationCode.replace("\n", "").replaceAll("\t", "");
            System.out.println("Код верификации на Twitch = " + verificationCode);
            driverEmail.quit();

            drivers.get(i).findElement(By.xpath(Options.enterAuthCode)).sendKeys(verificationCode);
            drivers.get(i).findElement(By.xpath(Options.radio)).click();

//            drivers.get(i).get(Options.urlChat);
            drivers.get(i).findElement(By.xpath(Options.sendMessage)).sendKeys("TwitchVotes ");
        }

        System.out.println("Для отключения зрителей ввести: Q");
        Scanner scanQ = new Scanner(System.in);
        String scanWord = scanQ.nextLine();

        if (scanWord.equalsIgnoreCase("Q")) for (int i = 0; i < Options.count; i++) {
            drivers.get(i).quit();
        }
    }
}