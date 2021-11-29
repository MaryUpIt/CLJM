import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter {


    public static final String ROME = "ROME";
    public static final String ARAB = "ARAB";
    public static final String NONE = "NONE";


    public static String typeOfNumber(String input) {
        Matcher arabic = Pattern.compile("[\\-]?\\d+[\\.]?\\d+||[\\-]?\\d+").matcher(input);
        Matcher romans = Pattern.compile("[IVXLCDM]+").matcher(input.toUpperCase());

        if (romans.matches()) {
            String check = toRomanNumber(toArabicNumber(input));

            if (check.equalsIgnoreCase(input))
                return ROME;
            else
                return NONE;
        } else if (arabic.matches()) {
            return ARAB;
        } else {
            return NONE;
        }
    }

    private static HashMap<Character, Integer> map = new HashMap<>();

    private static void addMap() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    private static int[] arrayOfCount(String romanNumber) {
        addMap();
        romanNumber = romanNumber.toUpperCase();
        int[] arrayOfCount = new int[romanNumber.length()];
        for (int i = 0; i < romanNumber.length(); i++) {
            arrayOfCount[i] = map.get(romanNumber.charAt(i));
        }
        return arrayOfCount;
    }

    public static int toArabicNumber(String romanNumber) {
        int[] arrayOfCount = arrayOfCount(romanNumber);
        int[] arrayCopy = Arrays.copyOf(arrayOfCount, arrayOfCount.length + 1);
        arrayCopy[arrayCopy.length - 1] = 0;
        int arabicNumber = 0;
        for (int i = 0; i < arrayOfCount.length; i++) {
            if (arrayOfCount[i] >= arrayCopy[i + 1]) {
                arabicNumber += arrayOfCount[i];
            } else if (arrayOfCount[i] < arrayOfCount[i + 1]) {
                arabicNumber += (arrayOfCount[i + 1] - arrayOfCount[i]);
                i++;
            } else {
                return 0;
            }
        }
        return arabicNumber;
    }

    public static String toRomanNumber(int arabicNumber) {
        String romanNumber = "";
        while (arabicNumber >= 1000) {
            romanNumber += "M";
            arabicNumber -= 1000;
        }
        int hundreds = arabicNumber / 100;
        arabicNumber = arabicNumber % 100;
        while (hundreds > 0) {
            if (hundreds == 9) {
                romanNumber += "CM";
                hundreds = 0;
            } else if (hundreds >= 5) {
                romanNumber += "D";
                hundreds -= 5;
            } else if (hundreds == 4) {
                romanNumber += "CD";
                hundreds -= 4;
            } else {
                romanNumber += "C";
                hundreds--;
            }
        }
        arabicNumber = arabicNumber % 100;
        int tens = arabicNumber / 10;
        while (tens > 0) {
            if (tens == 9) {
                romanNumber += "XC";
                tens -= 9;
            } else if (tens >= 5) {
                tens -= 5;
                romanNumber += "L";

            } else if (tens == 4) {
                romanNumber += "Xl";
                tens -= 4;
            } else {
                romanNumber += "X";
                tens--;
            }
        }
        int ones = arabicNumber % 10;
        while (ones > 0) {
            if (ones == 9) {
                romanNumber += "IX";
                ones -= 9;
            } else if (ones >= 5) {
                romanNumber += "V";
                ones -= 5;
            } else if (ones == 4) {
                romanNumber += "IV";
                ones -= 4;
            } else {
                romanNumber += "I";
                ones--;
            }
        }
        return romanNumber;
    }

}
