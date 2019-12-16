package by.it.sermyazhko.jd01_04;


import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        String line = "1 5 9 -6 8 32 78 -3 0 -89 88";
        buildOneDimArray(line);
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];
        System.out.println("Unsorted array");
        InOut.printArray(array,"V", 5);

        mergeSort(array);
        System.out.println("Sorted array");
        InOut.printArray(array,"V", 4);
        int newFirst = Arrays.binarySearch(array,first);
        System.out.printf("Index of first element=%d", newFirst);
        System.out.println();
        int newLast = Arrays.binarySearch(array, last);
        System.out.printf("Index of last element=%d", newLast);
    }


    static void mergeSort(double[] arr) {
        mergeSort(arr,0, arr.length-1);
    }

    public static void merge(double a[],int l,int m,int r)
    {
        int i, j,c=l;
        double b[]=new double[r+1];

        for(i = l, j = m+1; i <= m && j <= r; c++)
        {

            if(a[i] <= a[j])
                b[c] = a[i++];
            else
                b[c] = a[j++];
        }
        while(i <= m )
            b[c++] = a[i++];

        while(j<=r)
            b[c++] = a[j++];

        for(i = l ; i <= r; i++)
            a[i] = b[i];
    }

    public static void mergeSort(double a[],int l,int r)
    {
        if(l<r)
        {
            int m = (l+r)/2;
            mergeSort(a,l,m);
            mergeSort(a,m+1,r);
            merge(a,l,m,r);

        }
    }

    static int binarySearch(double[] array, double value) {
        /*if (array.length == 0){
            System.out.println("Array is empty");
            return -1;
        }*/
        int start = 0;
        int end = array.length - 1;
        int m = 0;
        while(start <= end){
            m = (end + start)/2;
            if(array[m] == value){
                return m;
            }
            else if (value > array[m]) {
                start = m + 1;
            }
            else{
                    end = m-1;
                }
            }
        return m;
        }
    }
