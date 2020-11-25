import java.awt.*;
import java.awt.event.*;

public class GraphicsE5 extends Frame implements MouseMotionListener {

    int x = 0;
    int y = 0;

    Image img = null;
    Graphics gImg = null;

    public static void main(String[] args){
        new GraphicsE5("GraphicsE5");
    }

    public GraphicsE5(String title){
        super (title);
        addMouseMotionListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });

        setBounds(100,100, 500,500);
        setVisible(true);

        img = createImage(500,500);
        gImg = img.getGraphics();
        gImg.drawString("왼쪽 버튼을 누른 채로 마우스를 움직여보세요.", 10,50);
        repaint();
    }

    public void paint(Graphics g){
        if(img==null)return;
        g.drawImage(img,0,0,this);
    }

    public void mouseMoved(MouseEvent me){
        x = me.getX();
        y = me.getY();
    }

    public void mouseDragged(MouseEvent me){
        if(me.getModifiersEx()!=MouseEvent.BUTTON1_DOWN_MASK) return;

        gImg.drawLine(x,y,me.getX(),me.getY());
        x = me.getX();
        y = me.getY();

        repaint();
    }
}
