/*
Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */
package homework2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task4 {
    public static void main(String[] args) throws IOException {
        print(bubbleSort(randomArr()));
    }
    public static int[] randomArr() {
        Random rand = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
        return arr;
    }
    static int[] bubbleSort(int[] arr) throws IOException {
        Logger logger = Logger.getLogger(Task4.class.getName());
        FileHandler fileHandler = new FileHandler("Task4log.txt");
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
        int temp;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            logger.info(Arrays.toString(arr));
        }
        return arr;
    }
    public static void print(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
