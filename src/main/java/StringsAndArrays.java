import org.w3c.dom.css.RGBColor;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringsAndArrays {

    public static void main(String[] args) {

        String string = "afssdgr s foaFsmcoasfnian lksdoiasoklmZ";
        String stringToCompress = "afssssdgrsssfooooooaFFFFFFFsmcoasfniiiiiian";
        String modifiedString = "afasfnisoklmZan s foaFssksdoo laisdgrmc";
        String palindrome = "Tact Coa";
//        System.out.println(compressString(stringToCompress));
        System.out.println(isCycleShift("waterbottle", "erbottlewat"));
        System.out.println(isCycleShift("wwfwww", "wfwwww"));


    }

    private static boolean isCycleShift(String string, String modifiedString) {
        if (string.length() == modifiedString.length()){
            return (string + string).contains(modifiedString);
        }else {
            return false;
        }
    }


    public static RGBColor[][] rot90DegRight(RGBColor[][] imageMatrix) {
        int width = imageMatrix.length;
        int height = imageMatrix[0].length;
        RGBColor[][] rotatedMatrix = new RGBColor[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rotatedMatrix[i][j] = imageMatrix[width - j - 1][i];
            }
        }
        return rotatedMatrix;
    }


    private static String compressString(String string) {
        StringBuilder compressedString = new StringBuilder();
        char lastSymbol = string.charAt(0);
        int count = 1;

        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == lastSymbol) {
                count++;
            } else {
                compressedString.append(lastSymbol);
                compressedString.append(count);
                lastSymbol = string.charAt(i);
                count = 1;
            }
        }
        return string.length() > compressedString.length() ? compressedString.toString() : string;
    }

    //    TODO: not complete yet
    private static boolean isOneModification(String s1, String s2) {
        int modificationCount = 0;
        int length1 = s1.length();
        int length2 = s2.length();
        String[] symbols1 = s1.split("");
        String[] symbols2 = s2.split("");

        if (Math.abs(length1 - length2) > 1) {
            return false;
        }
        if (length1 == length2) {
            for (int i = 0; i < length1; i++) {
                if (!symbols1[i].equals(symbols2[i])) {
                    modificationCount++;
                }
            }
        }
        for (int i = 0; i < Math.min(length1, length2); i++) {

        }
        return modificationCount <= 1;
    }

    private static boolean isPalindrome(String string) {
        int singleSymbolsCount = 0;
        Collection<Long> symbolsCount = Arrays.stream(string.toLowerCase().split(""))
                .filter(symbol -> symbol.equals(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values();
        for (Long symbolCount : symbolsCount) {
            if (symbolCount % 2 != 0 && symbolCount != 1) {
                return false;
            }
            if (symbolCount == 1) {
                singleSymbolsCount++;
            }
        }
        return singleSymbolsCount <= 1;
    }

    private static String replaceSpaces(String string) {
        return string.replaceAll("\\s+", "%20");
    }

    private static boolean isModifiedString(String s1, String s2) {
        String[] s1Symbols = s1.split("");
        Arrays.sort(s1Symbols);
        String[] s2Symbols = s2.split("");
        Arrays.sort(s2Symbols);

        return Arrays.equals(s1Symbols, s2Symbols);
    }


    private static boolean containsOneTime(String string, CharSequence c) {
        if (string.contains(c)) {
            String modifiedString = string.replaceFirst(String.valueOf(c), "");
            return !modifiedString.contains(c);
        }
        return false;
    }
}
