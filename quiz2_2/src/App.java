import java.io.FileReader;
import java.io.FileWriter;

public class App {
    public static void main(String[] args) throws Exception {
        int key = 0;
        int c;
        String check = "PASSWORD";
        boolean found = false;
        FileReader fin = new FileReader("ciphertext.txt");

        while (key < 26) {
            fin = new FileReader("ciphertext.txt");
            FileWriter fout = new FileWriter("recover.txt");
            while ((c = fin.read()) != -1) {
                if ((int) c >= 65 + key && (int) c <= 90) {
                    fout.write((char) (c - key));
                } else if ((int) c >= 97 + key && (int) c <= 122) {
                    fout.write((char) (c - key));
                } else if ((int) c >= 65 && (int) c <= 65 + key) {
                    fout.write((char) (c + 26 - key));
                } else if ((int) c >= 97 && (int) c <= 97 + key) {
                    fout.write((char) (c + 26 - key));
                } else {
                    fout.write((char) c);
                }
            }
            fout.close();
            if (containsPassword("recover.txt", check)) {
                found = true;
                break;
            }
            key++;
        }

        fin.close();

        if (found) {
            System.out.println("비밀번호를 찾았습니다. 키: " + key);
        } else {
            System.out.println("비밀번호를 찾지 못했습니다.");
        }
    }

    // 파일이 특정 문자열을 포함하는지 확인하는 함수
    private static boolean containsPassword(String filename, String password) throws Exception {
        FileReader reader = new FileReader(filename);
        char[] buffer = new char[password.length()];
        int bytesRead = reader.read(buffer);
        reader.close();

        if (bytesRead == password.length()) {
            String content = new String(buffer);
            return content.equals(password);
        }

        return false;
    }
}