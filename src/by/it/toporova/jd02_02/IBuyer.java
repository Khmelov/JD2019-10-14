package by.it.toporova.jd02_02;

public interface IBuyer {
    void enterToMarket();     //вошёл в магазин (мгновенно)
    void chooseGoods();        //выбрал товар (от 0,5 до 2 секунд)
    void goOut();             //отправился на выход (мгновенно)
}