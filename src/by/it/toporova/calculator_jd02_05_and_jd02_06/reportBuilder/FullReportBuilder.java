package by.it.toporova.calculator_jd02_05_and_jd02_06.reportBuilder;


import by.it.toporova.calculator_jd02_05_and_jd02_06.ConsoleRunner;
import by.it.toporova.calculator_jd02_05_and_jd02_06.Path;
import by.it.toporova.calculator_jd02_05_and_jd02_06.ResMan;
import by.it.toporova.calculator_jd02_05_and_jd02_06.lang.strings.Service;

import java.util.LinkedList;

public class FullReportBuilder extends ReportBuilder {


    private static LinkedList<String> operationsAndErrorsInfo = new LinkedList<>();


    public void addInfo(String info) {
        operationsAndErrorsInfo.addLast(info);
    }

    @Override
    void buildOutputFileName() {
        Path path = new Path();
        report.setFileName(path.getPath(FullReportBuilder.class, "FullReport.txt"));
    }

    @Override
    void buildTitle() {
        report.setTitle(ResMan.INSTANCE.get(Service.DETAILED_REPORT));
    }

    @Override
    void buildStartTime() {
        report.setStartTime(ResMan.INSTANCE.get(Service.START_TIME) + " " + ConsoleRunner.timeStart.toString());
    }

    @Override
    void buildOperationsAndErrorsInfo() {
        StringBuilder infoBuilder = new StringBuilder();
        for (String info : operationsAndErrorsInfo) {
            infoBuilder.append(info).append("\n");
        }
        report.setOperationsAndErrorsInfo(infoBuilder.toString());
    }

    @Override
    void buildFinishTime() {
        report.setFinishTime(ResMan.INSTANCE.get(Service.FINISH_TIME) + " " + ConsoleRunner.timeFinish.toString());
    }


}

