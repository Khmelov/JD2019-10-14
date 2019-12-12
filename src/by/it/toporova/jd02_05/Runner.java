package by.it.toporova.jd02_05;


import java.io.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Runner {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ResMan lang= ResMan.INSTANCE;
        DateFormat df;
        LABEL:
        while (true) {
            String language = reader.readLine();
            switch (language) {
                case "ru":
                   lang.setLocale(Language.RU, Country.RU);
                    df = DateFormat.getDateInstance(
                            DateFormat.LONG, new Locale(Language.RU, Country.RU));
                    break LABEL;
                case "en":
                    lang.setLocale(Language.EN, Country.US);
                    df = DateFormat.getDateInstance(
                            DateFormat.LONG, Locale.US);
                    break LABEL;
                case "be":
                    lang.setLocale(Language.BE, Country.BY);
                    df = DateFormat.getDateInstance(
                            DateFormat.LONG, new Locale(Language.BE, Country.BY));
                    break LABEL;
                default:
                    System.err.println(Systems.INCORRECT_INPUT);
            }



        }
        Date date = new Date(System.currentTimeMillis());
        output(lang, df, date);
      //  createCommandsFile();
    }

  /*  private static void createCommandsFile() {
        String path = GetPath.getPath(Runner.class);
        File f = new File(path);
        File[] files = f.listFiles();
        if (files != null)
            try (PrintWriter writer = new PrintWriter(new FileWriter(path + "commands.txt"))) {
                for (File file : files) {
                    if (file.getName().contains(".txt")) {
                        String name = file.getName().replace(".txt", ".properties");
                        writer.printf("native2ascii -encoding utf-8 %s %s\n", file.getName(), name);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }*/



    private static void output(ResMan lang, DateFormat df, Date date) {
        System.out.println(df.format(date));
        System.out.println(lang.get(Messages.WELCOME));
        System.out.println(lang.get(Messages.QUESTION));
        System.out.printf("%s %s\n",
                lang.get(User.FIRST_NAME),
                lang.get(User.LAST_NAME));


    }

}
