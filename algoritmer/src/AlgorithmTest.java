import java.util.Map;

public class AlgorithmTest {

    @FunctionalInterface
    interface SearchAlgorithm {
        int search(int[] array, int value);
    }

    @FunctionalInterface
    interface SortAlgorithm {
        void sort(int[] array);
    }

    record SearchTestCase(int value, int expected) {
    }

    record SearchResult(int value, int expected, int actual) {
        boolean passed() {
            return expected == actual;
        }
    }

    static SearchResult testAlgorithm(SearchAlgorithm algorithm, int[] array, SearchTestCase testCase) {
        int result = algorithm.search(array, testCase.value());
        return new SearchResult(testCase.value(), testCase.expected(), result);
    }

    record SortTestCase(int[] input, int[] expected) {
    }

    record SortResult(int[] input, int[] expected, int[] actual) {
        boolean passed() {
            return java.util.Arrays.equals(expected, actual);
        }
    }

    static SortResult testAlgorithm(SortAlgorithm algorithm, int[] array, SortTestCase testCase) {
        algorithm.sort(array);
        return new SortResult(testCase.input(), testCase.expected(), array);
    }

    static void printTestResult(SearchResult result, int width) {
        String value = ("%-" + width + "s").formatted(result.value());
        String expected = ("%-" + width + "s").formatted(result.expected());
        String actual = ("%-" + width + "s").formatted(result.actual());
        System.out.printf(
                "  value=%s  expected=%s  actual=%s -- %s\n",
                value,
                expected,
                actual,
                result.passed() ? Color.ANSI_GREEN + "PASSED" + Color.ANSI_RESET
                        : Color.ANSI_RED + "FAILED" + Color.ANSI_RESET);
    }

    static void printTestResult(SortResult result, int width) {
        String input = ("%-" + width + "s").formatted(java.util.Arrays.toString(result.input()));
        String expected = ("%-" + width + "s").formatted(java.util.Arrays.toString(result.expected()));
        String actual = ("%-" + width + "s").formatted(java.util.Arrays.toString(result.actual()));
        System.out.printf(
                "  value=%s  expected=%s  actual=%s -- %s\n",
                input,
                expected,
                actual,
                result.passed() ? Color.ANSI_GREEN + "PASSED" + Color.ANSI_RESET
                        : Color.ANSI_RED + "FAILED" + Color.ANSI_RESET);
    }

    public static void main(String[] args) {
        System.out.println("Testing algorithms...");

        int[] unsortedArray = { 3, 4, 1, 5, 8, 7, 2, 9 };

        SearchTestCase[] searchTestCases = {
                new SearchTestCase(5, 3),
                new SearchTestCase(10, -1)
        };

        SortTestCase[] sortTestCases = {
                new SortTestCase(unsortedArray, new int[] { 1, 2, 3, 4, 5, 7, 8, 9 }),
        };

        Map<String, SearchAlgorithm> searchAlgorithms = Map.of(
                "linearSearch", Algorithms::linearSearch,
                "binarySearch", Algorithms::binarySearch);

        Map<String, SortAlgorithm> sortingAlgorithms = Map.of(
                "selectionSort", Algorithms::selectionSort,
                "bubbleSort", Algorithms::bubbleSort);

        boolean allTestsPassed = true;

        for (var entry : searchAlgorithms.entrySet()) {
            String name = entry.getKey();
            SearchAlgorithm algorithm = entry.getValue();
            System.out.println("\nTesting %s...".formatted(name));

            boolean algorithmPassed = true;
            for (SearchTestCase tc : searchTestCases) {
                SearchResult result = testAlgorithm(algorithm, unsortedArray, tc);
                algorithmPassed &= result.passed();

                printTestResult(result, 3);
            }

            allTestsPassed &= algorithmPassed;
        }

        for (var entry : sortingAlgorithms.entrySet()) {
            String name = entry.getKey();
            SortAlgorithm algorithm = entry.getValue();
            System.out.println("\nTesting %s...".formatted(name));

            boolean algorithmPassed = true;
            for (SortTestCase tc : sortTestCases) {
                SortResult result = testAlgorithm(algorithm, tc.input().clone(), tc);
                algorithmPassed &= result.passed();

                printTestResult(result, 3);
            }

            allTestsPassed &= algorithmPassed;
        }

        Color.printlnAnsi(allTestsPassed ? "\nAll tests passed!" : "\nSome tests failed.",
                allTestsPassed ? Color.ANSI_GREEN : Color.ANSI_RED);
    }
}
