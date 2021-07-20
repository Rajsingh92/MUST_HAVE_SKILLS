/**
How to efficiently sort a big list dates in 20’s

Example: 

Input:
       Date arr[] = {{20,  1, 2014},
                    {25,  3, 2010},
                    { 3, 12, 2000},
                    {18, 11, 2001},
                    {19,  4, 2015},
                    { 9,  7, 2005}}
 */

 
public class SortDates {
    static class Date {
        int day;
        int month;
        int year;

        public Date(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    private static void CountingSortyear(Date[] arr) {
        Date[] output = new Date[arr.length];
        int[] count_array = new int[100];

        for (int i = 0; i < arr.length; i++) {
            count_array[arr[i].year % 2000]++;
        }

        for (int i = 1; i < count_array.length; i++) {
            count_array[i] += count_array[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count_array[arr[i].year % 2000] - 1] = arr[i];
            count_array[arr[i].year % 2000]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    private static void CountingSortmonth(Date[] arr) {
        Date[] output = new Date[arr.length];
        int[] count_array = new int[13];

        for (int i = 0; i < arr.length; i++) {
            count_array[arr[i].month]++;
        }

        for (int i = 1; i < count_array.length; i++) {
            count_array[i] += count_array[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count_array[arr[i].month] - 1] = arr[i];
            count_array[arr[i].month]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    private static void CountingSortday(Date[] arr) {
        Date[] output = new Date[arr.length];
        int[] count_array = new int[32];

        for (int i = 0; i < arr.length; i++) {
            count_array[arr[i].day]++;
        }

        for (int i = 1; i < count_array.length; i++) {
            count_array[i] += count_array[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count_array[arr[i].day] - 1] = arr[i];
            count_array[arr[i].day]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Date[] arr = new Date[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Date(scn.nextInt(), scn.nextInt(), scn.nextInt());
        }

        CountingSortday(arr);
        CountingSortmonth(arr);
        CountingSortyear(arr);

        for (Date date : arr) {
            System.out.println(date.day + " " + date.month + " " + date.year);
        }
    }

}