import java.lang.*;
import edu.duke.*;
import java.io.*;
import Cryptography.*;
/**
 * Write a description of TESTCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TESTCaesarCipher {

    public void SimpleTests(){
    FileResource fr = new FileResource();
    String fileData = fr.asString();
   CaesarCipher cc = new CaesarCipher(18);
   String encrypted = cc.encrypt(fileData);
   breakCaesarCipher(encrypted);
   
   //String decrypted = cc.decrypt(encrypted);
   


}
public void breakCaesarCipher(String input) {
CaesarCipher1 cc = new CaesarCipher1();
int key = cc.getKey(input);
//System.out.println(cc.encrypt(input, 26-key));
CaesarCipher hi = new CaesarCipher(26-key);
String d = hi.decrypt(input);

}
}
