package Cryptography;
import java.lang.*;
import java.io.*;
import edu.duke.*;

/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
public boolean isVowel(char s){
boolean tf = false;

if ((s =='a')||(s == 'e')||(s =='i')||(s == 'o')||(s == 'u')||(s =='A')||(s == 'E')||(s =='I')||(s == 'O')||(s == 'U')) 
{
   tf = true;
}
else{tf = false;}
return tf;
}
public void TestIsVowel(){
   System.out.println(isVowel('F')); //f
   System.out.println(isVowel('a')); //t
   System.out.println(isVowel('E')); //t
   System.out.println(isVowel('b')); //f
   System.out.println(isVowel('U')); //t
}
public String replaceVowels(String phrase, char ch) {
//every time phrase's character IsVowel method= true replace by ch
String NewPhrase = "";
char[] s = phrase.toCharArray();
for (int x =0; x < s.length ; x++){
    
if (isVowel(s[x])==true){
  NewPhrase = phrase.replace(s[x], ch); 
  System.out.println(NewPhrase + " , " + phrase);
  phrase = NewPhrase;
}
}
 return NewPhrase;
}
public String emphasize(String phrase, char ch){
 // if even index +
 // if odd index *
 // ch == letter we want to replace
char t = Character.toUpperCase(ch);
String NewPhrase = "";
char[] s = phrase.toCharArray();
for (int x =0; x < s.length ; x++){
 char a = Character.toUpperCase(s[x]);
if (a==t){
  if ((x+1)%2==0) //even 
  {
      System.out.println(x);
        s[x] = '+'; 
    }
  else { s[x] = '*';  }
}
}
 NewPhrase = String.valueOf(s);
 return NewPhrase;
    


}

 public void test(){
    
    String t = "Alana Gorukanti apple";
    System.out.println(t.replace('a','1'));
    
}

}

