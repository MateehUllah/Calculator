import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    //Declaration
    JFrame frame;
    JTextField textField2;
    JTextField textField;
    JButton[] numButtons = new JButton[10];
    JButton[] funButtons = new JButton[14];
    JButton addButton, subButton, mulButton, divButton;
    JButton decimal, signChange, equal;
    JButton percentage, Sqrt, Sqr, div;
    JButton Clear, ClearEntry, RemoveOneDigit;
    JPanel panel;
    ImageIcon icon;

    //Color Scheme
    Color back = new Color(230, 230, 230);
    Color fun=new Color(240, 240, 240);
    Color numCol=new Color(250, 250, 250);
//Fonts
    Font myFont = new Font("Segoe UI", Font.BOLD, 30);
    Font numFont = new Font("Segoe UI", Font.BOLD,20 );
    Font funFont = new Font("Segoe UI",Font.PLAIN,20);
    Font txt2=new Font("Segoe UI",Font.PLAIN,12);
    double num1 = 0, num2 = 0, result = 0;
    double result2=0;
    char operator;

    Calculator() {
        //Initialization
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 500);
        frame.setLayout(null);
        frame.setBackground(back);

        //Adding Icons
        icon= new ImageIcon("Icon.png");
        frame.setIconImage(icon.getImage());


        //First Text Field
        textField = new JTextField();
        textField.setBounds(50, 50, 300, 50);
        textField.setFont(myFont);
        textField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setEditable(false);
        //Second Text Field
        textField2 = new JTextField();
        textField2.setBounds(50, 20, 300, 30);
        textField2.setFont(txt2);
        textField2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        textField2.setHorizontalAlignment(SwingConstants.RIGHT);
        textField2.setEditable(false);

        //Creating Buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        divButton = new JButton("÷");
        mulButton = new JButton("*");
        decimal = new JButton(".");
        signChange = new JButton("±");
        equal = new JButton("=");
        percentage = new JButton("%");
        Sqrt = new JButton("√");
        div = new JButton("⅟x");
        Clear = new JButton("C");
        ClearEntry = new JButton("CE");
        Sqr = new JButton("x²");
        RemoveOneDigit = new JButton("←");


        //Adding Buttons in array
        funButtons[0] = addButton;
        funButtons[1] = subButton;
        funButtons[2] = divButton;
        funButtons[3] = mulButton;
        funButtons[4] = decimal;
        funButtons[5] = signChange;
        funButtons[6] = equal;
        funButtons[7] = percentage;
        funButtons[8] = Sqrt;
        funButtons[9] = Sqr;
        funButtons[10] = div;
        funButtons[11] = Clear;
        funButtons[12] = ClearEntry;
        funButtons[13] = RemoveOneDigit;


        //Setting Properties for function button
        for (int i = 0; i < 14; i++) {
            funButtons[i].addActionListener(this);
            funButtons[i].setFont(funFont);
            funButtons[i].setFocusable(false);
            funButtons[i].setBackground(fun);
            funButtons[i].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        }
        //Setting Properties for Number Buttons
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(numFont);
            numButtons[i].setFocusable(false);
            numButtons[i].setBackground(numCol);
            numButtons[i].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        }

        //Creating Panel and adding button in it
        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(6,4,2,2));
        panel.add(funButtons[7]);
        panel.add(funButtons[8]);
        panel.add(funButtons[9]);
        panel.add(funButtons[10]);
        panel.add(funButtons[12]);
        panel.add(funButtons[11]);
        panel.add(funButtons[13]);
        panel.add(funButtons[2]);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(funButtons[3]);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(funButtons[1]);
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(funButtons[0]);

        panel.add(funButtons[5]);
        panel.add(numButtons[0]);
        panel.add(funButtons[4]);
        panel.add(funButtons[6]);
        //Panel.setBackground(Color.GRAY);


