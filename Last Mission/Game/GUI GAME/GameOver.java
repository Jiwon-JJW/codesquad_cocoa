import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver extends JDialog {

    JButton yes = new JButton("YES");
    JButton no = new JButton("NO");
    JLabel msg = new JLabel("게임에서 졌습니다! 계속 하시겠습니까?");

    int dWidth, dHeight;

    public GameOver(Frame f , String title){
        super(f,title);

        dWidth = 250;
        dHeight = 90;
        setLayout(new FlowLayout());

        setLocation(500, 500); // 프레임을 화면에 배치
        setResizable(false); // 프레임의 크기를 임의로 조절 불가능 하게 막아놓기

        add(yes);
        add(no);
        add(msg);
        setSize(dWidth,dHeight);


        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                GFrame gf = new GFrame();
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
