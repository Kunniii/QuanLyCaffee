import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeController {
    String fn = ".env/IfaVni-Vne";
    private File fpwds = new File(fn);
    private MD5 md5 = new MD5();
    boolean admin = false;

    /**
     * Phần này, mình lặp qua tất cả tên + pass đã đc mã hóa md5 nếu có thì trả về
     * true ko thì false
     * 
     * lưu thông tin đã mã hóa trong file
     */
    public boolean verify(String userName, String password) {
        try {
            Scanner fileScan = new Scanner(fpwds);
            while (fileScan.hasNextLine()) {
                if (fileScan.nextLine().equals(md5.hashMD5(userName, password))) {
                    fileScan.close();
                    return true;
                }
            }
            fileScan.close();
            return false;
        } catch (IOException e) {
            try {
                fpwds.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Phần này như trên nhưng đc lưu trong một file khác bỏ
     */
    // public boolean verifyAdmin(String name, String pass) {
    // if (name == "admin" && pass == "admin") {
    // this.admin = true;
    // return true;
    // }
    // return false;

    // }

    public void adduser() {
        Console console = System.console();
        String name;
        Scanner sc = new Scanner(System.in);
        console.printf("User name: ");
        name = sc.nextLine();
        console.printf("Password for " + name + ": ");
        char[] pass = console.readPassword();
        if (name.equals("admin") && new String(pass).equals("admin")) {
            Employee e = new Employee();
            e.input();
            try {
                FileWriter fw = new FileWriter(fpwds, true);
                fw.write(md5.hashMD5(e.getName(), e.getPass())+"\n");
                fw.close();
            } catch (Exception exception) {
            }
        } else {
            System.out.println("You dont have permission!");
        }
    }

    public void save() {

    }
}
