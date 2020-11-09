import java.util.Arrays;
import java.util.Scanner;

public class Data {

    Scanner scanner =new Scanner(System.in);
    public static String[] Data = new String[500];

    public void MenuSelect(){
            System.out.println("작업하실 사항을 번호로 입력하여 주세요.");
            System.out.println("1.Input | 2.Delete | 3.Edit | 4. print | 5. finish");
            System.out.print("> ");
            int input = scanner.nextInt();

            if (input == 1) {
                DataInput();
            }
            if (input==2) {
                DataDelete();
            }
            if (input==3) {
                DataEdit();
            }
            if (input == 4){
                System.out.println(Arrays.toString(Data));
            }
            if (input == 5){
                scanner.close();
             }
    }

    public void ReturnMenu(){
        System.out.println("저장이 완료되었습니다.");
        System.out.println("메뉴로 돌아가 계속 진행하시겠습니까?(1.Yes/2.No)");
        System.out.print("> ");
        if(scanner.nextInt() == 1){
            MenuSelect();
        }
        if(scanner.nextInt() == 2){
            scanner.close();
        }
    }

    public void DataInput(){
        System.out.println("데이터를 저장할 번호를 입력해주세요");
        int number = scanner.nextInt();

        System.out.println("Date: ");
        String Date = scanner.next();

        System.out.println("Summary: ");
        String Summary = scanner.next();

        System.out.println("income: ");
        String income = scanner.next();

        System.out.println("expenditure: ");
        String expenditure = scanner.next();

        System.out.println("입력하신 정보는, "+Date+"/"+Summary+"/"+income+"/"+expenditure+"입니다.");
        System.out.println("저장하시겠습니까?(1.Yes/2.No)");
        System.out.print("> ");

        if(scanner.nextInt() == 1) {
            Data[number-1] = String.valueOf(number)+"/"+Date+"/"+ Summary+"/"+ income+"/"+ expenditure;
            ReturnMenu();
        }
        if(scanner.nextInt() == 2){
            scanner.close();
        }

    }

    public void DataDelete(){
        System.out.println("삭제하실 데이터 번호를 입력해주세요.");
        int inputNumber = scanner.nextInt();

        System.out.println("입력하신 데이터 번호의 내용은 다음과 같습니다.");
        System.out.println(Data[inputNumber-1]);
        System.out.println("정말 삭제하시겠습니까?(1.Yes/2.No)");

        if(scanner.nextInt()==1) {
            Data[inputNumber-1] = "0";
            ReturnMenu();
        }
        if(scanner.nextInt() == 2){
            scanner.close();
        }
    }

    public void DataEdit() {
        System.out.println("수정하실 데이터 번호를 입력해주세요.");
        int inputNumber = scanner.nextInt();

        System.out.println("입력하신 데이터 번호의 내용은 다음과 같습니다.");
        System.out.println(Data[inputNumber-1]);
        System.out.println("정말 수정하시겠습니까?(1.Yes/2.No)");

        if(scanner.nextInt() == 1) {
            String[] Edit = Data[inputNumber-1].split("/");
            System.out.println("수정하실 사항을 선택하여, 번호로 입력해주세요");
            System.out.println("1.날짜 / 2. 적요 / 3. 수입 / 4. 지출 / 5. 종료");
            int num = scanner.nextInt();

            if (num == 1){
                System.out.println("1. 날짜");
                System.out.print("변경하실 사항을 입력해주세요: ");
                Edit[1] = scanner.next();
            }
            if (num == 2){
                System.out.println("2. 적요");
                System.out.print("변경하실 사항을 입력해주세요: ");
                Edit[2] = scanner.next();
            }

            if(num == 3){
                System.out.println("3. 수입");
                System.out.print("변경하실 사항을 입력해주세요: ");
                Edit[3] = scanner.next();
            }

            if(num == 4){
                System.out.println("4. 지출");
                System.out.print("변경하실 사항을 입력해주세요: ");
                Edit[4] = scanner.next();
            }
            if(num == 5){
                System.out.println("수정을 종료합니다.");
            }

            System.out.println("입력하신 정보는, "+Edit[1]+"/"+Edit[2]+"|"+Edit[3]+"|"+Edit[4]+"입니다.");
            System.out.println("저장하시겠습니까?(1.Yes/2.No)");
            System.out.print("> ");

            if(scanner.nextInt() == 1) {
                Data[num-1] = String.join("/",Edit);
                ReturnMenu();
            }
            if(scanner.nextInt() == 2){
                scanner.close();
            }
        }

        if(scanner.nextInt() == 2) {
            scanner.close();
        }
    }
}
