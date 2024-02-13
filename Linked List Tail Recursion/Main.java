import p1.ListNode;

public class Main {

    public static void main(String[] args){
       int[] testFull = {1,2,3,2,4};
       ListNode headFull = ListFunctionsTestUtils.makeList(testFull);

        int[] testFull2 = {0, 5, 3};
        ListNode headFull2 = ListFunctionsTestUtils.makeList(testFull2);

        int[] testEmpty = {};
        ListNode headEmpty = ListFunctionsTestUtils.makeList(testEmpty);


       System.out.println("isEmpty() tests");
       System.out.println(ListFunctions.isEmpty(headFull));
       System.out.println(ListFunctions.isEmpty(headEmpty));

       System.out.println("size() tests");
       System.out.println(ListFunctions.size(headFull));
       System.out.println(ListFunctions.size(headEmpty));

        System.out.println("get() tests");
        System.out.println(ListFunctions.get(headFull, 0));
        System.out.println(ListFunctions.get(headFull, 2));

        System.out.println("indexOf() tests");
        System.out.println(ListFunctions.indexOf(headFull, 3));
        System.out.println(ListFunctions.indexOf(headFull, 4));

        System.out.println("lastIndexOf() tests");
        System.out.println(ListFunctions.lastIndexOf(headFull, 2));
        System.out.println(ListFunctions.lastIndexOf(headFull, 5));

        System.out.println("equals() tests");
        System.out.println(ListFunctions.equals(headFull, headFull));
        System.out.println(ListFunctions.equals(headFull, headFull2));

        System.out.println("reverse() tests");
        ListNode rev = ListFunctions.reverse(headFull);
        ListFunctionsTestUtils.viewer(rev);
        System.out.println();

        System.out.println("headList() tests");
        ListNode headList = ListFunctions.headList(headFull, 4);
        ListFunctionsTestUtils.viewer(headList);
        System.out.println();

        System.out.println("tailList() tests");
        ListNode tailList = ListFunctions.tailList(headFull, 4);
        ListFunctionsTestUtils.viewer(tailList);
        System.out.println();

        System.out.println("subList() tests");
        ListNode sub = ListFunctions.subList(headFull, 1, 3);
        ListFunctionsTestUtils.viewer(sub);
        System.out.println();

        System.out.println("add() tests");
        ListNode add = ListFunctions.add(headFull, 8);
        ListFunctionsTestUtils.viewer(add);
        System.out.println();

        System.out.println("addAll() tests");
        ListNode comb = ListFunctions.addAll(headFull, headFull2);
        ListFunctionsTestUtils.viewer(comb);
        System.out.println();


    }

}
