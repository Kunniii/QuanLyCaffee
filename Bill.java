import java.text.SimpleDateFormat;
import java.util.*;
import java.io.FileWriter;
import java.io.File;

public class Bill {
    private double TongTien;
    private String MaBan;
    private String GioDen; // Carlendar
    private ArrayList<Item> items = new ArrayList<>();

    public Bill(String maban, double tongtien, ArrayList<Item> items) {
        this.TongTien = tongtien;
        MaBan = maban;
        this.items = items;
        save();
    }

    public void SetMaBan(String maban) {
        MaBan = maban;
    }

    public String GetMaBan() {
        return MaBan;
    }

    public void SetGioDen(String gioden) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        GioDen = formatter.format(calendar.getTime());
    }

    public String GetGioDen() {
        return GioDen;
    }

    public void SetTongTien(double tongtien) {
        TongTien = tongtien;
    }

    public double GetTongTien() {
        return TongTien;
    }

    public String printBill() {
        System.out.println("----------------------------------------------");
        String s = "HIGHT TEAM\n" + "TEA & COFFEE\n" + "HIGHT TEAM Tea & Coffee\n"
                + "69 Nguyễn Văn Cừ, An Bình, Ninh Kiều TP Cần Thơ\n" + "ĐT:0915.789.258\n" + "HÓA ĐƠN\n" + "Số bàn:"
                + this.GetMaBan() + "\nThời gian: " + this.GetGioDen();
        System.out.println("HIGHT TEAM");
        System.out.println("TEA & COFFEE");
        System.out.println("HIGHT TEAM Tea & Coffee");
        System.out.println("69 Nguyễn Văn Cừ, An Bình, Ninh Kiều TP Cần Thơ");
        System.out.println("ĐT:0915.789.258");
        System.out.println("HÓA ĐƠN");
        System.out.println("Số bàn: " + this.GetMaBan());
        System.out.println("Thời gian: " + this.GetGioDen());
        for (Item i : items) {
            System.out.println("+ " + i.getName() + "     " + i.getPrice());
            s += "+ " + i.getName() + "     " + i.getPrice() + "\n";
        }
        System.out.println("Tổng tiền: " + this.GetTongTien());
        s += "Tổng tiền: " + this.GetTongTien();
        System.out.println("----------------------------------------------\n");
        return s;
    }

    public void save() {
        File f = new File("./HoaDon/" + GetGioDen());
        try {
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            fw.write(printBill());
            fw.close();
        } catch (Exception e) {
        }
    }
}
