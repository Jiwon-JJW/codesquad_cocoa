import java.io.IOException;
import java.util.Scanner;

public class Main {
    static User user = new User();
    static Map map = new Map();
    static Monster monster = new Monster();
    static Bomb bomb = new Bomb();
    static DB db = new DB();
    static int bestScore = 0;

    public static void main(String[] args) throws IOException {

        // TODO: GUI 구현하기

        user.initStage();

        menu();
        map.initMap(user,monster,bomb);

        while (true) {

            map.printMap();
            menu2();

            move();


        }

    }

    public static void move() throws IOException {
        map.mapSize[user.x][user.y] = " . ";
        user.moveUser();
        checkStatus();
        map.mapSize[user.x][user.y] = " @ ";
    }


    public static void menu() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("               RPG GAME");
        System.out.print("          최대 스코어  : ");
        db.ScoreReader();
        System.out.println("| W: UP | A: LEFT | S: DOWN | D: RIGHT |");
        System.out.println("|   GAME START: 1 |   GAME FINISH: 0   |");
        System.out.println("========================================");
        System.out.print("> ");
        while (true) {
            int start = scanner.nextInt();

            if (start == 1) {
                settingField();
                break;
            }
            if (start == 0) {
                System.exit(0);
                return;
            } else {
                System.out.println(" 잘못 입력하셨습니다.");
            }
        }
    }

    public static void menu2(){
        System.out.println("========================================");
        System.out.println("현재 스테이지:"+user.score);
        System.out.println("| W: UP | A: LEFT | S: DOWN | D: RIGHT |");
        System.out.println("========================================");
    }

    public static void settingField(){
        user.initUser();
        monster.initMonster();
        bomb.initBomb();
        map.initMap(user,monster,bomb);

        if(user.score>1){
            for (int i = 1; i< user.score; i++) {
                map.addBomb(bomb,monster);
            }
        }
    }

    public static void checkStatus() throws IOException {
        Scanner scanner = new Scanner(System.in);

        if(user.x == monster.x && user.y == monster.y){
            System.out.println("게임에서 이겼습니다!");
            bestScore = user.score;
            db.ScoreWriter();
            user.score++;

            while (true) {
                System.out.println("계속 하시겠습니까?");
                System.out.println("yes : 1 | no : 0");
                int answer = scanner.nextInt();
                if (answer == 1) {
                    settingField();
                    return;
                }
                if (answer == 0) {
                    System.exit(0);
                    return;
                } else {
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
                }
            }

        }
        if(map.mapSize[user.x][user.y].equalsIgnoreCase(" ! ")){
            System.out.println("게임에서 졌습니다!");
            while (true) {
                System.out.println("계속 하시겠습니까?");
                System.out.println("yes : 1 | no : 0");
                int answer = scanner.nextInt();
                if (answer == 1) {
                    user.initStage();
                    settingField();
                    return;
                }
                if (answer == 0) {
                    System.exit(0);
                    return;

                } else {
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
                }
            }
        }
    }

}
