package by.it.toporova.calculator_jd02_05_and_jd02_06.reportBuilder;

public class Reporter {

    private ReportBuilder builder;

    public void setBuilder(ReportBuilder builder) {
        this.builder = builder;
    }

    public Report buildReport(){
        builder.creatReport();
        builder.buildOutputFileName();
        builder.buildTitle();
        builder.buildStartTime();
        builder.buildOperationsAndErrorsInfo();
        builder.buildFinishTime();
        return builder.getReport();
    }
}