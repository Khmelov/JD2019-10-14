package by.it.protsko.calc.report;

abstract class ReportCreator {
    Report report;

    void createReport() {
        report = new Report();
    }

    abstract void createReportTitle();

    abstract void createTimeStartProgram();

    abstract void createOperation();

    abstract void createOperationResult();

    abstract void createTimeFinishProgram();

    abstract void createFileName();

    Report getReport() {
        return report;
    }
}


