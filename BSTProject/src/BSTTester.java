/*
 * TODO: Logan Torma-Kim
 * TODO: 2/24/2025
 * TODO: 3
 * TODO: Program Description dskfasdjfjd;f;LKDFKJLAS;DFJ  M;Lj;;alKDFj;fklJDFL;KSADJl;kj  ;lKDFJ;LDKFJE;LKRH;lkjsdfklDSJ;FDkjlj;DLFJ;ljK;LKDFJDLKRTGJVKklEFJKLSFkklkjfs
 */

 import java.lang.Comparable;

 public class BSTTester {
   public static void main(String[] args) {
   BST tree = new BST(); 
   tree.add("O");
   tree.add("R");
   tree.add("C");
   tree.add("H");
   tree.add("A");
   tree.add("R");
   tree.add("D");
   tree.add("Q");
   tree.add("U");
   tree.add("I");
   tree.add("N");
   tree.add("C");
   tree.add("E");
   tree.delete("Q");
   tree.printInOrder();
   tree.printPreOrder();
   tree.printPostOrder();
   System.out.println("Is L there?" );
   System.out.println(tree.find("L"));
   System.out.println("Is Q there?" );
   System.out.println(tree.find("Q"));
   System.out.println("Replacing U with  Z");
   System.out.println(tree.replace("U", "Z"));
 }
}