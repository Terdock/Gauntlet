package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;

public class ComboBox extends JComboBox{
	private Font font = new Font("Tempus Sans ITC",Font.BOLD,16);
	
	public ComboBox(Integer i){
		this.setBounds(250, 60 + i*100, 200, 30);
		this.addItem("Guerrier");
		this.addItem("Nain");
		this.addItem("Sorcier");
		this.addItem("Elfe");
		this.setOpaque(false);
		this.setFont(font);
		this.setForeground(Color.ORANGE);
		this.setRenderer(new DefaultListCellRenderer(){
  			    public Component getListCellRendererComponent(JList list, Object value,
  			            int index, boolean isSelected, boolean cellHasFocus) {
  			        JComponent result = (JComponent)super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
  			        result.setOpaque(false);
  			        return result;
  			    }
  			  public void paint(Graphics g) {
  				setBackground(Color.BLACK);
  		        setForeground(Color.ORANGE);
  		        super.paint(g);
  		    }});
	}

}
