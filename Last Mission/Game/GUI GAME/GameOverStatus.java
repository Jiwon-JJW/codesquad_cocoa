import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameOverStatus extends JDialog {
    DB db = new DB();
    String s;

    int dWidth, dHeight;

    JButton yes = new JButton("YES");
    JButton no = new JButton("NO");
    JLabel msg = new JLabel("게임에서 졌습니다! 계속 하시겠습니까?");




    public GameOverStatus(Frame f , String title) throws IOException {
        super(f,title);
        db.ScoreWriter();
        String rank = db.ScoreReader(s);
        JLabel best = new JLabel(" BEST SCORE:  "+rank +"  점 ");

        dWidth = 220;
        dHeight = 120;
        setLayout(null);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        // 프레임 위치 설정을 위해 현재의 모니터 해상도 값을 받아오는 것.

        int dXPos = (int) (screen.getWidth() / 2 - dWidth / 2);
        int dYPos = (int) (screen.getHeight() / 2 - dHeight / 2);
        // 모니터 정중앙에 위치하게 하기 위한 좌표 계산

        msg.setBounds(10, 10, 200, 20);
        best.setBounds(45, 30, 200, 20);
        yes.setBounds(50,60 ,50 , 20);
        no.setBounds(120, 60, 50, 20);

        setLocation(dXPos, dYPos); // 프레임을 화면에 배치
        setResizable(false); // 프레임의 크기를 임의로 조절 불가능 하게 막아놓기

        add(msg);
        add(best);
        add(yes);
        add(no);

        setSize(dWidth,dHeight);

        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                try {
                    GFrame gf = new GFrame();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                System.exit(0);
            }
        });
    }
}
