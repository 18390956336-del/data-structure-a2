package comp2011.a2; // Don't change this line!

/**
 *
 * @author Yixin Cao (November 1, 2025)
 *
 * A binary search tree for Polyu students.
 * Since we only store students, the class doesn't use generics.
 *
 * You are forbidden to use {@code import} or {@code java.} in this file.
 *
 * Do not change the signature of any given method, but feel free to introduce new ones, which must be {@code private}.
 */
public class PolyuTree_000 { // Please replace 000 with your secret number!
    /**
     * No modification to the class {@code Student} is allowed.
     * If you change anything in this class, your work will not be graded.
     */
    static class Student {
        String id;
        String name;

        public Student(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return id + ", " + name;
        }
    }

    /**
     * No modification to the class {@code Node} is allowed.
     * If you change anything in this class, your work will not be graded.
     */
    private class Node {
        Student e;
        public Node lc, rc; // left child; right child

        @SuppressWarnings("unused")
        public Node(Student data) {
            this.e = data;
        }

        public String toString() {
            return e.toString();
        }
    }

    Node root;

    /**
     * Insert a new student into the tree.
     *
     * VERY IMPORTANT.
     * I've sought help from the following GenAI:
     *     1. GPT-4.1
     *     2.
     *     3.
     *     ...
     *
     * I've discussed this question with the following students (secret numbers, not names!):
     *     1.
     *     2.
     *     3.
     *     ...
     *
     * I've sought help from the following Internet resources and books:
     *     1.
     *     2.
     *     3.
     *     ...
     *
     *
     * Running time: O(d). A function of d and n.
     */
    public void insert(Student s) {
        if(root==null){
            root=new Node(s);
            return;
        }

        Node parent=root;
        Node cur;
        if(s.name.compareTo(root.e.name)>0) cur=parent.rc;
        else cur=parent.lc;
        while(cur!=null){
            if(s.name.compareTo(cur.e.name)>0){
                parent=cur;
                cur=cur.rc;
            }
            else{
                parent=cur;
                cur=cur.lc;
            }
        }
        if(s.name.compareTo(parent.e.name)>0) parent.rc=new Node(s);
        else parent.lc=new Node(s);
    }

    /**
     * Calculate the largest difference between the depths of the two subtrees of a
     * node.
     *
     * VERY IMPORTANT.
     *
     * I've sought help from the following GenAI:
     *     1. GPT-4.1
     *     2.
     *     3.
     *     ...
     *
     * I've discussed this question with the following students (secret numbers, not names!):
     *     1.
     *     2.
     *     3.
     *     ...
     *
     * I've sought help from the following Internet resources and books:
     *     1.
     *     2.
     *     3.
     *     ...
     *
     *
     * Running time: O(n). A function of d and n.
     */
    private int getHight(Node root, int[] diff) {
        if(root==null) {
            return 0;
        }

        int leftHeight=getHight(root.lc, diff);
        int rightHeight=getHight(root.rc, diff);

        int curdiff;
        if(leftHeight<=rightHeight) {
            curdiff=rightHeight-leftHeight;
            if(curdiff>diff[0]) {
                diff[0]=curdiff;
            }
            return rightHeight+1;
        }
        else {
            curdiff=leftHeight-rightHeight;
            if(curdiff>diff[0]) {
                diff[0]=curdiff;
            }
            diff[0]=curdiff;
            return leftHeight+1;
        }
    }

    public int maxDepthDiff() {
        if(root==null)
            return -1;

        int[] diff=new int[1];
        getHight(root, diff);
        return diff[0];
    }

    /**
     * Calculate the largest difference between the sizes of the two subtrees of a
     * node.
     *
     * VERY IMPORTANT.
     *
     * I've sought help from the following GenAI:
     *     1.
     *     2.
     *     3.
     *     ...
     *
     * I've discussed this question with the following students (secret numbers, not names!):
     *     1.
     *     2.
     *     3.
     *     ...
     *
     * I've sought help from the following Internet resources and books:
     *     1.
     *     2.
     *     3.
     *     ...
     *
     *
     * Running time: O(n). A function of d and n.
     */


