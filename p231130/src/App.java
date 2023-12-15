import java.io.FileOutputStream;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        FileOutputStream fout = new FileOutputStream("input.txt");
        String b = "Hello. My name is YoHan Park.";
        
        byte[] by=b.getBytes();
	    fout.write(by);
        fout.close();

        FileReader fin = new FileReader ("input.txt");
        fout = new FileOutputStream("enc.txt");
        int c;
        System.out.print("input.txt : ");
        while((c = fin.read()) != -1) {
            if((int)c >= 65 && (int)c <= 87)
            {
                System.out.print((char)c);
                fout.write((char)c + 3);
            }else if((int)c >= 97 && (int)c <= 119)
            {
                System.out.print((char)c);
                fout.write((char)c + 3);
            }else if((int)c >= 88 && (int)c <= 90)
            {
                System.out.print((char)c);
                fout.write((char)c - 23);
            }else if((int)c >= 120 && (int)c <= 122)
            {
                System.out.print((char)c);
                fout.write((char)c - 23);
            }else
            {
                System.out.print((char)c);
                fout.write((char)c);
            }
        }
        System.out.println();
        fin.close(); 
        fout.close();

        fin = new FileReader("enc.txt");
        fout = new FileOutputStream("recover.txt");
        System.out.print("enc.txt : ");
        while((c = fin.read()) != -1) {
            System.out.print((char)c);
            if((int)c >= 68 && (int)c <= 90)
            {
                fout.write((char)c - 3);
            }else if((int)c >= 100 && (int)c <= 122)
            {
                fout.write((char)c - 3);
            }else if((int)c >= 65 && (int)c <= 67)
            {
                fout.write((char)c + 23);
            }else if((int)c >= 97 && (int)c <= 99)
            {
                fout.write((char)c + 23);
            }else
            {
                fout.write((char)c);
            }
        }
        fin.close(); 
        fout.close();

        System.out.print("\nrecover.txt : ");
        fin = new FileReader("recover.txt");
        while((c = fin.read()) != -1) {
            System.out.print((char)c);
        }

        fin.close(); 
    }
}

/*
문) 시저의 암호시스템을 만드시오. (아래와 같이 캐릭터가 맵핑되는 암호시스템)
    a  b  c  d  e ......
->  D  E  F  G  H ......
65 ~ 90 = 대문자
97 ~ 122 = 소문자
1. input.txt 파일을 만드시오. (Hello. My name is YoHan Park.)
2. input.txt 파일을 암호화하시오. (input.txt -> enc.txt)
3. enc.txt 파일을 복호화하시오. (enc.txt -> recover.txt)
4, input.txt와 recover.txt 파일이 동일한지 확인하시오.
*/