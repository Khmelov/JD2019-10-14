package by.it.volchek.jd02_01;

public class Backet {

    public static void backetPut(String name) {
        int xTimes = Helper.random(1,5);
        StringBuffer sb = new StringBuffer();
        sb.append(name + ": ");
        for (int i = 0; i < xTimes; i++) {
            int y = Helper.random(0,9);
            switch (y) {
                case 0:
                    sb.append("(cheese, 2)");
                    break;
                case 1:
                    sb.append("(milk, 1)");
                    break;
                case 2:
                    sb.append("(bread, 1)");
                    break;
                case 3:
                    sb.append("(water, 1)");
                    break;
                case 4:
                    sb.append("(mayo, 2)");
                    break;
                case 5:
                    sb.append("(vodka, 7)");
                    break;
                case 6:
                    sb.append("(ham, 3)");
                    break;
                case 7:
                    sb.append("(chicken, 6)");
                    break;
                case 8:
                    sb.append("(cola, 2)");
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}
