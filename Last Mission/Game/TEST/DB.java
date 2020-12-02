import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DB {

    public void ScoreWriter() throws IOException {
        Main main = new Main();

        BufferedOutputStream bs =null;

        try {
            bs = new BufferedOutputStream(new FileOutputStream("/Users/jeongjiwon/Java_S/Code Squad/Day21/src/BestScore.txt"));
            String score = String.valueOf(main.bestScore);
            System.out.println(score);

            bs.write(score.getBytes());
        } catch (Exception e){
            e.getStackTrace();
        }
        finally {
            bs.close();
        }
    }

    public void ScoreReader() throws IOException {
        try {
            String filePath = "/Users/jeongjiwon/Java_S/Code Squad/Day21/src/BestScore.txt";
            FileInputStream fileInputStream = null;

            fileInputStream = new FileInputStream(filePath);

            byte[ ] readBuffer = new byte[fileInputStream.available()];
            while (fileInputStream.read(readBuffer) != -1) {}
                System.out.print(new String(readBuffer)+"  점");
            System.out.println();

            fileInputStream.close();

        }catch (Exception e){
            e.getStackTrace();
        }
    }

}
