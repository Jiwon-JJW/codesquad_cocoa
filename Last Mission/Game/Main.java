import java.util.Scanner;

public class Main {
    static User user = new User();
    static Map map = new Map();
    static Monster monster = new Monster();
    static Bomb bomb = new Bomb();

    public static void main(String[] args) {
        user.initStage();

        menu();
        map.initMap(user,monster,bomb);

        while (true) {

            map.printMap();
            menu2();

            move();

            checkStatus();
        }

    }

    public static void move(){
        map.mapSize[user.x][user.y] = " . ";
        user.moveUser();
        map.mapSize[user.x][user.y] = " @ ";
    }


    public static void menu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("               RPG GAME");
        System.out.println("| W: UP | A: LEFT | S: DOWN | D: RIGHT |");
        System.out.println("|   GAME START: 1 |   GAME FINISH: 0   |");
        System.out.println("========================================");
        System.out.print("> ");
        int start = scanner.nextInt();

        if(start == 1){
            settingField();
        }
        if(start == 0){
            System.exit(0);
            return;
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
        bomb.initBomb(monster);
        map.initMap(user,monster,bomb);

        if(user.score>1){
            for (int i = 1; i< user.score; i++) {
                bomb.initBomb(monster);
                map.addBomb(bomb);
            }
        }
    }

    public static void checkStatus(){
        Scanner scanner = new Scanner(System.in);

        if(user.x == monster.x && user.y == monster.y){
            System.out.println("게임에서 이겼습니다!");
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
                } else {
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
                }
            }

        }

        if(user.x == bomb.x && user.y == bomb.y){
            System.out.println("게임에서 졌습니다!");
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
    }

}
