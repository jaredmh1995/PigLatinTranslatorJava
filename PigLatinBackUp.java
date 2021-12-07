/*
Name: Jared Hazel
Class: CS210
Date: 11/3/2019
Purpose: the purpose of this code is to translate English text files into pig latin.
*/
import java.io.*;
import java.util.*;

public class PigLatinTranslator{
   public static void main(String[] args)
         throws FileNotFoundException {
      //Allows user to enter in file name   
      Scanner console = new Scanner (System.in);
      //Prompts user to enter in name and puts the name into a string 
      //Decieded to not have user enter in .txt because the less information needed to run the better user experience 
      System.out.print("Please enter name of file without .txt/ everything before .txt: ");
      String a=console.next();
      //Scanner object is created to look for 
      Scanner input = new Scanner(new File(a+".txt"));
      PrintStream output = 
         new PrintStream(new File(a+"-PL.txt"));
      //Calls pigLatin method and Scanner and the PrintStream objects   
      pigLatin(input, output);
   }

   public static void pigLatin(Scanner text, PrintStream output){
   
    String word="";
   
    while(text.hasNextLine()){
    //Breaks down each line from txt file into newLine and help preserves line breaks from original text file
    Scanner newLine = new Scanner(text.nextLine());
    //Puts word from line into 'word' string
    word=newLine.next();
      //Two while loops are used to capture the last word. If one was used, it would not capture/ use the last word    
      while(newLine.hasNext()){
         while(newLine.hasNext()){
            //'word' is sent to returnWord method to translate/ configure word to pig latin
            //returnWord method was used due to logic being used twice
            word=returnWord(word);
            //Adds the word to the PrintStream/ new text file with a space
            output.print(word+" ");
            //Moves onto the next word
            word=newLine.next();
         }
        //'word' is sent to returnWord method to translate/ configure word to pig latin
        //returnWord method was used due to logic being used twice     
        word=returnWord(word);
        //Adds the word to the PrintStream/ new text file without a space because this is the last word of the line
        output.print(word);
        //Starts new line  
        output.println();
      
      }
    }
   }
   
   public static String returnWord(String word){
    //Inaltize variables to be used in method
    String t="";
    //String v="";
    int wordLength=word.length();
    //Removes punctuations from word and makes everything lowercase    
    word=word.toLowerCase();
    word=word.replace(".","");
    word=word.replace(",","");
    word=word.replace("?","");
    word=word.replace("!","");
    //Figures out what the first letter in the word is
    char letter = word.charAt(0);
    t=String.valueOf(letter);
    wordLength=word.length();
    //Strings used when the first letter is not a vowel
    String constantWord = "";
    String constantWord2="";
     //If statements are used to determine is first letter is a vowel
     //if thats true, the "way" is added to the end       
    if (t.equals("a")){
      word=word+"way";
    }
    else if (t.equals("e")){
       word=word+"way";
    }
    else if (t.equals("i")){
        word=word+"way";
    }
    else if (t.equals("o")){
        word=word+"way";
    }
    else if (t.equals("u")){
        word=word+"way";
    }
    else{
      //The two integers are used for the two lopps below
      int num=0;
      int num2=0;
      //While loop figures out where the first vowel is in a word
      //Prints all letters before the first vowel to constantWord
      //For example, trust, constantWord would be 'tr'
      while(num<wordLength){
       char nextLetter = word.charAt(num);
       String s=String.valueOf(nextLetter);
       if( !(s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u"))){
         constantWord=constantWord+s;
         num++;
       }
       else{
         //num2 is used to pick up where the while loop left off at
         num2=num;
         num=100;
       }
      }
      //For loop prints all letters till the end with the first vowel as the starting point to constantWord2
      //For example, trust, constantWord2 would be 'ust'
      for(int i=num2; wordLength>i;i++){
       char nextLetter = word.charAt(i);
       String s=String.valueOf(nextLetter);
       constantWord2=constantWord2+s;
      }
      //Combines constantWord2 and constantWord with the added "ay" at the end
      //For example, trust becomes usttray
      word=constantWord2+constantWord+"ay";
     }    
     //Returns the translated word
    return word;
   }
}