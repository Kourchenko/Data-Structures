class Vertex {
    /**
     * Vertex for a Graph Data Structure.
     *
     * Vertex
     * - char label
     * - boolean wasVisited
     */

    /* Instance variables */
    public char label; // 'A', 'B', 'C'...
    public boolean wasVisited; // keep track for searching

    /* Constructor */
    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }   // Constructor

}   // Class Vertex

