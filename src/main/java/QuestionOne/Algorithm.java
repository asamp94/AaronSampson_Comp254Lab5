package QuestionOne;

public class Algorithm {
    public static <E> Position<E> preorderNext(BinaryTree<E> t, Position<E> p){
        //Check left child
        //If p is an internal node(atleast 1 child), check if it has a left child
        if (t.isInternal(p)) {
            //Return the left child if exists
            Position<E> l = t.left(p);
            if(l != null) return l;
        }

        //Climb up to find Right Sibling
        Position<E> current = p;
        Position<E> parent = t.parent(current);

        //Check if current node is left child of its parent and if parent has right child.
        //If yes, the right child is the next node in the preorder.
        while (parent!= null){
            // If current is left child and right sibling exists, return it
            if(t.left(parent) == current) {
                Position<E> r = t.right(parent);
                if (r != null) return r;
            }
            //Move Upward
            current = parent;
            parent = t.parent(current);
        }

        return null; //No next node in preorder
        //If we go all the way up to the root and find no right child, it means we were at the last node in preorder.
    }

    public static void main(String[] args) {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        Position<String> root = tree.addRoot("A");
        Position<String> b = tree.addLeft(root,"B");
        Position<String> c = tree.addRight(root,"C");
        Position<String> d = tree.addLeft(b,"D");
        Position<String> e = tree.addRight(b,"E");
        Position<String> f = tree.addLeft(c,"F");
        Position<String> g = tree.addRight(c,"G");

        Position<String> next = Algorithm.preorderNext(tree,b);
        System.out.println("Position after B(preorderNext): " + (next != null ? next.getElement() : "null"));

        next = Algorithm.preorderNext(tree,e);
        System.out.println("Position after E(preorderNext): " + (next != null ? next.getElement() : "null"));

        next = Algorithm.preorderNext(tree,f);
        System.out.println("Position after F(preorderNext): " + (next != null ? next.getElement() : "null"));

        next = Algorithm.preorderNext(tree,g);
        System.out.println("Position after G(preorderNext): " + (next != null ? next.getElement() : "null"));

        /*
        Worst-case time:
            Worst case time is O(h). In the worst case, the algorithm traverses up the tree from a leaf to the root().
            Worst case running time is )(h) where h is height of tree T
         */


    }
}


