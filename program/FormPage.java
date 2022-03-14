package program;

//import libraries for the project
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import net.proteanit.sql.DbUtils;

public class FormPage {
	
	// Initialize components 

	public JFrame frame;
	JLayeredPane layeredPane;
	JPanel panelForm,panelReview;
	private JTextField txtAd;
	private JTextField txtTc;
	Connection conn=null;
	PreparedStatement prp=null;
	ResultSet rs =null;
	private JTable table;
	JDateChooser dcUzmalikBitis,dcUzmalikBaslama;
	Object[] rows;
	 DateOperation dateOperation = new DateOperation();
	 private JTextField jtfFilter;
	 private TableRowSorter<DefaultTableModel> rowSorter;
      
	
	//constructor for the Frame
	public FormPage() {
		
		conn =DbConnection.connect();
		initialize();			
		frame.setLocationRelativeTo(null);
	
		
	}

	//component initializer
	private void initialize() {
		
		
		//frame properties
	
		frame = new JFrame("Asistan Doktor Yönetim Sistemi");
		frame.setBounds(100, 100, 635, 762);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//layeredPane for multiple panels
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 46, 1332, 677);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		//this is the form panel
		panelForm = new JPanel();
		layeredPane.add(panelForm, "layeredPane");
		panelForm.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ASÝSTAN DOKTOR BÝLGÝLERÝ");
		lblNewLabel.setBounds(144, 43, 297, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelForm.add(lblNewLabel);
		
		JPanel panelPicture = new JPanel();
		panelPicture.setBounds(235, 83, 128, 160);
		panelForm.add(panelPicture);
		panelPicture.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnPictureAdd = new JButton("Foto\u011Fraf");
		panelPicture.add(btnPictureAdd);
		
		JButton btnKaydet = new JButton("KAYDET");
		btnKaydet.addActionListener(new ActionListener() {			
			//Check the times if not suitable
			public void actionPerformed(ActionEvent e) {
				
				if(dcUzmalikBaslama.getDate() == null || dcUzmalikBitis.getDate() ==null) {
					JOptionPane.showMessageDialog(null, "Lütfen bütün alanlarý doldurunuz!");
				}
			else if(dateOperation.compareDates( dcUzmalikBaslama.getDate(),dcUzmalikBitis.getDate())==false) {
					JOptionPane.showMessageDialog(null, "Uzmanlýk baþlama tarihi bitiþ tarihinden önce olmalýdýr.");
				}			
				else {
					insert();
				}
				
				
				
			}
			
			
		});
		btnKaydet.setBounds(257, 612, 132, 52);
		panelForm.add(btnKaydet);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(117, 281, 408, 318);
		panelForm.add(panel_1);
		
		JPanel panelAd = new JPanel();
		panel_1.add(panelAd);
		
		JLabel lblNewLabel_2 = new JLabel("Ad Soyad:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		//text field for name and surname
		txtAd = new JTextField();
		txtAd.setColumns(10);
		
		
		GroupLayout gl_panelAd = new GroupLayout(panelAd);
		gl_panelAd.setHorizontalGroup(
			gl_panelAd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAd.createSequentialGroup()
					.addGap(7)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtAd, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelAd.setVerticalGroup(
			gl_panelAd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAd.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panelAd.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAd, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
		);
		panelAd.setLayout(gl_panelAd);
		
		
		
		JPanel panelTc = new JPanel();
		panel_1.add(panelTc);
		
		JLabel lblNewLabel_2_1 = new JLabel("TC No:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		//textfield for tc
		txtTc = new JTextField();
		txtTc.setColumns(10);
		
	
		GroupLayout gl_panelTc = new GroupLayout(panelTc);
		gl_panelTc.setHorizontalGroup(
			gl_panelTc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTc.createSequentialGroup()
					.addGap(1)
					.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtTc, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		gl_panelTc.setVerticalGroup(
			gl_panelTc.createParallelGroup(Alignment.LEADING)
				.addGap(0, 44, Short.MAX_VALUE)
				.addGroup(gl_panelTc.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panelTc.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTc, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
		);
		panelTc.setLayout(gl_panelTc);
		
		JLabel lblUzmanlkEitimi = new JLabel("Uzmanl\u0131k E\u011Fitimi");
		panel_1.add(lblUzmanlkEitimi);
		lblUzmanlkEitimi.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JPanel panelUzBaslama = new JPanel();
		panel_1.add(panelUzBaslama);
		
		JLabel lblNewLabel_2_2 = new JLabel("Ba\u015Flama Tarihi:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		//datechooser for  proficiency
		 dcUzmalikBaslama = new JDateChooser();
		 
		 		GroupLayout gl_panelUzBaslama = new GroupLayout(panelUzBaslama);
		 		gl_panelUzBaslama.setHorizontalGroup(
		 			gl_panelUzBaslama.createParallelGroup(Alignment.LEADING)
		 				.addGroup(gl_panelUzBaslama.createSequentialGroup()
		 					.addContainerGap()
		 					.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
		 					.addPreferredGap(ComponentPlacement.UNRELATED)
		 					.addComponent(dcUzmalikBaslama, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
		 					.addGap(12))
		 		);
		 		gl_panelUzBaslama.setVerticalGroup(
		 			gl_panelUzBaslama.createParallelGroup(Alignment.LEADING)
		 				.addGroup(Alignment.TRAILING, gl_panelUzBaslama.createSequentialGroup()
		 					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		 					.addGroup(gl_panelUzBaslama.createParallelGroup(Alignment.TRAILING)
		 						.addComponent(dcUzmalikBaslama, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		 						.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
		 					.addGap(13))
		 		);
		 		panelUzBaslama.setLayout(gl_panelUzBaslama);
		 		
		 		JPanel panelUzBitis = new JPanel();
		 		panel_1.add(panelUzBitis);
		 		
		 		JLabel lblNewLabel_2_2_1 = new JLabel("Biti\u015F: Tarihi:");
		 		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 		
		 		dcUzmalikBitis = new JDateChooser();
		 		GroupLayout gl_panelUzBitis = new GroupLayout(panelUzBitis);
		 		gl_panelUzBitis.setHorizontalGroup(
		 			gl_panelUzBitis.createParallelGroup(Alignment.LEADING)
		 				.addGap(0, 304, Short.MAX_VALUE)
		 				.addGroup(gl_panelUzBitis.createSequentialGroup()
		 					.addContainerGap()
		 					.addComponent(lblNewLabel_2_2_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
		 					.addPreferredGap(ComponentPlacement.UNRELATED)
		 					.addComponent(dcUzmalikBitis, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
		 					.addGap(12))
		 		);
		 		gl_panelUzBitis.setVerticalGroup(
		 			gl_panelUzBitis.createParallelGroup(Alignment.LEADING)
		 				.addGap(0, 44, Short.MAX_VALUE)
		 				.addGroup(Alignment.TRAILING, gl_panelUzBitis.createSequentialGroup()
		 					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		 					.addGroup(gl_panelUzBitis.createParallelGroup(Alignment.TRAILING)
		 						.addComponent(dcUzmalikBitis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		 						.addComponent(lblNewLabel_2_2_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
		 					.addGap(13))
		 		);
		 		panelUzBitis.setLayout(gl_panelUzBitis);
		
		 panelReview = new JPanel();
		layeredPane.add(panelReview, "sss");
		panelReview.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("KAYITLI ASÝSTANLAR");
		lblNewLabel_1.setBounds(570, 5, 221, 25);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelReview.add(lblNewLabel_1);
		
	
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 150, 1246, 573);
		panelReview.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 1226, 191);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel());
		
		JButton btnDelete = new JButton("SÝL");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					deleteRow();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(1044, 235, 111, 34);
		panel.add(btnDelete);
		
		JButton btnEdit = new JButton("DÜZENLE");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	frame.dispose();
			 if(table.getSelectedRowCount()==0) {
					JOptionPane.showMessageDialog(null, "Bir satýr seçmelisin");
				}else {
					String tc= getSelectedData(0);
					String fullname=getSelectedData(1);
					Date uzBaslama= dcUzmalikBaslama.getDate();
					Date uzBit=dcUzmalikBitis.getDate();
				
					
					
					@SuppressWarnings("unused")
					UpdateForm updateForm = new UpdateForm(tc,fullname,uzBaslama,uzBit);
				}
			
	
			
			
					
			}
		});
		btnEdit.setBounds(904, 240, 97, 25);
		panel.add(btnEdit);
		panel.add(btnDelete);
		JLabel lblNewLabel_3 = new JLabel("Ara:");
		lblNewLabel_3.setBounds(562, 121, 56, 16);
		panelReview.add(lblNewLabel_3);
		
		jtfFilter = new JTextField();
		jtfFilter.setToolTipText("Tc no ile arama");
		jtfFilter.setBounds(607, 118, 116, 22);
		panelReview.add(jtfFilter);
		jtfFilter.setColumns(10);
		
		JButton btnForm = new JButton("Yeni asistan");
		btnForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setBounds(100, 100, 635, 762);
				frame.setLocationRelativeTo(null);
				switchPanel(panelForm);
				
			}
		});
		btnForm.setBounds(10, 12, 103, 35);
		frame.getContentPane().add(btnForm);
		
		JButton btnKayitForm = new JButton("Kayýtlar");
		
		btnKayitForm.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				 searchTable();
					getTableData();
					 rowSorter= new TableRowSorter<DefaultTableModel>((DefaultTableModel)table.getModel());
				frame.setSize(1300, 800);
				frame.setLocationRelativeTo(null);
				switchPanel(panelReview);
			}
		});
		btnKayitForm.setBounds(131, 12, 103, 35);
		frame.getContentPane().add(btnKayitForm);			
		
	}
	
	public String getSelectedData(int index) {
	return	table.getValueAt(table.getSelectedRow(), index).toString();
	}
		public void deleteRow() throws SQLException {
			if(table.getSelectedRowCount()==1) {
				String value = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
				String query="delete from asistanlar where tc =" +value;
				prp=conn.prepareStatement(query);
				prp.execute();			
				getTableData();
				
			}else if(table.getSelectedRowCount()==0) {
				JOptionPane.showMessageDialog(null, "Bir satýr seçmelisin");
			}
			
		}
		
		public void getTableData()  {
			//rows= new Object[6];
			try {
				
				String query= "select tc,fullname, uz_bas,uz_bitis, staj_bas,staj_bitis,calisma_yerleri,klinik from asistanlar";
				prp=conn.prepareStatement(query);
				rs =prp.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
		
				//set column names;
				String header[] = {"TC","Ad Soyad", "Uzmanlýk Baþlama", "Uzmanlýk Bitiþ", "Staj Baþlama", "Staj Bitiþ", "Çalýþma Yeri", "Klinik Tipi"};
				  
				for(int i=0;i<table.getColumnCount();i++)
				{
				TableColumn column1 = table.getTableHeader().getColumnModel().getColumn(i);
				  
				column1.setHeaderValue(header[i]);
				} 
				
			}catch (SQLException e){
				
				e.printStackTrace();
				
			}
		}
	
	   public void insert() {
		   	 
	        String sql = "INSERT INTO asistanlar(tc,fullname, uz_bas,uz_bitis,kalan_gun) "
	        		+ "VALUES(?,?,strftime('%d/%m/%Y',? , 'unixepoch'),"
	        		+ "strftime('%d/%m/%Y',? , 'unixepoch'),?)";

	        try{
	        	if(txtTc.getText() == null || txtAd.getText() == null) {
	        		JOptionPane.showMessageDialog(null, "Lütfen bütün alanlarý doldurunuz!");
	        	}if(txtTc.getText().length() != 11) {
	        		JOptionPane.showMessageDialog(null, "TC no 11 haneli olmalýdýr!");
	        	}
	        	else {
	        		prp= conn.prepareStatement(sql);
		        	prp.setLong(1, Long.parseLong(txtTc.getText()));  //tc insert
		            prp.setString(2, txtAd.getText()); // ad-soyad insert 
		            prp.setLong(3,dateOperation.convertDate(dcUzmalikBaslama.getDate())); // uzmanlýk baþlama insert
		            prp.setLong(4, dateOperation.convertDate(dcUzmalikBitis.getDate())); //uzmanlýk bitiþ insert
		            prp.setInt(5, (int) dateOperation.getDateDiff(dcUzmalikBaslama.getDate(), dcUzmalikBitis.getDate()));
		            prp.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Baþarýyla kaydedildi.");
	        	}
	        	System.out.println(DateOperation.getDateDiff(dcUzmalikBaslama.getDate(), dcUzmalikBitis.getDate()));
	        	
	        } catch (SQLException e) {
	        	if(e.getErrorCode()==19) {
	        		JOptionPane.showMessageDialog(null, "Girilmiþ olan TC numarasý daha önceden kaydedilmiþtir.");	   
	        	}else {
	        		JOptionPane.showMessageDialog(null, "Veritabanýna baðlanamadý.");	
	        	}
	        }catch(NumberFormatException e) {
	        	JOptionPane.showMessageDialog(null, "TC rakamlardan oluþmalýdýr" );
	        }
	    }
	   
	
	//this function switches between panels
	public void switchPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	//TODO: not searching for data
	public void searchTable() {
		jtfFilter= new JTextField();
		rowSorter=new TableRowSorter<DefaultTableModel>((DefaultTableModel) table.getModel());
		jtfFilter.getDocument().addDocumentListener((DocumentListener) new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
	
	}
}
