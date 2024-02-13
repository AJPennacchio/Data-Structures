import java.util.Arrays;

public class TestCase {

    public static void main(String[] args) {
        String[] alphabet = {
                "uniform", "tango", "sierra", "papa", "november",
                "alfa", "whiskey", "quebec", "hotel", "bravo",
                "india", "oscar", "romeo", "x-ray", "delta",
                "echo", "golf", "charlie", "zulu", "yankee",
                "juliett", "foxtrot", "mike", "lima", "victor",
                "kilo"
        };

        StringLinkedList list = new StringLinkedList();
        String[] array = new String[alphabet.length];

        for (int i = 0; i < alphabet.length; i++) {
            list.add(alphabet[i]);
            array[i] = alphabet[i];
        }

        list.mergesort();
        Arrays.sort(array);
        for (int i = 0; i < alphabet.length; i++) {
            String string = list.get(i);
            if (!string.equals(array[i])) {
                throw new AssertionError(
                        "List index " + i + " should be \"" + array[i] + "\" but instead got \"" + string + "\""
                );
            }
        }
    }

}