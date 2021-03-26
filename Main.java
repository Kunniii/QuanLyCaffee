import java.text.ParseException;
import java.util.Scanner;

class Main {

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void options() {
        System.out.println("--- HIGH TEAM COFFEE & TEA ---");
        System.out.println("1. Order Items");
        System.out.println("2. Print Bill");
        System.out.println("3. Add user");
        System.out.println("0. Logout");
        // System.out.println("");
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.tableController.init();
        int opt = 0;
        while (true) {
            do {
                cls();
                controller.login();
                while (!controller.loggedIn) {
                    cls();
                    System.out.println("Wrong infomation!");
                    controller.login();
                }
                while (controller.loggedIn) {
                    Scanner sc = new Scanner(System.in);
                    while (true) {
                        try {
                            cls();
                            options();
                            System.out.print("Your option: ");
                            opt = Integer.parseInt(sc.nextLine());
                            break;
                        } catch (Exception ex) {

                        }
                    }
                    if (opt == 0) {
                        break;
                    }
                    switch (opt) {
                    case 1:
                        controller.tableController.showAvailable();
                        System.out.print("Choose table id: ");
                        String tbid = sc.nextLine();
                        controller.menu.showAll();
                        System.out.print("Choose item id: ");
                        String id = sc.nextLine();
                        controller.tableController.tables.get(Integer.parseInt(tbid) - 1).available = false;
                        while (!id.equals("0")) {
                            controller.tableController.tables.get(Integer.parseInt(tbid) - 1)
                                    .setItems(controller.menu.getItem(Integer.parseInt(id) - 1));

                            System.out.print("Choose item id: ");
                            id = sc.nextLine();
                        }
                        break;
                    case 2:
                        controller.tableController.showNotAvailable();
                        System.out.print("Choose item id: ");
                        String tid = sc.nextLine();
                        Table a = controller.tableController.tables.get(Integer.parseInt(tid) - 1);
                        a.exportBill();
                        sc.nextLine();
                        controller.tableController.tables.get(Integer.parseInt(tid) - 1).available = true;
                        break;
                    case 3:
                        controller.employeeController.adduser();
                        break;
                    case 4:
                    }
                }
            } while (opt != 0);
            System.out.println("asasd");
        }
    }
}