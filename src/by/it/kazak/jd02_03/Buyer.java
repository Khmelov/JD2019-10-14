package by.it.kazak.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer, IUseBacket {

    private boolean pensioneer = false;
    private boolean wait;
    HashMap<String,Double> basket = new HashMap<>();
    private Semaphore shopingSemaphore = new Semaphore(20);
    private Semaphore basketSemaphore = new Semaphore(50);



    Buyer(int number) {
        super("Buyer № " + number);
        if(number%4==0) {
            this.pensioneer = true;
        }
        Counter.newBuyer();
    }

    boolean isPensionner() {
        return this.pensioneer;
    }

    void setWait() {
        this.wait = false;
    }

    Object getMonitor(){
        return this;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        addToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" Come to the market");
    }

    @Override
    public void chooseGoods() {
        try {
            shopingSemaphore.acquire();
            System.out.println(this+" Start to choose goods");
            if(pensioneer) Helper.sleepThread(Helper.random(750,3_000));
            Helper.sleepThread(Helper.random(500,2_000));
            System.out.println(this+" Finish to choose goods");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            shopingSemaphore.release();
        }
    }

    @Override
    public void addToQueue() {

        QueueBuyer.add(this);

        System.out.println(this + " added to queue and wait");

        wait = true;
        synchronized (this){
            while(wait)try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(this+" complete service at the cashier");
    }

    @Override
    public void goOut() {
        System.out.println(this+" Go out from the market");
        Counter.deleteBuyer();
    }

    @Override
    public void takeBacket() {
        try {
            basketSemaphore.acquire();
            if(pensioneer) Helper.sleepThread(Helper.random(150,300));
            Helper.sleepThread(Helper.random(100,200));
            System.out.println(this+" Take a backet");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            basketSemaphore.release();
        }

    }

    @Override
    public void putGoodsToBacket() {
        if(pensioneer)
            Helper.sleepThread(Helper.random(150,300));
        else
            Helper.sleepThread(Helper.random(100,200));
        int numberOfGoods = Helper.random(1,4);

        Map<String, Double> listOfGoods = Counter.getListOfGoods();
        Set<String> keySets = listOfGoods.keySet();
        ArrayList<String> listOfKeys = new ArrayList<>(keySets);

        for (int i = 0; i < numberOfGoods ; i++) {
            int indexRandom = Helper.random(0,listOfKeys.size()-1);
            String chosenGood = listOfKeys.remove(indexRandom);
            Double prise = listOfGoods.get(chosenGood);
            this.basket.put(chosenGood,prise);
            System.out.println(this+" put to the basket: "+chosenGood+" "+prise);
        }
    }
    @Override
    public String toString() {
        if(this.pensioneer) return this.getName()+" pensioneer";
        else return this.getName();
    }
}
