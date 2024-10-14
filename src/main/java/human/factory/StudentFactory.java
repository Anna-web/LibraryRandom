package human.factory;

import human.Human;
import human.Student;
import java.util.ArrayList;

public class StudentFactory extends HumanFactory {
    public StudentFactory(ArrayList<String> maleName,
                               ArrayList<String> femaleName,
                               ArrayList<String> maleLastName,
                               ArrayList<String> femaleLastName,
                               ArrayList<String> maleFathersName,
                               ArrayList<String> femaleFathersName) {
        super(maleName, femaleName, maleLastName, femaleLastName, maleFathersName,
                femaleFathersName);
    }

    @Override
    public Human createHuman() {
        Student human = new Student();
        if (initHuman(human))
            return human;
        return null;
    }
}