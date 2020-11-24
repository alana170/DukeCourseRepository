package Cryptography;

import edu.duke.*;
import java.io.*;
import java.lang.*;
public class CaesarCipher1 {
    
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        //input = input.toUpperCase();
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    public char encrypt(char input, int key) {
        //Make a StringBuilder with message (encrypted)
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //jKLMNOPQRSTUVWXYZABCDeFGHI
        if(Character.isLowerCase(input))
          alphabet = alphabet.toLowerCase();
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
           int idx = alphabet.indexOf(input);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                return newChar;
                //Replace the ith character of encrypted with newChar
                
            }
            //Otherwise: do nothing
            return input;
        
    }
    public void testCaesar(int key) {
        FileResource fr = new FileResource();
        char[] message = fr.asString().toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<message.length; i++)
        {
            sb.append(encrypt(message[i], key));
        }
        String encrypted = sb.toString();
        System.out.println(encrypted);
        message = encrypted.toCharArray();
        
        StringBuilder decrypt = new StringBuilder();
        for(int i = 0; i<message.length; i++)
        {
            decrypt.append(encrypt(message[i], 26-key));
        }
        //String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypt.toString());
    }
    public String encryptTwoKeys(String input, int key1,int key2){
    String encrypted = "";
    char[] s = input.toCharArray();
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<s.length; i++)
{
    
    if((i+1)%2 == 0) // key2
    {
       
       sb.append(encrypt(s[i], key2));
       
       
    }
    else //odd use key 1 
    {
        sb.append(encrypt(s[i], key1));
    }
}
   //System.out.println(sb.toString());
 return sb.toString();
}
public void decryptTwoKeys (int key1, int key2) {
StringBuilder decrypt = new StringBuilder();
 FileResource fr = new FileResource(); // encrypted message.
 String message = fr.asString();
 String a = encryptTwoKeys(message,26-key1,26-key2);
 System.out.println(a);
}
public String halfOfString(String message, int start){
// 1) start index +2 till length is < 2
StringBuilder sb = new StringBuilder();
for (int k = start; k<message.length();k=k+2){
sb.append(message.charAt(k));
}
//System.out.println(sb.toString());
return sb.toString();
}
public String maxAlpha(String input){
               CommonWords cw = new CommonWords();
           int[] counts = new int [26] ; 
               String[] abc = new String[] { "A", "B", "C", "D", "E", 
                "F", "G", "H", "I", "J", "K","L", "M", "N", "O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		for(int i=0; i<input.length(); i++){
			char s = input.charAt(i);
			int index = cw.indexOf(abc,Character.toString(s));
			if (index != -1) {
				counts[index] += 1;
			}
		}
	
		// done counting all letters. 
		int maxIdx =cw.maxIndex(counts);
	        
		System.out.println( "Letter with most is: " + abc[maxIdx] +"       "+"Max Index = " + maxIdx + "  ; " + counts[maxIdx]);
		return abc[maxIdx];
	}


public int getKey(String s){
    
   String mc = maxAlpha(s);
   char c = mc.charAt(0);
   for(int i= 1; i<=26; i++)
   {
       char a  = encrypt(c, i);
       if ((a == 'e')||(a=='E')){
       System.out.println("MY Possible decrypt key value : "  + i);
       return i;
    }
    }
return -1;
}
public void getMysteryFile2Keys()
{
    int key1 = 0; int key2 = 0;
    
    FileResource fr = new FileResource(); // encrypted message.
    String message = fr.asString();
    String s1 = halfOfString(message, 0);
    String s2 = halfOfString(message, 1);
    key1 = getKey(s1);
    key2 = getKey(s2); 
     System.out.println((26-key1)+" keys "+ (26-key2));
    String dmesg = encryptTwoKeys(message, key1, key2);
    System.out.println(dmesg);
    
    
    
    
}
}
