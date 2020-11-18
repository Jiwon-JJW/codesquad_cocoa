import java.util.Calendar;

class Year {
    Calendar c = Calendar.getInstance();
    public int year;

    public Year(int y) {
        year=y;
        if(year == 0){
            year =c.get(c.YEAR);
        }
    }
}

class Month {
    Calendar c = Calendar.getInstance();
    public int month;
    public Month(int m){
        month = m;
        if(month == 0){
            month= c.get(c.MONTH)+1;
        }
    }
}

public class Cal {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    Year y = new Year(0);
    Month m = new Month(0);
    Calendar c = Calendar.getInstance();

    public void initcal(){
        // 시작일을 설정하는 메소드
        c.set(y.year, m.month-1, 1);
        int START_DAY_OF_WEEK = c.get(Calendar.DAY_OF_WEEK);

        // 끝일을 설정하는 메소드
        c.set(y.year, m.month, 1);
        c.add(Calendar.DATE, -1);
        int END_DAY = c.get(Calendar.DATE);

        printcal(START_DAY_OF_WEEK, END_DAY);

        }

    public void printcal(int sDay,int eDay) {
        System.out.println("=====================");
        System.out.printf("%9d년 %3d월 %n",y.year,m.month);
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("---------------------");
        for (int i = 1; i < sDay; i++)
            System.out.print("   ");

        for (int i = 1, n = sDay; i <= eDay; i++, n++) {

            System.out.printf("%3d", i);
            if (n % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("=====================");
    }
}

