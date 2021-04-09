package hu.nive.ujratervezes.kepesitovizsga.covid;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pfizer extends Vaccine {

    public Pfizer(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Person> getVaccinationList() {
        List<Person> personList = super.getVaccinationList();
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int o1Int = 2;
                int o2Int = 2;
                if (o1.getPregnancy() == Pregnancy.IGEN) {
                    o1Int -= 2;
                } else if (o1.getAge() > 65) {
                    o1Int -=1;
                }
                if (o2.getPregnancy() == Pregnancy.IGEN) {
                    o2Int -= 2;
                } else if (o2.getAge() > 65) {
                    o2Int -=1;
                }
                return o1Int - o2Int;
            }
        });
        return personList;
    }
}
