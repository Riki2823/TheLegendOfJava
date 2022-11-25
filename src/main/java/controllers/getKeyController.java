package controllers;

import Service.*;
import model.Key;
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

@WebServlet("/getKey")
public class getKeyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User u = UserService.getUser((int) session.getAttribute("userId"));

        Maze inUseMaze = MazeService.getMazeInGame(u);

        Room actualRoom = u.getActualRoom();
        if (RoomService.hadKey(actualRoom)){
            Key key = (Key) RoomService.getKey(actualRoom);
            if (UserService.getnCoins(u) >= KeyService.getKeyPrice(key)){
                UserService.buying(KeyService.getKeyPrice(key), u);
                UserService.addKey(key, u);
                RoomService.deleteKey(actualRoom);

            }else {
                req.setAttribute("messageWall", "No tienes suficiente dinero para comprar esa llave");
            }
        }

        req.setAttribute("actualRoom", actualRoom.getId());
        req.setAttribute("coinsU", UserService.getnCoins(u));

        //!!!!!!!!!IMPORTANTE IMPLEMENTAR DAO!!!!!!!!!!!!!!!!1
        int actualRoomid = actualRoom.getId();
        String roomJSONString = TextService.getJsonInfo(inUseMaze, actualRoomid, u);
        roomJSONString = roomJSONString.toLowerCase();
        req.setAttribute("room", roomJSONString);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/game.jsp");
        dispatcher.forward(req, resp);
    }
}
