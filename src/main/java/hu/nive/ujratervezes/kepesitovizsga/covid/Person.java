package hu.nive.ujratervezes.kepesitovizsga.covid;

public class Person {

    private String name;
    private int age;
    private ChronicDisease chronicDisease;
    private Pregnancy pregnancy;

    public Person(String name, int age, ChronicDisease chronicDisease, Pregnancy pregnancy) {
        this.name = name;
        this.age = age;
        this.chronicDisease = chronicDisease;
        this.pregnancy = pregnancy;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ChronicDisease getChronicDisease() {
        return chronicDisease;
    }

    public Pregnancy getPregnancy() {
        return pregnancy;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", chronicDisease=" + chronicDisease +
                ", pregnancy=" + pregnancy +
                '}';
    }
}
