package by.it.sermyazhko.jd01_05;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaskC {
    public static void main(String[] args) {
        double x_start = 5.33;
        double x_end = 9.0;
        testTaskC1(x_start, x_end);
        double a_start = 103;
        double a_end = 405;
        int size = 31;
        testTaskC2(a_start, a_end, size);

    }

    private static void testTaskC2(double a_start, double a_end, int size) {
        double[] mas = new double[size];
        double x;
        int temp = 0;
        int count = 0;
        for (int i = 0; i < mas.length; i++) {
            x = Math.random() * (a_end - a_start) + a_start;
            BigDecimal bd = new BigDecimal(Double.toString(x));
            bd = bd.setScale(1, RoundingMode.HALF_UP);
            mas[i] = bd.doubleValue();
            if (0.1 * mas[i] > i){
                ++count;
            }
        }
        System.out.println("count = " + count);
        double[] arr = new double[count];
        for (int j = 0; j < arr.length; j++) {
            for (int i = temp; i < mas.length; i++) {
                if(0.1 * mas[i] > i){
                    arr[j] = mas[i];
                    temp = i + 1;
                    break;
                }
            }
        }
        //sort B
        by.it.sermyazhko.jd01_04.TaskC.mergeSort(arr,0,arr.length-1);
        System.out.println();
        System.out.println("Massiv A <index to rows>");
        printArrayPsev(mas,"A",5);
        System.out.println("Massiv B <index to cols>");
        printArrayPsevToRow(arr,"B",5);
    }


    public static void printArrayPsev(double[] arr, String name, int columnCount) {
        System.out.printf("%s", '\u2554');
        for (int i = 0; i < columnCount; i++) {
            System.out.printf("%s%s%s%s%s%s%s%s%s%s%s%s%s", '\u2550', '\u2550', '\u2550', '\u2550','\u2550','\u2550','\u2550','\u2550','\u2550','\u2550','\u2550','\u2550','\u2550');
            if(i==columnCount-1){
                System.out.printf("%s", '\u2557');
            }
            else{
                System.out.printf("%s",'\u2566');
            }
        }
        System.out.println("");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s%2s[%2d]=%-6.1f", '\u2551', name, i, arr[i]);
            int end = columnCount - arr.length%columnCount;
            if(i == arr.length - 1 && end != columnCount){
                for (int h = 0; h < end; h++) {
                    System.out.printf("%-14s", '\u2551');
                }
            }
            if((i+1) % columnCount == 0 || i == arr.length - 1){
                System.out.printf("%s", '\u2551');//конец каждой строки
                System.out.println();
                if(i!=arr.length-1){
                    System.out.printf("%s", '\u2560');//начало каждой между строки
                }
                for (int j = 0; j < columnCount; j++) {
                    if (i == arr.length - 1) {
                        break;
                    }
                    if(j == columnCount-1){
                        System.out.printf("%s%s%s%s%s%s%s%s%s%s%s%s%s", '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550');
                        System.out.printf("%s", '\u2563');
                    }
                    else {
                        System.out.printf("%s%s%s%s%s%s%s%s%s%s%s%s%s", '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550');
                        System.out.printf("%s", '\u256C');
                    }
                }
                if(i!=arr.length-1){
                    System.out.println();
                }
            }
        }
        System.out.printf("%s",'\u255A');
        for (int i = 0; i < columnCount; i++) {
            System.out.printf("%s%s%s%s%s%s%s%s%s%s%s%s%s",  '\u2550', '\u2550', '\u2550', '\u2550','\u2550','\u2550','\u2550','\u2550','\u2550','\u2550','\u2550','\u2550','\u2550');
            if(i == columnCount-1){
                System.out.printf("%s", '\u255D');
            }
            else{
                System.out.printf("%s",'\u2569');
            }
        }
        System.out.println();
    }

