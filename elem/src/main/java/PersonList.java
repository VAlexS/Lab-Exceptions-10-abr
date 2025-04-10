import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonList {

    private final List<Person> persons = new ArrayList<>();


    public Person findByName(String name) throws IllegalArgumentException{

        if (!name.matches("\\w+ \\w+")) { // El patrón "\\w+ \\w+" verifica "palabra1 palabra2"
            throw new IllegalArgumentException("El string debe estar formateado como 'palabra1 palabra2'.");
        }

        for (Person person : persons)
            if (person.getName().equals(name))
                return person;

        return null; //si no encuentra la persona con ese nombre
    }

    public Person clone(Person original, int newID){
        return new Person(newID, original.getName(), original.getOccupation(), original.getAge());
    }

    public void addPerson(Person person){
        persons.add(person);
    }

    public void savePersonFile(Person person, String path){

        try {
            FileWriter writer = new FileWriter(path, true);
            writer.write(person.toString()+"\n");
            System.out.println("La persona "+person+" se ha guardado correctamente en el fichero "+path);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error de E/S");
            throw new RuntimeException(e);
        }

    }

    public List<Person> getPersons() {
        return persons;
    }
}
