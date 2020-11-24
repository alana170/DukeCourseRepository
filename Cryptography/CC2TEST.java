import java.io.*;
import java.lang.*;
import edu.duke.*;
import Cryptography.*;
/**
 * Write a description of CC2TEST here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CC2TEST {
public void simpleTESTS() {

    FileResource fr = new FileResource();
    String fileData = fr.asString();
      CC2 cc = new CC2(17,3);
    String encrypted = cc.encrypt(fileData);
        breakCaesarCipher(encrypted);
   
   


}
public void breakCaesarCipher(String message) {
    CaesarCipher1 c = new CaesarCipher1();
  int key1 = 0; int key2 = 0;
String s1 = c.halfOfString(message, 0);
    String s2 = c.halfOfString(message, 1);
   key1 = c.getKey(s1);
   key2 =c.getKey(s2); 
     System.out.println((26-key1)+" keys "+ (26-key2));
    String dmesg = c.encryptTwoKeys(message, key1, key2);
    System.out.println(dmesg);
    
    
}
}

