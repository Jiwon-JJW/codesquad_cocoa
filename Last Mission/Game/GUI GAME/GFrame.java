import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GFrame extends JFrame implements KeyListener,Runnable {
    //프레임을 위한 JFrame 상속
    //키보드 이벤트 처리를 위한 KeyListener를 상속
    //스레드를 돌리기 위한 Runnable 상속

    Random random = new Random();

    int fWidth,fHeight;
    int x, y;
    int coinX,coinY;
    int characterLife = 5;
    int ghostX,ghostY;
    int ghostSpeed;

    int cnt; // 타이밍 조절을 위해 무한 루프를 카운터 할 변수
    static int score;
    static int bestScore;
    // TODO: 최대 스코어 생성
    // TODO: 메인 이미지 및 게임 오버 이미지 생성

    boolean KeyUp = false; // 키보드 입력 처리를 위한 변수
    boolean KeyDown = false;
    boolean KeyLeft = false;
    boolean KeyRight = false;

    boolean gameStatus = true;

    Thread th; // 스레드 생성
    Toolkit tk = Toolkit.getDefaultToolkit(); // 이미지를 불러오기 위한 툴킷

    Image DImg = tk.getImage("/Users/jeongjiwon/Java_S/Code Squad/RPG/src/농담곰.png");
    Image GImg = tk.getImage("/Users/jeongjiwon/Java_S/Code Squad/RPG/src/유령.png");
    Image CImg = tk.getImage("/Users/jeongjiwon/Java_S/Code Squad/RPG/src/코인.png");

    int charWidth = DImg.getWidth(this);
    int charHeight = DImg.getHeight(this);
    int coinWidth = CImg.getWidth(this);
    int coinHeight = CImg.getHeight(this);

    ArrayList ghostList = new ArrayList(); // 다수의 유령 제작을 위한 리스트

    Ghost g; // 유령 클래스 접근 키

    GameOver gameOver = new GameOver(this, "!! VICTORY !!");; // 상태 팝업창

    Image buffImage; // 더블버퍼링
    Graphics buffG; // 더블 버퍼링

    GFrame() throws IOException {
        init(); // 프레임에 들어갈 컴포넌트 세팅
        start(); // 기본적인 시작 명령 처리

        setTitle("RPG GAME");
        setSize(fWidth, fHeight);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        // 프레임 위치 설정을 위해 현재의 모니터 해상도 값을 받아오는 것.

        int fXPos = (int) (screen.getWidth() / 2 - fWidth / 2);
        int fYPos = (int) (screen.getHeight() / 2 - fHeight / 2);
        // 모니터 정중앙에 위치하게 하기 위한 좌표 계산

        setLocation(fXPos, fYPos); // 프레임을 화면에 배치
        setResizable(false); // 프레임의 크기를 임의로 조절 불가능 하게 막아놓기

        addWindowListener(new Eventhandler()); // X키 누르면 종료되도록 이벤트 핸들러 생성

        setVisible(true); // 프레임을 눈에 보이게 띄우기
    }

    public void init() {
        fWidth = 1000; // 프레임 넓이
        fHeight = 700; // 프레임 높이

        x = (fWidth - charWidth)/2; //캐릭터의 최초 좌표
        y = (fHeight - charHeight)/2;

        score = 0;

        coin();
    }

    public void start() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // X키 누르면 정상 종료 되도록 만들어주는 메소드

        addKeyListener(this); //키보드 이벤트 실행
        th = new Thread(this); // 스레드 생성
        th.start(); // 스레드 실행
    }

    public void run() {
        try {
            while (gameStatus) { // 무한루프
                KeyProcess(); // 키보드 입력처리로 x,y 갱신
                GhostProcess(); // 적 움직임 처리 메소드
                CoinProcess(); // 코인 처리 메소드

                repaint(); // 갱신된 값으로 이미지 재생성

                Thread.sleep(20); // 20milli sec로 스레드 돌리기
                cnt++; //무한 루프 카운터
            }
        } catch (Exception e) {

        }
    }

    public void coin(){
        coinX = random.nextInt(fWidth);
        coinY = random.nextInt(fHeight);

        while (coinX<30 ||coinX > fWidth-coinWidth-30){
            coinX = random.nextInt(fWidth);
        }
        while (coinY < 30||coinY > fHeight - coinHeight-30){
            coinY = random.nextInt(fHeight);
        } // 화면 밖으로 생성되지 않도록 조절
    }

    public void CoinProcess() {
        if(Crash(x,y,coinX,coinY,DImg,CImg )){
            score++;
            bestScore = score;
            System.out.println(bestScore);
            coin();
        }
    }

    public void GhostProcess() throws IOException {
        for (int i = 0; i<ghostList.size(); ++i){
            g = (Ghost)(ghostList.get(i));
            // 배열에 적이 생성되어있을 때 해당되는 적을 판별?
            g.move(); // 적을 이동시킨다
            if(g.x < -200){
                ghostList.remove(i);
            }
            if(Crash(x,y , g.x, g.y, DImg, GImg)){
                //플레이어와 적의 충돌을 판정하여, boolean 값이 true 일 경우, 아래를 실행

                ghostList.remove(i);
                -- characterLife; // 부딪히면 캐릭터의 생명력 깎기
                if(characterLife<1){

                    gameStatus = false;
                    GameOver gameOver =new GameOver(this,"!!GAME OVER");
                    gameOver.setVisible(true);
                }

            }
        }

        if(cnt%200 == 0){ // 루프 카운트 300회마다
            ghostX = fWidth+(random.nextInt(9))*100;
            ghostY = (random.nextInt(6))*100;
            ghostSpeed = random.nextInt(10);

            g = new Ghost(ghostX,ghostY,ghostSpeed);
            ghostList.add(g); // 각 좌표로 적을 생성 한 후, 배열에 추가.

            if(score>1) {
                for(int i =1,j = score; i < j;i++) { // 스코어가 오르면 유령 추가
                    if(j >5){ //최대 5개의 유령 추가.
                        j = 5;
                    }
                    ghostX = fWidth+(random.nextInt(9))*100;
                    ghostY = (random.nextInt(9))*100;
                    ghostSpeed = random.nextInt(10);

                    g = new Ghost(ghostX,ghostY,ghostSpeed);
                    ghostList.add(g); // 각 좌표로 적을 생성 한 후, 배열에 추가.

                }
            }
        }
    }

    public void paint(Graphics g) {
        buffImage = createImage(fWidth, fWidth);
        // 더블 버퍼링 버퍼 크기를 화면 크기와 같게 설정
        buffG = buffImage.getGraphics(); //버퍼의 그래픽 객체 얻기

        update(g);
    }

    public void update(Graphics g){

        DrawChar(); // 실제로 그려진 그림을 가지고 옴
        DrawGhost();
        DrawCoin();
        DrawString();

        g.drawImage(buffImage, 0, 0, this);
        // 버퍼에 그린 그림을 가져와 그리기
    }

    public void DrawChar(){
        buffG.clearRect(0, 0, fWidth, fHeight);
        buffG.drawImage(DImg, x,y , this);
    }

    public void DrawGhost(){
        for(int i = 0; i<ghostList.size(); ++i){
            g = (Ghost)(ghostList.get(i));
            buffG.drawImage(GImg, g.x, g.y, this);
        }
    }

    public void DrawCoin(){
        buffG.drawImage(CImg, coinX, coinY, this);
        if(score > 1) {
        }
    }

    public void DrawString() {
        buffG.setFont(new Font("Default", Font.BOLD,20));
        buffG.drawString("SCORE: "+score, 10, 70);
        buffG.drawString("LIFE: "+characterLife, 10, 100);
    }

    public boolean Crash (int x1, int y1, int x2, int y2, Image img1, Image img2){
        boolean check = false;

        if(Math.abs((x1+img1.getWidth(null)/2)
                - (x2+img2.getWidth(null)/2))
                < (img2.getWidth(null)/2 + img1.getWidth(null)/2)
                &&
                Math.abs((y1 + img1.getHeight(null)/2)
                        - (y2 + img2.getHeight(null)/2))
                        < (img2.getHeight(null)/2 + img1.getHeight(null)/2)){
            // 이미지 넓이, 높이 값을 바로 받아 계산

            check = true;
        }else{check = false;}

        return check;
    }


    public void keyPressed(KeyEvent e) {
        // 키보드가 눌렸을 때의 명령어
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                KeyUp = true;
                break;

            case KeyEvent.VK_DOWN:
                KeyDown = true;
                break;

            case KeyEvent.VK_LEFT:
                KeyLeft = true;
                break;

            case KeyEvent.VK_RIGHT:
                KeyRight = true;
                break;

        }
    }

    public void keyReleased(KeyEvent e) {
        // 키보드가 떼어졌을 때 이벤트

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                KeyUp = false;
                break;

            case KeyEvent.VK_DOWN:
                KeyDown = false;
                break;

            case KeyEvent.VK_LEFT:
                KeyLeft = false;
                break;

            case KeyEvent.VK_RIGHT:
                KeyRight = false;
                break;

        }
    }
    public void keyTyped(KeyEvent e){

    }

    public void KeyProcess(){
        //실제로 움직임을 실현하기 위해 키 값을 바탕으로 5만큼 이동시킨다.
        if(KeyUp) {
            if(y>20) {
                y -= 5;
            }
        }
        if(KeyDown) {
            if(y+DImg.getHeight(null)<fHeight) {
                y += 5;
            }
        }
        if(KeyLeft) {
            if(x>0) {
                x -= 5;
            }
        }
        if(KeyRight) {
            if(x+DImg.getWidth(null)<fWidth) {
                x += 5;
            }
        }
    }




}
