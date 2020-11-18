
import java.util.Scanner;

public class Clock {
    public static void main(String[] args) {
        Time t = new Time();
        Cal c = new Cal();
        Scanner scanner = new Scanner(System.in);


        System.out.println("원하시는 항목을 입력하여 주세요.");
        System.out.println("  clock  |  calendar");
        System.out.print("> ");
        String answer = scanner.nextLine();



        if(answer.equalsIgnoreCase("clock")) {
            t.start();
        }
        if(answer.equalsIgnoreCase("calendar")){
            c.initcal();
        }
    }

}