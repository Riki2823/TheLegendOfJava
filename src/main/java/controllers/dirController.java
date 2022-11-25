package controllers;

import Service.DoorService;
import Service.MazeService;
import Service.TextService;
import Service.UserService;
import Utils.SelectMaze;
import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/dir")
public class dirController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        int userId = (int) session.getAttribute("userId");
        User u = UserService.getUser(userId);

        int mapId = (Integer) session.getAttribute("mapId");
        Maze inUseMaze = MazeService.getMazeInGame(u);

        Room actualRoom = UserService.getActualRoom(u);
        req.setAttribute("actualRoom", actualRoom.getId());

        String dirS = req.getParameter("dir");
        Room.Dirrection dir = selectDirrection(dirS);

        RoomSide rs = actualRoom.getSides().get(dir);
        String side = rs.toString();

        System.out.println(u);

        if (side.equals("\"Wall\"")){
            System.out.println("Wall");
            req.setAttribute("messageWall", "No puedes atravesar una pared!!!!");
        }else if (side.equals("\"Door\"")){
            Door door = (Door) rs;
            if (door.isOpen()){
                Room r = DoorService.getOpositeRoom(actualRoom,door);
                actualRoom = r;
                req.setAttribute("actualRoom", actualRoom.getId());
                u.setActualRoom(actualRoom);
            }else {

            }
        }

        //!!!!!!!!!IMPORTANTE IMPLEMENTAR DAO!!!!!!!!!!!!!!!!1
        int actualRoomid = actualRoom.getId();
        String roomJSONString = TextService.getJsonInfo(inUseMaze, actualRoomid, u);
        roomJSONString = roomJSONString.toLowerCase();
        req.setAttribute("room", roomJSONString);
        System.out.println(roomJSONString);
        RequestDispatcher dispatcher =  req.getRequestDispatcher("/WEB-INF/jsp/game.jsp");
        dispatcher.forward(req, resp);
    }

    private Room.Dirrection selectDirrection(String dir) {
        switch (dir){
            case "w":
                return Room.Dirrection.WEST;
            case "e":
                return Room.Dirrection.EAST;
            case "n":
                return Room.Dirrection.NORTH;
            case "s":
                return Room.Dirrection.SOUTH;
            default:
                return null;
        }
    }
}
