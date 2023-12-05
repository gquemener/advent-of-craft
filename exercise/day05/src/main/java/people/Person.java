package people;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public record Person(String firstName, String lastName, List<Pet> pets) {
    public Person(String firstName, String lastName) {
        this(firstName, lastName, new ArrayList<>());
    }

    public Person addPet(PetType petType, String name, int age) {
        pets.add(new Pet(petType, name, age));
        return this;
    }

    public String fullName() {
        return format("%s %s", firstName, lastName);
    }
}
