import java.util.*;
import edu.duke.*;
import java.io.*;
public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        StringBuilder sb = new StringBuilder();
        
        for(int i =0 ;i<=message.length(); i=i+totalSlices){
        if(whichSlice+i+1 <  message.length())
        {
        String s = message.substring(whichSlice+i, whichSlice+i+1);
        sb.append(s);
         }
        }
        return sb.toString();
        
   
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        String[] slices = new String[klength];
         CaesarCracker cracker;
        for(int i=0; i<klength; i++){
            
        slices[i]= sliceString(encrypted, i, klength);
        cracker = new CaesarCracker(mostCommon);
        key[i] = cracker.getKey(slices[i]); //int 
        
    }
        
        return key;
    }
    public void getKeyFile(int KeyLength,char cm ){
    FileResource fr  = new FileResource();
    String a = fr.asString();
    int[] key = tryKeyLength(a,KeyLength, cm);
    for(int i = 0; i<key.length; i++){
    //System.out.println(key[i]);
    }

    }
    public void breakVigenere () {
        /**WRITE YOUR CODE HERE
        FileResource fr = new FileResource();
        String fileContent = fr.asString();**/
        HashSet<String> dictionary= readDictionary();
       // breakForLanguage(fileContent, dictionary);
        mostCommonCharIn(dictionary);
        
       // String d = vc.decrypt("Hhdiu LVXNEW uxh WKWVCEW, krg k wbbsqa si Mmwcjiqm");
       // System.out.println(d);
    }
    
    public void tester4(){
        FileResource fr = new FileResource();
        String fileContent = fr.asString();
        HashSet<String> dictionary= readDictionary();
        int[] keys = tryKeyLength(fileContent, 38, 'e');
        VigenereCipher vc = new VigenereCipher(keys);
        int count = countWords(vc.decrypt(fileContent), dictionary);
        System.out.println(count);
    }
    public HashSet<String> readDictionary() {
    HashSet<String> words = new HashSet<String>();
    FileResource fr = new FileResource();
    for (String s : fr.words()){
    s = s.toLowerCase();
    words.add(s);
    }
    return words;
    }
    public HashSet<String> NEWreadDictionary(File f ) {
    FileResource fr = new FileResource(f);
    HashSet<String> words = new HashSet<String>();
    
    for (String s : fr.words()){
    s = s.toLowerCase();
    words.add(s);
    }
    return words;
    }
    
    public int countWords(String message,HashSet<String> dictionary){
    int count = 0;
    String[] ewords  = message.toLowerCase().split("\\W+");
    for (int i = 0; i<ewords.length ; i++){
        if(dictionary.contains(ewords[i])){
        count++;
        }
    }
    
    return count;
    } 
    
    public void breakForLanguage(String encrypted, HashSet<String>dictionary){
    int maxVal = 0;
    int correctKeyL = 0 ;
    int [] keys; 
    
    
    for (int i = 1 ; i<=100 ; i++){
    keys = tryKeyLength(encrypted,i,'e');
    VigenereCipher vc = new VigenereCipher(keys);
    int a =countWords(vc.decrypt(encrypted), dictionary);
    if ( maxVal < a ) {
    maxVal = a;
    correctKeyL =  i;
    }
    }
    keys = tryKeyLength(encrypted, correctKeyL, 'e');
    // loop keys
    String s = "";
    String ks = "";
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for(int i = 0 ; i<keys.length; i++){
    ks = ks + ", " +  keys[i] ; 
    s = s + Character.toString(alphabet.charAt(keys[i]));
    }
    VigenereCipher vc = new VigenereCipher(keys);
    String decrypted = vc.decrypt(encrypted);
    System.out.println("Key Set: " + ks +" Key Word: "+ s) ;
    if (decrypted.length() < 100){
        System.out.println("Key Length = " + correctKeyL+  "   "  +maxVal + " : " +  vc.decrypt(encrypted));
    }
    else 
     System.out.println("Key Length = " + correctKeyL+  "   "  +maxVal + " : " +  vc.decrypt(encrypted).substring(0,99));
    
    }
     public void breakForLanguage2(String encrypted, HashSet<String>dictionary, char mostCommon){
    int maxVal = 0;
    int correctKeyL = 0 ;
    int [] keys; 
    
    
    for (int i = 1 ; i<=100 ; i++){
    keys = tryKeyLength(encrypted,i,mostCommon);
    VigenereCipher vc = new VigenereCipher(keys);
    int a =countWords(vc.decrypt(encrypted), dictionary);
    if ( maxVal < a ) {
    maxVal = a;
    correctKeyL =  i;
    }
    }
    keys = tryKeyLength(encrypted, correctKeyL, mostCommon);
    // loop keys
    String s = "";
    String ks = "";
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for(int i = 0 ; i<keys.length; i++){
    ks = ks + ", " +  keys[i] ; 
    s = s + Character.toString(alphabet.charAt(keys[i]));
    }
    VigenereCipher vc = new VigenereCipher(keys);
    String decrypted = vc.decrypt(encrypted);
    System.out.println("Key Set: " + ks +" Key Word: "+ s) ;
    if (decrypted.length() < 100){
        System.out.println("Key Length = " + correctKeyL+  "   "  +maxVal + " : " +  vc.decrypt(encrypted));
    }
    else 
     System.out.println("Key Length = " + correctKeyL+  "   "  +maxVal + " : " +  vc.decrypt(encrypted).substring(0,99));
    
    }
    public char mostCommonCharIn(HashSet<String> dictionary){
    HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
    //dictionary = new HashSet<String>();
    for (String words: dictionary) {
    // process each item in turn
    words = words.toLowerCase();
    //System.out.println(words);
    for (char a : words.toCharArray())
    { 
    if(!charCount.containsKey(a)){
        charCount.put(a,1);
    }
    else{
      charCount.put(a,charCount.get(a) +1);
    }
    }
    
     }
     
     int  max = 0;
     char maxChar = ' ';
    for (Character b: charCount.keySet()){
    int i = charCount.get(b); //value 
    if(max<i){
    max= i;
    maxChar = b;
    }
    }
    System.out.println("Max Char = " + maxChar+ " It has a count of "+max);
    return maxChar;
   }
   public void breakForAllLangs(String encrypted,HashMap<String,HashSet<String>> lang){
       for(String dictionary  : lang.keySet()){
       char common = mostCommonCharIn(lang.get(dictionary));
       System.out.println("Selected Language is " + dictionary);
       
       breakForLanguage2(encrypted, lang.get(dictionary), common);
       System.out.println("------------------------------------------------------------------------------");
    }
      
    }
   public void TESTER() {
    DirectoryResource dr = new DirectoryResource();
    HashMap<String, HashSet<String>> hm= new HashMap<String, HashSet<String>>();
    //String decrypted = "";
    for (File f : dr.selectedFiles()){
        String filename = f.getName();
        System.out.println(filename);
      HashSet <String> dictionary = NEWreadDictionary(f);
      hm.put(filename, dictionary);
    }
    FileResource f = new FileResource();
    String encrypt = f.asString();//content
    breakForAllLangs(encrypt, hm);
    
    }
}

