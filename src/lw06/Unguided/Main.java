package lw06.Unguided;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));
        Node root = null;

        BinarySearchTree bst = new BinarySearchTree();
        String[] number = read.nextLine().split(" ");
        for (String data : number) {
            bst.insert(Integer.parseInt(data));
        }
        int target = read.nextInt();
        
        System.out.print("Preorder : ");
        bst.preOrder();
        System.out.print("Inorder : ");
        bst.inOrder();
        System.out.print("Postorder : ");
        bst.postOrder();

        System.out.println("Search " + target + " : " + bst.search(target));
            
        System.out.println("Minimum : " + bst.findMin());
        System.out.println("Maximum  : " + bst.findMax());

        read.close();
    }
}