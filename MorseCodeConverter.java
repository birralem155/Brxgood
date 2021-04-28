import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class MorseCodeConverter {

    private static MorseCodeTree t = new MorseCodeTree();


    public MorseCodeConverter() {

    }

    /**
     * * returns a string with all the data in the tree in LNR order with an space in between them.
     *
     * @return the data in the tree in LNR order separated by a space.
     */
    public static String printTree() {
        ArrayList<String> treeData;

        treeData = t.toArrayList();

        String print = "";

        for (int i = 0; i < treeData.size(); i++) {
            print += treeData.get(i) + " ";
        }

        return print;
    }


    /**
     * Converts a file of Morse code into English each letter is delimited by space (''). Each word id delimited by a '/'.
     *
     * @param code - the morse code
     * @return the English translation
     */
    public static String convertToEnglish(String code) {
        String[] word;
        word = code.split(" / ");

        String outPut = "";
        for (int i = 0; i < word.length; i++) {
            String[] letter = word[i].split(" ");

            for (int j = 0; j < letter.length; j++) {

                outPut += t.fetch(letter[j]);
            }

            outPut = outPut + " ";
        }

        outPut = outPut.trim();

        return outPut;
    }


    /**
     * Converts Morse code into English.
     *
     * @param codefile name of the File that contains Morse Code
     * @return the English translation of the file
     * @throws java.io.FileNotFoundException
     */
    public static String convertToEnglish(File codeFile) throws FileNotFoundException {
        String output = "";
        ArrayList<String> line = new ArrayList<>();
        String[] word;

        Scanner inputFile;
        inputFile = new Scanner(codeFile);

        while (inputFile.hasNext()) {
            line.add(inputFile.nextLine());
        }

        inputFile.close();

        for (String s : line) {

            word = s.split(" / ");

            output = getString(output, word);
        }
        output = output.trim();

        return output;
    }

    private static String getString(String s, String[] word) {

        String[] letter;

        StringBuilder outPutBuilder = new StringBuilder(s);
        for (int j = 0; j < word.length; j++) {


            letter = " ".split(word[j]);

            for (int k = 0; k < letter.length; k++) {
            }

            outPutBuilder.append(" ");
        }
        s = outPutBuilder.toString();
        return s;
    }
}




