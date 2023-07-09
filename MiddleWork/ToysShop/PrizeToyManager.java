import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PrizeToyManager {
    private List<String> prizeToysList;
    private Map<String, Integer> toysCountMap;

    public PrizeToyManager() {
        prizeToysList = new ArrayList<>();
        toysCountMap = new HashMap<>();
    }

    public void choosePrizeToy() {
        String[] prizeToys = { "Doll", "Car", "Teddy Bear", "Puzzle" };
    
        Random random = new Random();
        String chosenToy = prizeToys[random.nextInt(prizeToys.length)];
    
        if (prizeToysList.isEmpty() || !prizeToysList.contains(chosenToy)) {
            prizeToysList.add(chosenToy);
            toysCountMap.put(chosenToy, 1);
        }
        
        // Для ранее выбранных призовых игрушек увеличиваем количество доступных игрушек в карте
        for (String toy : prizeToysList) {
            if (!toy.equals(chosenToy)) {
                int toysCount = toysCountMap.getOrDefault(toy, 0);
                toysCount++;
                toysCountMap.put(toy, toysCount);
            }
        }
    }

    public void getPrizeToy() {
        if (!prizeToysList.isEmpty()) {
            String prizeToy = prizeToysList.remove(0);
            int toysCount = toysCountMap.getOrDefault(prizeToy, 0);
            if (toysCount > 0) {
                toysCount--;
                toysCountMap.put(prizeToy, toysCount);
                writeToFile(prizeToy);
                System.out.println("Призовая игрушка получена и записана в файл.");
            } else {
                System.out.println("Нет доступных игрушек выбранного типа.");
            }
        } else {
            System.out.println("Нет призовых игрушек.");
        }
    }

    private void writeToFile(String toy) {
        try {
            FileWriter writer = new FileWriter("prize_toys.txt", true);
            writer.write(toy + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл.");
        }
    }

    public static void main(String[] args) {
        PrizeToyManager toyManager = new PrizeToyManager();
        toyManager.choosePrizeToy();
        toyManager.getPrizeToy();
    }
}