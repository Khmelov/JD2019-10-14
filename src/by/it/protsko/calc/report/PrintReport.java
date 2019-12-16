package by.it.protsko.calc.report;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintReport {
    private static Report report = new Report();

    static void saveReport(String fileName, String... reportItems) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            for (String item : reportItems) {
                if (item == null) continue;
                writer.append(item).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printStartReport(Report report) {
        saveReport(report.getFileName(), report.getReportTitle(), report.getTimeStartProgram());
    }

    public static void printOperation(Report report) {
        saveReport(report.getFileName(), report.getOperation(), report.getOperationResult());
    }

    public static void printEndReport(Report report) {
        saveReport(report.getFileName(), report.getTimeFinishProgram(), "");
    }


//    }
//
//    public static void printOperationReport(String operation) {
//        by.it.protsko.calc.report.Director director = new by.it.protsko.calc.report.Director();
//        director.setReportCreator(new ShortReportCreator());
//        Report report = director.createStartReport();
//        report.setOperation(operation);
//        report.saveOperationReport();
//    }
//
//    public static void printFinishReport() {
//        by.it.protsko.calc.report.Director director = new Director();
//        director.setReportCreator(new ShortReportCreator());
//        director.createFinishReport().saveFinishReport();
//    }
}
