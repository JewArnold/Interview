package common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class General {


    public static void main(String[] args) throws IOException {

        List<String> poem = Files.readAllLines(Path.of("D:\\test.txt"));

        checkPoemRhyme(poem);

    }

    public static void checkPoemRhyme(List<String> poem) {
        poem.removeIf(String::isEmpty);


        for (int i = 0; i < poem.size() - 2; i++) {

            String[] array1 = getArray(poem.get(i));
            String[] array2 = getArray(poem.get(i + 2));


            String string1 = array1[array1.length - 1];
            String string2 = array2[array2.length - 1];


            if (!isRhymed(string1, string2)) {
                System.out.println("Строка " + i + " " + string1 + "\n"
                        + "Строка " + (i + 2) + " " + string2);
            }

            if (i % 2 != 0) {
                i += 2;
            }
        }

    }


    public static String[] getArray(String string) {
        return string.split(" ");
    }

    public static boolean isRhymed(String string1, String string2) {
        string1 = replacePunctuation(string1);
        string2 = replacePunctuation(string2);

        int length1 = string1.length();
        int length2 = string2.length();

        return (string1.substring(length1 - 2).equals(string2.substring(length2 - 2)));

    }

    public static String replacePunctuation(String string) {
        string = string.replaceAll("\\p{Punct}", "");
        return string;
    }


}
