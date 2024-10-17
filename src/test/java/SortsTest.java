import org.junit.Test;
import ru.d3m4k.Main;

import static org.assertj.core.api.Assertions.assertThat;

public class SortsTest {

    @Test
    public void testBubbleSort() {
        int[] array = {5, 3, 8, 4, 2};
        Main.bubbleSort(array);
        assertThat(array).containsExactly(2, 3, 4, 5, 8);
    }

    @Test
    public void testInsertionSort() {
        int[] array = {5, 3, 8, 4, 2};
        Main.selectionSort(array);
        assertThat(array).containsExactly(2, 3, 4, 5, 8);
    }

    @Test
    public void testQuickSort() {
        int[] array = {5, 3, 8, 4, 2};
        Main.quickSort(array, 0, array.length - 1);
        assertThat(array).containsExactly(2, 3, 4, 5, 8);
    }

    @Test
    public void testEmptyArray() {
        int[] array = {};
        Main.bubbleSort(array);
        assertThat(array).isEmpty();
        Main.selectionSort(array);
        assertThat(array).isEmpty();
        Main.quickSort(array, 0, array.length - 1);
        assertThat(array).isEmpty();
    }

    @Test
    public void testSingleElementArray() {
        int[] array = {1};
        Main.bubbleSort(array);
        assertThat(array).containsExactly(1);
        Main.selectionSort(array);
        assertThat(array).containsExactly(1);
        Main.quickSort(array, 0, array.length - 1);
        assertThat(array).containsExactly(1);
    }

    @Test
    public void testAlreadySortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        Main.bubbleSort(array);
        assertThat(array).containsExactly(1, 2, 3, 4, 5);
        Main.selectionSort(array);
        assertThat(array).containsExactly(1, 2, 3, 4, 5);
        Main.quickSort(array, 0, array.length - 1);
        assertThat(array).containsExactly(1, 2, 3, 4, 5);
    }

}
