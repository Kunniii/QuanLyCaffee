public class Menu {
    ItemController itemController = new ItemController();

    public void showAll() {
        System.out.println("+ List of foods and drinks");
        itemController.showAll();
    }

    public Item getItem(int index) {
        return itemController.items.get(index);
    }
}
