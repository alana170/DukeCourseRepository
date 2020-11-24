
/**
 * Write a description of CaesarCipher here.
 * 
 * @GOrukanti, ALana.
 * 
 * @version (a version number or a date)
 */
public class CaesarCipher {
 private String alphabetU;
 private String shiftedAlphabetU;
 private String alphabetL;
 private String shiftedAlphabetL;
 private  int mainKey;
 public CaesarCipher(int key){
     alphabetU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
     shiftedAlphabetU = alphabetU.substring(key) + alphabetU.substring(0,key);
     alphabetL = alphabetU.toLowerCase();
     shiftedAlphabetL = alphabetL.substring(key) + alphabetL.substring(0,key);
     mainKey = key;
}
public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabetL.indexOf(currChar);
            if(idx == -1)
            {
                idx = alphabetU.indexOf(currChar);
                if(idx != -1)
                {
                    char newChar = shiftedAlphabetU.charAt(idx);
                //Replace the ith character of encrypted with newChar
                   encrypted.setCharAt(i, newChar);
                }
            }
            //If currChar is in the alphabet
            else if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabetL.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        System.out.println(encrypted.toString());
        return encrypted.toString();
    }
public String decrypt(String input){
CaesarCipher cc = new CaesarCipher(26 - mainKey);
cc.encrypt(input);

return input;
}
}