import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class expense_tracker {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JTextField amountField;
    private JTextField categoryField;
    private JTextField dateField;
    private static final String FILE_NAME = "expenses.txt";

    public expense_tracker() {
        frame = new JFrame("Expense Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        panel.add(amountField);
        
        panel.add(new JLabel("Category:"));
        categoryField = new JTextField();
        panel.add(categoryField);
        
        panel.add(new JLabel("Date (YYYY-MM-DD):"));
        dateField = new JTextField();
        panel.add(dateField);
        
        JButton addButton = new JButton("Add Expense");
        panel.add(addButton);
        
        JButton saveButton = new JButton("Save Expenses");
        panel.add(saveButton);
        
        model = new DefaultTableModel(new String[]{"Amount", "Category", "Date"}, 0);
        table = new JTable(model);
        loadExpenses();
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExpense();
            }
        });
        
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveExpenses();
            }
        });
        
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void addExpense() {
        String amount = amountField.getText();
        String category = categoryField.getText();
        String date = dateField.getText();
        
        if (amount.isEmpty() || category.isEmpty() || date.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        model.addRow(new Object[]{amount, category, date});
        amountField.setText("");
        categoryField.setText("");
        dateField.setText("");
    }
    
    private void saveExpenses() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                writer.write(model.getValueAt(i, 0) + "," + model.getValueAt(i, 1) + "," + model.getValueAt(i, 2));
                writer.newLine();
            }
            JOptionPane.showMessageDialog(frame, "Expenses saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving expenses", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void loadExpenses() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                model.addRow(data);
            }
        } catch (IOException e) {
            System.out.println("No previous data found.");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(expense_tracker::new);
    }
}
