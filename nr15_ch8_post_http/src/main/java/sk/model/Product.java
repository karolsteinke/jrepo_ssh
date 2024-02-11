package sk.model;

//Product is in 'model' package but apparently it is not the same as 'Model' class
//which we use to send data to the view (in the controller)
public class Product {
    
    private String name;
    private double price;

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
}
