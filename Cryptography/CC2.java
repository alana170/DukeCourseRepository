import Cryptography.*;

/**
 * Write a description of CC2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CC2 {
 private String alphabet;
 private String shiftedAlphabet1;
 private String shiftedAlphabet2;
 private int k1; private int k2;
 
 public CC2(int key1, int key2) {
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
    shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
    k1 = key1;
    k2 = key2;
    
    } 
 public String encrypt(String input){
    CaesarCipher1 cw = new CaesarCipher1();
    String e = cw.encryptTwoKeys(input, k1, k2);
 System.out.println(e);
 return e; 
}
 public String decrypt(String input){
    CaesarCipher1 cw = new CaesarCipher1();
    String e = cw.encryptTwoKeys(input,26-k1, 26-k2);
 System.out.println(e);
 return e; 
}
}
