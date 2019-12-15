package by.it.toporova.calculator_jd02_05_and_jd02_06.reportBuilder;

abstract class ReportBuilder {

    Report report;

    void creatReport(){
        report = new Report();
    }

    abstract void buildOutputFileName();
    abstract void buildTitle();
    abstract void buildStartTime();
    abstract void buildOperationsAndErrorsInfo();
    abstract void buildFinishTime();

    Report getReport(){
        return report;
    }

}