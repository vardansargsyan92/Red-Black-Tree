package com.xamlab.com;

import javax.print.attribute.standard.NumberOfDocuments;

import static com.xamlab.com.Constants.BLACK;
import static com.xamlab.com.Constants.RED;
import static com.xamlab.com.Constants.nil;

public class RedBlackTree {

    Node root;

    public RedBlackTree() {
        root = nil;
    }

    public RedBlackTree(Node node) {
        root = node;
    }

    //Printing Red-Black Tree traveling by height
    public void printTree(Node node) {
        if (node == nil) return;
        node.printNodeProperties();
        printTree(node.getLeft());
        printTree(node.getRight());
    }


    //Finding Node
    //returns null if there is no node  by key
    public Node findNode(int key, Node node) {
        if (this.root == null) return null;
        if (key < node.getKey()) {
            if (node.getLeft() != nil) return findNode(key, node.getLeft());
        } else if (key > node.getKey()) {
            if (node.getRight() != nil) return findNode(key, node.getRight());
        } else if (key == node.getKey()) {
            return node;
        }
        System.out.print(String.format("There is no  node by Key:%s", key));
        return null;


    }

    //Right Rotation
    //We have three cases
    // 1. when we rotate  root node
    // 2. when we  rotate internal node
    // 3. when the  root is NIL
    public void rotateRight(Node node) {

        //case3
        if (node.isNil()) return;

        //case 2
        if (!node.getParent().isNil()) {
            if (node == node.getParent().getLeft()) {
                node.getParent().setLeft(node.getLeft());
            } else {
                node.getParent().setRight(node.getLeft());
            }

            node.getLeft().setParent(node.getParent());
            node.setParent(node.getLeft());

            if (!node.getLeft().getRight().isNil()) {
                node.getLeft().getRight().setParent(node);
            }

            node.setLeft(node.getLeft().getRight());
            node.getParent().setRight(node);

        } else
        //case 1
        {
            Node left = root.getLeft();
            root.setLeft(root.getLeft().getRight());
            left.getRight().setParent(root);
            root.setParent(left);
            left.setRight(root);
            left.setParent(nil);
            root = left;
        }
    }

    //Left Rotation
    //We have three cases
    // 1. when we rotate  root node
    // 2. when we  rotate internal node
    // 3. when the  root is NIL
    public void rotateLeft(Node node) {

        //case 3
        if (node == nil) return;

        //case2
        if (node.getParent() != nil) {
            if (node == node.getParent().getLeft()) {
                node.getParent().setLeft(node.getRight());
            } else {
                node.getParent().setRight(node.getRight());
            }

            node.getRight().setParent(node.getParent());
            node.setParent(node.getRight());


            if (node.getRight().getLeft() != nil) {
                node.getRight().getLeft().setParent(node);
            }

            node.setRight(node.getRight().getLeft());
            node.getParent().setLeft(node);

        } else

        //case 1
        {
            Node right = root.getRight();
            root.setRight(right.getLeft());
            right.getLeft().setParent(root);
            root.setParent(right);
            right.setLeft(root);
            right.setParent(nil);
            root = right;
        }
    }

    //Insertion into RBTree
    //After insertion we should balance the tree in order to avoid  violations
    //We have  two cases
    //1. insertion into Empty tree
    //2. ordinary case when RB tree has at least one node
    // We add node as a red node and  after all we do balancing tree
    public void insert(Node node) {
        Node current = root;

        //case 1
        if (root.isNil()) {
            root = node;
            node.setColor(BLACK);
            node.setParent(nil);
        }
        //case 2
        else {
            node.setColor(RED);
            while (true) {
                if (node.getKey() < current.getKey()) {
                    if (current.getLeft().isNil()) {
                        current.setLeft(node);
                        node.setParent(current);
                        break;
                    } else {
                        current = current.getLeft();
                    }
                } else if (node.getKey() >= current.getKey()) {
                    if (current.getRight().isNil()) {
                        current.setRight(node);
                        node.setParent(current);
                        break;
                    } else {
                        current = current.getRight();
                    }
                }
            }
            balancingAfterInsertion(node);
        }
    }

    //Balancing the RB tree after insertion
    //Takes as argument the newly inserted node
    //we should balance RB tree while node's parent  color is black
    //we should observe  uncle color of node's parent and do  left or right rotations
    //we have 3 cases
    // 1.color of uncle node is Red (we do recoloring)
    // 2.color of uncle is Black (we do left/right rotation)
    // 3.the inserted node,it's parent and grandparent are on the same line (we do recoloring and opposite rotation)
    //then we cycle the same process  for grandparent of  inserted node if it's parent color is not black
    private void balancingAfterInsertion(Node node) {
        while (node.getParent().getColor() == RED) {
            Node uncle;
            if (node.getParent() == node.getParent().getParent().getLeft()) {
                uncle = node.getParent().getParent().getRight();

                //case 1
                if (!uncle.isNil() && uncle.getColor() == RED) {
                    node.getParent().setColor(BLACK);
                    uncle.setColor(BLACK);

                    // we allowed recolor grandparent node if it's not just root
                    if (node.getParent().getParent() != root) {
                        node.getParent().getParent().setColor(RED);
                    }

                    node = node.getParent().getParent();
                    continue;
                }

                //case 2
                if (node == node.getParent().getRight()) {
                    rotateLeft(node.getParent());
                    node = node.getLeft();
                }

                //case3
                if (node == node.getParent().getLeft()) {
                    node.getParent().setColor(BLACK);
                    node.getParent().getParent().setColor(RED);
                    rotateRight(node.getParent().getParent());

                }


            } else if (node.getParent() == node.getParent().getParent().getRight()) {
                uncle = node.getParent().getParent().getLeft();

                //case1
                if (!uncle.isNil() && uncle.getColor() == RED) {
                    node.getParent().setColor(BLACK);
                    uncle.setColor(BLACK);

                    // we allowed recolor grandparent node if it's not just root
                    if (node.getParent().getParent() != root) {
                        node.getParent().getParent().setColor(RED);
                    }
                    node = node.getParent().getParent();
                    continue;
                }

                //case 2
                if (node == node.getParent().getLeft()) {
                    rotateRight(node.getParent());
                    node = node.getRight();
                }

                //case 3
                if (node == node.getParent().getRight()) {
                    node.getParent().setColor(BLACK);
                    node.getParent().getParent().setColor(RED);
                    rotateLeft(node.getParent().getParent());
                }
            }
        }
    }


