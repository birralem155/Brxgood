import java.util.Stack;

public class Postfix {
  
// default constructor
public Postfix(){}
  
// method that decides the priority of each operator
static int precedence(char c)
{
switch(c)
{
case '+':
case '-':
return 1;
  
case '*':
case '/':
return 2;
  
case '^':
return 3;
}
return -1;
}
  
// method to convert an infix expression to a postfix expression
static String infixToPostfix(String expression)
{
String result = "";
  
Stack<Character> stack = new Stack<>();
  
for(int i = 0; i < expression.length(); i++)
{
char ch = expression.charAt(i);
if(Character.isLetterOrDigit(ch))
result += ch;
else if(ch == '(')
stack.push(ch);
else if(ch == ')')
{
while(!stack.isEmpty() && stack.peek() != '(')
result += stack.pop();
if(!stack.isEmpty() && stack.peek() != '(')
return "Invalid Expression Encountered!";
else
stack.pop();
}
else
{
while(!stack.isEmpty() && precedence(ch) <= precedence(stack.peek()))
result += stack.pop();
stack.push(ch);
}
}
while(!stack.isEmpty())
result += stack.pop();
  
return result;
}
}

PostfixTest.java

public class PostfixTest {
  
// default constructor
public PostfixTest(){}
  
public static String getPostfixExpression(String expression)
{
return Postfix.infixToPostfix(expression);
}
}

InfixToPostfixCalculatorUI.java (Main class)

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InfixToPostfixCalculatorUI {
  
private final JFrame mainFrame;
private final JPanel fieldPanel, buttonPanel, mainPanel;
private final JLabel infixLabel, postfixLabel;
private JTextField infixField, postfixField;
private final JButton evaluateButton, clearButton;
  
public InfixToPostfixCalculatorUI()
{
mainFrame = new JFrame();
mainPanel = new JPanel(new GridLayout(2, 1)); // row = 2, col = 1
  
// setting up the panel for containing the labels and the textfields
fieldPanel = new JPanel(new GridLayout(2, 1, 5, 25)); // row = 2, col = 1, horizontal gap between components = 5 and vertical gap between components = 25
infixLabel = new JLabel("Infix Expression:");
postfixLabel = new JLabel("Postfix Expression:");
infixField = new JTextField(20);
infixField.setHorizontalAlignment(SwingConstants.CENTER);
postfixField = new JTextField(20);
postfixField.setHorizontalAlignment(SwingConstants.CENTER);
postfixField.setEditable(false);
fieldPanel.add(infixLabel);
fieldPanel.add(infixField);
fieldPanel.add(postfixLabel);
fieldPanel.add(postfixField);
  
// setting up the panel for containing the 2 buttons
buttonPanel = new JPanel(new FlowLayout(1, 10, 25));
evaluateButton = new JButton("Evaluate");
clearButton = new JButton("Clear");
buttonPanel.add(evaluateButton);
buttonPanel.add(clearButton);
  
// adding the 2 panels to the main panel
mainPanel.add(fieldPanel);
mainPanel.add(buttonPanel);
mainFrame.add(mainPanel);
  
mainFrame.setTitle("Infix To Postfix Calculator");
mainFrame.setSize(350, 200);
mainFrame.setResizable(false);
mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
mainFrame.setLocationRelativeTo(null);
mainFrame.setVisible(true);
  
// action listener for evaluate button
evaluateButton.addActionListener((ActionEvent e) -> {
if(infixField.getText().equals(""))
JOptionPane.showMessageDialog(null, "Please provide a valid Infix expression!", "Field(s) Missing Alert"
, JOptionPane.ERROR_MESSAGE);
else
{
evaluateButton.setEnabled(false);
String infxiExpression = infixField.getText().trim();
postfixField.setText(PostfixTest.getPostfixExpression(infxiExpression));
}
});
  
clearButton.addActionListener((ActionEvent e) -> {
infixField.setText("");
postfixField.setText("");
evaluateButton.setEnabled(true);
});
}
  
public static void main(String[] args)
{
InfixToPostfixCalculatorUI infixToPostfixCalculatorUI = new InfixToPostfixCalculatorUI();
}
}
