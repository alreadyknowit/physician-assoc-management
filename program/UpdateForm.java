package program;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class UpdateForm {

	private JFrame frame;
	private JTextField txtAd;
	private JTextField txtTc;
	private JComboBox<String > cbCalisma,cbIzinler;
	Connection conn=null;
	PreparedStatement prp=null;
	ResultSet rs=null;
	private String tc,fullname;
	JCheckBox cbPoliklinik,cbKlinik;
	private Date uzBaslama,uzBitis;
	JDateChooser dcUzmalikBaslama,dcUzmalikBitis,dcStajBaslama,dcStajBitis,dcIzinBaslama,dcIzinBitis ; 
	private JPanel panelIzinler;
		
	public UpdateForm(String tc, String fullname,Date uzBaslama,Date uzBitis) {
		conn=DbConnection.connect();
		this.uzBaslama=uzBaslama;
		this.tc=tc;
		this.fullname=fullname;
		this.uzBitis=uzBitis;
		initialize();
		disablePanel(panelIzinler,false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
		private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1300, 800);		
		JPanel panelForm = new JPanel();
		panelForm.setLayout(null);
		frame.getContentPane().add(panelForm, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("ASÝSTAN DOKTOR BÝLGÝLERÝ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(532, 5, 297, 25);
		panelForm.add(lblNewLabel);
		
		JPanel panelAd = new JPanel();
		panelAd.setBounds(33, 72, 304, 44);
		panelForm.add(panelAd);
		
		JLabel lblNewLabel_2 = new JLabel("Ad Soyad:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtAd = new JTextField(fullname);
		txtAd.setColumns(10);
		GroupLayout gl_panelAd = new GroupLayout(panelAd);
		gl_panelAd.setHorizontalGroup(
			gl_panelAd.createParallelGroup(Alignment.LEADING)
				.addGap(0, 304, Short.MAX_VALUE)
				.addGroup(gl_panelAd.createSequentialGroup()
					.addGap(7)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtAd, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelAd.setVerticalGroup(
			gl_panelAd.createParallelGroup(Alignment.LEADING)
				.addGap(0, 44, Short.MAX_VALUE)
				.addGroup(gl_panelAd.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panelAd.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAd, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
		);
		panelAd.setLayout(gl_panelAd);
		
		JPanel panelTc = new JPanel();
		panelTc.setBounds(33, 127, 304, 44);
		panelForm.add(panelTc);
		
		JLabel lblNewLabel_2_1 = new JLabel("TC No:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtTc = new JTextField(tc);
		txtTc.setColumns(10);
		GroupLayout gl_panelTc = new GroupLayout(panelTc);
		gl_panelTc.setHorizontalGroup(
			gl_panelTc.createParallelGroup(Alignment.LEADING)
				.addGap(0, 304, Short.MAX_VALUE)
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
		
		JPanel panelUzBaslama = new JPanel();
		panelUzBaslama.setBounds(33, 202, 304, 44);
		panelForm.add(panelUzBaslama);
		
		JLabel lblNewLabel_2_2 = new JLabel("Baþlama Tarihi:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		 dcUzmalikBaslama = new JDateChooser(uzBaslama);
		GroupLayout gl_panelUzBaslama = new GroupLayout(panelUzBaslama);
		gl_panelUzBaslama.setHorizontalGroup(
			gl_panelUzBaslama.createParallelGroup(Alignment.LEADING)
				.addGap(0, 304, Short.MAX_VALUE)
				.addGroup(gl_panelUzBaslama.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(dcUzmalikBaslama, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);
		gl_panelUzBaslama.setVerticalGroup(
			gl_panelUzBaslama.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 44, Short.MAX_VALUE)
				.addGroup(gl_panelUzBaslama.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelUzBaslama.createParallelGroup(Alignment.TRAILING)
						.addComponent(dcUzmalikBaslama, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(13))
		);
		panelUzBaslama.setLayout(gl_panelUzBaslama);
		
		JLabel lblUzmanlkEitimi = new JLabel("Uzmanlýk Eðitimi");
		lblUzmanlkEitimi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUzmanlkEitimi.setBounds(104, 179, 150, 25);
		panelForm.add(lblUzmanlkEitimi);
		
		JPanel panelUzBitis = new JPanel();
		panelUzBitis.setBounds(33, 248, 304, 44);
		panelForm.add(panelUzBitis);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Bitiþ: Tarihi:");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		 dcUzmalikBitis = new JDateChooser(uzBitis);
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
			gl_panelUzBitis.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 44, Short.MAX_VALUE)
				.addGroup(gl_panelUzBitis.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelUzBitis.createParallelGroup(Alignment.TRAILING)
						.addComponent(dcUzmalikBitis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_2_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(13))
		);
		panelUzBitis.setLayout(gl_panelUzBitis);
		
		JPanel panelPicture = new JPanel();
		panelPicture.setBounds(610, 60, 128, 160);
		panelForm.add(panelPicture);
		panelPicture.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnPictureAdd = new JButton("Fotoðraf");
		panelPicture.add(btnPictureAdd);
		
		 panelIzinler = new JPanel();
		panelIzinler.setBounds(508, 512, 369, 255);
		panelForm.add(panelIzinler);
		
		JLabel lblIzinler = new JLabel("Ýzinler    ");
		lblIzinler.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelIzinler.add(lblIzinler);
		
		JPanel panelIzinTuru = new JPanel();
		panelIzinler.add(panelIzinTuru);
		
		JLabel lblNewLabel_2_2_2_1_1_1 = new JLabel("\u0130zin T\u00FCr\u00FC:");
		lblNewLabel_2_2_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbIzinler = new JComboBox<String>();
		cbIzinler.setModel(new DefaultComboBoxModel<String>(new String[] {"YILLIK \u0130Z\u0130N", "ASKERL\u0130K \u0130ZN\u0130", "BABALIK \u0130ZN\u0130", "\u00D6L\u00DCM \u0130ZN\u0130", "S\u00DCT \u0130ZN\u0130", "N\u0130KAH \u0130ZN\u0130", "DO\u011EUM \u0130ZN\u0130", "\u00DCCRETS\u0130Z \u0130Z\u0130N", "MAZARET \u0130ZN\u0130"}));
		GroupLayout gl_panelIzinTuru = new GroupLayout(panelIzinTuru);
		gl_panelIzinTuru.setHorizontalGroup(
			gl_panelIzinTuru.createParallelGroup(Alignment.LEADING)
				.addGap(0, 304, Short.MAX_VALUE)
				.addGroup(gl_panelIzinTuru.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_2_2_1_1_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(cbIzinler, 0, 160, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelIzinTuru.setVerticalGroup(
			gl_panelIzinTuru.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 52, Short.MAX_VALUE)
				.addGap(0, 52, Short.MAX_VALUE)
				.addGap(0, 52, Short.MAX_VALUE)
				.addGroup(gl_panelIzinTuru.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelIzinTuru.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_2_2_1_1_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbIzinler, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(13))
		);
		panelIzinTuru.setLayout(gl_panelIzinTuru);
		
		JPanel panelIzýnBaslama = new JPanel();
		panelIzinler.add(panelIzýnBaslama);
		
		JLabel lblNewLabel_2_2_4 = new JLabel("Baþlama Tarihi:");
		lblNewLabel_2_2_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		 dcIzinBaslama = new JDateChooser();
		GroupLayout gl_panelIzýnBaslama = new GroupLayout(panelIzýnBaslama);
		gl_panelIzýnBaslama.setHorizontalGroup(
			gl_panelIzýnBaslama.createParallelGroup(Alignment.LEADING)
				.addGap(0, 304, Short.MAX_VALUE)
				.addGroup(gl_panelIzýnBaslama.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_2_4, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(dcIzinBaslama, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);
		gl_panelIzýnBaslama.setVerticalGroup(
			gl_panelIzýnBaslama.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 50, Short.MAX_VALUE)
				.addGroup(gl_panelIzýnBaslama.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelIzýnBaslama.createParallelGroup(Alignment.TRAILING)
						.addComponent(dcIzinBaslama, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_2_4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(13))
		);
		panelIzýnBaslama.setLayout(gl_panelIzýnBaslama);
		JPanel panelIzýnBitis = new JPanel();
		panelIzinler.add(panelIzýnBitis);
		JLabel lblNewLabel_2_2_1_2 = new JLabel("Bitiþ Tarihi:");
		lblNewLabel_2_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		 dcIzinBitis = new JDateChooser();
		GroupLayout gl_panelIzýnBitis = new GroupLayout(panelIzýnBitis);
		gl_panelIzýnBitis.setHorizontalGroup(
			gl_panelIzýnBitis.createParallelGroup(Alignment.LEADING)
				.addGap(0, 304, Short.MAX_VALUE)
				.addGroup(gl_panelIzýnBitis.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_2_1_2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(dcIzinBitis, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);
		gl_panelIzýnBitis.setVerticalGroup(
			gl_panelIzýnBitis.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 50, Short.MAX_VALUE)
				.addGroup(gl_panelIzýnBitis.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelIzýnBitis.createParallelGroup(Alignment.TRAILING)
						.addComponent(dcIzinBitis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_2_1_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(13))
		);
		panelIzýnBitis.setLayout(gl_panelIzýnBitis);
		
		JButton btnKaydet = new JButton("GÜNCELLE");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateUzmanlik();
				updateDB();
				FormPage main = new FormPage();
				main.getTableData();

			}
		});
		btnKaydet.setBounds(1043, 642, 132, 52);
		panelForm.add(btnKaydet);
		
		JButton btnEnableIzin = new JButton("Izin ver");
		btnEnableIzin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disablePanel(panelIzinler,true);
			}
		});
		btnEnableIzin.setBounds(602, 438, 89, 23);
		panelForm.add(btnEnableIzin);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(881, 164, 396, 293);
		panelForm.add(panel_2);
		
		JLabel lblRotasyonlar_1 = new JLabel("ROTASYONLAR");
		lblRotasyonlar_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(lblRotasyonlar_1);
		
		JPanel panelKardiyoloji_1 = new JPanel();
		panel_2.add(panelKardiyoloji_1);
		
		JLabel lblNewLabel_2_2_3_2 = new JLabel("Kardiyoloji:");
		lblNewLabel_2_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JDateChooser dcKardiyoloji_1 = new JDateChooser();
		GroupLayout gl_panelKardiyoloji_1 = new GroupLayout(panelKardiyoloji_1);
		gl_panelKardiyoloji_1.setHorizontalGroup(
			gl_panelKardiyoloji_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 308, Short.MAX_VALUE)
				.addGroup(gl_panelKardiyoloji_1.createSequentialGroup()
					.addGap(6)
					.addComponent(lblNewLabel_2_2_3_2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(dcKardiyoloji_1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);
		gl_panelKardiyoloji_1.setVerticalGroup(
			gl_panelKardiyoloji_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 56, Short.MAX_VALUE)
				.addGroup(gl_panelKardiyoloji_1.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addGroup(gl_panelKardiyoloji_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2_2_3_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(dcKardiyoloji_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelKardiyoloji_1.setLayout(gl_panelKardiyoloji_1);
		
		JPanel panelRadyoloji_1 = new JPanel();
		panel_2.add(panelRadyoloji_1);
		
		JLabel lblNewLabel_2_2_3_1_2 = new JLabel("Radyoloji:");
		lblNewLabel_2_2_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JDateChooser dcRadyoloji_2 = new JDateChooser();
		GroupLayout gl_panelRadyoloji_1 = new GroupLayout(panelRadyoloji_1);
		gl_panelRadyoloji_1.setHorizontalGroup(
			gl_panelRadyoloji_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 308, Short.MAX_VALUE)
				.addGap(0, 314, Short.MAX_VALUE)
				.addGroup(gl_panelRadyoloji_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_2_3_1_2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(dcRadyoloji_2, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);
		gl_panelRadyoloji_1.setVerticalGroup(
			gl_panelRadyoloji_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 52, Short.MAX_VALUE)
				.addGap(0, 44, Short.MAX_VALUE)
				.addGroup(gl_panelRadyoloji_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelRadyoloji_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(dcRadyoloji_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_2_3_1_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(13))
		);
		panelRadyoloji_1.setLayout(gl_panelRadyoloji_1);
		
		JPanel panelIntaniye_1 = new JPanel();
		panel_2.add(panelIntaniye_1);
		
		JLabel lblNewLabel_2_2_3_1_1_2 = new JLabel("Ýntaniye:");
		lblNewLabel_2_2_3_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JDateChooser dcRadyoloji_1_1 = new JDateChooser();
		GroupLayout gl_panelIntaniye_1 = new GroupLayout(panelIntaniye_1);
		gl_panelIntaniye_1.setHorizontalGroup(
			gl_panelIntaniye_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 308, Short.MAX_VALUE)
				.addGap(0, 314, Short.MAX_VALUE)
				.addGap(0, 314, Short.MAX_VALUE)
				.addGroup(gl_panelIntaniye_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_2_3_1_1_2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(dcRadyoloji_1_1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);
		gl_panelIntaniye_1.setVerticalGroup(
			gl_panelIntaniye_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 52, Short.MAX_VALUE)
				.addGap(0, 44, Short.MAX_VALUE)
				.addGap(0, 44, Short.MAX_VALUE)
				.addGroup(gl_panelIntaniye_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelIntaniye_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(dcRadyoloji_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_2_3_1_1_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(13))
		);
		panelIntaniye_1.setLayout(gl_panelIntaniye_1);
		
		JPanel panelGog_1 = new JPanel();
		panel_2.add(panelGog_1);
		
		JLabel lblNewLabel_2_2_3_1_1_1_1 = new JLabel("Göðüs Hastalýklarý:");
		lblNewLabel_2_2_3_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JDateChooser dcGog_1 = new JDateChooser();
		GroupLayout gl_panelGog_1 = new GroupLayout(panelGog_1);
		gl_panelGog_1.setHorizontalGroup(
			gl_panelGog_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 320, Short.MAX_VALUE)
				.addGroup(gl_panelGog_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_2_3_1_1_1_1, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(dcGog_1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelGog_1.setVerticalGroup(
			gl_panelGog_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 52, Short.MAX_VALUE)
				.addGap(0, 44, Short.MAX_VALUE)
				.addGap(0, 44, Short.MAX_VALUE)
				.addGroup(gl_panelGog_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelGog_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(dcGog_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_2_3_1_1_1_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(13))
		);
		panelGog_1.setLayout(gl_panelGog_1);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(33, 381, 369, 283);
		panelForm.add(panel_1);
		
		JLabel lblStajBilgileri_1 = new JLabel("Staj Bilgileri");
		lblStajBilgileri_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblStajBilgileri_1);
		
		JPanel panelStajBaslama_1 = new JPanel();
		panel_1.add(panelStajBaslama_1);
		
		JLabel lblNewLabel_2_2_2_2 = new JLabel("Baþlama Tarihi:");
		lblNewLabel_2_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		

		dcStajBaslama = new JDateChooser();
		GroupLayout gl_panelStajBaslama_1 = new GroupLayout(panelStajBaslama_1);
		gl_panelStajBaslama_1.setHorizontalGroup(
			gl_panelStajBaslama_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 308, Short.MAX_VALUE)
				.addGroup(gl_panelStajBaslama_1.createSequentialGroup()
					.addComponent(lblNewLabel_2_2_2_2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(dcStajBaslama, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);
		gl_panelStajBaslama_1.setVerticalGroup(
			gl_panelStajBaslama_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 52, Short.MAX_VALUE)
				.addGroup(gl_panelStajBaslama_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelStajBaslama_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2_2_2_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(dcStajBaslama, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(13))
		);
		panelStajBaslama_1.setLayout(gl_panelStajBaslama_1);
		
		JPanel panelStajBitis_1 = new JPanel();
		panel_1.add(panelStajBitis_1);
		
		JLabel lblNewLabel_2_2_2_1_2 = new JLabel("Bitiþ Tarihi:");
		lblNewLabel_2_2_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		 dcStajBitis = new JDateChooser();
		GroupLayout gl_panelStajBitis_1 = new GroupLayout(panelStajBitis_1);
		gl_panelStajBitis_1.setHorizontalGroup(
			gl_panelStajBitis_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 308, Short.MAX_VALUE)
				.addGap(0, 308, Short.MAX_VALUE)
				.addGroup(gl_panelStajBitis_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_2_2_1_2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(dcStajBitis, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);
		gl_panelStajBitis_1.setVerticalGroup(
			gl_panelStajBitis_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 52, Short.MAX_VALUE)
				.addGap(0, 52, Short.MAX_VALUE)
				.addGroup(gl_panelStajBitis_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelStajBitis_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(dcStajBitis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_2_2_1_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(13))
		);
		panelStajBitis_1.setLayout(gl_panelStajBitis_1);
		
		JPanel panelCalismaYerleri_1 = new JPanel();
		panel_1.add(panelCalismaYerleri_1);
		
		JLabel lblNewLabel_2_2_2_1_1_2 = new JLabel("Çalýþma Yerleri:");
		lblNewLabel_2_2_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		 cbCalisma = new JComboBox<String>();
		 cbCalisma.setModel(new DefaultComboBoxModel<String>(new String[] {"HEMATOLOJÝ", "ONKOLOJÝ", "ENDOKRÝNOLOJÝ", "NEFROLOJÝ", "GASTROENTEROLOJÝ", "GERÝATRÝ", "GENEL DAHÝLÝYE", "ROMATOLOJÝ"}));
		GroupLayout gl_panelCalismaYerleri_1 = new GroupLayout(panelCalismaYerleri_1);
		gl_panelCalismaYerleri_1.setHorizontalGroup(
			gl_panelCalismaYerleri_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 308, Short.MAX_VALUE)
				.addGroup(gl_panelCalismaYerleri_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_2_2_1_1_2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(cbCalisma, 0, 160, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelCalismaYerleri_1.setVerticalGroup(
			gl_panelCalismaYerleri_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 53, Short.MAX_VALUE)
				.addGap(0, 53, Short.MAX_VALUE)
				.addGap(0, 53, Short.MAX_VALUE)
				.addGroup(gl_panelCalismaYerleri_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelCalismaYerleri_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_2_2_1_1_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbCalisma, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(13))
		);
		panelCalismaYerleri_1.setLayout(gl_panelCalismaYerleri_1);
		
		JPanel panelCheckBox_1 = new JPanel();
		panel_1.add(panelCheckBox_1);
		panelCheckBox_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		cbKlinik = new JCheckBox("Klinik");
		cbKlinik.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelCheckBox_1.add(cbKlinik);
		
		 cbPoliklinik = new JCheckBox("Poliklinik");
		cbPoliklinik.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelCheckBox_1.add(cbPoliklinik);
	}
		
		public void updateUzmanlik() {
			if(cbIzinler.getSelectedIndex() != 0) {
				DateOperation dto = new DateOperation();
				long res=dto.getDateDiff(dcIzinBaslama.getDate(), dcIzinBitis.getDate());
			Date ress=	dto.addDays(dcUzmalikBitis.getDate(), (int) res);
			dcUzmalikBitis=new JDateChooser(ress);
			System.out.println(ress.toString());
				System.out.println(dcUzmalikBitis.getDate().toString());
			}
		} 
		
		public int getKalan() {
			try {
				String query= "select kalan_gun from asistanlar where tc="+tc;
				prp=conn.prepareStatement(query);
	        	rs=prp.executeQuery();
	        	int kalan_gun =rs.getInt("kalan_gun"); 
	        	prp.close();
	        	return kalan_gun;
			}catch(SQLException ex) {
				ex.printStackTrace();
				return -1;
			}
		}
	
		public void updateDB() {
			DateOperation dto = new DateOperation();
			String sql="update asistanlar set fullname=?, tc=?, "
					+ "uz_bas=strftime('%d/%m/%Y',? , 'unixepoch'), "
					+ "uz_bitis=strftime('%d/%m/%Y',? , 'unixepoch'), "
					+ "staj_bas=strftime('%d/%m/%Y',? , 'unixepoch')"
					+ ", staj_bitis=strftime('%d/%m/%Y',? , 'unixepoch'), "
					+ "calisma_yerleri=?, klinik=?, "
					+ "izin_bas=strftime('%d/%m/%Y',? , 'unixepoch'),"
					+ "izin_bitis=strftime('%d/%m/%Y',? , 'unixepoch'),izin=?, kalan_gun=? where tc="+tc;
			int newKalan=0;
			if(dcStajBaslama.getDate()!= null || dcStajBitis.getDate() !=null ) {
				newKalan =(int) (getKalan()-dto.getDateDiff(dcStajBaslama.getDate(),dcStajBitis.getDate()));
			}
		
 
		        try{
		        			prp=conn.prepareStatement(sql);
          		        	prp.setString(1, txtAd.getText());
          		        	prp.setString(2, txtTc.getText());
          		        	prp.setLong(3, dto.convertDate(dcUzmalikBaslama.getDate()));
          		        	prp.setLong(4, dto.convertDate(dcUzmalikBitis.getDate())); 
          		        	prp.setLong(5, dto.convertDate(dcStajBaslama.getDate())); 
          		        	prp.setLong(6, dto.convertDate(dcStajBitis.getDate())); 
          		        	prp.setString(7, cbCalisma.getSelectedItem().toString());
          		        	if(cbPoliklinik != null && cbPoliklinik.isSelected()) {
          		        		prp.setString(8, "Poliklinik"); 
          		        	}if(cbKlinik !=null && cbKlinik.isSelected()) {
          		        		prp.setString(8, "Klinik");
          		        	}
          		        	prp.setLong(9, dto.convertDate(dcIzinBaslama.getDate()));
          					prp.setLong(10, dto.convertDate(dcIzinBitis.getDate()));
          					prp.setString(11, cbIzinler.getSelectedItem().toString());
          					prp.setInt(12,newKalan);
          					prp.executeUpdate();
          		            JOptionPane.showMessageDialog(null, "Baþarýyla güncellendi.");
		        	
		        } catch (SQLException e) {
		        	JOptionPane.showMessageDialog(null, "Veriler güncellenemedi \n" +e.getMessage());
		            e.printStackTrace();
		        }
			
			
		}
		
		private Component[] getComponents(Component container) {
	        ArrayList<Component> list = null;

	        try {
	            list = new ArrayList<Component>(Arrays.asList(
	                  ((Container) container).getComponents()));
	            for (int index = 0; index < list.size(); index++) {
	                for (Component currentComponent : getComponents(list.get(index))) {
	                    list.add(currentComponent);
	                }
	            }
	        } catch (ClassCastException e) {
	            list = new ArrayList<Component>();
	        }

	        return list.toArray(new Component[list.size()]);
	        }
	    
		public void disablePanel(Component container, boolean conditon) {
			for(Component component : getComponents(container)) {
			    component.setEnabled(conditon);
			}
			
		}
}
