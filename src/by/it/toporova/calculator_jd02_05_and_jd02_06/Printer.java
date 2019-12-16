package by.it.toporova.calculator_jd02_05_and_jd02_06;

import by.it.toporova.calculator_jd02_05_and_jd02_06.reportBuilder.BriefReportBuilder;
import by.it.toporova.calculator_jd02_05_and_jd02_06.reportBuilder.FullReportBuilder;

class Printer {

    private Logger logger = Logger.getLogger();
    private BriefReportBuilder briefReportBuilder = new BriefReportBuilder();
    private FullReportBuilder detailedReportBuilder = new FullReportBuilder();

    public void print(String result) {
        if (result != null)
            System.out.println(result);
    }

    void showErrorToLogAndReports(CalcException e) {
        logger.toLog(e.getMessage());
        briefReportBuilder.addInfo(e.getMessage());
        detailedReportBuilder.addInfo(e.toString());
    }

    void showCalculationInfoToLogAndReports(String expression, String result) {
        if (Parser.printToLog){
            if (result != null){
                logger.toLog(expression.replace("=", "")+"="+result);
                briefReportBuilder.addInfo(expression.replace("=", "")+"="+result);
                detailedReportBuilder.addInfo(expression.replace("=", "")+"="+result);
            }
        } else detailedReportBuilder.addInfo(expression);
    }

}

