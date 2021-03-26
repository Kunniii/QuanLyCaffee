import java.util.ArrayList;

public class TableController {

    ArrayList<Table> tables = new ArrayList<>();

    public void init() {
        for (int i = 1; i <= 5; ++i) {
            tables.add(new Table(String.valueOf(i)));
        }
    }

    public void showAvailable() {
        System.out.println("--- Available Tables ---");
        for (Table t : tables) {
            if (t.available)
                System.out.println(t.toString());
        }
    }

    public void showNotAvailable() {
        System.out.println("--- Unavailable Tables ---");
        for (Table t : tables) {
            if (!t.available)
                System.out.println(t.toString());
        }
    }

    // add food to table

}
