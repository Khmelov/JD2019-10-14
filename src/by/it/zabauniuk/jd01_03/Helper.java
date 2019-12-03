package by.it.zabauniuk.jd01_03;

public class Helper {
    /**
     * Функция нахождения минимального нахождения массива
     *
     * @param arr
     * @return
     */
    static double findMin(double[] arr) {
        double min = arr[0];
        for (double x : arr)
            if (min > x)
                min = x;
        return min;
    }

    /**
     * Функция значения максимального элемента массива
     *
     * @param arr
     * @return
     */
    static double findMax(double[] arr) {
        double max = arr[0];
        for (double x : arr)
            if (max < x)
                max = x;
        return max;
    }

    /**
     * Сортировка массива
     *
     * @param arr
     */
    static void sort(double[] arr) {
        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int j = 0; j < last; j++) {
                if (arr[j] > arr[j + 1]) {
                    double buf = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buf;
                    swap = true;

                }
            }
            last--;

        } while (swap);
    }
}
