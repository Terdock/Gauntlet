package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class ComboBox extends JComboBox{
	private Font font = new Font("Tempus Sans ITC",Font.BOLD,16);
	private Integer[] listDimensionLine = {18, 20};
	private Integer[] listDimensionColumn = {18, 20, 22, 24};
	
	public ComboBox(Integer i){
		this.setBounds(250, 230 + (i-1)*100, 200, 30);
		this.addItem("Guerrier");
		this.addItem("Nain");
		this.addItem("Sorcier");
		this.addItem("Elfe");
		this.setOpaque(false);
		this.setFont(font);
		this.setForeground(Color.ORANGE);
		setRender();
	}
	
	public ComboBox(Integer i, Integer[] bounds){
		this.setBounds(bounds[0], bounds[1], 60, 30);
		for(Integer a = 0; a<(2+i*2); a++){
			if (i.equals(0)){
				this.addItem(listDimensionLine[a]);
			}else{
				this.addItem(listDimensionColumn[a]);
			}
		}
		this.setOpaque(false);
		this.setFont(font);
		this.setForeground(Color.ORANGE);
		setRender();
	}
	
	private void setRender(){
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
