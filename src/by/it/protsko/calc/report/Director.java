package by.it.protsko.calc.report;

public class Director {
    ReportCreator reportCreator;

    public void setReportCreator(ReportCreator rc) {
        reportCreator = rc;
    }

    public Report createReport() {
        reportCreator.createReport();
        reportCreator.createReportTitle();
        reportCreator.createTimeStartProgram();
        reportCreator.createOperation();
        reportCreator.createOperationResult();
        reportCreator.createTimeFinishProgram();
        reportCreator.createFileName();
        Report report = reportCreator.getReport();
        return report;
    }
}

