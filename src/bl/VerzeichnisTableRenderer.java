package bl;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class VerzeichnisTableRenderer extends DefaultTableCellRenderer{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(VerzeichnisColumnEnum.values()[column] == VerzeichnisColumnEnum.BARWERT && 
           (double) value == 0) {
            this.setBackground(Color.RED);
        }  
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);  
    }
}
