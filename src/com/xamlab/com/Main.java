package com.xamlab.com;

import static com.xamlab.com.BTreePrinter.printNode;

public class Main {

    public static void main(String[] args) {


        RedBlackTree tree = new RedBlackTree();

        System.out.print("............................ \n");
        System.out.print("....... INSERT 1 ......... \n");
        System.out.print("............................ \n");

        tree.insert(new Node(1));
        printNode(tree.root);
        System.out.println();
        System.out.println();

        System.out.print("............................ \n");
        System.out.print("....... INSERT 2 ......... \n");
        System.out.print("............................ \n");
        tree.insert(new Node(2));
        printNode(tree.root);
        System.out.println();
        System.out.println();


        System.out.print("............................ \n");
        System.out.print("....... INSERT 3 ......... \n");
        System.out.print("............................ \n");
        tree.insert(new Node(3));
        printNode(tree.root);
        System.out.println();
        System.out.println();

        System.out.print("............................ \n");
        System.out.print("....... INSERT 4 ......... \n");
        System.out.print("............................ \n");
        tree.insert(new Node(4));
        printNode(tree.root);
        System.out.println();
        System.out.println();

        System.out.print("............................ \n");
        System.out.print("....... INSERT 5 ......... \n");
        System.out.print("............................ \n");
        tree.insert(new Node(5));
        printNode(tree.root);
        System.out.println();
        System.out.println();

        System.out.print("............................ \n");
        System.out.print("....... INSERT 6 ......... \n");
        System.out.print("............................ \n");
        tree.insert(new Node(6));
        printNode(tree.root);
        System.out.println();
        System.out.println();

        System.out.print("............................ \n");
        System.out.print("....... INSERT 7 ......... \n");
        System.out.print("............................ \n");
        tree.insert(new Node(7));
        printNode(tree.root);
        System.out.println();
        System.out.println();

        System.out.print("............................ \n");
        System.out.print("....... INSERT 8 ......... \n");
        System.out.print("............................ \n");
        tree.insert(new Node(8));
        printNode(tree.root);
        System.out.println();
        System.out.println();

        System.out.print("............................ \n");
        System.out.print("....... INSERT 9 ......... \n");
        System.out.print("............................ \n");
        tree.insert(new Node(9));
        printNode(tree.root);
        System.out.println();
        System.out.println();

        System.out.print("............................ \n");
        System.out.print("....... INSERT 10 ......... \n");
        System.out.print("............................ \n");
        tree.insert(new Node(10));
        printNode(tree.root);
        System.out.println();
        System.out.println();


        System.out.print("............................ \n");
        System.out.print("....... REMOVE 1 ......... \n");
        System.out.print("............................ \n");
        tree.remove(tree.findNode(1, tree.root));
        printNode(tree.root);
        System.out.println();
        System.out.println();

        System.out.print("............................ \n");
        System.out.print("....... REMOVE 3 ......... \n");
        System.out.print("............................ \n");
        tree.remove(tree.findNode(3, tree.root));
        printNode(tree.root);
        System.out.println();
        System.out.println();

        System.out.print("............................ \n");
        System.out.print("....... REMOVE 5 ......... \n");
        System.out.print("............................ \n");
        tree.remove(tree.findNode(5, tree.root));
        printNode(tree.root);
        System.out.println();
        System.out.println();

        System.out.print("............................ \n");
        System.out.print("....... REMOVE 7 ......... \n");
        System.out.print("............................ \n");
        tree.remove(tree.findNode(7, tree.root));
        printNode(tree.root);
        System.out.println();
        System.out.println();

        System.out.print("............................ \n");
        System.out.print("....... REMOVE 9 ......... \n");
        System.out.print("............................ \n");
        tree.remove(tree.findNode(9, tree.root));
        printNode(tree.root);
        System.out.println();
        System.out.println();


        System.out.print("..................................\n");
        System.out.print("..... FINAL TREE STRUCTURE ....... \n");
        System.out.print("..................................\n");
        tree.printTree(tree.root);
        System.out.println();
        System.out.println();
        System.out.print("..................................\n");
        System.out.print("....... FINAL VISUAL REPRESENTATION ......... \n");
        System.out.print("..................................\n");
        printNode(tree.root);
        System.out.print("PLEASE SCROLL UP");


    }
}
