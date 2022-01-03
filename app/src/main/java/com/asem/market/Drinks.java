package supermarket;

class Drinks extends Category {
    private String capacity;

    public Drinks() {
    }
    
    public Drinks(String name, float price, int quantity, int production_Date, int expiration_Date, String capacity) {
        super(name, price, quantity, production_Date, expiration_Date);
        this.capacity = capacity;
    }
    
    
}
 