import p1.ListNode;

public class ListFunctions {

    /**
     * Return true if the list is empty.
     *
     * Examples:
     *
     * * isEmpty(makeList()) should return true
     * * isEmpty(makeList(0)) should return false
     *
     * @param list The list.
     * @return True if the list is empty; false otherwise.
     */
    public static boolean isEmpty(ListNode list) {
        if(list != null){
            return false;
        }
        return true;
    }

    /**
     * Get the number of elements in the list.
     *
     * Examples:
     *
     * * size(makeList()) should return 0
     * * size(makeList(0, 1)) should return 2
     *
     * @param list The list.
     * @return The size of the list.
     */
    public static int size(ListNode list) {
        int size = 0;
        return size(list, size);

    }
    private static int size(ListNode node, int size){
        if(node != null){
            size++;
            return size(node.getRest(), size);
        } else{
            return size;
        }
    }

    /**
     * Get the element at the index.
     *
     * The index is assumed to be in range.
     *
     * Examples:
     *
     * * get(makeList(0, 1, 4, 9), 2) should return 4
     *
     * @param list The list.
     * @param index The index of the desired element.
     * @return The element at the index.
     */
    public static int get(ListNode list, int index) {
        return get(list, index, 0);
    }

    private static int get(ListNode node, int index, int curIndex) {
        if(curIndex != index){
            curIndex++;
            return get(node.getRest(), index, curIndex);
        } else{
            return (int) node.getFirst();
        }
    }

    /**
     * Get the index of the first occurrence of the element.
     *
     * Examples:
     *
     * * indexOf(makeList(0, 3, 3, 4), 3) should return 1
     *
     * @param list The list
     * @param element The element.
     * @return The index of the first occurrence element, or -1 if it is not in
     *   the list.
     */
    public static int indexOf(ListNode list, int element) {
        return indexOf(list, element, 0);
    }

    private static int indexOf(ListNode list, int element, int index) {
        if(list == null){
            return -1;
        } else if(element == (int)list.getFirst()){
            return index;
        } else{
            index++;
            return indexOf(list.getRest(), element, index);
        }

    }

    /**
     * Get the index of the last occurrence of the element.
     *
     * Examples:
     *
     * * lastIndexOf(makeList(0, 3, 3, 4), 3) should return 2
     *
     * @param list The list
     * @param element The element.
     * @return The index of the last occurrence element, or -1 if it is not in
     *   the list.
     */
    public static int lastIndexOf(ListNode list, int element) {
        return lastIndexOf(list, element, 0, -1);
    }

    private static int lastIndexOf(ListNode list, int element, int index, int holder) {
        if(list != null){

            if(element == (int)list.getFirst()){
                holder = index;
            }

            index++;
            return lastIndexOf(list.getRest(), element, index, holder);

        } else{
            return holder;
        }

    }

    /**
     * Return true if the two lists are the same.
     *
     * Examples:
     *
     * * equals(makeList(1, 2), makeList(1, 2)) should return true
     * * equals(makeList(1, 2), makeList(1, 1)) should return false
     *
     * @param list1 The first list.
     * @param list2 The second list.
     * @return True if the lists are equal; false otherwise.
     */
    public static boolean equals(ListNode list1, ListNode list2) {
        if((list1 != null) && (list2 != null)){

            if((int)list1.getFirst() != (int)list2.getFirst()){
                return false;
            } else{
                return equals(list1.getRest(), list2.getRest());
            }
        } else{
            if((list1 == null) && (list2 == null)){
                return true;
            } else{
                return false;
            }
        }

    }

    /**
     * Create a new, reversed list.
     *
     * Examples:
     *
     * * reverse(makeList(1, 2, 3)) should be equivalent to makeList(3, 2, 1)
     *
     * @param list The list to reverse.
     * @return A new list that is reversed of the argument.
     */
    public static ListNode reverse(ListNode list) {
        return reverse(list, null);
    }

    private static ListNode reverse(ListNode list, ListNode next) {
        if(list != null){
            ListNode cur = new ListNode(list.getFirst(), next);
            next = cur;
            return reverse(list.getRest(), next);
        } else{
            return next;
        }
    }

    /**
     * Get the first n elements of a list.
     *
     * n is assumed to between 0 and the size of the list, inclusive.
     *
     * Examples:
     *
     * * headList(makeList(1, 2, 3, 4), 2) should be equivalent to
     *   makeList(1, 2)
     *
     * @param list The list.
     * @param n The number of elements to get.
     * @return The head list of the specified size.
     */
    public static ListNode headList(ListNode list, int n) {
        return headList(list, n, 0, null);

    }

    private static ListNode headList(ListNode list, int n, int index, ListNode next) {

        if(index != n){
            ListNode cur = new ListNode(list.getFirst(), next);
            next = cur;
            index++;
            return headList(list.getRest(), n, index, next);
        } else{
            return reverse(next);
        }

    }

    /**
     * Get the last n elements of a list.
     *
     * n is assumed to between 0 and the size of the list, inclusive.
     *
     * Examples:
     *
     * * tailList(makeList(1, 2, 3, 4), 2) should be equivalent to
     *   makeList(3, 4)
     *
     * @param list The list.
     * @param n The number of elements to get.
     * @return The tail list of the specified size.
     */
    public static ListNode tailList(ListNode list, int n) {

        ListNode revList = reverse(list);
        return reverse(headList(revList, n));
    }

    /**
     * Get the slice of the list between the start and end indices.
     *
     * start and end are assumed to be between 0 and the size of
     * the list, inclusive, and that start <= end.
     *
     * Examples:
     *
     * * subList(makeList(1, 2, 3, 4), 1, 3) should be equivalent to
     *   makeList(2, 3)
     *
     * @param list The list.
     * @param start The first index to include in the slice.
     * @param end The first index to exclude from the slice.
     * @return The slice of the list between the start and end indices.
     */
    public static ListNode subList(ListNode list, int start, int end) {
        return subList(list, start, end, 0);
    }

    private static ListNode subList(ListNode list, int start, int end, int index) {
        if(index < start){
            index++;
            return subList(list.getRest(), start, end, index);
        } else{
            return headList(list, end - index);
        }

    }

    /**
     * Add an element at the end of the list.
     *
     * * add(makeList(1, 2), 3) should be equivalent to makeList(1, 2, 3)
     *
     * @param list The list.
     * @param element The element to add.
     * @return The list with the new element added.
     */
    public static ListNode add(ListNode list, int element) {
        ListNode rev = reverse(list);
        ListNode node = new ListNode(element, rev);
        return reverse(node);

    }

    /**
     * Add all of the second list to the end of the first list.
     *
     * * addAll(makeList(1, 2), makeList(3, 4)) should be equivalent to
     *   makeList(1, 2, 3, 4)
     *
     * @param list1 The first list.
     * @param list2 The second list.
     * @return A new list that combines the two lists.
     */
    public static ListNode addAll(ListNode list1, ListNode list2) {
        if(list2 != null){
            list1 = add(list1, (int)list2.getFirst());
            return addAll(list1, list2.getRest());
        }
        return list1;
    }

}