/*
    public static void printArrayPsevToRow(double[] arr, String name, int rowCount) {
        for (int i = 0; i < rowCount; i++) {
            for (int j = i; j < arr.length; j+=rowCount) {
                System.out.printf("%-1s[%2d]=%-10.1f ", name, j, arr[j]);
            }
            System.out.println();
        }
    }
*/

    public static void printArrayPsevToRow(double[] arr, String name, int rowCount) {
        int columnCount;
        if(arr.length%rowCount == 0){
            columnCount = arr.length/rowCount;
        }
        else {
            columnCount = arr.length/rowCount + 1;
        }

        System.out.printf("%s", '\u2554');
        for (int i = 0; i < columnCount; i++) {
            System.out.printf("%s%s%s%s%s%s%s%s%s%s%s%s%s", '\u2550', '\u2550','\u2550', '\u2550', '\u2550','\u2550','\u2550','\u2550','\u2550','\u2550','\u2550','\u2550','\u2550','\u2550');
            if(i==columnCount-1){
                System.out.printf("%s", '\u2557');
            }
            else{
                System.out.printf("%s",'\u2566');
            }

        }
        System.out.println("");
        for (int i = 0; i < rowCount; i++) {
            for (int j = i; j < arr.length; j+=rowCount) {

                System.out.printf("%s%2s[%2d]=%-5.1f ", '\u2551',name, j, arr[j]);

                if(j==i+(rowCount-1)*columnCount)
                {
                    System.out.printf("%s", '\u2551');//конец каждой строки
                }
            }
            if(i!=rowCount - 1){
                System.out.printf("\n%s", '\u2560');//начало каждой между строки
            }

            //System.out.println();
            for (int j = 0; j < columnCount; j++) {
                if (i == rowCount-1) {
                    break;
                }
                if(j == columnCount-1){
                    System.out.printf("%s%s%s%s%s%s%s%s%s%s%s%s%s", '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550');
                    System.out.printf("%s", '\u2563');
                }
                else {
                    System.out.printf("%s%s%s%s%s%s%s%s%s%s%s%s%s",'\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550', '\u2550');
                    System.out.printf("%s", '\u256C');
                }
            }


            System.out.println();
        }

        System.out.printf("%s",'\u255A');
        for (int i = 0; i < columnCount; i++) {
            System.out.printf("%s%s%s%s%s%s%s%s%s%s%s%s%s",  '\u2550', '\u2550', '\u2550', '\u2550','\u2550','\u2550','\u2550','\u2550','\u2550','\u2550','\u2550','\u2550','\u2550');
            if(i == columnCount-1){
                System.out.printf("%s", '\u255D');
            }
            else{
                System.out.printf("%s",'\u2569');
            }
        }

    }


    private static void testTaskC1(double x_start, double x_end) {
        double[] mas = new double[28];
        double z = 0;
        double x = x_start;
        int count = 0;
        double n = (x_end- x)/(mas.length-1);
        for (int i = 0; i < mas.length; i++) {
            mas[i] = Math.pow(((Math.pow(x,2))+4.5),1.0/3);
            x = x + n;
            if(mas[i] > 3.5)
            {
                ++count;
            }
        }
        String name = "A";
        System.out.println("Массив A[]");
        printArray(mas, name, 5);
        double arr[] = new double[count];
        double res = 1.0;
        int temp = 0;
        for (int j = 0; j < arr.length; j++) {
            for (int i = temp; i < mas.length; i++) {
                if(mas[i] > 3.5){
                    arr[j] = mas[i];
                    res *= arr[j];
                    temp = i + 1;
                    break;
                }
            }
        }
       // System.out.println("res=" + res);
        double average = Math.pow(res, 1.0/count);
        String nameB = "B";
        System.out.print("\nМассив B[] из элементов массива A > 3.5\n");
        printArray(arr, nameB, 5);
        System.out.printf("Среднее геометрическое значение массива B = %20.10f\n", average);
    }

    public static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%-1s[%3d] = %-10.5f", name, i, arr[i]);
            if((i+1) % columnCount == 0 || i == arr.length - 1){
                System.out.println();
            }
        }
    }
}
