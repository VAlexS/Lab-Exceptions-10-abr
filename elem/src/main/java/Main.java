import java.util.List;

public class Main {
    public static void main(String[] args) {


        Person person1 = new Person(1, "Victor Sanz", "Informatico", 23);

        Person person2 = new Person(2, "Marcel Boch", "Profesor", 30);


        Person person3 = new Person(3, "Hector Gomez", "Profesor", 35);

        PersonList personList = new PersonList();

        personList.addPerson(person1);
        personList.addPerson(person2);
        personList.addPerson(person3);




        Person especificPerson = personList.findByName("Victor Sanz");

        System.out.println(especificPerson);

        if (person2.equals(person3)){
            System.out.println("Ok");
        }
        else{
            System.out.println("No coinciden");
        }

        List<Person> listPerson = personList.getPersons();

        for (Person p : listPerson)
            personList.savePersonFile(p, "personas.txt");




    }
}