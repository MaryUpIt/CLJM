public class Operations extends Panel {

    public static void plusMinus(String input) {
        if (Converter.typeOfNumber(input) == Converter.ARAB) {
            double numberOne = Double.parseDouble(input) * (-1);
            Panel.input = String.valueOf(numberOne);
            output.setText(String.valueOf(numberOne));
        } else {
            output.setText("NOT_NUMBER");
        }
    }

    public static void plus(String input) {
        operation = '+';
        if (Converter.typeOfNumber(input) == Converter.ROME) {
            romanOne = Converter.toArabicNumber(input);
            output.setText("ENTER_ROMAN_NUMBER");

        } else if (Converter.typeOfNumber(input) == Converter.ARAB) {
            numberOne = input;
            output.setText("ENTER_ARAB_NUMBER");

        } else {
            input = "NOT_NUMBER";
            output.setText(input);
        }
    }

    public static void minus(String input) {
        operation = '-';
        if (Converter.typeOfNumber(input) == Converter.ROME) {
            romanOne = Converter.toArabicNumber(input);
            output.setText("ENTER_ROMAN_NUMBER");

        } else if (Converter.typeOfNumber(input) == Converter.ARAB) {
            numberOne = input;
            output.setText("ENTER_ARAB_NUMBER");

        } else {
            input = "NOT_NUMBER";
            output.setText(input);
        }
    }

    public static void multi(String input) {
        operation = '*';
        if (Converter.typeOfNumber(input) == Converter.ROME) {
            romanOne = Converter.toArabicNumber(input);
            output.setText("ENTER_ROMAN_NUMBER");

        } else if (Converter.typeOfNumber(input) == Converter.ARAB) {
            numberOne = input;
            output.setText("ENTER_ARAB_NUMBER");

        } else {
            input = "NOT_NUMBER";
            output.setText(input);
        }
    }

    public static void dev(String input) {
        operation = '/';
        if (Converter.typeOfNumber(input) == Converter.ROME) {
            romanOne = Converter.toArabicNumber(input);
            output.setText("ENTER_ROMAN_NUMBER");

        } else if (Converter.typeOfNumber(input) == Converter.ARAB) {
            numberOne = input;
            output.setText("ENTER_ARAB_NUMBER");

        } else {
            input = "NOT_NUMBER";
            output.setText(input);
        }
    }

    public static void remain(String input) {
        operation = '%';
        if (Converter.typeOfNumber(input) == Converter.ROME) {
            romanOne = Converter.toArabicNumber(input);
            output.setText("ENTER_ROMAN_NUMBER");

        } else if (Converter.typeOfNumber(input) == Converter.ARAB) {
            numberOne = input;
            output.setText("ENTER_ARAB_NUMBER");

        } else {
            input = "NOT_NUMBER";
            output.setText(input);
        }
    }

    public static void result(String input, char operation, String number, int romanOne) {

        if (Converter.typeOfNumber(input) == Converter.ROME) {
            if (romanOne == 0) {
                output.setText("FAIL_INPUT");
                return;
            }
            romanTwo = Converter.toArabicNumber(input);
            if (operation == '+') {
                romanResult = Converter.toRomanNumber(romanOne + romanTwo);
            } else if (operation == '-') {
                if (romanOne < romanTwo) {
                    output.setText("NOT_EXIST");
                    return;
                }
                romanResult = Converter.toRomanNumber(romanOne - romanTwo);

            } else if (operation == '*') {
                romanResult = Converter.toRomanNumber(romanOne * romanTwo);
            } else if (operation == '/') {
                if (romanOne < romanTwo) {
                    output.setText("NOT_EXIST");
                    return;
                }
                romanResult = Converter.toRomanNumber(romanOne / romanTwo);

            } else if (operation == '%') {
                romanResult = Converter.toRomanNumber(romanOne % romanTwo);
            }
            output.setText(romanResult);

        } else if (Converter.typeOfNumber(input) == Converter.ARAB) {
            if (numberOne == null) {
                output.setText("FAIL_INPUT");
                return;
            }
            numberTwo = Double.parseDouble(input);
            double numberOne = Double.parseDouble(number);
            if (operation == '+') {
                arabicResult = numberOne + numberTwo;
            } else if (operation == '-') {
                arabicResult = numberOne - numberTwo;
            } else if (operation == '*') {
                arabicResult = numberOne * numberTwo;
            } else if (operation == '/') {
                arabicResult = numberOne / numberTwo;
            } else if (operation == '%') {
                arabicResult = (double) ((int) numberOne % (int) numberTwo);
            }
            output.setText(String.valueOf(arabicResult));
        } else {
            input = "NOT_NUMBER";
            output.setText(input);
        }
    }
}

