
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;


public class BreadthFirstSearch implements GraphSearchAlgorithm {

    public Path search(State start, State goal) {
        ArrayList<State> visitedStates = new ArrayList<State>();
        visitedStates.add(start);

        LinkedList<Path> queue = new LinkedList<Path>();
        queue.add(new Path(start));

        while(queue.size() != 0){
            Path orig = queue.poll();

            State search = orig.getLastState();
            if(search.equals(goal)){
                return orig;
            }

            List<Action> actions = search.getActions();

            while(!actions.isEmpty()){
                Action action = actions.get(0);
                State move = action.getNextState();
                if(!visitedStates.contains(move)){
                    visitedStates.add(move);
                    queue.add(new Path(orig, action));
                }

                actions.remove(action);
            }


        }

        return null;
    }

}
