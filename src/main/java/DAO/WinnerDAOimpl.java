package DAO;

import Service.MazeService;
import Service.UserService;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static DAO.ConectionDatabase.getConnection;

public class WinnerDAOimpl implements WinnerDAO{
    @Override
    public void newWinner(User user) throws SQLException {
        Connection connection = getConnection();
        String insert = "INSERT INTO `winner` (`name`, `map_name`, `elapsed_time`) VALUES(?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(insert);
            statement.setString(1, UserService.getName(user));
            statement.setString(2, MazeService.getName(MazeService.getMazeInGame(user)));
            statement.setString(3, "0");
            statement.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> listOfWinners() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        return null;
    }
}
