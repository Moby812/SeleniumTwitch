import java.util.ArrayList;
import java.util.List;

public class Users {
    String login;
    String password;
    String emailName;
    String emailDat;

    public Users(String login, String password, String emailName, String emailDat) {
        this.login = login;
        this.password = password;
        this.emailName = emailName;
        this.emailDat = emailDat;
    }

    static List<Users> listUser() {
        List<Users> usersList = new ArrayList<>();
        usersList.add(new Users("OlegKotoff","pwnhob7uaj","olegkot.99","@mail.ru"));
        usersList.add(new Users("setestov","pwnhob7uaj","setestov","@inbox.ru"));
        usersList.add(new Users("nikonp92","pwnhob7uaj","nikonp92","@mail.ru"));
        usersList.add(new Users("KlaraOs","pwnhob7uaj","osvold_klara","@list.ru"));
        usersList.add(new Users("olga_ivan","pwnhob7uaj","olga_ivan_75","@bk.ru"));
        usersList.add(new Users("whodosk","pwnhob7uaj","osvold_klara","@list.ru"));
        usersList.add(new Users("Ivan_olga","pwnhob7uaj","olga_ivan_75","@bk.ru"));
        return usersList;
    }
}
