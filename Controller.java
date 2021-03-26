import java.io.*;
import java.util.Scanner;

public class Controller {
    ItemController itemController = new ItemController();
    TableController tableController = new TableController();
    EmployeeController employeeController = new EmployeeController();
    Menu menu = new Menu();
    Scanner sc = new Scanner(System.in);
    Console console = System.console();
    boolean loggedIn = false;


    public boolean login() {
        String name;
        console.printf("User name: ");
        name = sc.nextLine();
        console.printf("Password for " + name + ": ");
        char[] pass = console.readPassword();
        loggedIn = employeeController.verify(name, new String(pass));
        return employeeController.verify(name, new String(pass));
    }
}
