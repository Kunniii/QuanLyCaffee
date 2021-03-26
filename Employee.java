import java.util.*;

public class Employee {
    String name;
    String password;
    String phoneNu;
    boolean isLoggedln, admin;
    MD5 hash = new MD5();

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNu(String phoneNu) {
        this.phoneNu = phoneNu;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNu() {
        return phoneNu;
    }

    public String getPass() {
        return this.password;
    }

    public void isLoggedln() {
        this.isLoggedln = false;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter name: ");
        this.setName(sc.nextLine());
        System.out.print("Password: ");
        this.setPassword(sc.nextLine());
        System.out.print("Phone: ");
        this.setPhoneNu(sc.nextLine());
        sc.close();
    }

    public String getHash() {
        try {
            return hash.hashMD5(this.name, this.password);
        } catch (RuntimeException e) {
            System.out.println("ERROR: Method unavailable!");
            return "";
        }
    }

    @Override
    public String toString() {
        return "Name:  " + this.name + "\nPhone: " + this.phoneNu;
    }
}