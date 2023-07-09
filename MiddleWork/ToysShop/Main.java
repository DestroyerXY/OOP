public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        
        Toy toy1 = new Toy("1", "Doll", 5, 30);
        toyStore.addNewToy(toy1);
        
        Toy toy2 = new Toy("2", "Car", 7, 20 );
        toyStore.addNewToy(toy2);

        Toy toy3 = new Toy("3", "Teddy Bear", 10, 34 );
        toyStore.addNewToy(toy2);

        Toy toy4 = new Toy("4", "Puzzle", 8, 25 );
        toyStore.addNewToy(toy2);
        
        toyStore.changeToyWeight("1", 40);
        
        Toy prizeToy = toyStore.getPrizeToy();
        if (prizeToy != null) {
            toyStore.saveToyToFile(prizeToy, "prize_toys.txt");
        }
    }
}