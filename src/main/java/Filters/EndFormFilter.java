package Filters;

import Service.RoomService;
import Service.UserService;
import model.Room;
import model.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns =  "/endform")
public class EndFormFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        User u = UserService.getUser((int) session.getAttribute("userId"));
        Room actualRoom = UserService.getActualRoom(u);
        if (!RoomService.isTarget(actualRoom)){
            res.sendError(403, "No tienes acceso a esta página hasta que finalize la partida ");
            return;
        }
        chain.doFilter(req, res);
    }
}
