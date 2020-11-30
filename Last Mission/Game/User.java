import java.util.Scanner;

public class User {
    Scanner scanner = new Scanner(System.in);

    int x = 0;
    int y = 0;
    int score = 0;

    public void initStage(){
        score = 1;
    }

    public void initUser(){
        x=5;
        y=5;
    }

    private void userUp(){
        if(x-1<0){
            System.out.println("더 이상 위로 올라갈 수 없습니다.");
        }
        x--;
    }

    private void userDown(){
        if(x+1>=11){
            System.out.println("더 이상 아래로 내려갈 수 없습니다.");
        }
        x++;
    }

    private void userLeft(){
        if(y-1<0){
            System.out.println("더 이상 왼쪽으로 갈 수 없습니다.");
        }
        y--;
    }

    private void userRight(){
        if(y+1>=11){
            System.out.println("더 이상 오른쪽으로 갈 수 없습니다.");
        }
        y++;
    }

    public void moveUser(){
        String move = scanner.next();
        while (true) {
            if (move.equalsIgnoreCase("w")) {
                userUp();
                break;
            }
            if (move.equalsIgnoreCase("s")) {
                userDown();
                break;
            }
            if (move.equalsIgnoreCase("a")) {
                userLeft();
                break;
            }
            if (move.equalsIgnoreCase("d")) {
                userRight();
                break;

            } else {
                System.out.println("잘못 입력하셨습니다. 다시 입력하여 주세요.");
                return;
            }
        }
    }


}
