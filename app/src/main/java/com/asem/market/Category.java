package supermarket;

public class Category {

    protected String name;
    protected float price;
    protected int quantity;
    protected int production_Date;
    protected int expiration_Date;
    
    public Category(){}
    public Category(String name, float price, int quantity, int production_Date, int expiration_Date) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.production_Date = production_Date;
        this.expiration_Date = expiration_Date;
    }
     
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getProduction_Date() {
        return production_Date;
    }

    public int getExpiration_Date() {
        return expiration_Date;
    }
    public int returnDate()
    {
    return expiration_Date-production_Date;
    }
}
