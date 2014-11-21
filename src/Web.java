import java.awt.EventQueue;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;


public class Web {

	private JFrame frame;
	private JTextField txtUrl;
	private JEditorPane editorPane,editorPane_1;
	private JTextField textField_1;
	private JTextArea txtrHeader;
	private JTextArea txtrHea;
	private JScrollPane scrollPane_3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Web window = new Web();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Web() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setResizable(false);
		frame.setTitle("Wassamol Sakarin s5050445@kmitl.ac.th - Java Web Browser (Network Programming Class Assignment)");
		frame.setBounds(100, 100, 1235, 689);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Get  Link");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtrHeader.setText("");
				txtrHea.setText("");
				MyThread a = new MyThread("Thread_A",editorPane,txtUrl,txtrHea,txtrHea);
				MyThread b = new MyThread("Thread_B",editorPane_1,textField_1,txtrHeader,txtrHea);
				a.start();
				b.start();
			}
		});
		btnNewButton.setBounds(490, 9, 255, 30);
		frame.getContentPane().add(btnNewButton);
		
		txtUrl = new JTextField();
		txtUrl.setBounds(10, 45, 600, 25);
		frame.getContentPane().add(txtUrl);
		txtUrl.setColumns(10);

		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(editorPane);
		scrollPane.setBounds(10, 75, 600, 430);
		frame.getContentPane().add(scrollPane);
		
		editorPane_1 = new JEditorPane();
		editorPane_1.setEditable(false);
		
		JScrollPane scrollPane_2 = new JScrollPane(editorPane_1);
		scrollPane_2.setBounds(619, 75, 600, 430);
		frame.getContentPane().add(scrollPane_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(619, 45, 600, 25);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		txtrHea = new JTextArea();
		txtrHea.setEditable(false);
		txtrHea.setText("Header");
		
		JScrollPane scrollPane_1 = new JScrollPane(txtrHea);
		scrollPane_1.setBounds(10, 515, 600, 140);
		frame.getContentPane().add(scrollPane_1);
		
		txtrHeader = new JTextArea();
		txtrHeader.setEditable(false);
		txtrHeader.setText("Header");
		
		scrollPane_3 = new JScrollPane(txtrHeader);
		scrollPane_3.setBounds(619, 515, 600, 140);
		frame.getContentPane().add(scrollPane_3);

	}
}
