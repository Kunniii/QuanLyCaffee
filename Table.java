import java.util.ArrayList;

public class Table {
    Bill bill;
    ArrayList<Item> items = new ArrayList<>();
    boolean available;
    String id;

    public Table(String tid) {
        id = tid;
        available = true;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    public void setItems(Item items) {
        this.items.add(items);
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public double total() {
        double a = 0f;
        for (Item i : items) {
            a += i.getPrice();
        }
        return a;
    }

    public void exportBill() {
        bill = new Bill(this.getId(), this.total(), this.getItems());
    }

    public String toString() {
        return "    + " + this.getId();
    }
}
