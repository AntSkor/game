package game;

import java.util.*;
import java.util.Random;

public class MixedWord{
    private String word;
    private List<String> words = new ArrayList<>();
    private Random rand = new Random();

    public MixedWord(){
        words.add("каша");
        words.add("гриб");
        words.add("опушка");
        words.add("мера");
        words.add("кусок");
        words.add("пятка");
        words.add("дождь");
        words.add("пила");
        words.add("билет");
        words.add("стужа");
        words.add("нота");
        words.add("бомба");
        words.add("литр");
        words.add("клоп");
        words.add("щука");
    }

    public void getRandom() {
        int size = words.size();
        int randomword = rand.nextInt(size);
        word = words.remove(randomword);
    }

    public String mixWord() {
        List <Character> chars = new ArrayList<>();
        StringBuilder sbuilder = new StringBuilder();
        for (char c : word.toCharArray()) {
            chars.add(c);
        }
        while (chars.isEmpty() == false) {
            int i = rand.nextInt(chars.size());
            sbuilder.append(chars.remove(i));
        }
        return sbuilder.toString();
    }

    public String getWord(){
        return word;
    }
    public boolean wordsIsEmpty(){
        return words.isEmpty();
    }
}


