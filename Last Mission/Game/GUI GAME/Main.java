import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main extends JFrame{

    DB db = new DB();
    String s ;

    int fWidth = 1000; // 프레임 넓이
    int fHeight = 700; // 프레임 높이

    JButton start = new JButton("> START");
    JButton exit = new JButton("> EXIT");
    JLabel main = new JLabel("COIN GAME");
    JLabel best;

    Font font = new Font("Default", Font.BOLD, 100);
    Font font2 = new Font("Default", Font.BOLD, 20);

    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    // 프레임 위치 설정을 위해 현재의 모니터 해상도 값을 받아오는 것.

    int fXPos = (int) (screen.getWidth() / 2 - fWidth / 2);
    int fYPos = (int) (screen.getHeight() / 2 - fHeight / 2);
    // 모니터 정중앙에 위치하게 하기 위한 좌표 계산

    Main() throws IOException {

        String rank = db.ScoreReader(s);
        best = new JLabel(" BEST SCORE:  "+rank +"  점 ");


        setTitle("COIN GAME");
        setSize(fWidth, fHeight);


        setLocation(fXPos, fYPos); // 프레임을 화면에 배치
        setResizable(false); // 프레임의 크기를 임의로 조절 불가능 하게 막아놓기

        addWindowListener(new Eventhandler()); // X키 누르면 종료되도록 이벤트 핸들러 생성

        DrawMain();

        setVisible(true); // 프레임을 눈에 보이게 띄우기

    }


    public void DrawMain() {
        add(best);
        add(main);
        add(start);
        add(exit);

        main.setFont(font);
        best.setFont(font2);

        setLayout(null);
        best.setBounds(390, 470, 400, 20);
        main.setBounds(200, 200, 600, 100);
        start.setBounds(450, 500, 100, 20);
        exit.setBounds(450, 530, 100, 20);

        start.addActionListener(new ActionListener() {
@Override
    public void actionPerformed(ActionEvent e) {
    try {
        GFrame gf = new GFrame();
        } catch (IOException ioException) {
            ioException.printStackTrace();
                }
            }
        });
        exit.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
        }
        });
        }
    }

