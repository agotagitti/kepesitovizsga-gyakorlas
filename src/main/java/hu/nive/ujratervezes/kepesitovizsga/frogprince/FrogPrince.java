package hu.nive.ujratervezes.kepesitovizsga.frogprince;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class FrogPrince {


    public Set<PlayerOfTale> getPlayersOfTale(DataSource dataSource, Tale tale) {
        Set<PlayerOfTale> playerOfTaleSet = new HashSet<>();
        try (Connection cnx = dataSource.getConnection();
             PreparedStatement pstmt = cnx.prepareStatement("select *  from tales where tale = ?")) {
            pstmt.setString(1, tale.toString());
            getPlayersFromResultSet(playerOfTaleSet, pstmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot load database", se);
        }
        return playerOfTaleSet;
    }

    private void getPlayersFromResultSet(Set<PlayerOfTale> playerOfTaleSet, PreparedStatement pstmt) {
        try (ResultSet rs = pstmt.executeQuery()) {
            while(rs.next()) {
                playerOfTaleSet.add(new PlayerOfTale(
                        rs.getString("player_name"),
                        rs.getInt("age"),
                        Tale.valueOf(rs.getString("tale"))
                ));
            }
        } catch (SQLException se) {
            throw new IllegalArgumentException("Wrong statement", se);
        }
    }
}
