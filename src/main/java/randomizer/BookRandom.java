package randomizer;

import books.factory.EnglishBook;
import books.factory.RussianBook;
import books.interfaces.Available;
import java.util.ArrayList;

public class BookRandom {
    private static int num = 50;
    private EnglishBook en;
    private RussianBook ru;

    public BookRandom() {
        this.en = new EnglishBook();
        this.ru = new RussianBook();
    }

    public ArrayList<Available> generateBookList() {
        ArrayList<Available> list = new ArrayList<Available>();
        Available book;

        book = en.createTextbook();
        while (book != null) {
            list.add(book);
            book = en.createTextbook();
        }

        book = ru.createTextbook();
        while (book != null) {
            list.add(book);
            book = ru.createTextbook();
        }
        return list;
    }
}