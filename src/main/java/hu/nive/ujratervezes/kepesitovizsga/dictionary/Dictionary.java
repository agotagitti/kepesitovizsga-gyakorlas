package hu.nive.ujratervezes.kepesitovizsga.dictionary;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dictionary {

    private DataSource dataSource;

    public Dictionary(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getEnglishWord(String hungarianWord) {
        try(Connection cnx = dataSource.getConnection();
            PreparedStatement pstmt = cnx.prepareStatement("select angol from words where magyar = ?")) {
            pstmt.setString(1, hungarianWord);
            return getEnglishWordFromStatement(pstmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot load database", se);
        }
    }

    private String getEnglishWordFromStatement(PreparedStatement pstmt) {
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getString("angol");
            }
        }
        catch (SQLException se) {
            throw new IllegalStateException("Wrong statement", se);
        }
        throw new IllegalArgumentException("No such word in dictionary.");
    }

    public String getHungarianWord(String englishWord) {
        try(Connection cnx = dataSource.getConnection();
            PreparedStatement pstmt = cnx.prepareStatement("select magyar from words where angol = ?")) {
            pstmt.setString(1, englishWord);
            return getHungarianWordFromStatement(pstmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot load database", se);
        }
    }

    private String getHungarianWordFromStatement(PreparedStatement pstmt) {
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getString("magyar");
            }
        }
        catch (SQLException se) {
            throw new IllegalStateException("Wrong statement", se);
        }
        throw new IllegalArgumentException("No such word in dictionary.");
    }
}
