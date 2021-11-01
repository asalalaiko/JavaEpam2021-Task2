package by.asalalaiko.model;

import java.util.ArrayList;
import java.util.List;

public class Word implements PartText{
    private String value;
    private List<Symbol> symbols = new ArrayList<>();


    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public void setValue(String value) {
        this.value=value;
    }

    @Override
    public void parsing() {

    }

    @Override
    public void parsingWordsAndSortByChar(String ch) {

    }
}
