package books;

import books.interfaces.Textbook;

public class EnglishTextbook implements Textbook {
    private String name;
    private String university;
    private String author;
    private String level;
    public EnglishTextbook(String name, String university, String author, String level) {
        this.name = name;
        this.university = university;
        this.author = author;
        this.level = level;
    }

    @Override
    public String getInfo() {
        String out = new String(name + "; " + university + "; " + author + "; " + level);
        return out;
    }
}