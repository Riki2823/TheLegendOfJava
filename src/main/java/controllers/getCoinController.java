package controllers;

import Service.MazeService;
import Service.RoomService;
import Service.TextService;
import Service.UserService;
import Utils.SelectMaze;
import model.Maze;
import model.Room;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/getCoin")
public class getCoinController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User u = UserService.getUser((int) session.getAttribute("userId"));

        int mapId = (Integer) session.getAttribute("mapId");
        Maze inUseMaze = MazeService.getMazeInGame(u);

        Room actualRoom = u.getActualRoom();
        RoomService.deleteCoin(actualRoom);

        UserService.setActualRoom(u, actualRoom);
        req.setAttribute("actualRoom", actualRoom.getId());

        UserService.addCoin(u);


        //!!!!!!!!!IMPORTANTE IMPLEMENTAR DAO!!!!!!!!!!!!!!!!1
        int actualRoomid = actualRoom.getId();
        String roomJSONString = TextService.getJsonInfo(inUseMaze, actualRoomid, u);
        roomJSONString = roomJSONString.toLowerCase();
        req.setAttribute("room", roomJSONString);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/game.jsp");
        dispatcher.forward(req, resp);
    }
}
