package books.factory;

import com.github.javafaker.Faker;
import books.EnglishFiction;
import books.EnglishTextbook;
import books.interfaces.Fiction;
import books.interfaces.Textbook;
import java.util.ArrayList;
import java.util.Arrays;

public class EnglishBook implements BookFactory {
    private int textIter;
    private ArrayList<String> names;
    private ArrayList<String> lastNames;
    private ArrayList<String> authors;
    private ArrayList<String> university;
    private ArrayList<String> levels;
    private Faker faker;

    public EnglishBook() {
        this.textIter = 0;
        this.names = new ArrayList<String>(Arrays.asList(
                "Operating system", "AI", "Foundations of Analytics: Data", "HTML and CSS", "Clean Code"));
        this.university = new ArrayList<String>(
                Arrays.asList("Oxford University", "Peking University",
                        "University of Hong Kong", "University of Toronto", "Kyoto University"));
        this.authors = new ArrayList<String>(
                Arrays.asList("Kevin P. Murphy", "Kevin Behr", "George Spafford",
                        "Gene Kim", "Narasimha Karumanchi "));
        this.lastNames = new ArrayList<String>(
                Arrays.asList("(beginner)", "(intermediate)", "(advanced)"));
        this.levels =
                new ArrayList<String>(Arrays.asList("bachelor", "magistracy"));
        faker = new Faker();
    }

    @Override
    public Textbook createTextbook() {
        if (textIter / 3 == names.size())
            return null;
        String name = new String("\"");
        name = name.concat(names.get(textIter / 3)).concat(" ");
        name = name.concat(lastNames.get(textIter % 3)).concat("\"");
        String level = new String(textIter % 3 == 2 ? levels.get(1) : levels.get(0));
        textIter++;
        return new EnglishTextbook(name, university.get((textIter - 1) / 3),
                authors.get((textIter - 1) / 3), level);
    }

    @Override
    public Fiction createFiction() {
        return new EnglishFiction(faker.book().title());
    }
}
