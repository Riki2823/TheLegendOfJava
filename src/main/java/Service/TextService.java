package Service;

import model.Maze;
import model.Room;
import org.json.simple.JSONObject;

import java.util.Map;
import java.util.stream.Collectors;

public class TextService {
    public static String getJsonInfo(Maze maze, int room){
        JSONObject root = new JSONObject();
        Room actualRoom = maze.getRoom(room);

        JSONObject walls = new JSONObject();
        walls.putAll(actualRoom.getSides());
        root.put("walls", walls);

        JSONObject items = new JSONObject();
        items.
        return root.toJSONString();

    }
}