//Adding Panel and text fields in frame
        frame.add(panel);
        frame.add(textField);
        frame.add(textField2);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // write your code here
        Calculator obj = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == numButtons[i]) {//Adding text
                    textField.setText(textField.getText().concat(String.valueOf(i)));
                }
            }
            if (e.getSource() == decimal) {//Decimal
                textField.setText(textField.getText().concat("."));
            }
            if (e.getSource() == addButton) {//add button
                if(result==0) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = '+';
                    textField2.setText(textField.getText() + '+');
                    textField.setText("");
                    num2 = -1;
                }else{
                    num1 = result;
                    textField2.setText(String.valueOf(num1) + '+');
                    operator = '+';
                    textField.setText("");
                    num2 = -1;
                }
            }
            if (e.getSource() == divButton) {//Divide Button
                if(result==0) {
                    num1 = Double.parseDouble(textField.getText());
                    textField2.setText(textField.getText() + '÷');
                    operator = '÷';
                    textField.setText("");
                    num2 = -1;
                }else{
                    num1 = result;
                    textField2.setText(String.valueOf(num1) + '÷');
                    operator = '÷';
                    textField.setText("");
                    num2 = -1;
                }
            }
            if (e.getSource() == mulButton) {//Multiply Button
                if(result==0) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = '*';
                    textField2.setText(textField.getText() + '*');
                    textField.setText("");
                    num2 = -1;
                }else{
                    num1 = result;
                    textField2.setText(String.valueOf(num1) + '*');
                    operator = '*';
                    textField.setText("");
                    num2 = -1;

                }
            }
            if (e.getSource() == subButton) {//Subtraction Button
                if(result==0) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = '-';
                    textField2.setText(textField.getText() + '-');
                    textField.setText("");
                    num2 = -1;
                }else{
                    num1 = result;
                    textField2.setText(String.valueOf(num1) + '-');
                    operator = '-';
                    textField.setText("");
                    num2 = -1;

                }
            }
            if (e.getSource() == Sqr) {//Square
                if(result==0) {
                    num1 = Double.parseDouble(textField.getText());
                    result = num1 * num1;
                    textField2.setText(String.valueOf(result));
                    num1 = result;
                    textField.setText("");
                }else{
                    result = result * result;
                    textField2.setText(String.valueOf(result));
                    num1 = result;
                    textField.setText("");
                }
            }
            if (e.getSource() == percentage) {//Percentage
                if(result==0) {
                    num1 = Double.parseDouble(textField.getText());
                    result = num1 / 100;
                    textField2.setText(String.valueOf(result));
                    num1 = result;
                    textField.setText("");
                }
                else{
                    result = result / 100;
                    textField2.setText(String.valueOf(result));
                    num1 = result;
                    textField.setText("");
                }
            }
            if (e.getSource() == div) {//1/x
                if(result==0) {
                    num1 = Double.parseDouble(textField.getText());
                    result = 1 / num1;
                    textField2.setText(String.valueOf(result));
                    num1 = result;
                    textField.setText("");
                }else{
                    num1=result;
                    result = 1 / num1;
                    textField2.setText(String.valueOf(result));
                    num1 = result;
                    textField.setText("");
                }
            }
            if (e.getSource() == Sqrt) {//Square root
                if(result==0) {
                    num1 = Double.parseDouble(textField.getText());
                    result = Math.sqrt(num1);
                    textField2.setText(String.valueOf(result));
                    num1 = result;
                    textField.setText("");
                }else{
                    result = Math.sqrt(num1);
                    textField2.setText(String.valueOf(result));
                    num1 = result;
                    textField.setText("");
                }

            }
            if (e.getSource() == equal) {//Equal
                try {
                  //System.out.println(num1);
                    // System.out.println(num2);
                    if(num2!=0) {
                        num2 = Double.parseDouble(textField.getText());
                        String txt = Double.toString(num1) + " " + operator + " " + Double.toString(num2) + " =";
                        textField2.setText(txt);
                        //txt="";
                        switch (operator) {
                            case '+' -> result = num1 + num2;
                            case '*' -> result = num1 * num2;
                            case '-' -> result = num1 - num2;
                            case '÷' -> result = num1 / num2;
                        }
                        textField2.setText(txt + String.valueOf(result));
                        num1 = result;
                    }
                    else{
                        num1=Double.parseDouble(textField.getText());
                        String txt = Double.toString(num1)+" =";
                        textField2.setText(txt + String.valueOf(num1));
                        result=num1;

                    }

                } catch (Exception omg) {
                    textField.setText("Error");
                }
            }
            if (e.getSource() == Clear) {//Clearing all entities
                num1 = 0;
                num2 = 0;
                result = 0;
                operator=' ';
                textField.setText("");
                textField2.setText("");
            }
            if (e.getSource() == ClearEntry) {//Clearing one entity

                if(num2!=0)
                {
                    num2=0;
                    textField.setText("");
                }
                else{
                    num1=0;
                    textField2.setText("");
                }

            }
            if (e.getSource() == RemoveOneDigit) {//Removing one digit
                String string = textField.getText();
                textField.setText("");
                for (int i = 0; i < string.length() - 1; i++) {
                    textField.setText(textField.getText() + string.charAt(i));
                }
            }
            if (e.getSource() == signChange) {//Changing sign
                if(result==0) {
                    double temp = Double.parseDouble(textField.getText());
                    temp *= -1;
                    textField.setText(String.valueOf(temp));
                }
                else{
                    result*=-1;
                    textField.setText(String.valueOf(result));
                }
            }
        }
        catch(Exception obj){
            textField.setText("Error");
        }
    }

}
