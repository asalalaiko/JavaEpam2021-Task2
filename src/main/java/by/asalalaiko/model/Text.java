package by.asalalaiko.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text implements PartText{
   private String value;
   private List<Paragraph> paragraphs = new ArrayList<>();
   //private List<Word> words = new ArrayList<>();


   

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

      List<Paragraph> p = new ArrayList<>();

      Pattern pattern = Pattern.compile("(\\t|^|\\n).+?(?=\\n|$)");
      Matcher matcher = pattern.matcher(this.value);
      while (matcher.find()){

         Paragraph paragraph = new Paragraph();
         paragraph.setValue(matcher.group());
         p.add(paragraph);

      }
      this.paragraphs = p;

   }


}
