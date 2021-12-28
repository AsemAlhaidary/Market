package supermarket;

class Drinks extends Category {

    private String capacity;
    
    public Drinks(String name, float price, int quantity, int production_Date, int expiration_Date, String capacity) {
        super(name, price, quantity, production_Date, expiration_Date);
        this.capacity = capacity;
    }

    public String getName() {
        return super.name;
    }

    public float getPrice() {
        return super.price;
    }

    public int getQuantity() {
        return super.quantity;
    }

    public int getProduction_Date() {
        return super.production_Date;
    }

    public int getExpiration_Date() {
        return super.expiration_Date;
    }

}
