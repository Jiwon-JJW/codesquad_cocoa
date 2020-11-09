import java.util.Scanner;

public class AccountBook {
    Scanner scanner = new Scanner(System.in);
    static UserAccount userAccount;
    static Data data;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserAccount userAccount = new UserAccount();
        Data data = new Data();

            userAccount.Login();

            data.MenuSelect();
    }
}
