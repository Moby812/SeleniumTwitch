
public class Options {

    static Integer count = 1;
    private static final String streamer = "hook33";

    static String url = "https://twitch.tv/"+streamer;
    static String urlMail = "https://mail.ru/";
    static String urlChat = "https://www.twitch.tv/popout/"+streamer+"/chat";
    static String sendMessage = "//*[@data-a-target =\"chat-input\"]";


    static String enterSite = "//*[@id=\"root\"]/div/div[2]/nav/div/div[3]/div[3]/div/div[1]/div[1]/button/div";
    static String enterLogin = "//*[@id=\"login-username\"]";
    static String enterPassword = "//*[@id=\"password-input\"]";
    static String enterAuth = "/html/body/div[3]/div/div/div/div/div/div[1]/div/div/div[3]/form/div/div[3]/button/div";
    static String enterAuthCode = "/html/body/div[3]/div/div/div/div/div/div[1]/div/div/div[3]/div[2]/div/div[1]/div/input";
    static String radio = "//*[@id=\"root\"]/div/div[2]/div[1]/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/div/div/div[6]/div/div[2]/div[1]/div[3]/div";

    static String mailLogin = "//*[@id=\"mailbox\"]/form[1]/div[1]/div[2]/input";
    static String mailPassword = "//*[@type=\"password\"]";
    static String mailDatList = "//*[@id=\"mailbox\"]/form[1]/div[1]/div[1]/select";
    static String mailButtonAuth = "//*[@id=\"mailbox\"]/form[1]/button[1]";
    static String mailEnter = "//*[@id=\"mailbox\"]/form[1]/button[2]";
    static String searchMailEng = "//span[@class = 'll-sp__normal'][text()[contains(.,' - Your')]]";
    static String searchMailRu = "//span[@class = 'll-sp__normal'][text()[contains(.,' — Ваш')]]";
}