package com.xamlab.com;

import static com.xamlab.com.Constants.*;

public class Main {

    public static void main(String[] args) {

        Node node = new Node(7, nil, nil, nil, BLACK);
        Node node1 = new Node(6, nil, nil, node, RED);
        Node node2 = new Node(8, nil, nil, node, RED);
        node.setLeft(node1);
        node.setRight(node2);

        RedBlackTree tree = new RedBlackTree(node);


        tree.printTree(tree.root);

        System.out.println();
        System.out.println();
        Node res=tree.findNode(7, tree.root);
        if(res!=null){
            res.printNodeProperties();
        }


    }
}
