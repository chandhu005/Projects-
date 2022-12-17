package Calculators;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ButtonGroup;

public class ScentificCal {

	private JFrame frame;
	private JTextField textField;
	double firstNo;
	double secondNo;
	double result;//store the current result
     String operation;// store which operation need to be done 
     String answer;// store the answers final results
     private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScentificCal window = new ScentificCal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScentificCal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 470, 707);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sceintific Calculator");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(41, 10, 436, 28);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 48, 436, 76);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnR = new JButton("\u221A");
		btnR.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Math.sqrt(Double.parseDouble(textField.getText()));
				//a=a*a;
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btnR.setBounds(10, 134, 79, 66);
		frame.getContentPane().add(btnR);
		
		JButton btn1x = new JButton("1/x");
		btn1x.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn1x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=1/(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btn1x.setBounds(10, 210, 79, 66);
		frame.getContentPane().add(btn1x);
		
		JButton btnXpowY = new JButton("x^y");
		btnXpowY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNo=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="X^Y";
				
			}
		});
		//btnXpowY.setBackground(new Color(240, 240, 240));
		btnXpowY.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnXpowY.setBounds(10, 286, 79, 66);
		frame.getContentPane().add(btnXpowY);
		
		JButton btnX3 = new JButton("X^3");
		btnX3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Double.parseDouble(textField.getText());
				a=a*a*a;
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btnX3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnX3.setBounds(10, 362, 79, 66);
		frame.getContentPane().add(btnX3);
		
		JButton btnX2 = new JButton("X^2");
		btnX2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Double.parseDouble(textField.getText());
				a=a*a;
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btnX2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnX2.setBounds(10, 438, 79, 66);
		frame.getContentPane().add(btnX2);
		
		JButton btnex = new JButton("e^x");
		btnex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Math.exp(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btnex.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnex.setBounds(99, 134, 79, 66);
		frame.getContentPane().add(btnex);
		
		JButton btnsin = new JButton("Sin");
		btnsin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Math.sin(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btnsin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnsin.setBounds(188, 133, 79, 66);
		frame.getContentPane().add(btnsin);
		
		JButton btnCos = new JButton("Cos");
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Math.cos(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btnCos.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCos.setBounds(277, 133, 79, 66);
		frame.getContentPane().add(btnCos);
		
		JButton btnTan = new JButton("Tan");
		btnTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Math.tan(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btnTan.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTan.setBounds(366, 134, 79, 66);
		frame.getContentPane().add(btnTan);
		
		JButton btnLog = new JButton("Log");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Math.log(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btnLog.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLog.setBounds(99, 210, 79, 66);
		frame.getContentPane().add(btnLog);
		
		JButton btnpercent = new JButton("%");
		btnpercent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNo=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="%";
			}
		});
		btnpercent.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnpercent.setBounds(99, 286, 79, 66);
		frame.getContentPane().add(btnpercent);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// first we need to set the text in text field so we use setText here
				// we need to get the text in the TextFiled as well as from the button thats why we use getfunction.
				String number=textField.getText()+btn7.getText();
				textField.setText(number);
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 19));
		btn7.setBounds(99, 362, 79, 66);
		frame.getContentPane().add(btn7);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btn4.getText();
				textField.setText(number);
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 19));
		btn4.setBounds(99, 438, 79, 66);
		frame.getContentPane().add(btn4);
		
		JButton btnSinh = new JButton("Sinh");
		btnSinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Math.sinh(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btnSinh.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSinh.setBounds(188, 210, 79, 66);
		frame.getContentPane().add(btnSinh);
		// for clear button 
		JButton btnc = new JButton("C");
		btnc.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/// need to empty the text in textfield so we asssign it to null
				textField.setText(null);
			}
		});
		btnc.setBounds(188, 286, 79, 66);
		frame.getContentPane().add(btnc);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String number=textField.getText()+btn8.getText();
			textField.setText(number);
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 19));
		btn8.setBounds(188, 362, 79, 66);
		frame.getContentPane().add(btn8);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btn5.getText();
				textField.setText(number);
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 19));
		btn5.setBounds(188, 438, 79, 66);
		frame.getContentPane().add(btn5);
		
		JButton btnCosh = new JButton("Cosh");
		btnCosh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Math.cosh(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btnCosh.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCosh.setBounds(277, 210, 79, 66);
		frame.getContentPane().add(btnCosh);
		
		JButton btnB = new JButton("\uF0E7");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backspace=null;
				if(textField.getText().length()>0) {
					StringBuilder str=new StringBuilder(textField.getText());
					str.deleteCharAt(textField.getText().length()-1);
					backspace=str.toString();
					textField.setText(backspace);
					
				}
				//step 1: checking textfield length is greater than 0 or not
				//step 2 : if>1 take the text in the text filed
				//step 3: need to delete the last character of the string in the textfied
				//step 4: change the null to string 
				//step 5: set text last element to null 
			}
		});
		btnB.setFont(new Font("Wingdings", Font.BOLD, 18));
		btnB.setBounds(277, 286, 79, 66);
		frame.getContentPane().add(btnB);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btn9.getText();
				textField.setText(number);
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 19));
		btn9.setBounds(277, 362, 79, 66);
		frame.getContentPane().add(btn9);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btn6.getText();
				textField.setText(number);
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 19));
		btn6.setBounds(277, 438, 79, 66);
		frame.getContentPane().add(btn6);
		
		JButton btntanh = new JButton("Tanh");
		btntanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Math.tanh(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btntanh.setFont(new Font("Tahoma", Font.BOLD, 16));
		btntanh.setBounds(366, 210, 79, 66);
		frame.getContentPane().add(btntanh);
		
		JButton btnplus = new JButton("+");
		btnplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// need to get the text from the user parsdouble returns string value 
				//we have to set as empty becse we no need to print +
				// we need to done operation 
				firstNo=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="+";
			}
		});
		btnplus.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnplus.setBounds(366, 286, 79, 66);
		frame.getContentPane().add(btnplus);
		
		JButton btnsub = new JButton("-");
		btnsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNo=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="-";
			}
		});
		btnsub.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnsub.setBounds(366, 362, 79, 66);
		frame.getContentPane().add(btnsub);
		
		JButton btnmul = new JButton("*");
		btnmul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNo=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="*";
			}
		});
		btnmul.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnmul.setBounds(366, 438, 79, 66);
		frame.getContentPane().add(btnmul);
		
		JButton btnNfact = new JButton("n!");
		btnNfact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Double.parseDouble(textField.getText());
				double fact=1;
		           while(a!=0) {
		        	   fact=fact*a;
		        	   a--;
		           }
		           textField.setText("");
		           textField.setText(textField.getText()+fact);
			}
		});
		btnNfact.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNfact.setBounds(10, 514, 79, 66);
		frame.getContentPane().add(btnNfact);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btn1.getText();
				textField.setText(number);
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 19));
		btn1.setBounds(99, 514, 79, 66);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btn2.getText();
				textField.setText(number);
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 19));
		btn2.setBounds(188, 514, 79, 66);
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btn3.getText();
				textField.setText(number);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 19));
		btn3.setBounds(277, 514, 79, 66);
		frame.getContentPane().add(btn3);
		
		JButton btndev = new JButton("/");
		btndev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNo=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="/";
			}
		});
		btndev.setFont(new Font("Tahoma", Font.BOLD, 19));
		btndev.setBounds(366, 514, 79, 66);
		frame.getContentPane().add(btndev);
		
		JButton btnpm = new JButton("+/-");
		btnpm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double b=Double.parseDouble(String.valueOf(textField.getText()));
				b=b*(-1);
				textField.setText(String.valueOf(b));
			}
		});
		btnpm.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnpm.setBounds(10, 590, 79, 66);
		frame.getContentPane().add(btnpm);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btn0.getText();
				textField.setText(number);
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn0.setBounds(99, 590, 168, 66);
		frame.getContentPane().add(btn0);
		
		JButton btndot = new JButton(".");
		btndot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btndot.getText();
				textField.setText(number);
			}
		});
		btndot.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btndot.setBounds(277, 590, 79, 66);
		frame.getContentPane().add(btndot);
		
		JButton btnequal = new JButton("=");
		btnequal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondNo=Double.parseDouble(textField.getText());// taking second number form user
				if(operation=="+") {
					result=firstNo+secondNo; //adding two no
					answer=String.format("%2f", result); // changes to formated string
					textField.setText(answer);//set the answer in textFiled
				}
				else if(operation=="-") {
					result=firstNo-secondNo; //adding two no
					answer=String.format("%2f", result); // changes to formated string
					textField.setText(answer);//set the answer in textFiled
				}
				else if(operation=="*") {
					result=firstNo*secondNo; //adding two no
					answer=String.format("%2f", result); // changes to formated string
					textField.setText(answer);//set the answer in textFiled
				}
				else if(operation=="/") {
					result=firstNo/secondNo; //adding two no
					answer=String.format("%2f", result); // changes to formated string
					textField.setText(answer);//set the answer in textFiled
				}
				else if(operation=="%") {
					result=firstNo%secondNo; //adding two no
					answer=String.format("%2f", result); // changes to formated string
					textField.setText(answer);//set the answer in textFiled
				}
				else if(operation=="X^Y") {
					double  power=1;
					for(int i=0;i<secondNo;i++) {
						power=power*firstNo;
					}
					//result=firstNo%secondNo; //adding two no
					answer=String.format("%2f", power); // changes to formated string
					textField.setText(answer);//set the answer in textFiled
				}
			}
		});
		btnequal.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnequal.setBounds(366, 590, 79, 66);
		frame.getContentPane().add(btnequal);
	}
}
