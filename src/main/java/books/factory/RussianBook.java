package books.factory;

import com.github.javafaker.Faker;
import books.RussianFiction;
import books.RussianTextbook;
import books.interfaces.Fiction;
import books.interfaces.Textbook;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class RussianBook implements BookFactory {
    private int textIter;
    private ArrayList<String> prevNames;
    private ArrayList<String> lastNames;
    private ArrayList<String> names;
    private Faker faker;

    public RussianBook() {
        this.textIter = 0;
        this.names = new ArrayList<String>(
                Arrays.asList("Алгоритмы", "Компьютерные сети", "Компьютерная графика", "Криптография",
                        "Программирование", "Наука о данных", "Биоинформатика", "Робототехника", "Базы данных"));
        this.prevNames = new ArrayList<String>(Arrays.asList("Учебник", "Пособие"));
        this.lastNames = new ArrayList<String>(Arrays.asList(
                "для начинащих", "базовый уровень", "продвинутый уровень"));
        this.faker = new Faker(new Locale("ru"));
    }

    @Override
    public Textbook createTextbook() {
        if (textIter / (lastNames.size() * prevNames.size()) == names.size())
            return null;
        String name = new String();
        name = name.concat(prevNames.get(textIter % 2)).concat(" \"");
        name = name.concat(names.get((textIter / 3) % names.size())).concat(" ");
        name = name.concat(lastNames.get(textIter % 3)).concat("\"");
        textIter++;
        return new RussianTextbook(name);
    }

    @Override
    public Fiction createFiction() {
        return new RussianFiction(faker.address().cityName() + " и " +
                faker.address().firstName());
    }
}
