package by.it.komarov.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBacket {
    private int num; // пробема обращения потоков к одному ресурсу

    private boolean pensioneer = false;

    Buyer(int num){
        this.num = num;
        this.setName("Buyer №" + num + " ");
        start();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goOut();
    }

    @Override
    public void enterToMarket() { System.out.println(this + "enter to market"); }

    @Override
    public void chooseGoods() {
        try {
            System.out.println(this + "choosing goods");
            Thread.sleep(Randomize.fromTo(500, 2000)); // метод sleep() бросает ошибку
        } catch (InterruptedException e) {
            System.out.println(this + "некорректное завершение ожидания");
        }
    }

    @Override
    public void goOut() { System.out.println(this + "leave market"); }

    @Override
    public void takeBacket() {
        try {
            Thread.sleep(Randomize.fromTo(500, 2000));
            System.out.println(this + "take backet");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putGoodsToBacket() {
        try {
            System.out.println(this + "put goods to backet");
            Thread.sleep(Randomize.fromTo(500, 2000));
            for (int i = 0; i < Randomize.fromTo(1,4); i++) {
                System.out.println(Backet.chooseList());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
