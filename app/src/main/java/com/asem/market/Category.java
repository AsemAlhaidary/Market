package supermarket;

public abstract class Category {

    protected String name;
    protected float price;
    protected int quantity;
    protected String details;
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

    public abstract void setDetails(String details);

    public abstract String getName();

    public abstract float getPrice();

    public abstract int getQuantity();

    public abstract String getDetails();

    public abstract int getProduction_Date();

    public abstract int getExpiration_Date();

    public abstract int getReminingDate();
    
    public abstract void  insertNames(String [] names);
    
    public abstract void  insertPrice(float [] prices);
    
    public abstract void  insertQuantities(int  [] quantities);
    
    public abstract void  insertProduction_Date(int [] production_Date);
    
    public abstract void  insertExpiration_Date(int [] expiration_Date);
 
    public abstract void  displayData();
}
