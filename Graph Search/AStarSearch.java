import java.util.List;
import java.util.ArrayList;

public class AStarSearch implements GraphSearchAlgorithm {

    public Path search(State start, State goal) {
        PathPriorityQueue pq = new PathPriorityQueue();
        pq.add(new Path(start), start.heuristicTo(goal));

        ArrayList<State> visitedPath = new ArrayList<State>();

        while(!pq.isEmpty()){
            Path orig = pq.poll();
            State search = orig.getLastState();
            visitedPath.add(search);

            if(search.equals(goal)){
                return orig;
            }

            List<Action> actions = search.getActions();


            while(!actions.isEmpty()){
                Action action = actions.get(0);
                State move = action.getNextState();

                if(!visitedPath.contains(move)){
                    pq.add(new Path(orig, action), action.getCost() + move.heuristicTo(goal));
                }
                actions.remove(action);
            }


        }

        return null;
    }



}
