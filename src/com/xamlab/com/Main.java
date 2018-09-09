package com.xamlab.com;

import static com.xamlab.com.BTreePrinter.printNode;

public class Main {

    public static void main(String[] args) {


        RedBlackTree tree = new RedBlackTree();
        /*tree.insert(new Node(41));
        tree.insert(new Node(38));
        tree.insert(new Node(31));
        tree.insert(new Node(12));
        tree.insert(new Node(19));
        tree.insert(new Node(8));*/




        tree.insert(new Node(1));
        tree.insert(new Node(2));
        tree.insert(new Node(3));
        tree.insert(new Node(4));
        tree.insert(new Node(5));
        tree.insert(new Node(6));
        tree.insert(new Node(7));
        tree.insert(new Node(8));
        tree.insert(new Node(9));
        tree.insert(new Node(10));

        tree.remove(tree.findNode(1,tree.root));
        tree.remove(tree.findNode(3,tree.root));
        tree.remove(tree.findNode(5,tree.root));
        tree.remove(tree.findNode(7,tree.root));
        tree.remove(tree.findNode(9,tree.root));



        System.out.print("|||||||||||||||||||||||||||||||||||||||\n");
        System.out.print("....... TREE STRUCTURE ......... \n");
        tree.printTree(tree.root);
        System.out.println();
        System.out.println();



        System.out.print("            |         \n");
        System.out.print("           |||          \n");
        System.out.print("          |||||          \n");
        System.out.print("         |||||||          \n");
        System.out.print("        |||||||||         \n");
        System.out.print("          |||||          \n");
        System.out.print("          |||||          \n");
        System.out.print("          |||||          \n");
        System.out.print("          |||||          \n");
        System.out.print("          |||||          \n");
        System.out.print("iN ORDER TO SEE TREE STRUCTURE  PLEASE SCROLL UP");
        System.out.println();
        System.out.println();
        System.out.print("....... VISUAL REPRESENTATION ......... \n");


        printNode(tree.root);
        System.out.println();
        System.out.println();


        System.out.print("SCROLL UP");


    }
}
