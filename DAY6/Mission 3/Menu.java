import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void UserMenu(){
        UserAccount userAccount = new UserAccount();

        System.out.println("=======================================");
        System.out.println("작업하실 사항을 번호로 입력하여 주세요.");
        System.out.println("   1.로그인   |   2.회원가입   |   3.종료   ");
        System.out.println("=======================================");
        System.out.print("> ");
        int input = scanner.nextInt();

        if (input == 1) {
            userAccount.Login();
        }
        if (input == 2) {
            userAccount.UserAccountIn();
        }

        if (input == 3) {
            System.exit(0);
        }
    }

    public static void MenuSelect(){
        Data data = new Data();

        System.out.println("=======================================");
        System.out.println("작업하실 사항을 번호로 입력하여 주세요.");
        System.out.println("1.입력 | 2.삭제 | 3.수정 | 4.출력 | 5.종료");
        System.out.println("=======================================");
        System.out.print("> ");
        int input = scanner.nextInt();
        if (input == 1) {
            data.DataInput();
        }
        if (input == 2) {
            data.DataDelete();
        }
        if (input == 3) {
            data.DataEdit();
        }
        if (input == 4) {
            data.DataPrint();
        }

        if (input == 5) {
            scanner.close();
            System.exit(0);
        }
    }



    public static void ReturnMenu(){
        System.out.println("=======================================");
        System.out.println("메뉴로 돌아가 계속 진행하시겠습니까?(1.Yes/2.No)");
        System.out.println("=======================================");
        System.out.print("> ");
        if(scanner.nextInt() == 1){
            MenuSelect();
        }
        if(scanner.nextInt() == 2){
            scanner.close();
            System.exit(0);
        }
    }
}
