package by.it.komarov.jd01_04;

class Helper {

    static void sort(double[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++)
                if (arr[j] > arr[j + 1]) {
                    double clone = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = clone;
                }
        }
        for (double v : arr) {
            System.out.println(v);
        }
    }
}





