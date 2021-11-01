package by.asalalaiko.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Suggestion implements PartText{
    private String value;
    public List<Word> words = new ArrayList<>();


    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public void setValue(String value) {
        this.value=value;
        this.parsing();
    }

    @Override
    public void parsing() {
        List<Word> w = new ArrayList<>();

        Pattern pattern = Pattern.compile("(\\p{N}|\\p{L}).+?(?=\\n|$|\\s|\\.|\\!|\\,|\\&)");
        Matcher matcher = pattern.matcher(this.value);
        while (matcher.find()){

            Word word = new Word();
            word.setValue(matcher.group());
            w.add(word);

        }
        this.words = w;
    }

    @Override
    public void parsingWordsByCharAndSort(String ch) {

    }


}
