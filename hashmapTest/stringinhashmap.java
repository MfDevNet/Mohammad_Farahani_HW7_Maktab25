package hashmapTest;

import java.util.Scanner;

public class stringinhashmap {
    public static void main(String[] args) {
        stringrepeter sp=new stringrepeter();
        Scanner input =new Scanner(System.in);
        System.out.println("Enter Word : ");
        String word=input.next();
        System.out.println("Enter new Word for Check");
        String newWord=input.next();
        sp.printPermutations(word,newWord);
    }
}
