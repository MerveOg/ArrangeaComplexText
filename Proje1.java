/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arrangecomplextext;

/**
 * @File name = ArrangeComplexText
 * @Description =
 * @Assignement = 1.Homework
 * @Date = 10/12/2021
 * @author = merve
 * @mail = merve.og@stu.fsm.edu.tr
 */
public class ArrangeComplexText {

    //mySplitFunction methodumda kullanacağım dividedWords arrayinin boyutunu belirlemek için bu methodu oluşturdum.
    public static int space(String text) {
        int spaceCounter = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaceCounter++;
            }
        }
        return spaceCounter;

    }

    public static String[] mySplitFunction(String text) {

        String word = "";
        String[] dividedWords = new String[space(text) + 1];

        int startIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '\n' || text.charAt(i) == ' ') {

                dividedWords[startIndex] = word;
                word = "";
                startIndex++;
            } else {
                word += text.charAt(i);
            }
        }
        return dividedWords;
    }

    public static String control(String[] wrongText, String[] dictionary) {
        String rightWord = "";
        
        for (int i = 0; i < wrongText.length; i++) {
            String word = wrongText[i];
            boolean isSucceed = false;
                for (int k = 0; k < dictionary.length; k++) {
                    if (word.equals(dictionary[k]) ) {
                        rightWord += word+" ";
                        isSucceed=true;
                        break;
                    }else{
                         for (int j = 0; j < word.length(); j++) {
              word=  rotateToRight(word, 1);
              if(word.equals(dictionary[k])){
                  rightWord+=word+" ";
                  isSucceed=true;
                  break;
              }
                    }

                }
                    if(isSucceed)
                        break;
            }
        }
        return rightWord;
    }

    public static String rotateToRight(String word, int a) {
        String arrangedWord = "";
        int counter = 0;
         //Kaydırma sayısı 0 ise word aynı kalacak.

            while (counter < a) {
                arrangedWord += word.charAt(word.length() - 1);

                for (int i = 0; i < word.length() - 1; i++) {
                    arrangedWord += word.charAt(i);

                }
                word = arrangedWord;
                arrangedWord = "";
                counter++;

            }
        
        return word;
    }

    public static void counter(String[] dictionary, String[] text) {

        int counter = 0;
        for (int i = 0; i < dictionary.length; i++) {
            for (int j = 0; j < text.length; j++) {
                if (dictionary[i].equals(text[j])) {
                                counter++;

                }
                
            }
                    System.out.print(counter + " ");
counter =0;
            
        }
    }
//Kelimeleri kendi arasında eşit mi değil mi diye kontrol ederken java büyük ve küçük harfe duyarlı
//olduğu için bu methodu oluşturdum . 

    public static String turnLowerCase(String text) {

        String newText = "";
        int difference = 'a' - 'A';// a'nın Ascıı tablosundaki değeri A'dan daha büyük. Yani fark pozitiftir.
        for (int i = 0; i < text.length(); i++) {
            if ((int) text.charAt(i) >= 65 && (int) text.charAt(i) <= 90) {
                newText += (char) (text.charAt(i) + difference);

            } else {
                newText += text.charAt(i);
            }
        }

        return newText;
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final String wrongText = "onteM Ne si a merfor health esortr and nedplan unitycomm in het sU atest fo rkansasA nope omfr 9011 to the d-1930smi It asw owned nda by liamWil eHop arveyH a ncialfina ttheoris dan riterw ni eth kOzar llshi fo the iteWh iverR leyval east of sRoger no the edge of averBe eLak woT of sit hotels Missouri Row nda maOklaho Row ewer eth estlarg log ngsbuildi in eth rldwo at the etim and aOklahom tower si neo fo het rliestea xamplese of a storymulti- ncreteco restructu The ortres was otn a alfinanci uccesss edu ni rtpa ot entmanagem ylest dan yshortl eraft ish thdea the typroper swa dsol ffo heT remainder fo het esortr and town asw stalmo ompletelyc mergedsub rafte erBeav Lake was atedcre in 1964 heT erelysev zedvandali Oklahoma wRo werto is het yonl emainingr ructurest atth anc eb seen at alnorm kela lsleve heT area on eth edge of averBe Lake llsti erredref ot sa Monte eN edown and gedmana by het tedUni States yArm orpsC of sEngineer esserv nlymai as a tboa ampr\n";
        final String dictionary = "1901 1964 arkansas army beaver corps engineers harvey harveys hope it lake missouri monte ne oklahoma ozark river rogers row rows states the two us united white william a after almost and area as at be boat buildings by can community completely concrete created death due earliest east edge examples financial former from health hills his hotels in is its lake largest levels log mainly managed management mid-1930s multi-story normal not of off on one only open operated owned part planned property ramp referred remainder remaining resort seen serves severely shortly sold state still structure style submerged success that the theorist time to tower town valley vandalized was were world writer\n";

     

        String[] returnWordsWrongText = mySplitFunction(turnLowerCase(wrongText));

       

        String[] returnWordsDictionary = mySplitFunction(turnLowerCase(dictionary));

       
        // TODO code application logic here
       
        String []returnTrueText=mySplitFunction(control(returnWordsWrongText, returnWordsDictionary));
        
        System.out.print("Kelime tekrarları : ");
       counter(returnWordsDictionary, returnTrueText);

        System.out.println("");
        System.out.println("Hedef Metin = "+control(returnWordsWrongText, returnWordsDictionary));
    }
}
