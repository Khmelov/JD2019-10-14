package by.it.toporova.jd02_05;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;

public class Runner {

        public static void main(String[] args) throws IOException {

            ResMan resMan = ResMan.INSTANCE;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            if (args.length == 2) {
                resMan.setLocale(args[0], args[1]);
            }
            System.out.println(resMan.get(Systems.TO_START));
            String input = reader.readLine();
            if (input.equalsIgnoreCase(Language.EN)) {
                resMan.setLocale(Language.EN, Country.US);
                printMessage(resMan);
                instructionToFinish(resMan);
            } else if (input.equalsIgnoreCase(Language.RU)) {
                resMan.setLocale(Language.RU, Country.RU);
                printMessage(resMan);
                instructionToFinish(resMan);
            } else if (input.equalsIgnoreCase(Language.BE)) {
                resMan.setLocale(Language.BE, Country.BY);
                printMessage(resMan);
                instructionToFinish(resMan);
            } else {
                System.out.println(resMan.get(Systems.INCORRECT_INPUT));
                instructionToFinish(resMan);
            }

            while (!(input = reader.readLine()).equalsIgnoreCase(Systems.END)) {
                if (input.equalsIgnoreCase(Language.EN)) {
                    resMan.setLocale(Language.EN, Country.US);
                    printMessage(resMan);
                } else if (input.equalsIgnoreCase(Language.RU)) {
                    resMan.setLocale(Language.RU, Country.RU);
                    printMessage(resMan);
                } else if (input.equalsIgnoreCase(Language.BE)) {
                    resMan.setLocale(Language.BE, Country.BY);
                    printMessage(resMan);
                } else {
                    System.out.println(resMan.get(Systems.INCORRECT_INPUT));
                }
            }
        }

        private static void instructionToFinish(ResMan resMan) {
            System.out.println();
            System.out.println(resMan.get(Systems.TO_FINISH));
        }

        private static void printMessage(ResMan resMan) {
            System.out.println(resMan.get(Messages.WELCOME));
            System.out.println(resMan.get(Messages.QUESTION));
            System.out.println(resMan.get(User.FIRST_NAME));
            System.out.println(resMan.get(User.LAST_NAME));

            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, resMan.getLocale());
            System.out.println(dateFormat.format(new Date()));
            System.out.println();
        }
    }
