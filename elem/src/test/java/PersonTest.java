import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person person, person2, person3;
    PersonList personList;

    @BeforeEach
    void setUpPerson() throws IllegalArgumentException{
        person = new Person(1, "Victor Sanz", "Informático", 24);

        person2 = new Person(2, "Marcel Bosch", "Profesor", 30);

        person3 = new Person(3, "Hector Gomez", "Profesor", 32);

        personList = new PersonList();

        personList.addPerson(person);
        personList.addPerson(person2);
        personList.addPerson(person3);

    }


    @Test
    @DisplayName("Introduzco una edad negativa")
    void givenAgeNegativeThenThrowsIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> person.setAge(-24));
    }

    @Test
    @DisplayName("Busco una persona especifica y me la devuelve correctamente")
    void givenPersonThenReturnIt() {

        assertEquals(person, personList.findByName("Victor Sanz"));

    }

    @Test
    @DisplayName("Busco una persona y provoco que lance IllegalArgumentException metiendo solo el nombre")
    void givenPersonWithoutSpacesBetweenWordsInName() {

        assertThrows(IllegalArgumentException.class, () -> personList.findByName("Victor"));
    }

    @Test
    @DisplayName("Compruebo que puedo clonar una persona salvo el ID")  //esto es lo que me falla, y en la clase PersonList tengo bien implementado el metodo
    void clonePerson() {

        Person clonedPerson = personList.clone(person, 4);

        assertEquals(4, clonedPerson.getId());
        assertEquals("Victor Sanz", clonedPerson.getName());
        assertEquals("Informático", clonedPerson.getOccupation());
        assertEquals(24, clonedPerson.getAge());


    }


}