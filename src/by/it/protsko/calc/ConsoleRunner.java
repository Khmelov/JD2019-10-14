package by.it.protsko.calc;

import by.it.protsko.calc.lang_operations.LanguageChanger;
import by.it.protsko.calc.lang_operations.ResurceManager;
import by.it.protsko.calc.log.Logger;
import by.it.protsko.calc.report.*;

import java.util.Scanner;

public class ConsoleRunner {

    public static String operation;
    public static String operationResult;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        ResurceManager resurceManager = ResurceManager.INSTANSE;
        Var.loadCalcVariable();

        Director director = new Director();
        director.setReportCreator(new FullReportCreator());
        Report report = director.createReport();

        PrintReport.printStartReport(report);
        while (!(line = sc.nextLine()).equals("end")) {
            operation = line;
            switch (line) {
                case "printvar":
                    Printer.printVar();
                    break;
                case "sortvar":
                    Printer.sortVar();
                    break;
                case "ru":
                case "be":
                case "en":
                    resurceManager.setLocal(LanguageChanger.newLanguage(line));
                    break;
                default:
                    try {
                        Var result = parser.calc(line);
                        operationResult = result.toString();
                        printer.print(result);
                        Var.saveCalcVariable();
                    } catch (CalcException e) {
                        System.out.println(e.getMessage());
                        operationResult = e.getMessage();
                        Logger.logMessages(e.getMessage() + "\t(" + line + ")");
                    }
                    report = director.createReport();
                    PrintReport.printOperation(report);
            }
        }
        PrintReport.printEndReport(report);
    }
}
