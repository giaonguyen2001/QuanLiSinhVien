package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Bean.lopHocBean;
import Bean.sinhVienBean;
import Bo.lopHocBo;
import Bo.sinhVienBo;
import Dao.dungChung;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.List;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class qlsvView extends JFrame {
	TextField txtmasv = new TextField();
	TextField txtht = new TextField();
	TextField txtgt = new TextField();
	TextField txtns = new TextField();
	List list = new List();

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					qlsvView frame = new qlsvView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	lopHocBo lhBo = new lopHocBo();
	sinhVienBo svBo = new sinhVienBo();
	ArrayList<sinhVienBean> ds = new ArrayList<sinhVienBean>();
	void napBang(ArrayList<sinhVienBean> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Ma sv"); 
		mh.addColumn("Ho ten");
		mh.addColumn("Gioi tinh nam"); 
		mh.addColumn("Ngay sinh");
		mh.addColumn("Ma lop"); 
		for(sinhVienBean dv: ds) {
			Object[] t = new Object[5];
			t[0] = dv.getMasv();
			t[1] = dv.getHoten();
			t[2] = String.valueOf(dv.getGioitinh());	
			t[3] = String.valueOf(dv.getNgaysinh());
			t[4] = dv.getMalop();
			mh.addRow(t);
		}
		table.setModel(mh);
	}
	
	public qlsvView() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					dungChung.ketNoi();
					for(lopHocBean dv:lhBo.getlh())
						list.add(dv.getMalop());
					napBang(svBo.getsv());
						
				} catch (Exception e2) {
					
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QU\u1EA2N L\u00CD SINH VI\u00CAN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(341, 10, 180, 31);
		contentPane.add(lblNewLabel);
		list.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					String malop = list.getSelectedItem();
					ArrayList<sinhVienBean> svBean = new ArrayList<sinhVienBean>();
					for(sinhVienBean sv : svBo.getsv()) {
						if (sv.getMalop().equals(malop)) {
							svBean.add(sv);
						}
					}
					napBang(svBean);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		
		list.setBounds(10, 74, 104, 181);
		contentPane.add(list);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 sinh vi\u00EAn");
		lblNewLabel_1.setBounds(152, 82, 73, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("H\u1ECD t\u00EAn");
		lblNewLabel_2.setBounds(152, 132, 73, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblNewLabel_3.setBounds(152, 182, 73, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ng\u00E0y sinh");
		lblNewLabel_4.setBounds(152, 225, 73, 13);
		contentPane.add(lblNewLabel_4);
		
	
		txtmasv.setBounds(251, 74, 234, 21);
		contentPane.add(txtmasv);
		
		txtht.setBounds(251, 124, 234, 21);
		contentPane.add(txtht);
		
	
		txtgt.setBounds(251, 174, 234, 21);
		contentPane.add(txtgt);
		
		
		txtns.setBounds(251, 217, 234, 21);
		contentPane.add(txtns);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 301, 775, 156);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int d=table.getSelectedRow();
					String masv=(String) table.getValueAt(d, 0).toString();
					txtmasv.setText(masv);
					String hoten=(String) table.getValueAt(d, 1).toString();
					txtht.setText(hoten);
					String gioitinh=(String) table.getValueAt(d, 2).toString();
					txtgt.setText(gioitinh);
					String ngaysinh=(String) table.getValueAt(d, 3).toString();
					txtns.setText(ngaysinh);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_6 = new JLabel("Danh s\u00E1ch sinh vi\u00EAn");
		lblNewLabel_6.setBounds(82, 305, 239, 13);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("T\u00ECm ki\u1EBFm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = JOptionPane.showInputDialog("Nhap ma sinh vien can tim kiem");
				napBang(svBo.timsv(key));
			}
		});
		btnNewButton.setBounds(592, 70, 129, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Th\u00EAm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String malop = list.getSelectedItem();
					int n = svBo.them(txtmasv.getText(), txtht.getText(), txtgt.getText(), txtns.getText(), malop);
					if(n==0)
						JOptionPane.showMessageDialog(null, "Ma trung");
					else {
						napBang(svBo.getsv());
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(592, 112, 129, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("X\u00F3a");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String key = JOptionPane.showInputDialog("Nhap ma sinh vien can xoa !");
					svBo.xoa(key);
					napBang(svBo.getsv());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_2.setBounds(592, 154, 129, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("S\u1EEDa");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String malop = list.getSelectedItem();
					svBo.sua(txtmasv.getText(), txtht.getText(), txtgt.getText(), txtns.getText(), malop);
					napBang(svBo.getsv());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(592, 194, 129, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Nh\u1EADp d\u1EEF li\u1EC7u");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int n=svBo.Import();
					if( n==0) JOptionPane.showMessageDialog(null,"trung ma");
					else 	napBang(svBo.getsv());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(592, 234, 129, 21);
		contentPane.add(btnNewButton_4);
	}
}
