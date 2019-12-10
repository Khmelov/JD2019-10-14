package by.it.volchek.jd01_12;

public class Timer{
    private  long iniTime;
    private Double Delta;
    public Timer(){
        iniTime= System.nanoTime();
    }
    public String toString(){
        Delta=(double)(System.nanoTime()-iniTime)/1000;
        iniTime= System.nanoTime();

        return "Прошло "+Delta.toString()+" микросекунд.";
    }

}
