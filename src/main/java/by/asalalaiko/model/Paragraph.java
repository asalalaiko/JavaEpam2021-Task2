package by.asalalaiko.model;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Paragraph implements PartText {
    private String value;
    public List<Suggestion> suggestions = new ArrayList<>();



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

    @Override
    public void parsingWordsByCharAndSort(String ch) {
        List<Word> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\p{N}|\\p{L}).+?(?=\\n|$|\\s|\\.|\\!|\\,|\\&)");
        Matcher matcher = pattern.matcher(this.value);
        while (matcher.find()) {

            Word word = new Word();
            word.setValue(matcher.group().strip());
            words.add(word);
        }



        HashMap<String, Integer> wordMap = new HashMap<>();

        for (Word w : words) {
            int i = match(ch, w.getValue());
            if(i>0)  wordMap.put(w.getValue(),i);


        }
        sortByValue(wordMap).stream().distinct().forEach(System.out::println);
    }

    private int match(String ch, String value) {
        Matcher m = Pattern.compile(ch.toLowerCase()).matcher(value.toLowerCase());
        int count = 0;

        while (m.find()) {
            count++;
        }
        return count;
    }


    private static ArrayList<String> sortByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));
        Collections.reverse(list);
        ArrayList<String> result = new ArrayList<>();

        list.sort((o1, o2) -> ((o1.getValue().equals(o2.getValue())) ?
                (o1.getKey().compareTo(o2.getKey())) : (0)));

        for (Map.Entry<String, Integer> entry : list) {
            result.add(entry.getKey());
        }

        return result;
    }


}
