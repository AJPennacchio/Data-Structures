
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class DepthFirstSearch implements GraphSearchAlgorithm {

    public Path search(State start, State goal) {
        ArrayList<State> visitedStates = new ArrayList<State>();
        visitedStates.add(start);

        LinkedList<Path> stack = new LinkedList<Path>();
        stack.add(0, new Path(start));

        while(!stack.isEmpty()){

            Path p = stack.remove(0);
            State search = p.getLastState();

            if(search.equals(goal)){
                return p;
            }

            if(!visitedStates.contains(search)){
                visitedStates.add(search);
            }


            List<Action> actions = search.getActions();
            while(!actions.isEmpty()){
                State move = actions.get(0).getNextState();
                if(!visitedStates.contains(move)){
                    stack.add(0, new Path(p, actions.get(0)));

                }
                actions.remove(0);

            }

        }

        return null;
    }



}
