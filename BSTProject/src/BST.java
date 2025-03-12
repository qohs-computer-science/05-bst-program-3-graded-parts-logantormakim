import java.lang.Comparable;

public class BST implements BSTInterface
{
    private TreeNode root = new TreeNode(null);

    public BST () { // constructor
        root=null;
    } // end constructor
    // add
    public void add(Comparable val) { //Creates a new node to store the value being sent then adds the node to the tree in the correct place (remember all left children are less than or equal to their parent and all right children are greater than their parent)
        if(root == null)
	            root = new TreeNode(val, null,null);
        else if (val.compareTo(root.getValue()) <= 0) { // if smaller value than root
	        addHelper(val, root.getLeft(), root);
        } // end else if
        else {
	        addHelper(val, root.getRight(), root);
        } // end else
    }

        // add helper   
        private void addHelper(Comparable val, TreeNode child, TreeNode parent)
        {
            if (child == null) {
	            if (val.compareTo(parent.getValue()) <=0) {
			            parent.setLeft(new TreeNode(val));
                } // end if
                if (val.compareTo(parent.getValue()) >0) {
			parent.setRight(new TreeNode(val));
            } // end if
            } // end if
	         else if (val.compareTo(child.getValue()) <=0) {
                addHelper(val, child.getLeft(), child);
            } // end else if
	        else {
                addHelper(val, child.getRight(), child);
            } // end else
        } // end add helper


        public void printInOrder() //  prints the tree using an In Order traversal - recursion
        {
            System.out.println("In order:");
            if (root == null) {
                System.out.println("In order: ____");
            } // end if
            if (root.getLeft()!= null) {
                inOrderHelper(root.getLeft());
            } // end if
            System.out.println(root.getValue());
            if (root.getRight()!= null) {
                inOrderHelper(root.getRight());
            } // end if
        }



        //in order helper
        public void inOrderHelper(TreeNode child) {
            if(child.getLeft() !=null) {
                inOrderHelper(child.getLeft());
            }
            System.out.println(child.getValue() + " ");
            if(child.getRight() !=null) {
                inOrderHelper(child.getRight());
            }
            return;
        }

        public void printPreOrder() // prints the tree using a Pre Order traversal - recursion
        {
            System.out.println("Pre order:");
            if (root == null) {
                System.out.println("Pre order: ____");
            } // end if
            System.out.println(root.getValue());
            if (root.getLeft()!= null) {
                preOrderHelper(root.getLeft());
            } // end if
            if (root.getRight()!= null) {
                preOrderHelper(root.getRight());
            } // end if
        } // end print preorder

        // preorder helper
        public void preOrderHelper(TreeNode child) {
            System.out.println(child.getValue() + " ");
            if(child.getLeft() !=null) {
                preOrderHelper(child.getLeft());
            }
            if(child.getRight() !=null) {
                preOrderHelper(child.getRight());
            }
            return;
        }

        public void printPostOrder() // prints the tree using a Post Order traversal – recursion
        {
            System.out.println("Post order:");
            if (root == null) {
                System.out.println("Post order: ____");
            } // end if
            if (root.getLeft()!= null) {
                postOrderHelper(root.getLeft());
            } // end if
            if (root.getRight()!= null) {
                postOrderHelper(root.getRight());
            } // end if
            System.out.println(root.getValue());
        } // end printpostorder

        // postorder helper
        public void postOrderHelper(TreeNode child) {
            if(child.getLeft() !=null) {
                postOrderHelper(child.getLeft());
            }
            if(child.getRight() !=null) {
                postOrderHelper(child.getRight());
            }
            System.out.println(child.getValue() + " ");
            return;
        }
        //this method deletes the object being passed to the method from the tree.  When you remove the node you must then 
        //change any children around to accommodate for the deleted node.  
        //Return true if the node was successfully deleted, false if it was not in the tree and therefore not deleted.
        public boolean delete(Comparable old) { 
            if (root == null) {
                return false;
            } // end if
            else if (root.getValue().compareTo(old) == 0){
                    if(root.getLeft() != null && root.getRight() != null) {
                        TreeNode temp = root.getLeft();
                        while (temp.getRight() != null) {
                            temp = temp.getRight();
                        }
                        temp.setRight(root.getRight());
                        root.setRight(null);
                        root = root.getLeft();
                    } // end if
                    // has lc
                    else if (root.getLeft() != null) {
                        root = root.getLeft();
                    } // end elseif
                    // has rc
                    else if (root.getRight() != null) {
                        root = root.getRight();
                    } // end elseif
                    // has no children
                    else {
                        root.setValue(null);
                        return true;
                    }// end else
            } // end else if
            else if (old.compareTo(root.getValue()) <= 0) {
                deleteHelper(old, root.getLeft(), root);
            }  // end else if
            else {
                deleteHelper(old, root.getRight(), root);
            } // end else
            return false;
            } // end delete


