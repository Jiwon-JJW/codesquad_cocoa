import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DB {


    public void ScoreWriter() throws IOException {
        String s=null;
        int i = 0;

        {
            try {
                i = Integer.parseInt(ScoreReader(s));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        BufferedOutputStream bs =null;
        if(GFrame.score> i) {
            try {
                bs = new BufferedOutputStream(new FileOutputStream
                        ("/Users/jeongjiwon/Java_S/Code Squad/RPG/src/Best.txt"));
                String score = String.valueOf(GFrame.bestScore);

                bs.write(score.getBytes());
            } catch (Exception e) {
                e.getStackTrace();
            } finally {
                bs.close();
            }
        }
    }

    public String ScoreReader(String s) throws IOException {
        try {
            String filePath = "/Users/jeongjiwon/Java_S/Code Squad/RPG/src/Best.txt";
            FileInputStream fileInputStream = null;

            fileInputStream = new FileInputStream(filePath);

            byte[ ] readBuffer = new byte[fileInputStream.available()];
            while (fileInputStream.read(readBuffer) != -1) {}
            s = new String(readBuffer);

            fileInputStream.close();

        }catch (Exception e){
            e.getStackTrace();
        }

        return s;
    }

}
