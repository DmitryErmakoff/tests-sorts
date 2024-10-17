package ru.d3m4k;

public class Main {

        public static void main(String[] args) {
            int[] array = {64, 34, 25, 12, 22, 11, 90};

            System.out.println("Исходный массив:");
            printArray(array);

            int[] bubbleSortedArray = bubbleSort(array.clone());
            System.out.println("Отсортированный массив (пузырьковая сортировка):");
            printArray(bubbleSortedArray);

            int[] selectionSortedArray = selectionSort(array.clone());
            System.out.println("Отсортированный массив (сортировка выборкой):");
            printArray(selectionSortedArray);

            int[] quickSortedArray = quickSort(array.clone(), 0, array.length - 1);
            System.out.println("Отсортированный массив (быстрая сортировка):");
            printArray(quickSortedArray);
        }

        public static int[] bubbleSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
            return arr;
        }

        public static int[] selectionSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
            return arr;
        }

        public static int[] quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
            return arr;
        }

        private static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = (low - 1);
            for (int j = low; j < high; j++) {
                if (arr[j] < pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            return i + 1;
        }

        public static void printArray(int[] arr) {
            for (int value : arr) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
