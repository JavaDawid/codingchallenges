package leetcode.largeelement;

public class Element {
    public int secondLargestElement(int[] array) {
        int theLargestElement = Integer.MIN_VALUE;
        int theSecondLargestElement = Integer.MIN_VALUE;
        int i = 0;
        while (i < array.length) {
            if (array[i] > theLargestElement) {
                theSecondLargestElement = theLargestElement;
                theLargestElement = array[i];
            }
            if ((array[i] > theSecondLargestElement) && (array[i] < theLargestElement)) {
                theSecondLargestElement = array[i];
            }
            i++;
        }
        return theSecondLargestElement;
    }
}
