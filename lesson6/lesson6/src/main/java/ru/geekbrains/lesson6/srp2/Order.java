package ru.geekbrains.lesson6.srp2;

// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.Scanner;

// public class Order {

//     private Scanner scanner = new Scanner(System.in);
//     private String clientName;
//     private String product;
//     private int qnt;
//     private int price;

//     public String getClientName() {
//         return clientName;
//     }

//     public String getProduct() {
//         return product;
//     }

//     public int getQnt() {
//         return qnt;
//     }

//     public int getPrice() {
//         return price;
//     }

//     public Order(){

//     }

//     public Order(String clientName, String product, int qnt, int price) {
//         this.clientName = clientName;
//         this.product = product;
//         this.qnt = qnt;
//         this.price = price;
//     }

//     public void inputFromConsole(){
//         clientName = prompt("Имя клиента: ");
//         product = prompt("Продукт: ");
//         qnt = Integer.parseInt(prompt("Кол-во: "));
//         price = Integer.parseInt(prompt("Цена: "));
//     }

//     private String prompt(String message){
//         System.out.println(message);
//         return scanner.nextLine();
//     }

//     public void saveToJson() {
//         String fileName = "order.json";
//         try (FileWriter writer = new FileWriter(fileName, false)) {
//             writer.write("{\n");
//             writer.write("\"clientName\":\""+ clientName + "\",\n");
//             writer.write("\"product\":\""+product+"\",\n");
//             writer.write("\"qnt\":"+qnt+",\n");
//             writer.write("\"price\":"+price+"\n");
//             writer.write("}\n");
//             writer.flush();
//         } catch (IOException ex) {
//             System.out.println(ex.getMessage());
//         }
//     }


// }

// Нарушение принципа единственной ответственности (SRP):
// Класс Order отвечает за сохранение заказа в формат JSON и за ввод данных о заказе с консоли. Необходимо разделить эти две ответственности на разные классы.

// Нарушение принципа открытости/закрытости (OCP):
// Класс Order не предусматривает возможности сохранения заказа в других форматах (например, в формате XML). Необходимо добавить возможность расширения функциональности класса без изменения его исходного кода.

// Нарушение принципа подстановки Барбары Лисков (LSP):
// Нет наследников, поэтому данный принцип не нарушен.

// Нарушение принципа разделения интерфейса (ISP):
// Нет интерфейсов, поэтому данный принцип не нарушен.

// Нарушение принципа инверсии зависимостей (DIP):
// Класс Order жестко зависит от класса FileWriter. Для решения этой проблемы можно использовать интерфейс, который будет абстрагировать запись в файл от класса Order. Также можно использовать Dependency Injection для внедрения зависимости класса FileWriter в класс Order.

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Order {
    private final OrderSaver orderSaver;
    private String clientName;
    private String product;
    private int qnt;
    private int price;

    public Order(OrderSaver orderSaver) {
        this.orderSaver = orderSaver;
    }
    
    public String getClientName() {
        return clientName;
    }
    
    public String getProduct() {
        return product;
    }
    
    public int getQnt() {
        return qnt;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void save(OrderSaver.Format format) {
        orderSaver.save(format, this);
    }
    
    public void inputFromConsole(){
        clientName = prompt("Client name: ");
        product = prompt("Product: ");
        qnt = Integer.parseInt(prompt("Quantity: "));
        price = Integer.parseInt(prompt("Price: "));
    }
    
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    public void saveToJson() {
    }
}

interface OrderSaver {
enum Format {
JSON,
XML
}
void save(Format format, Order order);

}

class JsonOrderSaver implements OrderSaver {
private final FileWriter writer;
public JsonOrderSaver(FileWriter writer) {
    this.writer = writer;
}

@Override
public void save(Format format, Order order) {
    try {
        writer.write("{\n");
        writer.write("\"clientName\":\"" + order.getClientName() + "\",\n");
        writer.write("\"product\":\"" + order.getProduct() + "\",\n");
        writer.write("\"qnt\":" + order.getQnt() + ",\n");
        writer.write("\"price\":" + order.getPrice() + "\n");
        writer.write("}\n");
        writer.flush();
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
}
}

class XmlOrderSaver implements OrderSaver {
private final FileWriter writer;
public XmlOrderSaver(FileWriter writer) {
    this.writer = writer;
}

@Override
public void save(Format format, Order order) {
    try {
        writer.write("<order>\n");
        writer.write("<clientName>" + order.getClientName() + "</clientName>\n");
        writer.write("<product>" + order.getProduct() + "</product>\n");
        writer.write("<qnt>" + order.getQnt() + "</qnt>\n");
        writer.write("<price>" + order.getPrice() + "</price>\n");
        writer.write("</order>\n");
        writer.flush();
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
}
}

    