    private int getSize(Node root, int[] diff) {
        if (root == null){
            return 0;
        }

        int leftSize = getSize(root.lc, diff);
        int rightSize = getSize(root.rc, diff);

        int curdiff;
        if(leftSize <= rightSize){
            curdiff = rightSize - leftSize;
        }
        else{
            curdiff = leftSize - rightSize;
        }
        if(curdiff > diff[0]) {
            diff[0]=curdiff;
        }
        return leftSize+rightSize+1;
    }


    public int maxSizeDiff() {
        if(this.root==null)
            return -1;

        int[] diff=new int[1];
        getSize(root, diff);
        return diff[0];
    }

    /**
     * Calculate the number of nodes that have only one child.
     *
     * VERY IMPORTANT.
     *
     * I've sought help from the following GenAI:
     *     1.
     *     2.
     *     3.
     *     ...
     *
     * I've discussed this question with the following students (secret numbers, not names!):
     *     1.
     *     2.
     *     3.
     *     ...
     *
     * I've sought help from the following Internet resources and books:
     *     1.
     *     2.
     *     3.
     *     ...
     *
     *
     * Running time: O(n). A function of d and n.
     */
    private int numLeaves(Node root) {
        if(root==null) return 0;
        if(root.rc==null && root.lc==null) return 1;

        return numLeaves(root.rc)+numLeaves(root.lc);
    }

    private int numTotal(Node root) {
        if(root==null) return 0;

        return numTotal(root.rc)+numTotal(root.lc)+1;
    }

    public int nodesWithOneChild() {
        if(root==null) return -1;

        int leaves=numLeaves(root);
        int total=numTotal(root);

        return total-2*leaves+1;
    }

    /*
     * Find a student with the specified name.
     * You may return any of them if there are multiple students of this name.
     *
     * VERY IMPORTANT.
     *
     * I've sought help from the following GenAI:
     *     1.
     *     2.
     *     3.
     *     ...
     *
     * I've discussed this question with the following students (secret numbers, not names!):
     *     1.
     *     2.
     *     3.
     *     ...
     *
     * I've sought help from the following Internet resources and books:
     *     1.
     *     2.
     *     3.
     *     ...
     *
     *
     * Running time: O(d). A function of d and n.
     */
    public Student searchFullname(String name) {
        if(name==null)
            return null;

        Node cur=root;
        while(cur!=null){
            if(cur.e.name.compareTo(name)==0){
                return cur.e;
            }
            else if(cur.e.name.compareTo(name)<0){
                cur=cur.rc;
            }
            else{
                cur=cur.lc;
            }
        }

        return null;
    }

    /*
     * Find all students with the specified surname.
     * Consider the first word as the surname.
     * Warning: Make sure "Liu Dennis" does not show when you search "Li."
     *
     * VERY IMPORTANT.
     *
     * I've sought help from the following GenAI:
     *     1. GPT-4.1
     *     2.
     *     3.
     *     ...
     *
     * I've discussed this question with the following students (secret numbers, not names!):
     *     1.
     *     2.
     *     3.
     *     ...
     *
     * I've sought help from the following Internet resources and books:
     *     1.
     *     2.
     *     3.
     *     ...
     *
     *
     * Running time: O(n). A function of d and n.
     */
    private int count(Node root, String surname){
        if(root==null) return 0;

        if(root.e.name.split(",")[0].compareTo(surname)==0) return 1+count(root.lc, surname)+count(root.rc, surname);

        else return count(root.lc, surname)+count(root.rc, surname);
    }

    private int collect(Node root, String surname, Student[] target, int index){
        if(root==null) return index;

        if(root.e.name.split(",")[0].compareTo(surname)==0) {
            target[index]=root.e;
            index++;
        }

        index=collect(root.lc, surname, target, index);
        index=collect(root.rc, surname, target, index);

        return index;
    }

    public Student[] searchSurname(String surname) {
        if(root==null)
            return null;

        int num=count(root, surname);
        Student[] answer=new Student[num];
        collect(root, surname, answer, 0);
        return answer;
    }
}
