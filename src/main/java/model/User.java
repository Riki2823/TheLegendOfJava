package model;

import com.sun.tools.javac.jvm.Items;

import java.util.ArrayList;
import java.util.List;

public class User {
    int id;
    int name;
    Room actualRoom;
    List<Items> items = new ArrayList<>();

    public List<Items> getItems() {
        return items;
    }

    public void addItem(Items item) {
        this.items.add(item);
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
