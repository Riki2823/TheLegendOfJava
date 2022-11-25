package model;

public class Key implements Item {
    private int id;
    private int keyLevel;
    private int price;

    public Key(int id, int keyLevel, int price){
        this.id = id;
        this.keyLevel = keyLevel;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {

        return "\"key" + this.keyLevel + "\"";
    }
}
