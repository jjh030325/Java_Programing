import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        FileOutputStream fout = new FileOutputStream("output.txt");
        FileReader fin = new FileReader("14(a) 파일입출력_바이트스트림.txt");

        double beforeTime = System.currentTimeMillis();
        int c;
        while((c = fin.read()) != -1) {
            fout.write((char)c);
        }
        double afterTime = System.currentTimeMillis();
        double milliSecDiffTime = (afterTime - beforeTime)/1000;
        System.out.println("1바이트 단위로 복사하는데 걸린 시간: " + milliSecDiffTime + " 초");

        fin.close();
        fout.close();

        fin = new FileReader("14(a) 파일입출력_바이트스트림.txt");
        beforeTime = System.currentTimeMillis();
        BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("output_buffered.txt"), 20);
        while ((c = fin.read()) != -1) {
            bout.write((char)c);
        }
        afterTime = System.currentTimeMillis();
        milliSecDiffTime = (afterTime - beforeTime)/1000;
        System.out.println("버퍼 단위로 복사하는데 걸린 시간: " + milliSecDiffTime + " 초");

        fin.close();
        bout.close();
    }
}
