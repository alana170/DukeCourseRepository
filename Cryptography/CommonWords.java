package Cryptography;


/**
 * Count common words in Shakespeare's works
 * 
 * @author Duke Software Team
 * @version 1.0
 */
import edu.duke.*;

public class CommonWords
{
    public String[] getCommon(){
		FileResource resource = new FileResource("C:/Users/Alana Gorukanti/Desktop/BJProjects/Cryptography/data/common.txt");
		String[] common = new String[20];
		int index = 0;
		for(String s : resource.words()){
			common[index] = s;
			index += 1;
		}
		return common;
	}
	
	public int indexOf(String[] list, String word) {
	    for (int k=0; k<list.length; k++) {
	        if (list[k].equalsIgnoreCase(word)) {
	               return k;
	           }
	       }
	    return -1;
	}
	
	public int maxIndex(int[] a)
	{ int idx = 0;
	  int max = 0;
	  for (int i=0; i< a.length; i++){
	   if (a[i]>max){
	   max = a[i];
	   idx = i; 
	   }
	}
	return idx;
}
	public void countWords(FileResource resource, String[] common, int[] counts){
		for(String word : resource.words()){
			word = word.toLowerCase();
			int index = indexOf(common,word);
			if (index != -1) {
				counts[index] += 1;
			}
		}
	}
	public void countMaxLength()
	{
	    int[] counts = new int[30];
	    FileResource resource = new FileResource();
	    for(String word : resource.words()){  	
     int wordlength = word.length(); 
     if (Character.isLetter(word.charAt(word.length()-1)) == false) {
      wordlength--;
        }
     if (Character.isLetter(word.charAt(0)) == false) {
       wordlength--;
          }
     if (wordlength >= counts.length) {  	    	   
          wordlength = counts.length - 1;  	  	
     }  	
     if (wordlength > 0 ) {  	   	   
          counts[wordlength] ++;  	  	
     }
}
 int maxIdx = maxIndex(counts);
 System.out.println(maxIdx+ " is most repeated word length"); 
}
	   
	void countShakespeare(){
		//String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt",
			//          "likeit.txt", "macbeth.txt", "romeo.txt"};
	    String[] plays = {"romeo.txt"};
		String[] common = getCommon();
		int[] counts = new int[common.length];
		for(int k=0; k < plays.length; k++){
			FileResource resource = new FileResource();
			countWords(resource,common,counts);
			System.out.println("done with " + plays[k]);
		}
		
		for(int k=0; k < common.length; k++){
			System.out.println(common[k] + "\t" + counts[k]);
		}
	}
	
	
	
}
