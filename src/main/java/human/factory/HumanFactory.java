package human.factory;

import human.Human;
import java.util.ArrayList;
import java.util.Random;

public abstract class HumanFactory {
    ArrayList<String> maleName;
    ArrayList<String> femaleName;
    ArrayList<String> maleLastName;
    ArrayList<String> femaleLastName;
    ArrayList<String> maleFathersName;
    ArrayList<String> femaleFathersName;
    Random rand;

    public HumanFactory(ArrayList<String> maleName, ArrayList<String> femaleName, ArrayList<String> maleLastName,
                        ArrayList<String> femaleLastName, ArrayList<String> maleFathersName,
                        ArrayList<String> femaleFathersName) {
        this.maleName = maleName;
        this.femaleName = femaleName;
        this.maleLastName = new ArrayList<String>(maleLastName);
        this.femaleLastName = new ArrayList<String>(femaleLastName);
        this.maleFathersName = maleFathersName;
        this.femaleFathersName = femaleFathersName;
        this.rand = new Random();
    }

    private boolean femaleInit(Human human) {
        if (femaleLastName.size() == 0)
            return false;
        human.setMale(false);
        human.setName(femaleName.get(rand.nextInt(femaleName.size())));
        human.setLastName(femaleLastName.get(0));
        femaleLastName.remove(0);
        human.setFathersName(
                femaleFathersName.get(rand.nextInt(femaleFathersName.size())));
        return true;
    }

    protected boolean initHuman(Human human) {
        if (maleLastName.size() == 0) {
            return femaleInit(human);
        }
        human.setMale(true);
        human.setName(maleName.get(rand.nextInt(maleName.size())));
        human.setLastName(maleLastName.get(0));
        maleLastName.remove(0);
        human.setFathersName(
                maleFathersName.get(rand.nextInt(maleFathersName.size())));
        return true;
    }
    Human createHuman() { return null; }
}