    //returns true when deleting  is succeed and false vice versa
    //after deleting node we should do corresponding transplantation and balance the tree
    //when we remove black node we should balance tree in order to avoid violates
    public boolean remove(Node node) {
        if ((node = findNode(node.getKey(), root)) == null) return false;
        Node x;
        Node current = node; // temporary reference y
        boolean y_original_color = current.getColor();

        if (node.getLeft().isNil()) {
            x = node.getRight();
            transplantation(node, node.getRight());
        } else if (node.getRight().isNil()) {
            x = node.getLeft();
            transplantation(node, node.getLeft());
        } else {
            current = treeMinimum(node.getRight());
            y_original_color = current.getColor();
            x = current.getRight();
            if (current.getParent() == node)
                x.setParent(current);
            else {
                transplantation(current, current.getRight());
                current.setRight(node.getRight());
                current.getRight().setParent(current);
            }
            transplantation(node, current);
            current.setLeft(node.getLeft());
            current.getLeft().setParent(current);
            current.setColor(node.getColor());
        }
        if (y_original_color == BLACK)
            balancingAfterRemoval(x);
        return true;
    }

    //Balancing the RB tree after deletion
    //we should balance RB tree while node's nodes color is red or node is root
    //we should observe  uncle color of node's parent and do  left or right rotations
    //we have 4 cases
    //1. node's sibling is red (our goal is make it black so we make a rotation to get a black sibling)
    //2. node's sibling is black, and both of sibling’s children are black(we recolor sibling Red and go up)
    //3. node's sibling is black, sibling’s left child is red, and sibling's right child is black
    //our goal is to make sibling's far child as a red, so we do recoloring and rotation to achieve that
    //4. node's sibling is black, sibling’s left child is black, and sibling's right child is red
    //we do recolor; make rotation to remove the deficiency of black nodes color
    private void balancingAfterRemoval(Node node) {
        while (node != root && node.getColor() == BLACK) {
            if (node == node.getParent().getLeft()) {
                Node sibling = node.getParent().getRight();

                //case 1
                if (sibling.getColor() == RED) {
                    sibling.setColor(BLACK);
                    node.getParent().setColor(RED);
                    int a = node.getParent().getRight().getKey();
                    rotateLeft(node.getParent());
                    int b = node.getParent().getRight().getKey();
                    sibling = node.getParent().getRight();
                }
                if (sibling.getLeft().getColor() == BLACK && sibling.getRight().getColor() == BLACK) {
                    sibling.setColor(RED);
                    node = node.getParent();
                    continue;
                } else if (sibling.getRight().getColor() == BLACK) {
                    sibling.getLeft().setColor(BLACK);
                    sibling.setColor(RED);
                    rotateRight(sibling);
                    //????
                    sibling = node.getParent().getRight();
                }
                if (sibling.getRight().getColor() == RED) {
                    sibling.setColor(node.getParent().getColor());
                    node.getParent().setColor(BLACK);
                    sibling.getRight().setColor(BLACK);
                    rotateLeft(node.getParent());
                    node = root;
                }
            } else {
                Node sibling = node.getParent().getLeft();
                if (sibling.getColor() == RED) {
                    sibling.setColor(BLACK);
                    node.getParent().setColor(RED);
                    rotateRight(node.getParent());
                    sibling = node.getParent().getLeft();
                }
                if (sibling.getRight().getColor() == BLACK && sibling.getLeft().getColor() == BLACK) {
                    sibling.setColor(RED);
                    node = node.getParent();
                    continue;
                } else if (sibling.getLeft().getColor() == BLACK) {
                    sibling.getRight().setColor(BLACK);
                    sibling.setColor(RED);
                    rotateLeft(sibling);
                    sibling = node.getParent().getLeft();
                }
                if (sibling.getLeft().getColor() == RED) {
                    sibling.setColor(node.getParent().getColor());
                    node.getParent().setColor(BLACK);
                    sibling.getLeft().setColor(BLACK);
                    rotateRight(node.getParent());
                    node = root;
                }
            }
        }
        node.setColor(BLACK);
    }


    //returns node which have a minimum key
    Node treeMinimum(Node subTreeRoot) {
        while (!subTreeRoot.getLeft().isNil()) {
            subTreeRoot = subTreeRoot.getLeft();
        }
        return subTreeRoot;
    }

    //This operation we will use in DELETING method
    //This operation doesn't care about the new Node's connections
    //with previous node's left and right. The caller has to take care
    //of that.
    private void transplantation(Node target, Node with) {
        if (target.getParent().isNil()) {
            root = with;
        } else if (target == target.getParent().getLeft()) {
            target.getParent().setLeft(with);
        } else
            target.getParent().setRight(with);
        with.setParent(target.getParent());
    }


}
