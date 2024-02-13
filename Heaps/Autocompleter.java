import java.util.ArrayList;

public class Autocompleter {
        
	static class Node {
            char value;
            ArrayList<Node> children;

            Node(char value){
                this.value = value;
                this.children = new ArrayList<Node>();
            }
            public Node addChild(char value){
                Node child = new Node(value);
                this.children.add(child);
                return child;
            }
        }
        
        Node rootNode = new Node('*'); // use '*' for root and terminal nodes
       
        /**
         * Constructor
         * TODO: what am I doing?
         */
        Autocompleter(String[] variables){
            for (int i=0; i < variables.length; i++) {
                String variable = variables[i];
                this.addVariable(variable);
            }
        }
        /**
         * @param variable the variable string being added to autocompleter
         */
        public void addVariable(String variable) {
            char[] charVar = variable.toCharArray();
            this.recursiveAddVariable(charVar, 0, this.rootNode);
        }
        /**
         * @param chars an array of chars to be added
         * @param index an integer, identifying which char index we are at (to avoid copying the array)
         * @param root the current node
         */
        protected void recursiveAddVariable(char[] chars, int index, Node root) {
            char currChar = chars[index];
            Node newRoot = null;
            for (int i=0; i < root.children.size(); i++) {
                Node child = root.children.get(i);
                if (child.value == currChar) {
                    newRoot = child;
                    break;
                }
            }
            if (newRoot == null) {
                newRoot = root.addChild(currChar);
            }
            if (index < chars.length - 1) {
                this.recursiveAddVariable(chars, index+1, newRoot);
            } else {
                newRoot.addChild('*'); // terminal node
            }
        }
        /**
         * @param prefix the prefix of variables to find
         * @return an ArrayList of possible variables
         */
        public ArrayList<String> find(String prefix){
            ArrayList<String> all = new ArrayList<String>();
            all = find("", this.rootNode, all);

            ArrayList<String> answer = new ArrayList<String>();
            for(int i = 0; i < all.size(); i++){
                if(all.get(i).substring(0, prefix.length()).equals(prefix) ){
                    answer.add(all.get(i));
                }
            }

            return answer;
        }

        private ArrayList<String> find(String prefix, Node node, ArrayList<String> answer) {

            if(node.value == '*' && node != this.rootNode) {
                answer.add(prefix);
            }

            for(int i = 0; i < node.children.size(); i++) {
                if(node.children.get(i) != null) {
                    if(node.value != '*') {
                        find(prefix + node.value, node.children.get(i), answer);
                    } else{
                        find(prefix, node.children.get(i), answer);
                    }
                }
            }

            return answer;
        }



    public static void main(String[] args) {
            Autocompleter autocomplete = new Autocompleter(
                new String[] {"apple", "apricot", "banana", "banjo", "bingo"}
            );
            
            System.out.println(autocomplete.find("ap")); // should return ["apple", "apricot"]
            
            System.out.println(autocomplete.find("apr")); // should return ["apricot"]
           
            System.out.println(autocomplete.find("c"));  // should return []
            
            System.out.println(autocomplete.find("b")); // should return ["banana", "banjo", "bingo"]
            
            System.out.println(autocomplete.find("bingo")); // should return ["bingo"]
        }
	}

