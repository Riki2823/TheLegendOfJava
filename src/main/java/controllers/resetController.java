package controllers;

import Service.MazeService;
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

@WebServlet("/reset")
public class resetController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User u = UserService.getUser((int) session.getAttribute("userId"));
        UserService.deleteItems(u);

        int mapId = (int) session.getAttribute("mapId");
        int actualRoomid = 1;

        Maze inUseMaze = SelectMaze.createMaze(mapId, u);
        Room actualRoom = MazeService.getRoom( inUseMaze, actualRoomid);

        UserService.setActualRoom(u,actualRoom);
        String roomJSONString = TextService.getJsonInfo(inUseMaze, actualRoomid, u);
        roomJSONString = roomJSONString.toLowerCase();

        req.setAttribute("coinsU", UserService.getnCoins(u));
        req.setAttribute("mapId", mapId);
        req.setAttribute("actualRoom", actualRoomid);
        req.setAttribute("room", roomJSONString);

        session.setAttribute("mapId", mapId);
        session.setAttribute("userId", u.getId());


        RequestDispatcher dispatcher =  req.getRequestDispatcher("/WEB-INF/jsp/game.jsp");
        dispatcher.forward(req, resp);
    }
}
