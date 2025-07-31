package QuestionTwo;

public class HPAlgorithm {

    //Perform post-order traversal that compute height of each subtree and prints the element followed by the height
    /** Post‑order: print element and subtree height; return that height. */
    public static <E> int heightPrint(BinaryTree<E> T, Position<E> p){

        int maxC = -1;          //tallest child

        //Recursive post-order... we process each child befor parent.
        for(Position<E> c : T.children(p))
            maxC = Math.max(maxC, heightPrint(T, c));

        int height = maxC +1;           //height of current subtree

        //Output  element and subtree height
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

        //Print each element with its subtree height.
        heightPrint(t,a);

    }




}
