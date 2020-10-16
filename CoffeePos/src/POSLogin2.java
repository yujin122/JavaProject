import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class POSLogin2 extends JFrame {
	
	private ImageIcon icon;

	public POSLogin2() {
		
		super("로그인 화면");
		
		icon = new ImageIcon("image/login.png");
		icon = imageSetSize(icon, 380, 400);
		
		JPanel background = new JPanel(new BorderLayout()) {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,null);
			}
		};	
		
		setFont(new Font("굴림", Font.PLAIN, 12));
		
		// 포스이름
		JPanel loginScreenPanel = new JPanel();
		loginScreenPanel.setOpaque(false);
		JLabel loginScreenLabel = new JLabel("Sist P.O.S");
		loginScreenLabel.setFont(new Font("함초롬바탕", Font.PLAIN, 30));
		loginScreenPanel.add(loginScreenLabel);
		
		// ID
		JPanel idlaPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		idlaPanel.setOpaque(false);
		JLabel idLabel = new JLabel("ID :");
		idLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		idlaPanel.add(idLabel);
		
		//IDTextfield
		JPanel idTfPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		idTfPanel.setOpaque(false);
		JTextField idTf = new JTextField(10);
		idTfPanel.add(idTf);
		
		JPanel idPanel = new JPanel(new GridLayout(1,2));	
		idPanel.setOpaque(false);
		idPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,100));
		idPanel.add(idlaPanel); idPanel.add(idTfPanel);
		
		// Password
		JPanel pwlaPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pwlaPanel.setOpaque(false);
		JLabel pwLabel = new JLabel("PW :");
		pwLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		pwlaPanel.add(pwLabel);
		
		// PWTextField
		JPanel pwTfPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pwTfPanel.setOpaque(false);
		// 암호화
		JTextField pwTf = new JPasswordField(10);
		pwTfPanel.add(pwTf);

		JPanel pwPanel = new JPanel(new GridLayout(1,2));
		pwPanel.setOpaque(false);
		pwPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,100));
		pwPanel.add(pwlaPanel); pwPanel.add(pwTfPanel);
	
		// ID/PW찾기
		JPanel idPwBPanel = new JPanel();
		idPwBPanel.setOpaque(false);
		JButton findIdPwButton = new JButton("ID/PW찾기");
		findIdPwButton.setForeground(Color.WHITE); 
		findIdPwButton.setFont(new Font("굴림", Font.BOLD, 12));
		findIdPwButton.setBackground(new Color(230,160,0));
		idPwBPanel.add(findIdPwButton);
		
		// 로그인버튼
		JPanel JloginBPanel = new JPanel();
		JloginBPanel.setOpaque(false);
		JButton JLoginButton = new JButton("로그인");
		JLoginButton.setForeground(Color.WHITE); 
		JLoginButton.setFont(new Font("굴림", Font.BOLD, 12));
		JLoginButton.setBackground(new Color(230,160,0));
		JloginBPanel.add(JLoginButton);
		
		// 회원가입 버튼
		JPanel joinBpanel = new JPanel();
		joinBpanel.setOpaque(false);
		
		JButton joinButton = new JButton("회원가입");
		joinButton.setForeground(Color.WHITE); 
		joinButton.setFont(new Font("굴림", Font.BOLD, 12));
		joinButton.setBackground(new Color(230,160,0));
		joinBpanel.add(joinButton);
		
		JPanel btnPanel = new JPanel(new GridLayout(1,3));
		btnPanel.setOpaque(false);
		btnPanel.setBorder(BorderFactory.createEmptyBorder(5,30,10,30));
		
		btnPanel.add(JloginBPanel); btnPanel.add(idPwBPanel); btnPanel.add(joinBpanel);

		JPanel jp = new JPanel(new GridLayout(3,1));
		jp.setOpaque(false);
		jp.add(idPanel);
		jp.add(pwPanel);
		jp.add(btnPanel);
		

		background.add(jp,BorderLayout.SOUTH);
		
		//background.add(allJp);
		
		add(background);
		setBounds(500, 250, 380, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		//로그인 버튼, ID/PW찾기 버튼 , 회원가입 버튼
		JLoginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(background, "로그인 성공");
				new Menu();
				dispose();
			}
		});

		joinButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new POSJoin();
				dispose();
			}
		});
		findIdPwButton.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				new FindIDPW();
				dispose();
			}
		});

	}

	public ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	
	public static void main(String[] args) {

		new POSLogin2();
	}
}