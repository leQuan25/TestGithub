 	package ketnoiCSDL;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import entities.Sinhvien;
import pro.read;
import regex.batloi;



public class giaodien extends JFrame implements ActionListener, ListSelectionListener {
	
	private JLabel l1;
	private JLabel l2;
	
	private JButton btDN;
	private JTextField tfEM;
	private JLabel l4;
	private JLabel l3;
	private JTextField tfT;
	private JButton BTthem;
	private JTextField tfMS;
	private JTextField tfHT;
	private DefaultTableModel dtm;
	private JTable table;
	private ArrayList<Sinhvien> lst;
	private JButton BTload;
	private JButton BTthoat;
	private JButton BTxoa;
	private JButton BTluu;
	


	public giaodien() throws Exception {
		setTitle("demo connect");
		setSize(500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		gui();
		table();
//		loadXML();
		loadDB();
		//filltable();
	}
	
	
	
	
	
	private void loadXML() throws Exception {
		Document document =read.readFileXml("XML/GIGO1.txt");
		NodeList nodes = document.getElementsByTagName("hocsinh");
		for(int i=0;i<nodes.getLength();i++)
		{
			Node node = nodes.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE)
				{
					Element element = (Element) node;
					String id= element.getAttribute("id");
					String name= element.getElementsByTagName("ten").item(0).getTextContent();
					String lop= element.getElementsByTagName("lop").item(0).getTextContent();
					String em= element.getElementsByTagName("email").item(0).getTextContent();
				
					Sinhvien sv = new Sinhvien(id, name, lop, em);
					try {
						sinhvienDAO dao2= new sinhvienDAO();
						dao2.persist(sv);
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			
		}
		
	
		
	}





	private void loadDB() throws Exception {
		
		
		
		Document document =read.readFileXml("XML/GIGO1.txt");
		NodeList nodes = document.getElementsByTagName("hocsinh");
		for(int i=0;i<nodes.getLength();i++)
		{
			Node node = nodes.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE)
				{
					Element element = (Element) node;
					String id= element.getAttribute("id");
					String name= element.getElementsByTagName("ten").item(0).getTextContent();
					String lop= element.getElementsByTagName("lop").item(0).getTextContent();
					String em= element.getElementsByTagName("email").item(0).getTextContent();
				
					Sinhvien sv = new Sinhvien(id, name, lop, em);
					try {
						sinhvienDAO dao2= new sinhvienDAO();
						dao2.persist(sv);
						
						
						//sinhvienDAO load = new sinhvienDAO();
//						lst = dao2.getAll();
//						for (Sinhvien sv1 : lst) {
//							String[] row = { sv1.getMaso(), sv1.getHoten(),sv1.getLop(),
//									sv1.getEmail()};
//							dtm.addRow(row);
//						}
						
						
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			
		}
		
		
		
		
		
		sinhvienDAO load = new sinhvienDAO();
		lst = load.getAll();
		for (Sinhvien sv : lst) {
			String[] row = { sv.getMaso(), sv.getHoten(),sv.getLop(),
					sv.getEmail()};
			dtm.addRow(row);
		}
	}
	
	
	
private void table() {
	JPanel CenPane = new JPanel();
	CenPane.setLayout(new BorderLayout());
	CenPane.setBorder(BorderFactory.createTitledBorder("Danh sách sinh vien"));
	String[] title = { "MA SO", "Ten", "Lop", "Email"};
	dtm = new DefaultTableModel(title, 0);
	table = new JTable(dtm);
	JScrollPane scrp = new JScrollPane(table);
	CenPane.add(scrp);
	table.getSelectionModel().addListSelectionListener(this);
	this.add(CenPane,BorderLayout.CENTER);
		
	}



private void gui() {
		Box b =Box.createVerticalBox();
		Box b3= Box.createHorizontalBox();
		Box b1= Box.createHorizontalBox();
		Box b2= Box.createHorizontalBox();
		Box b4= Box.createHorizontalBox();
		Box b5= Box.createHorizontalBox();
		Box b6= Box.createHorizontalBox();
		b.add(Box.createHorizontalStrut(10));
		b.add(b5);b.add(Box.createVerticalStrut(8));
		b.add(b1);b.add(Box.createVerticalStrut(18));
		b.add(b2);b.add(Box.createVerticalStrut(8));
		b.add(b3);b.add(Box.createVerticalStrut(8));
		b.add(b4);b.add(Box.createVerticalStrut(8));
		b.add(b6);b.add(Box.createVerticalStrut(8));
		b5.add(new JLabel("----nhap thong tin sinh vien----"));
		
		b1.add(l1=new JLabel("Ten :",JLabel.RIGHT));
		b1.add(tfHT=new JTextField(20));
		b2.add(l2=new JLabel("maso :",JLabel.RIGHT));
		b2.add(tfMS=new JTextField(20));
        b3.add(l3=new JLabel("lop :",JLabel.RIGHT));
		b3.add(tfT=new JTextField(20));
		b4.add(l4=new JLabel("email :",JLabel.RIGHT));
		b4.add(tfEM=new JTextField(20));
		
		l1.setPreferredSize(l2.getPreferredSize());
		l3.setPreferredSize(l2.getPreferredSize());
		l4.setPreferredSize(l2.getPreferredSize());
		
		b6.add(BTthem= new JButton("them sinh vien"));
		b6.add(BTluu= new JButton("luu"));
		b6.add(BTthoat= new JButton("thoat"));
		b6.add(BTxoa= new JButton("xoa"));
		BTthem.addActionListener(this);
		BTthoat.addActionListener(this);
		BTxoa.addActionListener(this);
		BTluu.addActionListener(this);
		this.add(b,BorderLayout.NORTH);
		disen(false);
	}






private void disen(boolean state) {
	tfMS.setEnabled(state);
	tfHT.setEnabled(state);
	tfT.setEnabled(state);
	tfEM.setEnabled(state);
}

private void clearField() {
	tfMS.setText("");	
	tfHT.setText("");
	tfT.setText("");
	tfEM.setText("");
	
}




@Override
public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	if(o.equals(BTthem))
	{
		if (BTthem.getText().equals("them sinh vien")) 
			{
			BTthem.setText("Hủy");
			BTluu.setEnabled(true);
			BTxoa.setEnabled(false);	
			disen(true);
			clearField();
			} else {
			
				BTthem.setText("them sinh vien"); 
				
				BTluu.setEnabled(false);
				BTxoa.setEnabled(true);
				disen(false);
				clearField();

					}
	}
		
		if(o.equals(BTluu))
		{
			String ms =tfMS.getText();
			String name=tfHT.getText();
			String email=tfEM.getText();
			String lop=tfT.getText();
			if(! new batloi().kiemtaten1(ms)|| ms.trim().equals(""))
			{
			JOptionPane.showMessageDialog(null, "nhập mã số sai!! mã số không được rỗng");
			return;
			}
	
			if(name.trim().equals(""))
			{
			JOptionPane.showMessageDialog(null, "Ten không cho rỗng");
			return;
			}
			if(! new batloi().kiemtralop((lop)))
			{
			JOptionPane.showMessageDialog(null, "nhập lop sai!! lop theo dinh dang 2 chu so dau va 1 chu cai in hoa  ");
			return;
			}
			
			if(! new batloi().kiemtraemai(email))
			{
			JOptionPane.showMessageDialog(null, "nhập email sai!! email nhập theo định dạng xxx@gmail.com");
			return;
			}

			
			
			Sinhvien sv = new Sinhvien(tfMS.getText(), tfHT.getText(), tfT.getText(), tfEM.getText());
			try {
				sinhvienDAO dao = new sinhvienDAO();
				dao.persist(sv);
				JOptionPane.showConfirmDialog(null, "xong");
				String[] row = { sv.getMaso(), sv.getHoten(),sv.getLop(),sv.getEmail()};
				dtm.addRow(row);			
				} catch (Exception e2) {
				e2.printStackTrace();
										}
			
			
			
		}


	if(o.equals(BTthoat))
	{
		JOptionPane.showConfirmDialog(null, "chac chan thoat");
		System.exit(1);		
	}
	
	if(o.equals(BTxoa))
	{
		Sinhvien sv = new Sinhvien(tfMS.getText(), tfHT.getText(), tfT.getText(), tfEM.getText());
		try {
			sinhvienDAO dao2= new sinhvienDAO();
			dao2.delete(sv);
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
		int selRow=table.getSelectedRow();
		if(selRow==-1)
		{
			return;
		}else
		{
		dtm.removeRow(selRow);
		JOptionPane.showMessageDialog(null, "xong");
		}
	}


	

	
}



@Override
public void valueChanged(ListSelectionEvent arg0) {
	// TODO Auto-generated method stub
	int selRow=table.getSelectedRow();
	if(selRow==-1)
	{
		return;
	}else
	{
	String ms=table.getValueAt(selRow, 0).toString();
	String ht=table.getValueAt(selRow, 1).toString();
	String ns=table.getValueAt(selRow, 2).toString();
	String em=table.getValueAt(selRow, 3).toString();
	tfMS.setText(ms);
	tfHT.setText(ht);
	tfT.setText(ns);
	tfEM.setText(em);
	}
}

}
