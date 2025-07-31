package QuestionOne;

public class Algorithm {
    //preorderNext finds the node that comes after a goven position in a preorder traversal
    public static <E> Position<E> preorderNext(BinaryTree<E> t, Position<E> v) {
        //If v has children, then left child is next in preorder
        if (t.isInternal(v)) {
            return t.left(v);
        } else {
            //Else walk up until we go right
            Position<E> p = t.parent(v);
            //If v was root, there isn't a next node
            if (p == null) return null;
            // If v was left child of p, ps right is nexy
            if (t.left(p) == v) {
                return t.right(p);
            } else {
                //Else, v was a right child and we climb until we come up from left
                while (p != null && t.left(p) != v) {
                    v = p;
                    p = t.parent(v);
                }
                //No next if we've climbed past root. return p's richt child
                return (p == null ? null : t.right(p));
            }
        }
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


