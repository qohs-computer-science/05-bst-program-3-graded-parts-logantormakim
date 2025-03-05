import java.lang.Comparable;

public class BST implements BSTInterface
{
    private TreeNode root = new TreeNode(null);

    public BST () {
        root=null;
    }
    // add
    public void add(Comparable val) {
        if(root == null)
	            root = new TreeNode(val, null,null);
        else if (val.compareTo(root.getValue()) <= 0) {
	        addHelper(val, root.getLeft(), root);
        }
        else {
	        addHelper(val, root.getRight(), root);
        }
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


        public void printInOrder() // prints the list in order
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

        public void printPreOrder() // prints in pre order
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

        public void printPostOrder() // prints in post order
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
        // method to delete a node from the tree and to properly replace it or not replace it with a node
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

            public boolean deleteHelper(Comparable old, TreeNode child, TreeNode parent) {
                if (child ==null) {
                    return false;
                }
                else if (child.getValue().compareTo(old) == 0) {
                        if (child.getLeft()!= null && child.getRight()!= null) { //2 children
                            TreeNode temp = child.getLeft();
                                while (temp.getRight() != null) {
                                    temp= temp.getRight();
                                }
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
                        
                    }
                    else {
                        deleteHelper(old, child.getRight(), child);
                        return false;
                    }
            } // end delete helper
        } // end  class
