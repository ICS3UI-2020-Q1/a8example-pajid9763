import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
  JLabel firstSideLabel;
  JLabel secondSideLabel;
  JLabel thirdSideLabel;

  JTextField firstSideInput;
  JTextField secondSideInput;
  JTextField thirdSideInput;

  JButton validateButton;
  JButton resetButton;

  JTextArea outputText;
  JTextArea instructionText;



  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    // initialize the main JPanel
    mainPanel = new JPanel();
    // turn on the manual layouts 
    mainPanel.setLayout(null);
    // add the panel to JFrame to see it
    frame.add(mainPanel);


    // create the Labels that let the user know what to enter
    firstSideLabel = new JLabel("Enter the first side:");
    secondSideLabel = new JLabel("Enter the second side:");
    thirdSideLabel = new JLabel("Enter the third side:");

    // set the location and size of the Labels
    firstSideLabel.setBounds(10, 10, 150, 20);
    secondSideLabel.setBounds(10, 40, 170, 20);
    thirdSideLabel.setBounds(10, 70, 150, 20);
    
    // add the labels to the mainPanel so we can see it
    mainPanel.add(firstSideLabel);
    mainPanel.add(secondSideLabel);
    mainPanel.add(thirdSideLabel);

    // initialize the JTextFields
    firstSideInput = new JTextField();
    secondSideInput = new JTextField();
    thirdSideInput = new JTextField();

    // set the location and size for the input fields
    firstSideInput.setBounds(200, 10, 100, 20);
    secondSideInput.setBounds(200, 40, 100, 20);
    thirdSideInput.setBounds(200, 70, 100, 20);

    // add the input to the main panel
    mainPanel.add(firstSideInput);
    mainPanel.add(secondSideInput);
    mainPanel.add(thirdSideInput);


    // initialize the JButtons
    validateButton = new JButton("Validate");
    resetButton = new JButton("Reset");

    // add actionListener to the buttons
    validateButton.addActionListener(this);
    resetButton.addActionListener(this);

    // give each button an action command
    validateButton.setActionCommand("validate");
    resetButton.setActionCommand("reset");

    // set the location and size of the buttons
    validateButton.setBounds(320, 10, 100, 35);
    resetButton.setBounds(320, 55, 100, 35);

    // add the buttons to the main panel
    mainPanel.add(validateButton);
    mainPanel.add(resetButton);


    // initialize the JButtons
    outputText = new JTextArea();
    instructionText = new JTextArea();

    // set the location and size of the buttons 
    outputText.setBounds(10, 100, 780, 245);
    instructionText.setBounds(10, 355, 780, 245);

    // disable the textAreas so the user can't type in them
    outputText.setEnabled(false);
    instructionText.setEnabled(false);

    // put some text inside instructionText
    instructionText.setText("This is a simple Triangle detector.\nEnter an integer in each of the text fields above.\nPress the button \"Validate\" to find out whether you have made a valid triangle or not.\nPress the \"Clear\" button to clear the previous text.");

    // add the buttons to the main panel
    mainPanel.add(outputText);
    mainPanel.add(instructionText);


  }
  // checks to see if a triangle with the lengths a, b, and c are valid
  public boolean isValidTriangle(int a, int b, int c){
    // using the triangle inequality to determine if it is valid
    if( a + b > c && a + c > b && b + c > a){
      return true;
    } else {
      return false;
    }
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if( command.equals("validate")){
      // the validate button was pressed
      // get all of the input as a String
      String firstText = firstSideInput.getText();
      String secondText = secondSideInput.getText();
      String thirdText = thirdSideInput.getText();

      // convert those to integers
      int firstSide = Integer.parseInt(firstText);
      int secondSide = Integer.parseInt(secondText);
      int thirdSide = Integer.parseInt(thirdText);

      // determine if valid triangle
      boolean isValid = isValidTriangle(firstSide, secondSide, thirdSide);

      // let the user know if the triangle is a valid one or not
      if (isValid){
        outputText.setText("This triangle is valid");
      } else {
        outputText.setText("This triangle is invalid");
      }


    }else if ( command.equals("reset")){
      // the reset button was pressed
      firstSideInput.setText("");
      secondSideInput.setText("");
      thirdSideInput.setText("");
      outputText.setText("");
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
