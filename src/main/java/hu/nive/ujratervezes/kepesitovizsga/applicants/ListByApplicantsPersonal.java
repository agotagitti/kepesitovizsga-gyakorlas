package hu.nive.ujratervezes.kepesitovizsga.applicants;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListByApplicantsPersonal implements ApplicantListGenerator {

    @Override
    public List<Applicant> getListFromDatabase(DataSource dataSource) {

        try (Connection cnx = dataSource.getConnection();
             Statement stmt = cnx.createStatement();
             ResultSet rs = stmt.executeQuery("select first_name, last_name, phone_number, email from applicants")) {
            List<Applicant> applicants = new ArrayList<>();
            while (rs.next()) {
                applicants.add(new Applicant(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone_number"),
                        rs.getString("email")
                ));
            }
            return applicants;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot load database", se);
        }
    }

}
