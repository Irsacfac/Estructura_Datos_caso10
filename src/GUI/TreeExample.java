package GUI;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.text.*;

class RemoveNodes{
    public static JButton button1, button2;
    public static DefaultTreeModel model;
    public static TreePath path;
    public static JTree tree;
    public static DefaultMutableTreeNode nNode;
    public static MutableTreeNode mNode;
    String nodeName;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Removing a Node to a JTree Component!");
        JPanel panel = new JPanel();
        DefaultMutableTreeNode myComputer = new DefaultMutableTreeNode("My Computer");
        DefaultMutableTreeNode c = new DefaultMutableTreeNode("Local Disk(C:)");
        DefaultMutableTreeNode vinod = new DefaultMutableTreeNode("Vinod");
        DefaultMutableTreeNode swing = new DefaultMutableTreeNode("Swing");
        DefaultMutableTreeNode tr = new DefaultMutableTreeNode("Tree");
        DefaultMutableTreeNode a = new DefaultMutableTreeNode("3½ Floppy(A:)");
        DefaultMutableTreeNode e = new DefaultMutableTreeNode("New Volume(E:)");
        c.add(vinod);
        vinod.add(swing);
        swing.add(tr);
        myComputer.add(c);
        myComputer.add(a);
        myComputer.add(e);
        tree = new JTree(myComputer);
        panel.add(tree);
        button1 = new JButton("Remove Specific Node");
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                model = (DefaultTreeModel)tree.getModel();
                String nodeName = JOptionPane.showInputDialog(null, "Enter the node name  which have to be deleted from tree:");

                if(nodeName.equals("")){
             ti        JOptionPane.showMessageDialog(null, "Node could not be  deleted from tree!");

                }
                else{
                    path = tree.getNextMatch(nodeName, 0, Position.Bias.Forward);
                    mNode = (MutableTreeNode)path.getLastPathComponent();
                    model.removeNodeFromParent(mNode);
                    JOptionPane.showMessageDialog(null, "Node are deleted from tree!");
                }
            }
        });
        panel.add(button1);
        button2 = new JButton("Remove Root Node");
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                model = (DefaultTreeModel)tree.getModel();
                model.setRoot(null);
                button1.setEnabled(false);
                button2.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Remove the root!");
            }
        });
        panel.add(button2);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setSize(200,300);
        frame.setVisible(true);
    }
}