package by.it.yurtsevich.jd02_01;

public class UseBacket extends Thread implements IUseBacket {

    @Override
    public void takeBacket() {
        System.out.println(this +" Taked backet");
    }

    @Override
    public void putGoodsToBacket() {
        System.out.println(this +" Put goods in the backet");
        int timeout=Helper.random(500,2000);
        Helper.sleep(timeout);
    }
}
