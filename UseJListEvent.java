package day0714;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class UseJListEvent extends WindowAdapter implements ActionListener, MouseListener {

	private UseJList ujl;
	
	public UseJListEvent(UseJList ujl) {
		this.ujl = ujl;
		// 기본 친구 세팅
		setFriends();
	}
	
	public void setFriends() {
		DefaultListModel<String> dlm = ujl.getDlmFriends();
		dlm.addElement("강다연");
		dlm.addElement("김다영");
		dlm.addElement("김선경");
		dlm.addElement("김인영");
		dlm.addElement("김주민");
		dlm.addElement("박상준");
	}
	
	public void addFriend() {
		JTextField jtfName = ujl.getJtfInputName();
		String name = ujl.getJtfInputName().getText().trim();
		
		if (!name.isEmpty()) {
			DefaultListModel<String> dlm = ujl.getDlmFriends();
			dlm.addElement(name);
			jtfName.setText("");
			
			// 수직스크롤 바를 얻고
			JScrollBar jsb = ujl.getJspFriends().getVerticalScrollBar();
			// 수직스크롤 바의 최고값으로 수직스크롤 바의 값을 설정한다.
			jsb.setValue(jsb.getMaximum());
		}
	}
	
	public void moveBlockFriend() {
		// jlFriends가 클릭되면 아이템의 값을 가져와서
		// ConfirmDialog로 물어본 후 "예"가 눌리면
		// jlFriends에서 삭제하고 jlBlockFriends에 추가한다.
		
		// 값을 관리하는 Model 객체를 가져온다.
		DefaultListModel<String> dlmFriends = ujl.getDlmFriends();
		DefaultListModel<String> dlmBlockFriends = ujl.getDlmBlockFriends();
		// 디자인을 제공하는 View 객체를 가져온다.
		JList<String> jlFriends = ujl.getJlFriends();
		
		String name = dlmFriends.getElementAt(jlFriends.getSelectedIndex());
//		String name = jlFriends.getSelectedValue();
		if(name != null) {
			int selectionValue = JOptionPane.showConfirmDialog(ujl, name + "을 차단하시겠습니다.","친구도 아님",JOptionPane.YES_NO_OPTION);
			
			switch (selectionValue) {
			case JOptionPane.OK_OPTION:
				dlmFriends.removeElement(name);
				dlmBlockFriends.addElement(name);
				break;

			default:
				break;
			}
		}
	}
	
	public void moveFriend() {
		// jlBlockFriends가 클릭되면 아이템의 값을 가져와서
		// ConfirmDialog로 물어본 후 "예"가 눌리면
		// jlBlocjFriends에서 삭제하고 jlFriends에 추가한다.
		// 값을 관리하는 Model 객체를 가져온다.
		DefaultListModel<String> dlmFriends = ujl.getDlmFriends();
		DefaultListModel<String> dlmBlockFriends = ujl.getDlmBlockFriends();
		// 디자인을 제공하는 View 객체를 가져온다.
		JList<String> jlBlockFriends = ujl.getJlBlockFriends();
				
		String name = dlmBlockFriends.getElementAt(jlBlockFriends.getSelectedIndex());
//		String name = jlFriends.getSelectedValue();
		if(name != null) {
			int selectionValue = JOptionPane.showConfirmDialog(ujl, name + "을 차단해제 하시겠습니다.","친구 등록",JOptionPane.YES_NO_OPTION);
					
			switch (selectionValue) {
			case JOptionPane.OK_OPTION:
				dlmBlockFriends.removeElement(name);
				dlmFriends.addElement(name);
				break;

			default:
				break;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		addFriend();
	}

	@Override
	public void windowClosing(WindowEvent we) {
		ujl.dispose();
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		switch (me.getButton()) {
		case MouseEvent.BUTTON1:
			if(me.getSource() == ujl.getJlFriends()) {
				moveBlockFriend();// 친구에서 차단으로
			}
			if (me.getSource() == ujl.getJlBlockFriends() ) {
				moveFriend();// 차간에서 친구로
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
