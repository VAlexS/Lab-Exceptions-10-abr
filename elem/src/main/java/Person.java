public class Person {

    private final int id;

    private final String name;

    private final String occupation;

    private int age;

    public Person(int id, String name, String occupation, int age) throws IllegalArgumentException {
        if (!name.matches("\\w+ \\w+")) { // El patrón "\\w+ \\w+" verifica "palabra1 palabra2"
            throw new IllegalArgumentException("El nombre debe estar formateado con <nombre apellido>'.");
        }

        this.id = id;
        this.name = name;
        this.occupation = occupation;
        setAge(age);
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age < 0)
            throw new IllegalArgumentException("La edad no puede tener valores negativos");
        this.age = age;
    }



    public boolean equals(Person person) {
        return name.equals(person.name) && occupation.equals(person.occupation) && age == person.age;
    }



    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", occupation='" + occupation + '\'' +
                ", age=" + age +
                '}';
    }




}
