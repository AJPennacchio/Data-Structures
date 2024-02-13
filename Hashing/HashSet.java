import java.util.Arrays;

public class HashSet {

    private int[] values;
    private int ratio;
    private ProbeStrategy strategy;
    private int size;

    public int size(){
        return this.size;
    }

    public HashSet(int initArrayLength, int ratio, ProbeStrategy strategy) {
        this.values = new int[initArrayLength];
        this.ratio = ratio;
        this.strategy = strategy;

        for(int i = 0; i < initArrayLength; i++){
            this.values[i] = -1;
        }

        this.size = 0;

    }

    public boolean add(int value) {
        if(contains(value)){
            return false;
        } else{

            if(values[value % values.length] < 0){
                values[value % values.length] = value;
            } else{
                int numAttempts = 1;
                int i = strategy.probe(values.length, value % values.length, numAttempts);

                while(values[i] >= 0 && numAttempts <= values.length){
                    numAttempts++;
                    i = strategy.probe(values.length, value % values.length, numAttempts);
                }

                values[i] = value;
            }

            size++;

            if(values.length <= ratio * size){
                values = resize();
            }
        }
        return true;
    }

    private int[] resize(){
        int[] newArr = new int[2 * values.length + 1];

        Arrays.fill(newArr, -1);

        for(int i = 0; i < values.length; i++){
            int numAttempts = 0;

            if(values[i] != -1) {
                int j = strategy.probe(newArr.length, values[i], numAttempts);

                while(newArr[j] >= 0){
                    numAttempts++;
                    j = strategy.probe(newArr.length, values[i], numAttempts);
                }

                newArr[j] = values[i];
            }
        }

        return newArr;
    }

    public boolean contains(int value) {
        int origHash = value % values.length;
        int numAttempts = 0;
        int i = strategy.probe(values.length, origHash, numAttempts);

        while(values[i] != -1){
            if(values[i] == value){
                return true;
            }
            numAttempts++;
            i = strategy.probe(values.length, origHash, numAttempts);
        }

        return false;
    }

    public boolean remove(int value) {
        int origHash = value % values.length;
        int numAttempts = 0;
        int i = strategy.probe(values.length, origHash, numAttempts);

        while(values[i] != -1){
            if(values[i] == value){
                values[i] = -2;
                size--;
                return true;
            }
            numAttempts++;
            i = strategy.probe(values.length, origHash, numAttempts);
        }

        return false;
    }

    public int[] toArray() {
        int[] result = new int[this.values.length];
        for (int i = 0; i < this.values.length; i++) {
            result[i] = this.values[i];
        }
        return result;
    }

    private void printArray(){
        for(int i = 0; i < values.length; i++){
            System.out.println(values[i]);
        }
    }

    public static void main(String[] args) {


        System.out.println("Linear Probe Tests");

        System.out.println("Add Elements");

        HashSet set = new HashSet(10, 3, new LinearProbeStrategy());
        set.add(5);
        set.add(7);
        set.add(15);
        set.printArray();

        System.out.println("Resize + Add Tests");
        set.add(25);
        set.add(35);
        set.add(45);
        set.printArray();

        System.out.println("Contains Tests");

        System.out.println(set.contains(2));
        System.out.println(set.contains(15));
        System.out.println(set.contains(7));
        System.out.println(set.contains(45));
        set.printArray();


        System.out.println("Remove Tests");

        set.remove(5);
        set.remove(4);
        set.remove(35);
        set.remove(45);
        set.printArray();

        System.out.println("Quadratic Probe Tests");
        System.out.println("Add Elements");

        HashSet qset = new HashSet(10, 3, new QuadraticProbeStrategy());
        qset.add(5);
        qset.add(7);
        qset.add(15);
        qset.printArray();

        System.out.println("Resize + Add Tests");
        qset.add(25);
        qset.add(45);
        qset.add(66);
        qset.printArray();



    }
}
