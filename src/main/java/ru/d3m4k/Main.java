package ru.d3m4k;

public class Main {

        public static void main(String[] args) {
            int a = 5;
            int b = 3;
            a = a + b;
            b = a - b;
            System.out.println(a);
            System.out.println(b);

            // Плюсы минусы тестов
            // Плюсы : упрощение кода, в будущем будет проще поддерживать, ускоряет разработку кода в будущем
            // Плюсы : помогает отловить некоторые ошибки
            // Плюсы : уверенность в коде
            // Минусы : сложность написание, время написания, избыточные тесты, TDD не всегда нужен, и не сразу окупается
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

    public static void validateInput(String input) throws Exception {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new Exception("Input string must contain only digits");
            }
        }
    }
}
