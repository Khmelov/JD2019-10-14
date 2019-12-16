package by.it.protsko.calc.report;

public class Runner {

    public static void main(String[] args) {

        Director director = new Director();
        director.setReportCreator(new ShortReportCreator());
        Report report = director.createReport();

        PrintReport.printStartReport(report);
        PrintReport.printOperation(report);
        PrintReport.printEndReport(report);

    }
}
