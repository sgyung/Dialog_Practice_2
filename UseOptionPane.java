package day0714;

import java.awt.GridLayout;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UseOptionPane extends JFrame implements ActionListener {

	private JButton jbtnInput,jbtnConfirm,jbtnMsg;
	
	public UseOptionPane() {
		super("JOptionPane 연습");
		jbtnInput = new JButton("입력 다이얼로그");
		jbtnConfirm = new  JButton("확인 다이얼로그");
		jbtnMsg = new JButton("메시지 다이얼로그");
		
		jbtnInput.addActionListener(this);
		jbtnConfirm.addActionListener(this);
		jbtnMsg.addActionListener(this);
		
		JPanel jpInput = new JPanel();
		JPanel jpConfirm = new JPanel();
		JPanel jpMsg = new JPanel();
		
		jpInput.add(jbtnInput);
		jpConfirm.add(jbtnConfirm);
		jpMsg.add(jbtnMsg);
		
		setLayout(new GridLayout(3,1));
		
		add(jpInput);
		add(jpConfirm);
		add(jpMsg);
		
		setBounds(100,100,300,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void useInputDialog() {
//		String name = JOptionPane.showInputDialog("당신의 이름을 입력해 주세요.");
//		String name = JOptionPane.showInputDialog("당신의 이름을 입력해 주세요.","홍길동");
		String name = JOptionPane.showInputDialog("당신의 이름을 입력해 주세요.","홍길동");
		System.out.println(name + "님 안녕하세요?");
	}
	
	public void useConfirmDialog() {
		int num = JOptionPane.showConfirmDialog(this, "오늘은 금요일 입니까?","오늘의 점심은?",JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.ERROR_MESSAGE);
//		System.out.println( "선택한 값 : " + num );
		
		switch (num) {
		case JOptionPane.OK_OPTION:
			JOptionPane.showMessageDialog(this,"\"예\"를 누르셨습니다.");
			break;
		case JOptionPane.NO_OPTION:
			String input = JOptionPane.showInputDialog("오늘의 요일을 입력해주세요.");
			JOptionPane.showMessageDialog(this, input + "요일 입니다.");
		default :
			System.out.println("취소를 선택하셨습니다.");
			break;
		}
	}
	
	public void useMessageDialog() {
//		JOptionPane.showMessageDialog(this, "오늘은 금요일 입니다.");
		JOptionPane.showMessageDialog(this, "오늘은 금요일 입니다. 아자봉~!","오늘의 요일은?",JOptionPane.WARNING_MESSAGE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == jbtnInput) {
			useInputDialog();
		}
		if(ae.getSource() == jbtnConfirm) {
			useConfirmDialog();
		}
		if(ae.getSource() == jbtnMsg) {
			useMessageDialog();
		}
		
	}

	public static void main(String[] args) {
		new UseOptionPane();
	}

}
