public class HeapChecker {

    public boolean addEltValidator(IHeap hOrig, int elt, IBinTree hAdded){

        //Is this a heap
        //Is root smaller than the rest of the heap
        //Is each subtree also a heap
        if(!hAdded.isHeap()) {
            return false;
        }

        //Does the result contain all the elements from the original heap
        if(!hOrig.hasAllElt(hAdded)) {
            return false;
        }

        //Has the new element been added
        if(!hAdded.hasNewEltAdded(elt)) {
            return false;
        }

        //No elements in the result were not in the original
        //By testing that the size is the same, we are ensuring that more than 1 value is not added into the new binary tree
        if (!hOrig.addedSameSize(elt, hAdded)) {
            return false;
        }

        return true;
    }

    public boolean remMinEltValidator(IHeap hOrig, int elt, IBinTree hRemoved){

        //Is this a heap
        //Is root smaller than the rest of the heap
        //Is each subtree also a heap
        if(!hOrig.isHeap() || !hRemoved.isHeap()) {
            return false;
        }


        //Does the result contain all the elements from the original heap
        if(!hRemoved.hasAllElt(hOrig)) {
            return false;
        }

        //Has the element been removed
        if (!hRemoved.hasNewEltRemoved(elt)) {
            return false;
        }

        //No elements in the result that were not in original
        //By testing that the size is the same, we are ensuring that more than 1 value is not added into the new binary tree
        if (!hOrig.removedSameSize(elt, hRemoved)) {
            return false;
        }

        return true;

    }


}


