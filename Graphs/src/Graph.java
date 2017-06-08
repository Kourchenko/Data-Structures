public class Graph {

    /**
     * File: Graph.java
     * Author: Diego Kourchenko
     * Created: 06.01.2017
     *
     * Graph - Data Structure
     *
     */

    /* Instance Variables */
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; // vertices list
    private int adjMat[][]; // adjacency matrix
    private int nVerts; // number of vertices;

    /* Shortest Path - sPath */
    private final int INFINITY = 1000000;
    private int nTree; // number of verts in tree
    private DistPar sPath[]; // array for Shortest-Path data
    private int currentVert; // current vertex
    private int startToCurrent; // distance to currentVert;
    private PriorityQ thePQ; // shortest path

    /* Graph - Constructor */
    Graph() {
        // New list of Vertices
        vertexList = new Vertex[MAX_VERTS]; // Max 20 vertices allowed
        adjMat = new int[MAX_VERTS][MAX_VERTS]; // adjacency matrix
        nVerts = 0;

        // Set adjacency matrix
        for (int row=0; row<MAX_VERTS; row++) // row
            for (int col=0; col<MAX_VERTS;col++) // column
                adjMat[row][col] = INFINITY;

        // Shortest Paths list
        sPath = new DistPar[MAX_VERTS];
        thePQ = new PriorityQ();
    } // Graphs Constructor

    public void addVertex(char name) {

        /********************************
         * Add Vertex character to vertexList.
         *******************************/

        vertexList[nVerts++] = new Vertex(name);
    } // void addVertex(char)

    public void addEdge(int start, int end) {

        /********************************
         * Add two way connection between vertices.
         * Default weight of edge (connection) is 1.
         *******************************/

        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    } // void addEdge(int, int)

    public void addEdge(int start, int end, int weight)  {

        /********************************
         * Add two way connection between vertices.
         * Weight of edge (connection) is distance
         * between start and end.
         *******************************/

        adjMat[start][end] = weight;
        adjMat[end][start] = weight;
    } // void addEdge(int, int, int)

    public void addDirectedEdge(int start, int end) {

        /********************************
         * Add one way connection between vertices.
         * Default weight is 1;
         *******************************/

        adjMat[start][end] = 1;
    } // void addDirectedEdge(int, int)

    public void addDirectedEdge(int start, int end, int weight) {

        /********************************
         * Add one way connection between vertices.
         * Set weight;
         *******************************/

        adjMat[start][end] = weight;
    } // void addDirectedEdge(int, int, int)

    public int getAdjUnvisitedVertex(int v) {

        /********************************
         * Get adjacency matrix for unvisited vertices.
         * Check all adjacent values
         * return position in adjacency matrix.
         *******************************/

        for (int j=0; j<nVerts; j++) {
            if (adjMat[v][j] == 1 && !vertexList[j].wasVisited) {
                return j;
            }
        }

        // no unvisited nodes found
        return -1;
    }   // int getAdjUnvisitedNode()

    public void reset() {

        /********************************
         * Reset all visited vertices.
         ********************************/

        for (int i=0; i<nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    } // void reset()

    public void display(int v) {
        /********************************
         * Display the vertex at location, v.
         ********************************/

        System.out.print(vertexList[v].label);
    } // void display(int)

    public void mstw() {

        /******************************
         * Minimum spanning tree.
         * find shortest path to reach all vertices.
         ******************************/

        // Starting vertex at 0
        currentVert = 0;
        nTree = 0;

        while (nTree < nVerts - 1) {
            vertexList[currentVert].wasVisited = true;
            nTree++;

            // insert edges adjacent to currentVert into PQ
            for (int j = 0; j < nVerts; j++) {
                if (j == currentVert) {// skip if it's us
                    continue;
                }

                if (vertexList[j].wasVisited) { // skip if in the tree
                    continue;
                }

                int distance = adjMat[currentVert][j];
                if (distance == INFINITY) { // skip if no edge
                    continue;
                }
                putInPQ(j, distance); // put in PQ (maybe)
            }

            if (thePQ.size() == 0) {
                System.out.println(" GRAPH NOT CONNECTED...");
                return;
            }
            // remove edge with minimum distance, from PQ
            Edge theEdge = thePQ.removeMin();
            int sourceVert = theEdge.srcVert;
            currentVert = theEdge.destVert;

            // display edge from source to current
            System.out.print(vertexList[sourceVert].label);
            System.out.print(vertexList[currentVert].label);
            System.out.print(" ");
        } // end while(not all verts in tree)

        // mst is complete
        // reset vertexList
        reset();

    } // void mstw()

    public void putInPQ(int newVert, int newDist) {

        /********************************
         * Update the distance from vertices,
         * if new distance is shorter.
         * Add new vertex to priority queue given a distance.
         *
         * newVert - new vertex
         * newDist - new distance
         *********************************/

        // is there another edge with the same destination vertex?
        // new vertex in list, return the index of new vertex, if found
        int queueIndex = thePQ.find(newVert);
        if (queueIndex != -1) {                         // got edge's index
            Edge tempEdge = thePQ.peekN(queueIndex);    // get edge
            int oldDist = tempEdge.distance;
            // if new edge is shorter
            if (oldDist > newDist) {
                thePQ.removeN(queueIndex);
                Edge theEdge = new Edge(currentVert, newVert, newDist);
                // insert new shorter edge
                thePQ.insert(theEdge);
            }

        } else { // no edge same destination vertex
            Edge theEdge = new Edge(currentVert, newVert, newDist);
            thePQ.insert(theEdge);
        }

    } // void putInPQ()

    /******************************************************************
     * TODO: Lab 7 - Problem 1
     * Minimum Spanning Tree
     *****************************************************************/

    public void minSpanTree() {

        /**********************************
         * Minimum Spanning Tree.
         *
         * Find the minimum nodes
         * to access all vertices and edges.
         *
         * Display vertex and edge.
         *********************************/

        // Starting point for search
        Stack theStack = new Stack();
        vertexList[0].wasVisited = true;
        theStack.push(0);   // push it

        while (!theStack.isEmpty()) {
            // get an unvisited node adjacent to the stack top
            int currentVertex = theStack.peek();
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) { // if no vertex,
                theStack.pop(); // pop a new one
            } else { // if it exists
                vertexList[v].wasVisited = true;
                display(currentVertex); // display vertex
                display(v); // display connected vertex
                System.out.print(" ");
                theStack.push(v); // have visited, add to stack
            }
        }
        // Reset all values in vertex list
        reset();

    }   // void minSpanTree()

    /*****************************************************************
     * TODO: Lab 7 - Problem 2
     * Connectivity Table
     ****************************************************************/

    public void dfs() {

        /********************************
         * Depth-First Search
         * implemented using a Stack.
         *
         * Start at initial vertex
         * move to any adjacent vertex,
         * checking if that adjacent vertex
         * has a neighbor. If not, remove it
         * from the stack - LIFO.
         *
         *
         * -- Connectivity Table --
         * The following depth-first search
         * is written to perform
         * breadth-first search
         * on each label found in an intial
         * depth-first search.
         *
         * Outputs a connectivity table
         * for a directed graph.
         ********************************/

        Queue theQueue = new Queue();
        Stack theStack = new Stack();

        // Queue for the Connectivity Table
        Queue tempQueue = new Queue();

        /* Start: Depth-First Search Code */
        vertexList[0].wasVisited = true;
        theStack.push(0); // push it
        while (!theStack.isEmpty()) {
            // get an unvisited node adjacent to the stack top
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) { // if no vertex,
                theStack.pop();

            } else { // if it exists
                vertexList[v].wasVisited = true;
                theStack.push(v);
                // Store them into a temporary queue
                tempQueue.insert(v);
            }

        }

        // Reset vertexList
        reset();
        // Line Break
        System.out.println();
        /* End: Depth-First Search Code */

        /* Start: Breadth-First Search */
        int v1;
        int v2;

        // Starting point for search
        tempQueue.insert(0);

        // DFS
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = true;  // mark it
            display(i); // display the vertex
            theQueue.insert(i);

            // BFS on vertex
            while (!theQueue.isEmpty()) {
                v1 = theQueue.remove();

                // Check for and display vertex neighbors
                while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                    vertexList[v2].wasVisited = true; // mark it
                    display(v2); // display it
                    theQueue.insert(v2); // insert into queue
                } // no more unvisited vertices

            } // end BFS on vertex

            // Reset vertexList
            reset();
            // Line Break
            System.out.println();
        } // end DFS
        /* END: Breadth-First Search */

        // Reset vertexList
        reset();
    }   // void dfs()

    public void bfs() {

        /********************************
         * Breadth-First Search
         * implemented using a Queue.
         *
         * Start at initial
         * vertex, displaying all of it's
         * neighbors, add it to a queue - FIFO.
         *********************************/

        Queue theQueue = new Queue();

        // Starting point for search
        vertexList[0].wasVisited = true;  // mark it
        display(0); // display the vertices
        theQueue.insert(0); // order of visited nodes

        int v1;
        int v2;
        // Until vertex 1, v1, it has no neighbors,
        // display the neighbor, v2
        while (!theQueue.isEmpty()) {
            v1 = theQueue.remove();

            while ((v2=getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true; // mark it
                display(v2); // display it
                theQueue.insert(v2); // insert into queue
            }
        }

        // no more neighbors,
        // the queue is empty so we're done,
        // reset all values
        for (int j = 0; j<nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
    }   // void bfs()

    /****************************************************************
     * TODO: Lab 7 - Problem 3
     * Shortest Path for all vertices.
     *****************************************************************/

    public void path() {

        /**********************************
         * Find the shortest path
         * for a given vertex
         * to all other vertices.
         *********************************/

        // Get shortest path of every vertex

        for (int i=0; i<nVerts; i++) {
            vertexList[i].wasVisited = true;
            nTree = 1; // put it in tree

            // transfer row of distances from adjMat to sPath
            for (int j=0; j<nVerts; j++) {
                int tempDist = adjMat[i][j];
                sPath[j] = new DistPar(i, tempDist);
            }

            // until all vertices are in the tree
            while (nTree < nVerts) {
                int indexMin = getMin(); // get minimum from sPath
                int minDist = sPath[indexMin].distance;

                if (minDist == INFINITY) { // if all infinite
                    System.out.print("");
                    break; // sPath is complete
                } else {
                    currentVert = indexMin; // reset currentVert to closest vert
                    startToCurrent = sPath[indexMin].distance;
                    // minimum distance from startTree is
                    // to currentVert, and is startToCurrent
                }

                vertexList[currentVert].wasVisited = true;
                nTree++;
                adjust_sPath(); // update sPath[] array

            } // end while(nTree<nVerts)

            displayPaths(); // display sPath[] contents
            nTree = 0; // clear tree
            // Reset vertexList
            reset();
        }

        reset();
    } // void path()

    public int getMin() {
        /**********************************
         * Get minimum path
         *********************************/
        int minDist = INFINITY;
        int indexMin = 0;
        for (int j=1; j<nVerts; j++) {
            if (!vertexList[j].wasVisited && sPath[j].distance < minDist) {
                minDist = sPath[j].distance;
                indexMin = j;
            }
        }
        return indexMin;
    } // int getMin()

    public void adjust_sPath() {

        /********************************
         * Adjust values in shortest-path array, sPath
         *********************************/

        int column = 1;
        while (column < nVerts) {
            // if this column's vertex already in tree, skip it
            if (vertexList[column].wasVisited) {
                column++;
                continue;
            }

            // calculate distance for one sPath entry
            // get edge from currentVert to column
            int currentToFringe = adjMat[currentVert][column];
            // add distance from start
            int startToFringe = startToCurrent + currentToFringe;
            int sPathDist = sPath[column].distance;

            // compare distance from start with sPath entry
            if (startToFringe < sPathDist) { // if shorter
                sPath[column].parentVert = currentVert;
                sPath[column].distance = startToFringe;
            }

            column++;
        } // end while(column<nVerts)
    } // void adjust_sPath()

    public void displayPaths() {
        /********************************
         * Display contents of sPath[]
         ********************************/
        for(int j=0; j<nVerts; j++)
        {
            System.out.print(vertexList[j].label + "=");
            if(sPath[j].distance == INFINITY)
                System.out.print("inf");
            else
                System.out.print(sPath[j].distance);
            char parent = vertexList[ sPath[j].parentVert ].label;
            System.out.print("(" + parent + ") \t");
        }
        System.out.println("");
    } // void displayPaths()

    public static void main(String[] args) {

        String dots = ".........................";

        // ====================================================
        //          Minimum Spanning Tree - Test
        // ====================================================
        System.out.println("Testing Minimum Spanning Tree");
        System.out.println(dots+dots+'\n');
        Graph theGraph = new Graph();
        System.out.print("...adding Vertices: A-E\n");
        // Add five vertices
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');

        System.out.println("...connecting Vertices...");
        // Create four edges
        // Connecting the five vertices
        theGraph.addEdge(0, 1, 1);     // AB
        theGraph.addEdge(1, 2, 1);     // BC
        theGraph.addEdge(0, 3, 1);     // AD
        theGraph.addEdge(3, 4, 1);     // DE

        System.out.println("Connected!");
        System.out.print("Expected Result s/b: AB BC AD DE  -- ");
        theGraph.minSpanTree();
        System.out.println();
        System.out.println();

        // ====================================================
        //  Minimum Spanning Tree, 9 vertices 12 edges - Test
        // ====================================================
        System.out.println("Testing 9 vertices and 12 edges...");

        System.out.print("...adding Vertices: F-I\n");
        // Add four more vertices
        theGraph.addVertex('F');
        theGraph.addVertex('G');
        theGraph.addVertex('H');
        theGraph.addVertex('I');

        System.out.println("...connecting Vertices...");
        // Add 7 more edge connections
        theGraph.addEdge(0, 4, 1); // AE
        theGraph.addEdge(0, 7, 1); // AH
        theGraph.addEdge(0, 2, 1); // AC
        theGraph.addEdge(2, 5, 1); // CF
        theGraph.addEdge(2, 8, 1); // CI
        theGraph.addEdge(3, 7, 1); // DH
        theGraph.addEdge(4, 8, 1); // EI

        System.out.println("Connected!");
        System.out.print("Expected Result s/b: AB BC CF CI IE ED DH -- ");

        theGraph.minSpanTree();

        System.out.println();
        System.out.println();

        // ====================================================
        //              Connectivity Table - Test
        // ====================================================
        System.out.println("Testing Directed Graph - Connectivity Table");
        System.out.println(dots+dots+'\n');
        Graph directedGraph = new Graph();

        directedGraph.addVertex('A');
        directedGraph.addVertex('B');
        directedGraph.addVertex('C');
        directedGraph.addVertex('D');
        directedGraph.addVertex('E');
        directedGraph.addDirectedEdge(1, 0); // BA
        directedGraph.addDirectedEdge(0, 2); // AC
        directedGraph.addDirectedEdge(1, 4); // BE
        directedGraph.addDirectedEdge(3, 4); // DE
        directedGraph.addDirectedEdge(4, 2); // EC

        System.out.print("Minimum span tree s/b: \n" +
                "AC\n" +
                "BAEC\n" +
                "C\n" +
                "DEC\n" +
                "EC\n" +
                "\n--\n");
        directedGraph.dfs();
        System.out.println();

        // ====================================================
        //                Shortest Path - Test
        // ====================================================
        System.out.println("Testing shortest path - directed");
        System.out.println(dots+dots);
        Graph sPGraph = new Graph();

        sPGraph.addVertex('A');
        sPGraph.addVertex('B');
        sPGraph.addVertex('C');
        sPGraph.addVertex('D');
        sPGraph.addVertex('E');

        sPGraph.addDirectedEdge(0, 1, 50);
        sPGraph.addDirectedEdge(0, 3, 80);
        sPGraph.addDirectedEdge(1, 2, 60);
        sPGraph.addDirectedEdge(1, 3, 90);
        sPGraph.addDirectedEdge(2, 4, 40);
        sPGraph.addDirectedEdge(3, 2, 20);
        sPGraph.addDirectedEdge(3, 4, 70);
        sPGraph.addDirectedEdge(4, 1, 50);

        System.out.println();
        System.out.println("Shortest path ");
        sPGraph.path();

    } // void main(String[])

} // Class Graph
