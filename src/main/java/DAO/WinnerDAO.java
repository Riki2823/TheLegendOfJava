package DAO;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface WinnerDAO {
    void newWinner(User user) throws SQLException;
    List<User> listOfWinners() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException;

}
