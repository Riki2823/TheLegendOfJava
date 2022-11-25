package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    int id;
    int name;
    Room actualRoom;
   Map<String, Item> items = new HashMap<>();
   int coinCounter = 0;

    public Map<String, Item> getItems() {
        return items;
    }

    public void addItem(String itemS, Item item) {
        if (itemS.equals("coin")){
            coinCounter++;
        }
        this.items.put(itemS, item);
    }
    public int getCoins(){
        return coinCounter;
    }
    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Room getActualRoom() {
        return actualRoom;
    }

    public void setActualRoom(Room actualRoom) {
        this.actualRoom = actualRoom;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
