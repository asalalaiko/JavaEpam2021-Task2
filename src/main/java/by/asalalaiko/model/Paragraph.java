package by.asalalaiko.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Paragraph implements PartText {
    private String value;
    private List<Suggestion> suggestions = new ArrayList<>();



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
        List<Suggestion> s = new ArrayList<>();

        Pattern pattern = Pattern.compile("([^.!?]+)");
        Matcher matcher = pattern.matcher(this.value);
        while (matcher.find()){

            Suggestion suggestion = new Suggestion();
            suggestion.setValue(matcher.group());
            s.add(suggestion);

        }
        this.suggestions = s;
    }

}
