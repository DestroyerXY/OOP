import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys;
    private List<Toy> prizeToys;
    
    public ToyStore() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }
    
    public void addNewToy(Toy toy) {
        toys.add(toy);
    }
    
    public void changeToyWeight(String toyId, int newWeight) {
        for (Toy toy : toys) {
            if (toy.getId().equals(toyId)) {
                toy.setWeight(newWeight);
                break;
            }
        }
    }
    
    public void randomizeToys() {
        for (Toy toy : toys) {
            for (int i = 0; i < toy.getWeight(); i++) {
                prizeToys.add(toy);
            }
        }
    }
    
    public Toy getPrizeToy() {
        if (prizeToys.isEmpty()) {
            randomizeToys();
        }
        
        Random random = new Random();
        int index = random.nextInt(prizeToys.size());
        
        Toy prizeToy = prizeToys.get(index);
        prizeToy.decreaseQuantity();
        prizeToys.remove(index);
        
        return prizeToy;
    }
    
    public void saveToyToFile(Toy toy, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(toy.getId() + "," + toy.getName() + "," + toy.getQuantity());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}


