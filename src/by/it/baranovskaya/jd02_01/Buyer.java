package by.it.baranovskaya.jd02_01;

   public  class Buyer extends Thread implements IBuyer {

        Buyer(int num) {
            super("Buyer №"+ num);
        }

        @Override
        public void run() {
            enterToMarket();
            chooseGoods();
            goOut();
        }

        @Override
        public void enterToMarket() {
            System.out.println(this+"come to market");
        }

        @Override
        public void chooseGoods() {
            System.out.println(this+" started to choose goods");
            int timeout = Helper.random(100, 1000);
            Helper.sleep(timeout);
            System.out.println(this+" finished to choose goods");
        }

        @Override
        public void goOut() {
            System.out.println(this+" leave the market");
        }

        @Override
        public String toString() {
            return getName();
        }
    }

