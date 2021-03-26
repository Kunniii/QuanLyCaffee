public class Item {
    private String id;
    private String name;
    private double price;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        while(id.trim().isEmpty()){
            // same id -> again
            // Atemp to input again
        }
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        while(name.trim().isEmpty()) {
            // same name -> again
            // Atemp to input again
        }
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        while (price <= 0) {
            // Atemp to input again
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return id+";"+name+";"+price;
    }
}