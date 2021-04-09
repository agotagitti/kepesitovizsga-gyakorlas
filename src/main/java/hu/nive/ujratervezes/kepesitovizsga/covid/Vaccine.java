package hu.nive.ujratervezes.kepesitovizsga.covid;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Vaccine {

    private List<Person> people = new ArrayList<>();

    public Vaccine(DataSource dataSource) {
        this.people = loadPeople(dataSource);

    }

    public List<Person> getVaccinationList() {
        return people;
    }

    private List<Person> loadPeople(DataSource dataSource) {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from registrations")) {
            List<Person> people = new ArrayList<>();
            while (rs.next()) {
                people.add(new Person(
                        rs.getString("person_name"),
                        rs.getInt("age"),
                        ChronicDisease.valueOf(rs.getString("chronic_disease").toUpperCase()),
                        Pregnancy.valueOf(rs.getString("pregnancy").toUpperCase())
                ));
            }
            return people;
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot select employees", se);
        }
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "people=" + people +
                '}';
    }
}
