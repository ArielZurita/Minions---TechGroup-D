import java.util.*;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {

    /*
    * This method assumes the input LinkedList is already sorted in non-descending order
    * (i.e.,such that each element is greater than or equal to the one that is before it,
    * and inserts the input int value into the correct location of the list.
    * Note that the method does not return anything, but rather modifies the input LinkedList as a side effect.
    * If the input LinkedList is null, this method should simply terminate.
    * */
    public static void insertSorted(LinkedList<Integer> list, Integer value) {
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                if (list.get(x) >= value) {
                    list.add(x, value);
                    break;
                }
            }
        } else {
            list.add(value);
        }

    }

    /*
    * This method removes all instances of the N largest values in the LinkedList. Because the values are Strings,
    * you will need to use the String class’ compareTo method to find the largest elements;
    * see the Java API for help with that method. If the input LinkedList is null or if N is non-positive,
    * this method should simply return without any modifications to the input LinkedList.
    * Keep in mind that if any of the N largest values appear more than once in the LinkedList,
    * this method should return remove all instances, so it may remove more than N elements overall.
    * The other elements in the LinkedList should not be modified and their order must not be changed.
    * */
    public static void removeMaximumValues(LinkedList<String> list, int N) {
        if (list == null || N < 0) {
            return;
        } else {
            LinkedList<String> listSorted = new LinkedList(list);
            Collections.sort(listSorted, Collections.reverseOrder());
            //Search for repeated values
            Set<String> nonDups = new LinkedHashSet<>(listSorted);
            Iterator<String> iterator = nonDups.iterator();
            String[] toRemove = new String[nonDups.size()];
            int index = 0;
            while (iterator.hasNext() && index < N){
                toRemove[index] = iterator.next();
                index ++;
            }
            //remove
            for (String word : toRemove) {
                while (list.contains(word)) {
                    list.remove(word);
                }
            }
        }
    }

    /*
    * This method determines whether any part of the first LinkedList contains all elements of the second in the same
    * order with no other elements in the sequence, i.e. it should return true if the second LinkedList is a
    * subsequence of the first, and false if it is not. The method should return false if either input is null or empty.
    * */
    public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
        boolean res = false;
        if ((one.isEmpty() || one == null) || (two.isEmpty() || two == null)) {
        return res;
    } else {
        int firstElementListTwo = two.getFirst();
        if (one.contains(firstElementListTwo)) {
            int initIndex = one.lastIndexOf(firstElementListTwo);
            for (int x = initIndex; x < initIndex + two.size(); x++) {
                for (int y = 0; y < two.size(); y++) {
                    if (one.get(x) == two.get(y)) {
                        res = true;
                    } else res = false;
                }
            }
        }
    }
        return res;
}

    public static void main(String[] args) {
        //1
        System.out.println("Method 1");
        LinkedList<Integer> test = new LinkedList<>();
        test.add(2);
        test.add(7);
        insertSorted(test, 5);
        for (int number : test){
            System.out.println(number);
        }

        //2
        System.out.println("Method 2");
        Integer x = 3;
        LinkedList<String> testing = new LinkedList<>();
        testing.add("Hola");
        testing.add("Mundo");
        testing.add("Test");
        testing.add("Hola");
        removeMaximumValues(testing, 2);
        for (String y : testing) {
            System.out.println("Remaining value after delete: " + y);
        }

        //3
        System.out.println("Method 3");
        LinkedList<Integer> one = new LinkedList<>();
        LinkedList<Integer> two = new LinkedList<>();
        one.add(1);
        one.add(2);
        one.add(3);
        one.add(4);
        one.add(5);
        one.add(6);
        one.add(7);
        one.add(8);
        one.add(9);

        two.add(7);
        two.add(8);
        two.add(9);
        System.out.println(containsSubsequence(one, two));
    }
}
