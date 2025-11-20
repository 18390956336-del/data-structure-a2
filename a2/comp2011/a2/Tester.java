package comp2011.a2;
import comp2011.a2.PolyuTree_360;

/*
 * You are free to use any Java packages here.
 * Please do NOT submit this file: 5 points deducted if you do.
 */

public class Tester {

    private static void testTrees() {
    }

    private static void testHeaps() {
    }
    
    /**
     * You are free to make any change to this method.
     * You can even remove it, if you want to test your code with other means.
     */
    public static void main(String[] args) {
        PolyuTree_360 a = new PolyuTree_360();
        PolyuTree_360.Student b = new PolyuTree_360.Student("1", "b");
        PolyuTree_360.Student c = new PolyuTree_360.Student("1", "c");
        PolyuTree_360.Student d = new PolyuTree_360.Student("1", "b, d");
        PolyuTree_360.Student e = new PolyuTree_360.Student("1", "e");
        PolyuTree_360.Student f = new PolyuTree_360.Student("1", "b, f");
        PolyuTree_360.Student g = new PolyuTree_360.Student("1", "g");
        PolyuTree_360.Student h = new PolyuTree_360.Student("1", "h");
        a.insert(b);
        a.insert(c);
        a.insert(d);

        a.insert(e);
        a.insert(f);
        System.out.println(a.maxDepthDiff());
        System.out.println(a.maxSizeDiff());
        System.out.println(a.nodesWithOneChild());
    }
}
