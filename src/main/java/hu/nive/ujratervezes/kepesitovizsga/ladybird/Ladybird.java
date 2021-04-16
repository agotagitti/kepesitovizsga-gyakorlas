package hu.nive.ujratervezes.kepesitovizsga.ladybird;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class Ladybird {

    private DataSource dataSource;

    public Ladybird(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getLadybirdsWithExactNumberOfPoints(int number) {
        Connection cnx = getConnection();
        try (PreparedStatement pstmt = cnx.prepareStatement("select hungarian_name from ladybirds where number_of_points = ?")) {
            pstmt.setInt(1, number);
            return getLadyBirdsWithExactPoints(pstmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot load database", se);
        }
    }

    private List<String>  getLadyBirdsWithExactPoints(PreparedStatement pstmt) throws SQLException {
        List<String> ladyBirdNames = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                ladyBirdNames.add(rs.getString("hungarian_name"));
            }
        return ladyBirdNames;
    }

    public Map<Integer, Integer> getLadybirdsByNumberOfPoints() {
        Connection cnx = getConnection();
        try (Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT number_of_points, COUNT(*) AS 'ladybirds' FROM ladybirds GROUP BY number_of_points ORDER BY number_of_points asc")) {
            Map<Integer, Integer> ladyBirdsByPoints = new HashMap<>();
            while (rs.next()) {
                ladyBirdsByPoints.put(rs.getInt("number_of_points"), rs.getInt("ladybirds"));
            }
            return ladyBirdsByPoints;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot load database", se);
        }
    }

    public Set<Ladybug> getLadybirdByPartOfLatinNameAndNumberOfPoints(String partOfName, int numberOfPoints) {
       Connection cnx = getConnection();
       try(PreparedStatement pstmt = cnx.prepareStatement("SELECT * FROM ladybirds WHERE latin_name LIKE ? AND number_of_points = ?")) {
            pstmt.setString(1, "%" + partOfName + "%");
            pstmt.setInt(2, numberOfPoints);
           return getLadybugsFromPrepStatement(pstmt);
       } catch (SQLException se) {
           throw new IllegalStateException("Cannot load database", se);
       }
    }

    private Set<Ladybug> getLadybugsFromPrepStatement(PreparedStatement pstmt) {
        try (ResultSet rs = pstmt.executeQuery()) {
            Set<Ladybug> foundLadybugs = new HashSet<>();
            while (rs.next()) {
                foundLadybugs.add(new Ladybug(
                        rs.getString("hungarian_name"),
                        rs.getString("latin_name"),
                        rs.getString("genus"),
                        rs.getInt("number_of_points")
                ));
            }
            return foundLadybugs;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot", se);
        }
    }

    public Map<String, Integer> getLadybirdStatistics() {
        Connection cnx = getConnection();
        try(Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT genus, COUNT(*) AS 'ladybirds' FROM ladybirds GROUP BY genus")) {
            Map<String, Integer> foundLadyBirds = new HashMap<>();
            while(rs.next()) {
                foundLadyBirds.put(rs.getString("genus"),
                                    rs.getInt("ladybirds"));
            }
            return foundLadyBirds;
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot load database", se);
        }
    }

    private Connection getConnection() {
        try {
            Connection cnx = dataSource.getConnection();
            return cnx;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect to database", se);
        }
    }

}
