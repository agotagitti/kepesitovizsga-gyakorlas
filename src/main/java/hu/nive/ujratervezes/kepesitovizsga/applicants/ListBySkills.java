package hu.nive.ujratervezes.kepesitovizsga.applicants;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListBySkills implements ApplicantListGenerator{

    @Override
    public List<Applicant> getListFromDatabase(DataSource dataSource) {
        try (Connection cnx = dataSource.getConnection();
             Statement stmt = cnx.createStatement();
             ResultSet rs = stmt.executeQuery("select first_name, last_name, skill from applicants")) {
            List<Applicant> applicants = new ArrayList<>();
            while (rs.next()) {
                if (rs.getString("skill").length() == 3) {
                    applicants.add(new Applicant(
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("skill")
                    ));
                }
            }
            return applicants;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot load database", se);
        }
    }

}
