package by.it.zimina.jd02_06.calc_factory;



import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger();
        logger.log("start calculation");
        Report.Builder reportBuilder = new Report.Builder();
        reportBuilder.setReportType(Report.Type.SHORT)
                .setTitle("Calculator report")
                .setStartTime(Logger.getTime());
        Scanner sc = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = sc.nextLine()).equals("end")) {
            try {
                Var result = parser.calc(line);
                printer.print(result);
                logger.log(line + " result: " + result);
                reportBuilder.addAction(line + " calculated, result: " + result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
                logger.log(e.getMessage());
                reportBuilder.addException(e);
            }
        }
        reportBuilder.setFinishTime(Logger.getTime());
        reportBuilder.build().reportToFile();
        logger.log("calculator finished");
    }
}