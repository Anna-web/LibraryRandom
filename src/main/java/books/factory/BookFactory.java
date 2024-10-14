package books.factory;

import books.interfaces.Fiction;
import books.interfaces.Textbook;

public interface BookFactory {
    Textbook createTextbook();
    Fiction createFiction();
}
