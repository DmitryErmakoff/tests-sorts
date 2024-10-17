import org.junit.Test;
import ru.d3m4k.Main;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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

    @Test
    public void testValidInput() throws Exception {
        String validInput = "1234567890";
        Main.validateInput(validInput);
    }

    @Test
    public void testInputWithLetters() {
        String invalidInput = "123abc";
        assertThatThrownBy(() -> Main.validateInput(invalidInput))
                .isInstanceOf(Exception.class)
                .hasMessage("Input string must contain only digits");
    }

    @Test
    public void testInputWithSpecialCharacters() {
        String invalidInput = "123!@#";
        assertThatThrownBy(() -> Main.validateInput(invalidInput))
                .isInstanceOf(Exception.class)
                .hasMessage("Input string must contain only digits");
    }

    @Test
    public void testEmptyInput() {
        String emptyInput = "";
        try {
            Main.validateInput(emptyInput);
        } catch (Exception e) {
            throw new AssertionError("Method should not throw an exception for empty input", e);
        }
    }

    @Test
    public void testInputWithSpaces() {
        String invalidInput = "123 456";
        assertThatThrownBy(() -> Main.validateInput(invalidInput))
                .isInstanceOf(Exception.class)
                .hasMessage("Input string must contain only digits");
    }

}
