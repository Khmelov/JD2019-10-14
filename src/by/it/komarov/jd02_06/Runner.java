package by.it.komarov.jd02_06;

public class Runner {
    public static void main(String[] args) {

        try{
            Logger.getInstance().log("The method is working");
            throw new Exception();
        } catch (Exception e){
            Logger.printExeptionInFile(e.getMessage());
        }
    }
}
