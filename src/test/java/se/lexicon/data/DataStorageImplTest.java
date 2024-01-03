package se.lexicon.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Person;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class DataStorageImplTest {
    DataStorage instance;
    @BeforeEach
    void setUp() {
        instance = DataStorageImpl.getInstance();
    }

    @Test
    void findMany() {
        List<Person> list = instance.findMany(person -> person.getFirstName().equalsIgnoreCase("Frank"));
        Assertions.assertTrue(list.size() > 1);
    }

    @Test
    void findOne() {
        Person person = instance.findOne(p -> p.getFirstName().equalsIgnoreCase("Frank"));
        assertTrue(person.getFirstName().equalsIgnoreCase("Frank"));
    }

    @Test
    void findOneAndMapToString() {
        Person person = instance.findOne(p -> p.getFirstName().equalsIgnoreCase("Frank"));
        String expectedName = person.getFirstName() + " " + person.getLastName();
        String actualName = instance.findOneAndMapToString(
                p1 -> p1.getFirstName().equalsIgnoreCase("Frank"),
                (p2) -> p2.getFirstName() + " " + p2.getLastName());
        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    void findManyAndMapEachToString() {
    }

    @Test
    void findAndDo() {
    }

    @Test
    void findAndSort() {
    }

    @Test
    void testFindAndSort() {
    }
}