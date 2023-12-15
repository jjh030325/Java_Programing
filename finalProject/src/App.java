import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

class PhoneManager {
    HashSet<Phone> set = new HashSet<Phone>();
    private static final String FILE_NAME = "data.txt";

    public void input(String name, String phoneNumber) {
        set.add(new Phone(name, phoneNumber));
    }

    public void input(String name, String phoneNumber, String major, String grade) {
        set.add(new PhoneUniv(name, phoneNumber, major, grade));
    }

    public void input(String name, String phoneNumber, String companyName) {
        set.add(new PhoneComp(name, phoneNumber, companyName));
    }

    public void search(String name) {
        Iterator<Phone> it = set.iterator();
        while (it.hasNext()) {
            Phone s = it.next();
            if (s.returnName().equals(name)) {
                s.display();
                System.out.println("======================================");
                return;
            }
        }
        System.out.println("존재하지 않습니다.");
    }

    public void delete(String name) {
        Iterator<Phone> it = set.iterator();
        while (it.hasNext()) {
            Phone s = it.next();
            if (s.returnName().equals(name)) {
                it.remove();
                return;
            }
        }
        System.out.println("존재하지 않습니다.");
    }

    public void printAll() {
        Iterator<Phone> itr = set.iterator();
        while (itr.hasNext()) {
            itr.next().display();
            System.out.println("======================================");
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            set = (HashSet<Phone>) ois.readObject();
        } catch (FileNotFoundException e) {
            // 파일이 없으면 무시
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(set);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Phone implements Serializable {
    // 1. 일반(Phone) – 이름, 전화번호
    String Name;
    String PhoneNumber;

    Phone(String name, String phoneNumber) {
        this.Name = name;
        this.PhoneNumber = phoneNumber;
    }

    public void display() {
        System.out.println("이름 : " + Name);
        System.out.println("전화번호 : " + PhoneNumber);
    }

    public String returnName() {
        return Name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Phone phone = (Phone) obj;
        return Name.equals(phone.Name);
    }

    @Override
    public int hashCode() {
        return Name.hashCode();
    }
}

class PhoneUniv extends Phone {
    // 2. 대학(PhoneUniv) – 이름, 전화번호, 전공, 학년
    String Major;
    String Grade;

    PhoneUniv(String name, String phoneNumber, String major, String grade) {
        super(name, phoneNumber);
        this.Major = major;
        this.Grade = grade;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("전공 : " + Major);
        System.out.println("학년 : " + Grade);
    }
}

class PhoneComp extends Phone {
    // 3. 회사(PhoneComp) - 이름, 전화번호, 회사명
    String CompanyName;

    PhoneComp(String name, String phoneNumber, String companyName) {
        super(name, phoneNumber);
        this.CompanyName = companyName;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("회사명 : " + CompanyName);
    }
}

public class App {
    public static void main(String[] args) {
        PhoneManager phoneManager = new PhoneManager();
        phoneManager.loadFromFile(); // 프로그램 시작 시 파일에서 데이터 불러오기

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. 데이터 입력");
            System.out.println("2. 데이터 검색");
            System.out.println("3. 데이터 삭제");
            System.out.println("4. 전체 데이터 출력");
            System.out.println("5. 프로그램 종료");
            System.out.print("선택: ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("1. 일반(Phone)");
                    System.out.println("2. 대학(PhoneUniv)");
                    System.out.println("3. 회사(PhoneComp)");
                    System.out.print("선택: ");
                    int type = scanner.nextInt();
                    //종류 선택

                    System.out.print("이름: ");
                    String name = scanner.next();
                    System.out.print("전화번호: ");
                    String phoneNumber = scanner.next();
                    //필수 입력

                    switch (type) {
                        case 1:
                            phoneManager.input(name, phoneNumber);
                            break;
                        case 2:
                            System.out.print("전공: ");
                            String major = scanner.next();
                            System.out.print("학년: ");
                            String grade = scanner.next();
                            phoneManager.input(name, phoneNumber, major, grade);
                            break;
                        case 3:
                            System.out.print("회사명: ");
                            String company = scanner.next();
                            phoneManager.input(name, phoneNumber, company);
                            break;
                    }
                    break;
                    //데이터 입력
                case 2:
                    System.out.print("검색할 이름: ");
                    String searchName = scanner.next();
                    phoneManager.search(searchName);
                    break;
                    //데이터 검색
                case 3:
                    System.out.print("삭제할 이름: ");
                    String delName = scanner.next();
                    phoneManager.delete(delName);
                    break;
                    //데이터 삭제
                case 4:
                    phoneManager.printAll();
                    break;
                    //전체 데이터 출력
                case 5:
                    phoneManager.saveToFile(); // 프로그램 종료 전에 파일에 데이터 저장
                    scanner.close();
                    System.exit(0);
                    break;
                    //프로그램 종료
            }
        }
    }
}


/*
중간고사 기간에 수행하였던 전화번호 관리 프로그램을 다음과 같이 수정하시오.

1. 기존의 기능을 그대로 유지하시오.
2. 전화번호부에 등록된 사용자의 정보(객체)를 파일로 저장하고, 읽어오는 기능을 추가하시오.
3. 사용자의 정보를 HashSet으로 관리하시오.
 */