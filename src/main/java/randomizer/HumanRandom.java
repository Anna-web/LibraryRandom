package randomizer;

import excel.Excel;
import human.Human;
import human.factory.ProfFactory;
import human.factory.StudentFactory;
import java.util.ArrayList;

public class HumanRandom {
    ProfFactory profFactory;
    StudentFactory studentFactory;

    public HumanRandom(Excel excel) {
        this.profFactory = new ProfFactory(
                excel.getMaleNameList(), excel.getFemaleNameList(),
                excel.getMaleProfLastNameList(), excel.getFemaleProfLastNameList(),
                excel.getMaleFathersName(), excel.getFemaleFathersName());
        this.studentFactory = new StudentFactory(
                excel.getMaleNameList(), excel.getFemaleNameList(),
                excel.getMaleStudentLastNameList(),
                excel.getFemaleStudentLastNameList(), excel.getMaleFathersName(),
                excel.getFemaleFathersName());
    }

    public ArrayList<Human> generateHumanList() {
        ArrayList<Human> list = new ArrayList<Human>();
        Human human = this.profFactory.createHuman();
        while (human != null) {
            list.add(human);
            human = this.profFactory.createHuman();
        }
        human = this.studentFactory.createHuman();
        while (human != null) {
            list.add(human);
            human = this.studentFactory.createHuman();
        }
        return list;
    }
}