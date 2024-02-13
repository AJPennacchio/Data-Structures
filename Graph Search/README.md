## Data Structures Programming Assignment 6
### 

For this final coding assignment, you will be writing three graph search algorithms and use them to solve some basic puzzles. This assignment contains a large number of files, so make sure you understand their relationship before starting. The files can be roughly organized into three categories. You will only need to modify the last category of files, but understanding how the files in the first two categories work will help make your implementations easier.

* Puzzles and main entry point (you do not need to modify these)

    * `Main.java` - A test case with both a maze and a sliding puzzle.

    * `MazeState.java` - A class that represents a grid-world maze. See `State` for accessible methods. The constructor takes a single string that describes the maze. The string uses `#` for walls, ` ` (space) for empty space, and `*` for the location of the player, and uses `|` as the row separator. For example, the string `"* # #| ## #|    #|# # #|# # #"` would represent this maze:

        ```
        +-----+
        |* # #|
        | ## #|
        |    #|
        |# # #|
        |# # #|
        +-----+
        ```

    * `SlidingPuzzleState.java` - A class that represents a sliding puzzle. See `State` for accessible methods. The constructor takes a single string that describes the board. Any character can be used for a tile, except for `|` (which represents the end of a row) and ` ` (space) which represents the hole. For example, the string `"182| 43|765"` would represent the board:

        ```
        +---+
        |182|
        | 43|
        |765|
        +---+
        ```

* Basic and utility files (you do not need to modify these)

    * `State.java` - An *abstract class* that represents the state of a puzzle. An abstract class is like a hybrid between an interface and a class - it has normal methods with code, as well as `abstract` methods which has no code. Like interfaces, you cannot directly create an instance of an abstract class, but will need to create other classes that extend the abstract class. All concrete (ie. non-abstract) subclasses must implement all abstract methods.

        This abstract class defines four public methods:

        * `List<Action> getActions()` - Returns a list of actions possible from this state.
        * `int heuristicTo(State goal)` - Calculcates the heuristic to a goal state.
        * `String toString()` - Converts the state to a string.
        * `void print()` - Prints out the state in a pictoral format.

        Both `MazeState` and `SlidingPuzzleState` are concrete subclasses of `State` and implement these four methods.

        <div style="page-break-before:always;">&nbsp;</div>

    * `Action.java` - A class that represents an action. This class contains four public methods:

        * `Action(String name, int cost, State nextState)` - The constructor. Takes a string description (for human readability), an integer cost of that action, and the resulting next `State`.
        * `String toString()` - Returns the name of this action.
        * `int getCost()` - Returns the cost of this action.
        * `State getNextState()` - Returns the next `State` as a result of this action.

    * `Path.java` - A class that represents a path through the problem space graph, or equivalently, as two sequences of `State`s and `Action`s. This class contains six public methods:

        * `Path(State state)` - A constructor, used for a path with just the starting `State`.
        * `Path(Path path, Action nextAction)` - A constructor, used for adding onto existing paths with the next `Action`.
        * `List<State> getStates()` - Returns the list of `State`s in this path.
        * `List<Action> getActions()` - Returns the list of `Action`s in this path.
        * `State getLastState()` - Returns the last `State` in this path.
        * `int getCost()` - Returns the total cost of all `Action`s in this path.

    * `PathPriorityQueue.java` - A priority queue for `Path`s. This avoids the need to use Java's `java.util.PriorityQueue`, which has a non-standard priority queue API. As with a standard priority queue, a higher priority is indicated by a smaller number. This class contains six public methods:

        * `PathPriorityQueue()` - The constructor. Initializes an empty priority queue.
        * `boolean isEmpty()` - Returns `true` if the priority queue is empty.
        * `int size()` - Returns the number of elements in the priority queue.
        * `void add(Path path, int priority)` - Adds a `Path` into the priority queue with the appropriate priority.
        * `Path poll()` - Removes and returns the `Path` with the highest priority.
        * `Path peek()` - Returns, but does not remove, the `Path` with the highest priority.

    * `GraphSearchAlgorithm.java` - An interface that defines a function for graph search. This serves as the interface for the three classes you will modify below. This interface defines one public method:

        * `Path search(State start, State goal)` - A function that, given a start `State` and a goal `State`, finds a `Path` between them. The specific path it finds is up to the implementing class. If no path exists between the start and goal `State`s, this function should return `null`.

* Graph search algorithms (you're writing these!)

    * `DepthFirstSearch.java` - A class that implements `GraphSearchAlgorithm` and performs depth-first search. For the purpose of this assignment, the return value of `State.getActions()` should be explored in reverse order. For example, if `getActions()` returns a list with Up, Down, Left, and Right as possibilities, depth-first search will explore Right, Left, Down, then Up.

    * `BreadthFirstSearch.java` - A class that implements `GraphSearchAlgorithm` and performs breadth-first search. For the purpose of this assignment, the return value of `State.getActions()` should be explored in that order. For example, if `getActions()` returns a list with Up, Down, Left, and Right as possibilities, breadth-first search will explore Up, Down, Left, then Right.

    * `AStarSearch.java` - A class that implements `GraphSearchAlgorithm` and performs A* search.

Although none of the search algorithms are particularly difficult to implement, understanding how the different classes work together may be challenging. For this programming project, you may additionally import the following classes and interfaces from the Java standard library:

* `java.util.List`
* `java.util.Iterator`
* `java.util.ArrayList`
* `java.util.LinkedList`
* `java.util.HashSet`
