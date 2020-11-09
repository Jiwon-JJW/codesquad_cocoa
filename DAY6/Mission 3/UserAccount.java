import java.util.HashMap;
import java.util.Scanner;

public class UserAccount {
    private String UserName;
    private String PassWord;
    HashMap<String,String> User = new HashMap<>();

    public String getUserName() {
        return UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }
    public void initUser(){
        User.put("project","cocoa");
    }

    public void UserAccountIn(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("UserName: ");
        this.setUserName(scanner.nextLine());
        System.out.println("PassWord: ");
        this.setPassWord(scanner.nextLine());

        User.put(this.getUserName(),this.getPassWord());

        }

        public boolean AccountCheck(String ID, String PW) {

            if(User.containsKey(ID)==false||User.containsValue(PW)==false){
                System.out.println("유저 이름 혹은 비밀번호가 잘못되었습니다.");
                return false;
            }
            if(User.containsKey(ID)==true&&User.containsValue(PW)==true){
                return true;
            }
            return true;
        }

        public void Login(){
            Scanner scanner = new Scanner(System.in);

            initUser();

            System.out.println("UserName: ");
            String UserName=scanner.nextLine();

            System.out.println("PassWord: ");
            String PassWord=scanner.nextLine();

            if(AccountCheck(UserName,PassWord)==false){
                System.out.println("회원가입 하시겠습니까?(Y/N)");
                System.out.print("> ");
                String answer = scanner.nextLine();

                if(answer.equalsIgnoreCase("Y")) {
                    UserAccountIn();
                    return;
                }
            }

        }
    }
