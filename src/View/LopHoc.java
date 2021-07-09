package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Bean.lopHocBean;
import Bo.lopHocBo;
import Dao.dungChung;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.TextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LopHoc extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LopHoc frame = new LopHoc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	lopHocBo lhBo = new lopHocBo();
	void napBang(ArrayList<lopHocBean> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Ma lop"); mh.addColumn("Ten Lop");
		for(lopHocBean dv: ds) {
			Object[] t = new Object[2];
			t[0]=dv.getMalop(); t[1]=dv.getTenlop();
			mh.addRow(t);
		}
		table.setModel(mh);
	}
	
	public LopHoc() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					dungChung.ketNoi();
					napBang(lhBo.getlh());
				} catch (Exception e2) {
					e2.getMessage();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TH\u00D4NG TIN L\u1EDAP H\u1ECCC");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(248, 10, 167, 33);
		contentPane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(43, 249, 562, 175);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 L\u1EDBp");
		lblNewLabel_1.setBounds(43, 56, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("T\u00EAn L\u1EDBp");
		lblNewLabel_2.setBounds(43, 124, 59, 13);
		contentPane.add(lblNewLabel_2);
		
		TextField txtMa = new TextField();
		txtMa.setBounds(129, 48, 351, 21);
		contentPane.add(txtMa);
		
		TextField txtTen = new TextField();
		txtTen.setBounds(129, 116, 351, 21);
		contentPane.add(txtTen);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int n = lhBo.them(txtMa.getText(), txtTen.getText());
					if(n==0) 
						JOptionPane.showMessageDialog(null, "Trung ma");
					else {
						napBang(lhBo.getlh());
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setBounds(43, 192, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lhBo.xoa(txtMa.getText());
					napBang(lhBo.getlh());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_1.setBounds(193, 192, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CHANGE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lhBo.Sua(txtMa.getText(), txtTen.getText());
					napBang(lhBo.getlh());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_2.setBounds(350, 192, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("FIND");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = JOptionPane.showInputDialog("Nhap don vi can tim");
				napBang(lhBo.timlh(key));
			}
		});
		btnNewButton_3.setBounds(510, 192, 85, 21);
		contentPane.add(btnNewButton_3);
	}
}
