package QuestionTwo;

public class HPAlgorithm {

    /** Post‑order: print element and subtree height; return that height. */
    public static <E> int heightPrint(BinaryTree<E> T, Position<E> p){
        //Begin with -1 so adding 1 makes the leafs height 0
        int maxChild = -1;
        //Process children first
        for(Position<E> c : T.children(p))
            maxChild = Math.max(maxChild, heightPrint(T, c));
        //Height of node is 1 + tallest child
        int height = maxChild +1;

        System.out.println(p.getElement() + " " + height);
        return height;
    }

    public static void main(String[] args) {
        LinkedBinaryTree<String> t = new LinkedBinaryTree<>();
        Position<String> a = t.addRoot("A");
        Position<String> b = t.addLeft(a,"B");
        Position<String> c = t.addRight(a,"C");
        Position<String> d = t.addLeft(c,"D");
        Position<String> e = t.addRight(c,"E");
        Position<String> f = t.addLeft(e,"F");
        Position<String> g = t.addRight(e, "G");

        heightPrint(t,a);

    }




}
