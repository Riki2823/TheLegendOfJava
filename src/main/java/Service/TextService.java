package Service;

import model.Maze;
import model.Room;
import model.User;
import org.json.simple.JSONObject;

import java.util.Map;
import java.util.stream.Collectors;

public class TextService {
    public static String getJsonInfo(Maze maze, int room, User u){
        JSONObject root = new JSONObject();
        Room actualRoom = maze.getRoom(room);

        JSONObject walls = new JSONObject();
        walls.putAll(actualRoom.getSides());
        root.put("walls", walls);

        JSONObject roomItems = new JSONObject();
        roomItems.putAll(actualRoom.getItems());
        root.put("items", roomItems);

        JSONObject userItems = new JSONObject();
        userItems.putAll(UserService.getItems(u));
        root.put("userItems", userItems);

        return root.toJSONString();

    }
}
