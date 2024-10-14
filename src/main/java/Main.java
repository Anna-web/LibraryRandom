import books.interfaces.Available;
import excel.Excel;
import randomizer.BookRandom;
import randomizer.HumanRandom;
import gui.GUI;
import human.Human;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Excel test = new Excel("input/input.xlsx");
        HumanRandom gen = new HumanRandom(test);
        ArrayList<Human> list = gen.generateHumanList();
        BookRandom genBook = new BookRandom();
        ArrayList<Available> listBook = genBook.generateBookList();
        GUI gui = new GUI("App", list, listBook);
        gui.setVisible(true);
        gui.setSize(500,700);
    }
}