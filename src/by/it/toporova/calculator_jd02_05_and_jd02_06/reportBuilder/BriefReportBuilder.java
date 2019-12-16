package by.it.toporova.calculator_jd02_05_and_jd02_06.reportBuilder;

import by.it.toporova.calculator_jd02_05_and_jd02_06.ConsoleRunner;
import by.it.toporova.calculator_jd02_05_and_jd02_06.Path;
import by.it.toporova.calculator_jd02_05_and_jd02_06.ResMan;
import by.it.toporova.calculator_jd02_05_and_jd02_06.lang.strings.Service;

import java.text.DateFormat;
import java.util.LinkedList;
//кратний отчет
public class BriefReportBuilder extends ReportBuilder{

    private static LinkedList<String> operationsAndErrorsInfo = new LinkedList<>();


    public void addInfo(String info){
        operationsAndErrorsInfo.addLast(info);
    }

    @Override
    void buildOutputFileName() {
        Path path = new Path();
        report.setFileName(path.getPath(BriefReportBuilder.class, "BriefReport.txt"));
    }

    @Override
    void buildTitle() {
        report.setTitle(ResMan.INSTANCE.get(Service.BRIEF_REPORT));
    }

    @Override
    void buildStartTime() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, ResMan.INSTANCE.getLocale());
        report.setStartTime(dateFormat.format(ConsoleRunner.timeStart));
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
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, ResMan.INSTANCE.getLocale());
        report.setFinishTime(dateFormat.format(ConsoleRunner.timeFinish));
    }

}