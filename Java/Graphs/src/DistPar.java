class DistPar {

    /**
     * Distance and parent.
     */

    public int distance; // distance from start to this vertex
    public int parentVert; // current parent of this vertex

    DistPar(int pv, int d) {
        distance = d;
        parentVert = pv;
    }

} // Class DistPar
