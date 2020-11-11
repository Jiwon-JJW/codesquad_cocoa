import java.util.Scanner;

public class Data {
    static SelectTest selectTest;

    private String Date;
    private String Summary;
    private int Income;
    private int Expenditure;
    private String Type;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public int getIncome() {
        return Income;
    }

    public void setIncome(int income) {
        Income = income;
    }

    public int getExpenditure() {
        return Expenditure;
    }

    public void setExpenditure(int expenditure) {
        Expenditure = expenditure;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }


    Scanner scanner =new Scanner(System.in);

    public void DataInput(){

        System.out.println("데이터를 저장할 번호를 입력해주세요");
        int num = scanner.nextInt();
        int n = num-1;

        System.out.println("소비유형: 1. 현금 | 2. 카드 ");
        System.out.print("");
        setType(scanner.next());

        System.out.print("날짜: ");
        setDate(scanner.next());

        System.out.print("적요: ");
        setSummary(scanner.next());

        System.out.print("수입: ");
        setIncome(scanner.nextInt());

        System.out.print("지출: ");
        setExpenditure(scanner.nextInt());

        System.out.println("=======================================");
        System.out.println("입력하신 내용은 다음과 같습니다.");
        System.out.println(getType()+"/"+getDate()+"/"+getSummary()+"/"+getIncome()+"/"+getExpenditure());

        System.out.println("저장이 완료되었습니다.");

        Menu.ReturnMenu();

    }

//    public void DataDelete(){
//        System.out.println("삭제하실 데이터 번호를 입력해주세요.");
//        int num = scanner.nextInt();
//        int n = num-1;
//
//        System.out.println("입력하신 데이터 번호의 내용은 다음과 같습니다.");
//        System.out.println(getType()+"/"+getDate()+"/"+getSummary()+"/"+getIncome()+"/"+getExpenditure());
//        System.out.println("정말 삭제하시겠습니까?(1.Yes/2.No)");
//
//        if(scanner.nextInt()==1) {
//            Date.remove(n);
//            Summary.remove(n);
//            Income.remove(n);
//            Expenditure.remove(n);
//            Menu.ReturnMenu();
//        }
//        if(scanner.nextInt() == 2){
//            Menu.ReturnMenu();
//        }
//    }
//
//    public void DataEdit() {
//        System.out.println("수정하실 데이터 번호를 입력해주세요.");
//        int num = scanner.nextInt();
//        int n = num-1;
//
//        System.out.println("입력하신 데이터 번호의 내용은 다음과 같습니다.");
//        System.out.println(Date.get(n)+"/"+Summary.get(n)+"/"+Income.get(n)+"/"+Expenditure.get(n));
//        System.out.println("정말 수정하시겠습니까?(1.Yes/2.No)");
//
//        if(scanner.nextInt() == 1) {
//            System.out.println("수정하실 사항을 선택하여, 번호로 입력해주세요");
//            System.out.println("1.소비 유형 / 2.날짜  / 3.적요  / 4.수입  / 5.지출  / 6.종료");
//            int num2 = scanner.nextInt();
//
//            if (num2 == 1){
//                Type.remove(n);
//                System.out.println("소비유형: 1. 현금 | 2. 카드 ");
//                System.out.print("번호로 입력하여주세요: ");
//                if(scanner.nextInt() == 1){
//                    Type.add(n,"현금");
//                }
//                if(scanner.nextInt() == 2){
//                    Type.add(n,"카드");
//                }
//                else {
//                    System.out.println("공백으로 저장됩니다.");
//                    Type.add(n,"  ");
//                }
//            }
//
//            if (num2 == 2){
//                Date.remove(n);
//                System.out.println("1. 날짜");
//                System.out.print("변경하실 사항을 입력해주세요: ");
//                Date.add(n,scanner.next());
//            }
//
//            if(num2 == 3){
//                Summary.remove(n);
//                System.out.println("2. 적요");
//                System.out.print("변경하실 사항을 입력해주세요: ");
//                Summary.add(n,scanner.next());
//
//            }
//
//            if(num2 == 4){
//                Income.remove(n);
//                System.out.println("3. 수입");
//                System.out.print("변경하실 사항을 입력해주세요: ");
//                Income.add(n,scanner.nextInt());
//
//            }
//
//            if(num2 == 5){
//                Expenditure.remove(n);
//                System.out.println("4. 지출");
//                System.out.print("변경하실 사항을 입력해주세요: ");
//                Expenditure.add(n,scanner.nextInt());
//
//            }
//
//            if(num2 == 6){
//                System.out.println("수정을 종료합니다.");
//                Menu.ReturnMenu();
//            }
//
//            System.out.println("수정하신 데이터 번호의 내용은 다음과 같습니다.");
//            System.out.println(Type.get(n)+"/"+Date.get(n)+"/"+Summary.get(n)+"/"+Income.get(n)+"/"+Expenditure.get(n));
//            System.out.println("저장이 완료되었습니다.");
//            Menu.ReturnMenu();
//        }
//
//        if(scanner.nextInt() == 2) {
//            Menu.ReturnMenu();
//        }
//    }

    public void DataPrint(){
        System.out.println("=============================================================");
        System.out.println(" No / 소비 유형 /   날짜   /   적요   /   수입   /   지출   /   잔액  ");
        selectTest.print();
        System.out.println("=============================================================");
        System.out.println("출력이 완료되었습니다.");
        Menu.ReturnMenu();
    }
}



