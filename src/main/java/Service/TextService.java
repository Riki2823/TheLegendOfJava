package Service;

import model.Maze;
import model.Room;
import org.json.simple.JSONObject;

public class TextService {
    public static String getJsonInfo(Maze maze, int room){
        JSONObject root = new JSONObject();
        Room actualRoom = maze.getRoom(room);

        JSONObject walls = new JSONObject();
        walls.putAll(actualRoom.getSides());
        root.put("walls", walls);

        return root.toJSONString();

    }
}