            // helper method for delete
            public boolean deleteHelper(Comparable old, TreeNode child, TreeNode parent) {
                if (child ==null) {
                    return false;
                } // end if
                else if (child.getValue().compareTo(old) == 0) {
                        if (child.getLeft()!= null && child.getRight()!= null) { //2 children
                            TreeNode temp = child.getLeft();
                                while (temp.getRight() != null) {
                                    temp= temp.getRight();
                                } // end while
                                temp.setRight(child.getRight());
                                child.setRight(null);
                                if(child.getValue().compareTo(parent.getValue())> 0) {
                                    parent.setRight(child.getLeft());
                                } // end if
                                else {
                                    parent.setLeft(child.getLeft());
                                } // end else
                                child=child.getLeft();
                                return true;
                        } // end if

                                else if (child.getRight() != null) { // has right
                                    if (child.getValue().compareTo(parent.getValue()) >0) {
                                        parent.setRight(child.getRight());
                                    } // end if
                                    else {
                                        parent.setLeft(child.getRight());
                                    } // end else
                                    parent = parent.getRight();
                                    return true;
                                } // end elseif

                                else if (child.getLeft() != null) { // has left
                                    if (child.getValue().compareTo(parent.getValue()) >0) {
                                        parent.setRight(child.getRight());
                                    } // end if
                                    else {
                                        parent.setLeft(child.getRight());
                                    } // end else
                                    parent = parent.getRight();
                                    return true;
                                } // end else if
                                
                                else { // 0 children
                                   parent.setValue(null);
                                   return true;
                                } // end else
                } // end if
                    else if  (parent.getValue().compareTo(old) > 0) {
                                deleteHelper(old, child.getLeft(), child);
                                return true;
                        
                    } // end else if
                    else {
                        deleteHelper(old, child.getRight(), child);
                        return false;
                    } // end else
            } // end delete helper

            // method to check if the binary tree is empty, has no nodes in it
            public boolean isEmpty() {
                // if there's no nodes
                if(root== null) {
                    return true;
                } // end if
                else {
                    return false;
                } // end else
            }//end isEmpty

            //  determine if the object being passed is a current element in the tree if it is, return true, otherwise, return false
            public boolean find (Comparable val) {
                if (root.getValue() ==null) {
                    return false;
                } // end if
                else {
                    if (val.compareTo(root.getValue())== 0) {
                        return true; 
                    }// end if
                    else if (val.compareTo(root.getValue()) <= 0) {
                        if(root.getLeft() != null) {
                            return findHelper(root.getLeft(), val);
                        } // end if
                        else {
                            return false;
                        } // end else
                    } // end else if
                    else if (val.compareTo(root.getValue()) > 0) {
                        if (root.getRight() !=null) {
                            return findHelper(root.getRight(), val);
                        } // end if
                        else {
                            return false;
                        } // end else
                    } // end elsef if
                    else {
                        return false;
                    } // end else
                } // end else
            } // end find

            public boolean findHelper(TreeNode child, Comparable val) {
                if(child.getValue() == val) {
                    return true;
                } // end if
                else if (val.compareTo(child.getValue()) <=0) {
                    if (child.getLeft() != null) {
                        return findHelper(child.getLeft(), val);
                    } // end if
                    else {
                        return false;
                    } // end else
                } // end else if
                else if (val.compareTo(child.getValue()) > 0) {
                    if (child.getRight() !=null) {
                        return findHelper(child.getRight(), val);
                    } // end if
                    else {
                        return false;
                    } // end else
                } // end else if
                else  {
                    return false;
                } // end else
            } // end findHelper

            //  this method takes an “old” object – determines if it is currently in the tree and if it is, removes that object and adds the “toAdd” object.  If the element was successfully replaced then true is returned, if the old object did not exist then false is returned and the toAdd object is added to the BST.  Remember that you cannot just replace an element by changing its value because it may not belong at that spot in the tree after being replaced.  
            public boolean replace(Comparable old, Comparable toAdd)
            {
                if (find(old) == true) {
                    delete(old);
                    add(toAdd);
                    return true;
                } // end if
                else {
                    add(toAdd);
                    return false;
                } // end else
            } // end replace


        } // end  class
