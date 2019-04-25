import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class TreeSetWithFunction  {
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
        union(treeSet1, treeSet2);
        intersection(treeSet1, treeSet2);


    }//end of method main

    //find union from tow Set
    //first display set1 and check set2 by set1 and display different
    static void union(TreeSet<Character> ts1, TreeSet<Character> ts2) {
        int counter = 0;
        boolean flag = false;
        Iterator<Character> itr1 = ts1.iterator();
        Iterator<Character> itr2 = ts2.iterator();

        System.out.print("Union:{");
        //display set1
        while (itr1.hasNext()) {
            System.out.print(itr1.next() + " ");
            counter++;
        }
        //for find different set1 with set2
        while (itr2.hasNext()) {
            itr1 = ts1.iterator();
            char charTree2 = itr2.next();
            while (itr1.hasNext()) {
                char charTree1 = itr1.next();
                if (charTree2 == charTree1) {
                    flag = true;
                    break;
                }
                flag = false;
            }
            if (flag == false) {
                System.out.print(charTree2 + " ");
                counter++;
                flag = true;
            }
        }
        System.out.println("}");
        System.out.println("Count of Union : " + counter);
    }//end of method union

    //find Intersection from tow TreeSet
    static void intersection(TreeSet<Character> ts1, TreeSet<Character> ts2) {
        int counter = 0;
        Iterator<Character> itr1 = ts1.iterator();
        System.out.print("Intersection:{");
        while (itr1.hasNext()) {
            char charTree1 = itr1.next();
            Iterator<Character> itr2 = ts2.iterator();
            while (itr2.hasNext()) {
                char charTree2 = itr2.next();
                if (charTree1 == charTree2) {
                    System.out.print(charTree1 + " ");
                    counter++;
                }
            }
        }
        System.out.println("}");
        System.out.println("Count of Intersection : " + counter);
    }//end of method intersection
}//end of class TreeSetWithFuncation

