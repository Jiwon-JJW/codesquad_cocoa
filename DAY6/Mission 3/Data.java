import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Data {

    Scanner scanner =new Scanner(System.in);
    static Menu menu;

    ArrayList<String> Date = new ArrayList<String>();
    ArrayList<String> Summary = new ArrayList<String>();
    ArrayList<Integer> Income = new ArrayList<Integer>();
    ArrayList<Integer> Expenditure = new ArrayList<Integer>();

    public void addDate(int n,String Date){
        this.Date.add(n-1,Date);
    }
    public void addSummary(int n,String Summary){
        this.Summary.add(n-1,Summary);
    }
    public void addIncome(int n,int Income){
        this.Income.add(n-1,Income);
    }
    public void addExpenditure(int n,int Expenditure){
        this.Expenditure.add(n-1,Expenditure);
    }


    public void DataInput(){

        System.out.println("데이터를 저장할 번호를 입력해주세요");
        int num = scanner.nextInt();

        System.out.print("날짜: ");
        addDate(num,scanner.next());

        System.out.print("적요: ");
        addSummary(num,scanner.next());

        System.out.print("수입: ");
        addIncome(num,scanner.nextInt());

        System.out.print("지출: ");
        addExpenditure(num,scanner.nextInt());

        System.out.println("=======================================");
        System.out.println("입력하신 내용은 다음과 같습니다.");
        System.out.println(Date.get(num-1)+"/"+Summary.get(num-1)+"/"+Income.get(num-1)+"/"+Expenditure.get(num-1));

        System.out.println("저장이 완료되었습니다.");
        menu.ReturnMenu();

    }

    public void DataDelete(){
        System.out.println("삭제하실 데이터 번호를 입력해주세요.");
        int num = scanner.nextInt();
        int n = num-1;

        System.out.println("입력하신 데이터 번호의 내용은 다음과 같습니다.");
        System.out.println(Date.get(n)+"/"+Summary.get(n)+"/"+Income.get(n)+"/"+Expenditure.get(n));
        System.out.println("정말 삭제하시겠습니까?(1.Yes/2.No)");

        if(scanner.nextInt()==1) {
            Date.remove(n);
            Summary.remove(n);
            Income.remove(n);
            Expenditure.remove(n);
            menu.ReturnMenu();
        }
        if(scanner.nextInt() == 2){
            menu.ReturnMenu();
        }
    }

    public void DataEdit() {
        System.out.println("수정하실 데이터 번호를 입력해주세요.");
        int num = scanner.nextInt();
        int n = num-1;

        System.out.println("입력하신 데이터 번호의 내용은 다음과 같습니다.");
        System.out.println(this.Date.get(n)+"/"+this.Summary.get(n)+"/"+this.Income.get(n)+"/"+this.Expenditure.get(n));
        System.out.println("정말 수정하시겠습니까?(1.Yes/2.No)");

        if(scanner.nextInt() == 1) {
            System.out.println("수정하실 사항을 선택하여, 번호로 입력해주세요");
            System.out.println("1.날짜 / 2. 적요 / 3. 수입 / 4. 지출 / 5. 종료");
            int num2 = scanner.nextInt();

            if (num2 == 1){
                System.out.println("1. 날짜");
                System.out.print("변경하실 사항을 입력해주세요: ");
                Date.remove(n);
                Date.add(n,scanner.nextLine());
                return;
            }
            if (num2 == 2){
                System.out.println("2. 적요");
                System.out.print("변경하실 사항을 입력해주세요: ");
                Summary.remove(n);
                Summary.add(n,scanner.nextLine());
                return;
            }

            if(num2 == 3){
                System.out.println("3. 수입");
                System.out.print("변경하실 사항을 입력해주세요: ");
                Income.remove(n);
                Income.add(n,scanner.nextInt());
                return;
            }

            if(num2 == 4){
                System.out.println("4. 지출");
                System.out.print("변경하실 사항을 입력해주세요: ");
                Expenditure.remove(n);
                Expenditure.add(n,scanner.nextInt());
                return;
            }
            if(num2 == 5){
                System.out.println("수정을 종료합니다.");
                menu.ReturnMenu();
                return;
            }

            System.out.println("수정하신 데이터 번호의 내용은 다음과 같습니다.");
            System.out.println(Date.get(n)+"/"+Summary.get(n)+"/"+Income.get(n)+"/"+Expenditure.get(n));
            System.out.println("저장이 완료되었습니다.");
            menu.ReturnMenu();
            }

        if(scanner.nextInt() == 2) {
            menu.ReturnMenu();
        }
    }

    public void DataPrint(){
        System.out.println("=======================================");
        System.out.println("  No  /  날짜  /  적요  /  수입  /  지출  / 잔액 ");
        for(int i = 0; i < Date.size(); i++) {
            int total = 0;
            total = (total +Income.get(i))- Expenditure.get(i);
            System.out.println(i+"/ "+ Date.get(i) +"/ "+ Summary.get(i) +"/ "+ Income.get(i) +"원/ "+ Expenditure.get(i)+"원/ "+ total+"원");
        }
        System.out.println("=======================================");
        System.out.println("출력이 완료되었습니다.");
        menu.ReturnMenu();
    }
}


