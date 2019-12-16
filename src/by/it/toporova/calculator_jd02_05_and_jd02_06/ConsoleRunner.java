package by.it.toporova.calculator_jd02_05_and_jd02_06;


import by.it.toporova.calculator_jd02_05_and_jd02_06.lang.strings.Country;
import by.it.toporova.calculator_jd02_05_and_jd02_06.lang.strings.Language;
import by.it.toporova.calculator_jd02_05_and_jd02_06.lang.strings.Errors;
import by.it.toporova.calculator_jd02_05_and_jd02_06.lang.strings.Service;
import by.it.toporova.calculator_jd02_05_and_jd02_06.reportBuilder.BriefReportBuilder;
import by.it.toporova.calculator_jd02_05_and_jd02_06.reportBuilder.FullReportBuilder;
import by.it.toporova.calculator_jd02_05_and_jd02_06.reportBuilder.Report;
import by.it.toporova.calculator_jd02_05_and_jd02_06.reportBuilder.Reporter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;


public class ConsoleRunner {

    public static Date timeStart;
    public static Date timeFinish;
    private static boolean fullReport = false;

    public static void main(String[] args) throws IOException {
        timeStart = new Date();
        ResMan resMan = ResMan.INSTANCE;
        if (args.length == 2) {
            resMan.setLocale(args[0], args[1]);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Parser parser = new Parser();
        Printer printer = new Printer();
        choosingLanguage(resMan, reader);
        String expression;
        Var.loadVarFromFile();
        while (!(expression = reader.readLine()).equalsIgnoreCase(Service.END)) {
            String result;

            if (expression.equalsIgnoreCase(Language.EN)) {
                resMan.setLocale(Language.EN, Country.US);
            } else if (expression.equalsIgnoreCase(Language.RU)) {
                resMan.setLocale(Language.RU, Country.RU);
            } else if (expression.equalsIgnoreCase(Language.BE)) {
                resMan.setLocale(Language.BE, Country.BY);
            } else if (expression.equalsIgnoreCase(Service.FULL)) {
                fullReport = true;
            } else try {
                result = parser.calc(expression);
                printer.print(result);
                printer.showCalculationInfoToLogAndReports(expression, result);
            } catch (CalcException e) {
                printer.showErrorToLogAndReports(e);
            }
        }
        Var.saveVarToFile();
        timeFinish = new Date();
        Reporter reporter = new Reporter();
        if (fullReport) {
            reporter.setBuilder(new FullReportBuilder());
        } else reporter.setBuilder(new BriefReportBuilder());
        Report report = reporter.buildReport();
        report.printReport(report);
        System.out.println("\n" + resMan.get(Service.REPORT_LINK));
        System.out.println(report.getOutputFileName().replace("/", "\\"));
    }

    private static void choosingLanguage(ResMan resMan, BufferedReader reader) throws IOException {
        System.out.println(resMan.get(Service.TO_START));
        String expression = reader.readLine();
        if (expression.equalsIgnoreCase(Language.EN)) {
            resMan.setLocale(Language.EN, Country.US);
            welcomeMessages(resMan);
        } else if (expression.equalsIgnoreCase(Language.RU)) {
            resMan.setLocale(Language.RU, Country.RU);
            welcomeMessages(resMan);
        } else if (expression.equalsIgnoreCase(Language.BE)) {
            resMan.setLocale(Language.BE, Country.BY);
            welcomeMessages(resMan);
        } else {
            System.out.println(resMan.get(Errors.INCORRECT_INPUT));
            choosingLanguage(resMan, reader);
        }
    }

    private static void welcomeMessages(ResMan resMan) {
        System.out.println(resMan.get(Service.START_CALCULATION));
        System.out.println(resMan.get(Service.CHANGE_LANGUAGE));
        System.out.println(resMan.get(Service.CHOOSE_REPORT));
        System.out.println(resMan.get(Service.TO_FINISH));
        System.out.println();
    }
}