package hu.nive.ujratervezes.kepesitovizsga.zoo;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class Zoo {

    private DataSource dataSource;

    private List<ZooAnimal> animals = new ArrayList<>();

    public Zoo(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<ZooAnimal> getAnimals() {
        return new ArrayList<>(animals);
    }

    public void loadAnimals() {
        try (Connection cnx = dataSource.getConnection();
             Statement stmt = cnx.createStatement();
             ResultSet rs = stmt.executeQuery("select * from animals")) {
            animals.clear();
            while (rs.next()) {
                String name = rs.getString("animal_name");
                int length = rs.getInt("length_of_member");
                long weight = rs.getLong("weight");
                AnimalType type = AnimalType.valueOf(rs.getString("animal_type"));
                if (type == AnimalType.ELEPHANT) {
                    animals.add(new Elephant(name, length, weight));
                } else if (type == AnimalType.GIRAFFE) {
                    animals.add(new Giraffe(name, length));
                } else {
                    animals.add(new Lion(name));
                }
            }
        } catch (SQLException ioe) {
            throw new IllegalStateException("Cannot load database", ioe);
        }
    }

    public void addAnimal(ZooAnimal animal) {
        if (!animals.contains(animal)) {
            try (Connection cnx = dataSource.getConnection();
                 PreparedStatement pstmt = cnx.prepareStatement("insert into animals (animal_name, length_of_member, weight, animal_type)  values (?, ?, ?, ?)")) {
                pstmt.setString(1, animal.getName());
                pstmt.setInt(2, animal.getLength());
                pstmt.setLong(3, animal.getWeight());
                pstmt.setString(4, animal.getType().toString());
                pstmt.executeUpdate();
            } catch (SQLException ioe) {
                throw new IllegalStateException("Cannot connect database", ioe);
            }
        }
    }

    public ZooAnimal getHeaviestAnimalInTheZoo() {
        ZooAnimal heaviestAnimal = null;
        long weightCount = 0L;
        for (ZooAnimal actualAnimal : animals) {
            if (actualAnimal.getWeight() > weightCount) {
                weightCount = actualAnimal.getWeight();
                heaviestAnimal = actualAnimal;
            }
        }
        return heaviestAnimal;
    }

    public long countWeights() {
        long sumWeight = 0;
        for (ZooAnimal actualAnimal : animals) {
            sumWeight += actualAnimal.getWeight();
        }
        return sumWeight;
    }


    public ZooAnimal findExactAnimal(ZooAnimal animal) {
        for (ZooAnimal actualAnimal : animals) {
            if (actualAnimal.equals(animal)) {
                return actualAnimal;
            }
        }
        throw new IllegalArgumentException("There is no such animal in the zoo!");
    }

    public ZooAnimal findExactAnimalByName(String name) {
        for (ZooAnimal actualAnimal : animals) {
            if (actualAnimal.getName().equals(name)) {
                return actualAnimal;
            }
        }
        throw new IllegalArgumentException("There is no such animal in the zoo!");
    }

    public int getNumberOfAnimals() {
        return animals.size();
    }

    public List<ZooAnimal> getAnimalsOrderedByName() {
        List<ZooAnimal> animalsInOrder = new ArrayList<>();
        for (ZooAnimal actualAnimal : animals) {
            animalsInOrder.add(actualAnimal);
        }
        Collections.sort(animalsInOrder, new Comparator<ZooAnimal>() {
            @Override
            public int compare(ZooAnimal o1, ZooAnimal o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return animalsInOrder;
    }

    public Map<AnimalType, Integer> getAnimalStatistics() {
        Map<AnimalType, Integer> animalStatistics = new HashMap<>();
        for (ZooAnimal actualAnimal : animals) {
            if (animalStatistics.containsKey(actualAnimal.getType())) {
                animalStatistics.put(actualAnimal.getType(), animalStatistics.get(actualAnimal.getType()) + 1);
            } else {
                animalStatistics.put(actualAnimal.getType(), 1);
            }
        }
        return animalStatistics;
    }
}
