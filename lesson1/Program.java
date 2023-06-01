package OOP.OOP.lesson1;

import java.util.ArrayList;
import java.util.List;

public class Program {
    
    public static void main(String[] args) {
        
        int a = 1;
        Product product1;

        product1 = new Product("ООО Лучшая вода", "БУ", 100.12  );
        // product1.brand = "ООО Лучшая вода";
        // product1.name = "БУ";
        // product1.price = 100.12;
        System.out.println(product1.displayInfo());

        Product bottleOfWater1 = new BottleOfWater("ООО Чистый источник", "Бутылка с водой 1", 115, 1);
        Product bottleOfWater2 = new BottleOfWater("ООО Чистый источник", "Бутылка с водой 2", 115, 2);
        Product bottleOfWater3 = new BottleOfWater("ООО Чистый источник", "Бутылка с водой 3", 115, 5);
        Product bottleOfWater4 = new BottleOfWater("ООО Чистый источник", "Бутылка с водой 4", 115, 1.5);
        Product bottleOfWater5 = new BottleOfWater("ООО Чистый источник", "Бутылка с водой 5", 115, 3);
        System.out.println(bottleOfWater1.displayInfo());
        Product bottleOfMilk1 = new BottleOfMilk("ООО Домик в деревне", "Цельное 1", 120, 2, 3);
        Product bottleOfMilk2 = new BottleOfMilk("ООО Домик в деревне", "Цельное 2", 140, 2, 5);
        Product bottleOfMilk3 = new BottleOfMilk("ООО Домик в деревне", "Цельное 3", 160, 1, 7);
        Product bottleOfMilk4 = new BottleOfMilk("ООО Домик в деревне", "Цельное 4", 190, 2, 2);
        Product bottleOfMilk5 = new BottleOfMilk("ООО Домик в деревне", "Цельное 5", 220, 3, 1);
        System.out.println(bottleOfMilk1.displayInfo());
        Product Chocolate1 = new Chocolate("ООО Баунти", "Шоколад 1", 120, 130, 50);
        Product Chocolate2 = new Chocolate("ООО Красный Октябрь", "Шоколад 2", 110, 130, 70);
        Product Chocolate3 = new Chocolate("ООО РотФронт", "Шоколад 3", 100, 300, 20);
        Product Chocolate4 = new Chocolate("ООО Лейс", "Шоколад 4", 160, 100, 100);
        System.out.println(Chocolate1.displayInfo());

        List<Product> products = new ArrayList<>();
        products.add(bottleOfWater1);
        products.add(bottleOfWater2);
        products.add(bottleOfWater3);
        products.add(bottleOfWater4);
        products.add(bottleOfWater5);

        products.add(bottleOfMilk1);
        products.add(bottleOfMilk2);
        products.add(bottleOfMilk3);
        products.add(bottleOfMilk4);
        products.add(bottleOfMilk5);

        products.add(Chocolate1);
        products.add(Chocolate2);
        products.add(Chocolate3);
        products.add(Chocolate4);

        VendingMachine vendingMachine = new VendingMachine(products);
        Chocolate ChocolateResult = vendingMachine.getChocolate(100);
        if (ChocolateResult != null){
            System.out.println("Вы купили: ");
            System.out.println(ChocolateResult.displayInfo());
        }
        else{
            System.out.println("Такого шоколада нет");
        }
    }
}
