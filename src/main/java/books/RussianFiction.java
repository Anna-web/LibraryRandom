package books;

import books.interfaces.Fiction;

public class RussianFiction implements Fiction {
    private String name;
    public RussianFiction(String name) { this.name = name; }

    @Override
    public String getInfo() {
        return new String(name);
    }
}