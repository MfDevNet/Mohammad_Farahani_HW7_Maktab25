import java.util.Random;
import java.util.TreeSet;

public class TreeSetWithInternalMethod {
    public static void main(String[] args) {
        Random rnd = new Random();
        TreeSet<Character> treeSet1 = new TreeSet<>();
        TreeSet<Character> treeSet2 = new TreeSet<>();
        int size = 10;
        //check for add 10 item in set1 and set2
        do {
            if (treeSet1.size() != size)
                treeSet1.add((char) (97 + rnd.nextInt(25)));
            if (treeSet2.size() != size)
                treeSet2.add((char) (97 + rnd.nextInt(25)));
        } while (treeSet1.size() != size || treeSet2.size() != size);

        System.out.println("Set 1 :" + treeSet1);
        System.out.println("Size of Set1:" + treeSet1.size());
        System.out.println("Set 2 :" + treeSet2);
        System.out.println("Size Of Set2:" + treeSet2.size());


    }//end of method main

    // find union items of treeset1 and treeset2 and display
    //use mehthod addall and remove duplicate with addall
    static void union(TreeSet<Character> treeSet1, TreeSet<Character> treeSet2) {
        TreeSet<Character> temp = new TreeSet<>();
        temp.addAll(treeSet1);
        temp.addAll(treeSet2);
        System.out.println(temp);
        System.out.println("Count of Union : " + temp.size());

    }//end of method union
}
