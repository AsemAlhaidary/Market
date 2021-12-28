package supermarket;

public class Category {

    protected String name;
    protected float price;
    protected int quantity;
    protected int production_Date;
    protected int expiration_Date;

    public Category(String name, float price, int quantity, int production_Date, int expiration_Date) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.production_Date = production_Date;
        this.expiration_Date = expiration_Date;
    }
}
