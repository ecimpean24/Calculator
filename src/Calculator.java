import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    private JPanel panel;
    private JFrame frame;
    private JTextField textField;

    JButton buttonAdd,buttonSub,buttonMul,buttonDiv,buttonEqu,buttonCom,buttonClr,buttonDel;
    JButton[] func = new JButton[8];
    JButton[] nums = new JButton[10];

    Double num1, num2, result;
    Character op;


    Font myFont = new Font("Algerian", Font.TRUETYPE_FONT, 30);
    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,700);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,50, 400,50);
        textField.setFont(myFont);
        textField.setEditable(false);


        buttonAdd = new JButton("+");
        buttonSub = new JButton("-");
        buttonMul = new JButton("*");
        buttonDiv = new JButton("/");
        buttonEqu = new JButton("=");
        buttonCom = new JButton(".");
        buttonDel = new JButton("Delete");
        buttonClr = new JButton("Clear");

        func[0] = buttonAdd;
        func[1] = buttonSub;
        func[2] = buttonMul;
        func[3] = buttonDiv;
        func[4] = buttonCom;
        func[5] = buttonEqu;
        func[6] = buttonDel;
        func[7] = buttonClr;

        for(int i=0; i<8;i++){
            func[i].addActionListener(this);
            func[i].setFont(myFont);
            func[i].setFocusable(false);
        }

        for(int i=0; i<10;i++){
            nums[i] = new JButton(String.valueOf(i));
            nums[i].addActionListener(this);
            nums[i].setFont(myFont);
            nums[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(50,125, 400,400);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(nums[1]);
        panel.add(nums[2]);
        panel.add(nums[3]);
        panel.add(func[0]);

        panel.add(nums[4]);
        panel.add(nums[5]);
        panel.add(nums[6]);
        panel.add(func[1]);

        panel.add(nums[7]);
        panel.add(nums[8]);
        panel.add(nums[9]);
        panel.add(func[2]);

        panel.add(buttonCom);
        panel.add(nums[0]);
        panel.add(buttonEqu);
        panel.add(buttonDiv);

        buttonClr.setBounds(50,550, 150, 40);
        buttonDel.setBounds(300, 550, 150, 40);
        frame.add(panel);
        frame.add(buttonClr);
        frame.add(buttonDel);
        frame.add(textField);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<10; i++){
            if(e.getSource() == nums[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == buttonCom){
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource() == buttonAdd){
            num1 = Double.parseDouble(textField.getText());
            op = '+';
            textField.setText("");
        }

        if(e.getSource() == buttonSub){
            num1 = Double.parseDouble(textField.getText());
            op = '-';
            textField.setText("");
        }

        if(e.getSource() == buttonMul){
            num1 = Double.parseDouble(textField.getText());
            op = '*';
            textField.setText("");
        }

        if(e.getSource() == buttonDiv){
            num1 = Double.parseDouble(textField.getText());
            op = '/';
            textField.setText("");
        }

        if(e.getSource() == buttonEqu) {
            num2 = Double.parseDouble(textField.getText());

            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if(e.getSource() == buttonClr){
            textField.setText("");
        }

        if(e.getSource() == buttonDel){
            textField.setText(textField.getText().substring(0,textField.getText().length()-1));
        }

    }
}
