package OOP.OOP.lesson1;

public class Program {
    
    public static void main(String[] args) {
        
        int a = 1;
        Product product1;

        product1 = new Product("ООО Лучшая вода", "БУ", 100.12  );
        // product1.brand = "ООО Лучшая вода";
        // product1.name = "БУ";
        // product1.price = 100.12;
        System.out.println(product1.displayInfo());
    }
}
