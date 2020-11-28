package views.components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import constants.MyConstants;

public class OwnJTable extends JTable {

	private DefaultTableModel dtmElements;

	public OwnJTable() {
		dtmElements = new DefaultTableModel();
		dtmElements.setColumnIdentifiers(MyConstants.COLI_BASIC);
		setModel(dtmElements);

		getTableHeader().setReorderingAllowed(false);
		getTableHeader().setResizingAllowed(false);
		getTableHeader().setBackground(Color.decode(MyConstants.CLR_BLUE_TABLE));
		getTableHeader().setForeground(Color.BLACK);
		getTableHeader().setFont(new Font(MyConstants.FONT_ARIAL, 1, 20));
		setFont(new Font(MyConstants.FONT_ARIAL, 0, 16));
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
	}

//	public void manageTableData(String[] columnIdentifiers, ArrayList<DataForTable> dataForTable) {
//		dtmElements.setColumnIdentifiers(columnIdentifiers);
//		dtmElements.setRowCount(0);
//		
//		for (DataForTable data : dataForTable) {
//			dtmElements.addRow(data.getDataForTable());
//		}
//	}

	private static final long serialVersionUID = 1L;
}