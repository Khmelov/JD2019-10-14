package by.it.komarov.jd02_01;

public class Buyer extends Thread implements IBuyer {

    Buyer(int number){
        super("Bauyer№ " + number);
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошёл в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " выбирает товар");

            System.out.println((int) (Math.random() * 3));


        System.out.println(this + " закончил выбирать товар");
    }

    @Override
    public void goOut() {
        System.out.println(this + " покинул магазин");
    }

    @Override
    public String toString() {
        return getName();
    }
}
