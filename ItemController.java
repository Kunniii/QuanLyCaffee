import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ItemController {
    ArrayList<Item> items = new ArrayList<>();

    public ItemController() {
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader(".env/items"));
            ArrayList<String> listOfLines = new ArrayList<>();
            String line = bufReader.readLine();
            while (line != null) {
                listOfLines.add(line);
                line = bufReader.readLine();
                Item t = new Item();
                String[] tline = line.split(";");
                t.setId(tline[0]);
                t.setName(tline[1]);
                t.setPrice(Double.parseDouble(tline[2]));
                items.add(t);
            }
            bufReader.close();
        } catch (Exception ex) {
        }
    }

    public void showAll() {
        System.out.println("+--------------------------------------------------------------");
        for (Item i : items) {
            System.out.println("| " + i.getId() + "     " + i.getName() + "       " + i.getPrice());
        }
        System.out.println("| 0. Save");
        System.out.println("+--------------------------------------------------------------");
    }
}
