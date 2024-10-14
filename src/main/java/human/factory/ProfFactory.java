package human.factory;

import human.Human;
import human.Prof;
import java.util.ArrayList;

public class ProfFactory extends HumanFactory {
    public ProfFactory(ArrayList<String> maleName, ArrayList<String> femaleName,
                       ArrayList<String> maleLastName, ArrayList<String> femaleLastName,
                       ArrayList<String> maleFathersName, ArrayList<String> femaleFathersName) {
        super(maleName, femaleName, maleLastName, femaleLastName, maleFathersName, femaleFathersName);
    }

    @Override
    public Human createHuman() {
        Prof human = new Prof();
        if (initHuman(human))
            return human;
        return null;
    }
}