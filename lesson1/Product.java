package  OOP.OOP.lesson1;

public class Product {

    protected String name; //protected - поле защищено, но с ним можно работать

    protected String brand;

    protected double price;

    double getPrice(){
        return price;
    } //ньютейпер или геттер

    void setPrice(double inputPrice){
        checkPrice(inputPrice);
        // price = inputPrice;
    } //аксессор или сеттер

    public Product(){  //конструктор без параметров - дефолтный конструктор
        this("product", 100); //this- указатель текущего экземпляра объекта
    }
    //public, private - модификаторы области видимости

    public Product(String inputName, double inputPrice){
        brand = "noname";
        name = "product";
        price = 100;
    }

    public Product(String inputBrand, String inputName, double inputPrice){
        checkPrice(inputPrice);
        // if (inputPrice <= 0){
        //     price = 100;
        // }
        // else{
        //     price = inputPrice;
        // }
        if(inputName.length() < 5){
            name = "product";
        }
        else{
            name = inputName;
        }
        brand = inputBrand;
    }

    void checkPrice(double inputPrice){
        if (inputPrice <= 0){
            price = 100;
        }
        else {
            price = inputPrice;
        }
    }

    // супермодификаторы видимости - private, public и "По умолчанию"
    //инкапсуляция - механизм, связывающий код и данные, которыми он манипулирует, 
    // защищая оба этих компонента от внешнего вмешательства и злоупотреблений.

    // Product(String inputBrand, String inputName, double inputPrice){  // в рамках конструктора не прописывается возвращаемое значение
    //          brand = inputBrand;
    //          name = inputName;
    //          price = inputPrice;
    //  }  //если мы не создаем конструктор в классе, то он создается самостоятельно по умолчанию

    public String displayInfo(){
        return String.format("%s - %s - %f", brand, name, price);
    }
}