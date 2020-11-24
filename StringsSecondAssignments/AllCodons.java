/**
 * DNA code finding gene 3 stop codons
 * 
 * @Alana
 * @12.17.18
 */
import edu.duke.*;
import java.lang.*;
public class AllCodons {
public int findStopCodon(String dnaStr, int startIndex, String stopCodon){
int currIndex = dnaStr.indexOf(stopCodon, startIndex+3);
while(currIndex != -1) {
   // System.out.println("currIndex"+ currIndex);
int diff= currIndex-startIndex;
if (diff % 3 ==0) {
    return currIndex;
}
else{
    currIndex = dnaStr.indexOf(stopCodon,currIndex+1);
}
}
return dnaStr.length();
}


public String findGene(String dna, int where) {
int startIndex = dna.indexOf("ATG", where);
if (startIndex==-1){
return "";
}
int taaIndex = findStopCodon(dna,startIndex,"TAA");
int tagIndex = findStopCodon(dna,startIndex,"TAG");
int tgaIndex = findStopCodon(dna,startIndex,"TGA");
int temp = Math.min(taaIndex,tagIndex);
int minIndex = Math.min(temp, tgaIndex);
if ((minIndex == dna.length()) || (minIndex==-1)) {
return "";
}   
if (taaIndex == -1 || (tgaIndex != -1
&& tgaIndex < taaIndex)) {
    minIndex= tgaIndex;
}
else {
    minIndex = taaIndex;
}
if (minIndex == -1 || (tagIndex != -1
&& tagIndex < minIndex)) {
    minIndex= tagIndex;
}

return dna.substring(startIndex,minIndex + 3);
}

public void testOn(String dna) {
System.out.println("Testing printAllGenes on " + dna);
printAllGenes(dna);
}

public void test() {
//      ATG^  ^      ^START       ^STOP
testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
//testOn("");
//testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
}

public void testFindStop() {
String dna ="xxxyyyzzzTAAxxxyyyzzzTAAxx";
int dex = findStopCodon(dna,0,"TAA");
//System.out.println("Finished step 1. Dex ="+ dex);
if (dex !=9) 
System.out.println("error on 9");
dex = findStopCodon(dna,9,"TAA");
//System.out.println("Finished step 2. Dex ="+ dex); 
if (dex !=21) 
System.out.println("error on 21");
dex = findStopCodon(dna,1,"TAA"); 
//System.out.println("Finished step 3. Dex ="+ dex);
if (dex !=26) 
System.out.println("error on 26");
dex = findStopCodon(dna,0,"TAG"); 
System.out.println("tests finished");
}

public void printAllGenes(String dna){
int startIndex = 0;
while (true) {
String currentGene = findGene(dna, startIndex);
if (currentGene.isEmpty()){
 break;
}
System.out.println(currentGene);
startIndex = dna.indexOf(currentGene, 
startIndex) + currentGene.length();
}

}
 public void howMany(String stringa, String stringb) {
   //stringa string you want to find
   //stringb total string  
   int currIndex = 0;
   int startIndex = 0;
   int count = 0;
   currIndex = stringb.indexOf(stringa);
   while(currIndex != -1)
   {
       count++; 
       startIndex = currIndex + stringa.length();
       //System.out.println("SI: " + startIndex);
       currIndex = stringb.indexOf(stringa, startIndex);
    }
   
  System.out.println("How many= "+ count);
    }
    
 public void TestHowMany() {
     FileResource ur = new FileResource();
     String contents = ur.asString();
     howMany("CTG", contents);

    }
    
 public void HowManyGenes()
 {
     //Read file
     FileResource fr = new FileResource();
     String contents = fr.asString();
     int count = 0;
     int counter = 0;
     int startIndex = 0;
     while (true) {
         System.out.println("count: " + count);
         count++;
         String currentGene = findGene(contents, startIndex);
      if (currentGene.isEmpty()){
          break;
}
    System.out.println(currentGene);
    
    System.out.println("after count: " + count);
    startIndex = contents.indexOf(currentGene, 
    startIndex) + currentGene.length();

if (currentGene.length()>60) {
    counter++;

}

     }
    
    System.out.println("Number of genes in file is "+ count);
   System.out.println("Genes > 60 = " + counter);
    
   
}

 public void cgGenes()
 {
     //Read file
     FileResource ur = new FileResource();
     String contents = ur.asString();
     System.out.println(contents);
     int count = 0;
     int counter = 0;
     int startIndex = 0;
     int cgc = 0;
     double cg;
     while (true) {
         System.out.println("count: " + count);
         
         String currentGene = findGene(contents, startIndex);
      if (currentGene.isEmpty()){
          break;}
          count++; 
       
          if  (CGRatio(currentGene)>0.35) {
     
              cgc++;
              System.out.println("Test1passed");
        }
          
  //  System.out.println(currentGene);
    
    //System.out.println("after count: " + count);
    startIndex = contents.indexOf(currentGene, 
    startIndex) + currentGene.length();

if (currentGene.length()>60) {
    counter++;

}

     }
    
    System.out.println("Number of genes in file is "+ count);
   System.out.println("Genes > 60 = " + counter);
   System.out.println("CG Ratio greater than 0.35 = " + cgc);
   
}
public double CGRatio(String dnacode) {
 
 //URLResource ur = new URLResource("http://www.cs.duke.edu/~rodger/GRch38dnapart.fa");
 //dnacode = ur.asString();
 int ccount= 0;
 int gcount = 0;
for (int i = 0; i<dnacode.length(); i++)
{
if ((dnacode.charAt(i)=='c') || (dnacode.charAt(i)=='C')){
ccount++;
}
if ((dnacode.charAt(i)=='g') || (dnacode.charAt(i)=='G')){
gcount++;
}

}
int total = ccount+gcount;
double answer = (float)total/dnacode.length();
return answer;
}

public void LongestGene() {
FileResource ur = new FileResource(); //create file resource
String dna = ur.asString(); //convert to String
int maxLength = 0; //intializing 2 varibles 0
int startIndex = 0;

while (true) {
String currentGene = findGene(dna, startIndex);
if (currentGene.isEmpty()){
 break;
}
//System.out.println(currentGene);
startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
if (currentGene.length() > maxLength) {
maxLength= currentGene.length();
}

}
System.out.println("The Longest Gene Length = " + maxLength);
}
}




