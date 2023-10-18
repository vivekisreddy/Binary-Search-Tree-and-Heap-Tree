public class DataBT implements IBinTree {
    int data;
    IBinTree left;
    IBinTree right;

    DataBT(int data, IBinTree left, IBinTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // an alternate constructor for when both subtrees are empty
    DataBT(int data) {
        this.data = data;
        this.left = new MtBT();
        this.right = new MtBT();
    }

    // determines whether this node or node in subtree has given element
    public boolean hasElt(int e) {
        return this.data == e || this.left.hasElt(e) || this.right.hasElt(e);
    }

    // adds 1 to the number of nodes in the left and right subtrees
    public int size() {
        return 1 + this.left.size() + this.right.size();
    }

    // adds 1 to the height of the taller subtree
    public int height() {
        return 1 + Math.max(this.left.height(), this.right.height());
    }


    /**
     * Checks if the current node is less than  the parent value.
     * @return boolean
     */
    @Override
    public boolean isHeap(int min) {
        if (this.data < min) {
            return false;
        } else {
            return left.isHeap(this.data) && right.isHeap(this.data);
        }
    }

    /**
     * Checks if this is a heap. Is root smaller than the rest of the heap. Is each subtree also a heap.
     *
     * @return boolean
     */
    @Override
    public boolean isHeap() {
        return left.isHeap(this.data) && right.isHeap(this.data);
    }

    /**
     * Checks if the result contains all the elements from the original heap
     *
     * @param aTree
     * @return boolean
     */
    @Override
    public boolean hasAllElt(IBinTree aTree) {

        if (aTree.hasElt(this.data)) {
            return this.left.hasAllElt(aTree) && this.right.hasAllElt(aTree);

        } else return false;
    }


    /**
     * Checks if new added element is in the binary tree.
     * @param elt
     * @return boolean
     */
    @Override
    public boolean hasNewEltAdded(int elt) {
        return this.hasElt(elt);
    }


    @Override
    public boolean hasNewEltRemoved(int elt) {
        if (this.data != elt) {
            return true;
        }else return false;
    }


}
