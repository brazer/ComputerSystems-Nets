package by.bsuir.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TablePanel extends JPanel {
	
	private static final long serialVersionUID = 3668869632599478799L;
	private boolean DEBUG = false;	
	
    public TablePanel() {
        super(new GridLayout(1,0));
    	String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};
    	Object[][] data = {
    		{"Kathy", "Smith",
    		"Snowboarding", new Integer(5), new Boolean(false)},
    		{"John", "Doe",
    		"Rowing", new Integer(3), new Boolean(true)},
    		{"Sue", "Black",
    		"Knitting", new Integer(2), new Boolean(false)},
    		{"Jane", "White",
    		"Speed reading", new Integer(20), new Boolean(true)},
    		{"Joe", "Brown",
    		"Pool", new Integer(10), new Boolean(false)}
    		};
        final JTable table = new JTable(data, columnNames);
        init(table);
    }

    public TablePanel(final JTable table) {
    	init(table);
    }
    
    private void init(final JTable table) {
    	table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        //Add the scroll pane to this panel.
        add(scrollPane);
    }
    
    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("SimpleTableSample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        //Create and set up the content pane.
        TablePanel newContentPane = new TablePanel();
        setPaneAndDisplayWindow(newContentPane, frame);
    }
    
    public static void createAndShowGUI(TablePanel panel) {
    	//Create and set up the window.
        JFrame frame = new JFrame("Спецификация");
        setPaneAndDisplayWindow(panel, frame);
    }

    private static void setPaneAndDisplayWindow(TablePanel pane, JFrame frame) {
    	//Set up the content pane.
        pane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(pane);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();                
            }
        });
    }
}