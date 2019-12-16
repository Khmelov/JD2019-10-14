package by.it.yurtsevich.jd02_05;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class CheckL18n {
    private static DateFormat dateFormat;
    public static void main(String[] args) throws IOException {
        ResourceManager resourceManager=ResourceManager.INSTANCE;
        Scanner sc = new Scanner(System.in);

        if (args.length==2){
            String lang=args[0];
            String country=args[1];
            Locale locale=new Locale(lang,country);
            resourceManager.setLocale(locale);
        }
        String input;
        do {
            System.out.println(">> Specify locale [ru RU] for example,  to change (by default used host's locale)\n" +
                    " or type END to quit app:");
            input = sc.nextLine();
            if (input.toLowerCase().equals("end"))
             break;
            String[] params = input.split(" ");
            if (params.length == 2) {
                String lang = params[0];
                String country = params[1];
                if (!(lang.equals("ru")|lang.equals("be")|lang.equals("en")))
                {
                    System.out.println(resourceManager.get(Errors.INCORRECT_LANGUAGE));
                    continue;
                }
                else {
                Locale locale = new Locale(lang, country);
                resourceManager.setLocale(locale);
                dateFormat=DateFormat.getDateInstance(DateFormat.MEDIUM,locale);
            } }else {
                throw new IOException(resourceManager.get(Errors.INCORRECT_COMMAND));
            }
            printStrings(resourceManager);
        }
        while (!input.toLowerCase().equals("end"));
    }
// Print all strings from resources
    private static void printStrings(ResourceManager resourceManager){
        Date currentDate=new Date();
        String date=dateFormat.format(currentDate);
        System.out.printf("%10s (%s)\n%s\n%s %s\n%s\n",date,resourceManager.get(Message.TODAY),resourceManager.get(Message.WELCOME)
                ,resourceManager.get(User.USERNAME),resourceManager.get(User.USERLASTNAME),resourceManager.get(Message.QUESTION));
    }
}
