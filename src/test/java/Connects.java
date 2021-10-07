import java.util.ArrayList;
import java.util.List;

public class Connects {
//    String HOST;
//    String PORT;
    String hostPort;

//    public Connects(String HOST, String PORT) {
//        this.HOST = HOST;
//        this.PORT = PORT;
//    }

    public Connects(String hostPort) {
        this.hostPort = hostPort;
    }

    static List<Connects> listConnect() {
        List<Connects> connectsList = new ArrayList<>();

        connectsList.add(new Connects("85.26.146.169:80"));
        connectsList.add(new Connects("91.77.162.117:8080"));
        connectsList.add(new Connects("95.161.150.210:8080"));
        connectsList.add(new Connects("185.180.231.30:443"));
        connectsList.add(new Connects("149.126.98.162:9090"));
        connectsList.add(new Connects("178.205.169.210:3128"));
        connectsList.add(new Connects("95.172.52.133:3128"));

        return connectsList;
    }


//    static List<Connects> listConnect(int count, String hostPort) {
//        List<Connects> connectsList = new ArrayList<>();
//
//            connectsList.add(new Connects("85.26.146.169","80"));
//            connectsList.add(new Connects("91.77.162.117","8080"));
//            connectsList.add(new Connects("95.161.150.210","8080"));
//            connectsList.add(new Connects("185.180.231.30","443"));
//            connectsList.add(new Connects("149.126.98.162","9090"));
//            connectsList.add(new Connects("178.205.169.210","3128"));
//            connectsList.add(new Connects("95.172.52.133","3128"));
//
//        for (int i = 0; i < count; i++) {
//            System.out.println("Данный цикл должен будет добавить в массив распаршенную запись "+hostPort);
//        }
//        return connectsList;
//    }
}
