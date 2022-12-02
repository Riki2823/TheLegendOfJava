package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    int id;
    String name;
    Room actualRoom;
    Map<String, Item> items = new HashMap<>();
    int coinCounter = 0;
    private String mapUsed;
    private String elapsTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    public void setCointCounter(int coins){
        this.coinCounter = coins;
    }

    public void setMapUsed(String map_name) {
        this.mapUsed = map_name;
    }

    public void setElapsTime(String elapsed_time) {
        this.elapsTime = elapsed_time;
    }
}
