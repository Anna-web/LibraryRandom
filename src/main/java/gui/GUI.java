package gui;

import books.interfaces.Available;
import human.Human;
import human.Prof;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class GUI extends JFrame {
    private JTree tree;
    private DefaultMutableTreeNode rootTree;
    private DefaultMutableTreeNode students;
    private DefaultMutableTreeNode profs;
    private JScrollPane scroll;
    private Random rand;

    public GUI(String name, ArrayList<Human> people, ArrayList<Available> books) {
        super(name);
        rand = new Random();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.rootTree = new DefaultMutableTreeNode("Пользователи");
        this.tree = new JTree(rootTree);
        this.students = new DefaultMutableTreeNode("Студенты");
        this.profs = new DefaultMutableTreeNode("Преподаватели");
        this.scroll = new JScrollPane(tree);
        rootTree.add(profs);
        rootTree.add(students);
        initHumanNodes(people, books);
        this.add(scroll);
    }

    private void initHumanNodes(ArrayList<Human> people, ArrayList<Available> books) {
        DefaultMutableTreeNode varNode;

        for (Human p : people) {
            varNode = new DefaultMutableTreeNode(p.sayHello());
            if (p instanceof Prof) {
                profs.add(varNode);
            } else {
                students.add(varNode);
            }
            initBookNodes(varNode, books);
        }
    }

    private void initBookNodes(DefaultMutableTreeNode parent,
                               ArrayList<Available> books) {
        ArrayList<Available> copy = new ArrayList<>(books);
        Collections.shuffle(copy);
        DefaultMutableTreeNode varNode;

        for (Available b : copy.subList(0, rand.nextInt(3, 10))) {
            varNode = new DefaultMutableTreeNode(b.getInfo());
            parent.add(varNode);
        }
    }
}