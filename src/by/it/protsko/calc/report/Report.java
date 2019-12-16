package by.it.protsko.calc.report;

public class Report {
    private String reportTitle;
    private String timeStartProgram;
    private String operation;
    private String operationResult;
    private String timeFinishProgram;
    private String fileName;

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public void setTimeStartProgram(String timeStartProgram) {
        this.timeStartProgram = timeStartProgram;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setOperationResult(String operationResult) {
        this.operationResult = operationResult;
    }

    public void setTimeFinishProgram(String timeFinishProgram) {
        this.timeFinishProgram = timeFinishProgram;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    void saveStartReport() {
        PrintReport.saveReport(fileName, reportTitle, timeStartProgram);
    }

    void saveOperationReport() {
        PrintReport.saveReport(fileName, operation, operationResult);
    }

    void saveFinishReport() {
        PrintReport.saveReport(fileName, timeFinishProgram);
    }

    public String getFileName() {
        return fileName;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public String getTimeStartProgram() {
        return timeStartProgram;
    }

    public String getOperation() {
        return operation;
    }

    public String getOperationResult() {
        return operationResult;
    }

    public String getTimeFinishProgram() {
        return timeFinishProgram;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportTitle='" + reportTitle + '\'' +
                ", timeStartProgram='" + timeStartProgram + '\'' +
                ", operation='" + operation + '\'' +
                ", operationResult='" + operationResult + '\'' +
                ", timeFinishProgram='" + timeFinishProgram + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
