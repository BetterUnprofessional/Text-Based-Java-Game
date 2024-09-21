import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class gui {

    public static JFrame frame;
    public static JPanel invPanel;
    public static JPanel txtPanel;
    

    public static void runGui(){
        //set up the container
        frame = new JFrame("Trekker RPG");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);;


        //setup first JPanel
        Dimension minSizeinv = new Dimension(600,800);
        invPanel = new JPanel();
        invPanel.setBackground(Color.gray);
        invPanel.setMinimumSize(minSizeinv);

        
        //setup second JPanel for text
        Dimension minSizeTxt = new Dimension(600,800);
        txtPanel = new JPanel();
        txtPanel.setMinimumSize(minSizeTxt);
        txtPanel.setBackground(Color.white);

        //create a split container to hold the side by side panels
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, invPanel, txtPanel);
        splitPane.setDividerLocation(400); //Set divider location
        

        //Create the text input panel
        JPanel inputPanel = new JPanel();
        JTextField textField = new JTextField(45);
        inputPanel.add(textField);

        //Create a main panel to hold the split pane and the input panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(splitPane, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        //add the main panel to the frame
        frame.add(mainPanel);

        //make the frame visible
        frame.setVisible(true);
    }
}
