package hu.nive.ujratervezes.kepesitovizsga.covid;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SinoPharm extends Vaccine {

    public SinoPharm(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Person> getVaccinationList() {
        List<Person> personList = super.getVaccinationList();
        Iterator<Person> iterator = personList.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getPregnancy() == Pregnancy.IGEN || person.getChronicDisease() == ChronicDisease.IGEN) {
                iterator.remove();
            }
        }
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int o1Int = 2;
                int o2Int = 2;
                if (o1.getAge() < 65) {
                    o1Int -= 1;
                }
                if (o2.getAge() < 65) {
                    o2Int -= 1;
                }
                return o1Int - o2Int;
            }
        });
        return personList;
    }
}
