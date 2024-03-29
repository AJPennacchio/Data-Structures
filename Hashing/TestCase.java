import java.util.TreeSet;

public class TestCase {

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = {
                300, -300, 251, 348, -251, 285, -348, 229, 198, -285, 339, 279, 56, 400, -339, 349, -349, 237, 247, -247, -400, 94, -56, -94, 291, 75, 210, 219, 179, -229, -210, 164, -219, -75, -179, -237, 189, 357, -164, 177, 116, 245, 384, 249, -116, 256, -198, 267, -245, -357, -267, -279, -256, -384, 96, 140, 111, 330, 359, -140, 274, 148, 218, 113, 122, -291, -177, 124, -330, -122, 302, -218, 168, 56, -189, 111, 275, 220, 347, 189, -275, 221, 226, -56, -226, 403, -403, 284, 331, -124, -96, 155, 355, -155, -302, -111, -284, 293, 357, -331,
                227, -148, -221, -189, 169, -220, -359, 159, 188, -113, -293, 87, 336, 86, 114, -274, -188, -159, 377, 119, -357, 139, 122, -114, -87, -227, 242, 308, -249, 139, -86, 129, 226, 279, -355, -139, 44, 143, -279, -308, 300, 104, -242, -44, 129, -226, 137, 209, -129, 79, -104, -300, 105, 330, -105, -209, 194, -122, -330, 251, 188, 333, 218, -218, 270, -169, 99, 110, 43, 229, 200, -99, 388, 223, 185, -333, -110, 258, 72, -270, -79, 329, -200, 300, -388, -194, 192, 388, -347, -192, -229, -185, -168, 223, 143, 161, 309, -143, -258, -251,
                -300, -72, -336, -43, -223, 302, -137, 174, 242, 193, -161, 340, 325, -325, -329, 145, -340, 101, -101, 211, 231, 254, 200, 179, 369, -145, -231, 377, 96, 97, -242, -96, -193, 209, 119, 293, -369, -119, -174, 369, -388, 232, 294, -254, 127, -294, 222, 124, -211, -309, 242, 379, 405, -377, 210, 89, -379, -302, 326, 54, -405, 323, 217, -200, 46, 400, 334, 71, -293, -323, -188, 150, -217, 74, -74, -124, -334, 183, -54, 216, -179, -183, 51, 138, -150, -216, -89, -138, 254, -209, 305, -46, -97, -400, 146, 287, 99, 149, 263, -287,
                -222, 220, 164, 284, 149, -242, 235, -220, -146, -127, 64, -210, 314, -326, -263, -164, -235, -99, 369, 97, -314, 242, 387, 293, 243, 195, 292, -305, -64, -254, -195, -51, -232, -243, 144, -387, -71, 243, 218, 289, 49, -149, 357, 175, -144, 190, 172, -175, -49, -243, 189, 332, 225, -289, -357, -190, 87, -369, -284, -332, -292, -172, 380, -189, 369, -225, 163, 126, 126, 362, 46, -218, 364, 267, -364, -362, 244, -87, 198, 72, 142, -198, 189, -142, -72, -293, -380, 259, -126, -267, 122, -46, -122, 348, -242, 334, 255, -97, 368, -189,
                99, 227, -259, 106, -99, 241, -369, -368, 216, -244, 150, 68, 190, -150, 325, 148, -227, 316, 102, 180, -316, 268, -180, -68, 59, -241, 45, -148, -163, -190, 89, -348, 394, -255, 104, 207, 104, -268, -59, 297, 153, -334, 192, 243, 308, 183, -89, -394, -153, 97, 304, 278, -297, 283, 338, 52, -106, 383, -308, -283, -102, -104, 380, 216, -278, -216, 233, -183, 270, 217, 384, 44, 400, 405, -233, 186, 84, -217, -325, -186, 219, 334, -334, 391, 248, 104, 326, -304, 58, 271, 286, -207, -400, 325, -219, 133, -58, -84, 191, -325,
                325, 226, -133, -271, 93, 254, -325, -45, 304, 68, -383, -286, 171, 302, 289, 273, -171, -93, 323, -323, -104, 161, -97, 217, 199, 273, 250, -384, 397, 112, -191, -112, -380, -391, 53, 282, 116, -405, 49, -250, 347, 229, -289, 136, -68, -161, -397, -243, 173, -199, 242, -326, 258, 136, -217, -258, 369, 77, -282, -302, 137, 80, -49, 303, 406, -52, 357, -304, -229, 111, -192, 308, -248, 227, -308, -406, 322, 255, 276, -322, -77, 242, -136, 289, 96, 256, -303, -256, -289, -276, -227, -369, -80, 241, -255, -226, -111, -338, 373, -173,
                -242, -137, -241, -373, -347, 364, -53, 387, 253, 53, -364, 214, 57, -273, 160, -254, -57, 308, 316, -308, -44, -316, 166, -357, -160, -116, -166, -214, -53, 242, 372, -242, 74, -96, 388, -253, 199, 323, 212, -388, 85, 212, -372, 109, -323, 199, -270, -74, 331, 78, -387, -212, 317, 229, -317, -331, 404, -78, -109, 384, 145, 65, -229, 403, 258, -404, -384, -199, -258, 81, -85, -81, -65, -403, -145, 392, 234, -234, 241, -241, 231, -392, -231, 328, 122, 340, -340, 77, 402, 403, -328, -403, -122, -77, 146, -146, -402, 173, -173, 94,
                315, 196, -196, 254, 366, 51, -366, 223, -51, -223, 129, -315, -129, 96, 235, 259, 383, 137, -259, 383, 328, 166, 196, 290, -254, -290, 145, 173, -145, 189, -189, 128, 66, -166, 279, -328, -196, 244, -128, -235, -94, 115, 167, 139, 55, 284, 158, -284, -115, -173, -279, 157, 373, 293, 92, 322, -158, -157, 139, 271, 366, -383, 293, -96, -244, -137, 275, 185, -293, -322, -185, -366, -271, -92, 111, 161, 97, 406, 208, 352, -97, -352, 236, -139, -161, -373, 300, 150, -150, 196, -66, 239, -275, -167, -196, 217, 404, -404, 190, -300,
                -236, -406, -190, -239, 309, 395, -208, -111, -55, 276, -395, -217, -309, 43, -43, 101, 318, 180, -180, -101, -318, 43, 144, 214, 292, 333, 236, -236, -292, 140, -333, -140, 207, -214, 192, -192, -43, -207, -276, -144, 301, 373, -373, 361, 405, -361, -405, 237, -237, 63, -63, 301, -301, 185, 186, -185, 90, 258, -90, -186, 67, -258, 310, 96, -96, 58, -67, 289, 54, 152, -152, 309, 353, 143, -309, -289, -54, -143, -310, -58, 389, 299, 123, -389, 83, 395, -395, 154, -83, -353, -154, -123, -299, 172, 212, -212, -172, 88, -88, 344,
                361, -361, 70, 199, 99, 320, 349, 117, -320, 260, 107, -349, 147, 364, 365, 47, 77, -117, 363, -363, 314, -314, -99, 126, -364, -47, 203, 67, 153, 309, -203, -199, -70, -365, 349, 381, 387, 264, 232, -260, -107, -309, -264, 124, -126, 128, 351, 308, 111, 330, -77, 187, 82, 302, -67, 155, 97, -349, -111, 409, -330, 75, -153, -97, 387, -128, -381, -387, 245, -75, -344, 162, 226, 130, -124, 167, -226, 204, -232, -162, 393, 93, -147, 358, -187, 108, -93, -82, 381, -108, 71, 48, -71, 331, 363, 325, 321, 170, 384, 217
        };

        HashSet set = new HashSet(29, 1, new LinearProbeStrategy());
        TreeSet<Integer> refset = new TreeSet<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            boolean add = true;
            if (number < 0) {
                number *= -1;
                add = false;
            }
            boolean actual;
            boolean expected;
            if (add) {
                actual = set.add(number);
                expected = !refset.contains(number);
                refset.add(number);
                System.out.println("added " + number);
            } else {
                actual = set.remove(number);
                expected = refset.contains(number);
                refset.remove(number);
                System.out.println("removed " + number);
            }
            if (actual != expected) {
                System.out.println("adding/removing " + number + " should be " + expected + " but got " + actual);
                throw new AssertionError();
            }
            if (set.size() != refset.size()) {
                System.out.println("size() should be " + (refset.size()) + " but got " + set.size());
                throw new AssertionError();
            }
            for (Integer contained : refset) {
                if (!set.contains(contained)) {
                    System.out.println("contains(" + contained + ") should return true but got false");
                    throw new AssertionError();
                }
            }
        }
    }
}