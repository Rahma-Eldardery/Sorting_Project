package sort;
/**
 *
 * @author Rahma
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainSort extends JFrame implements ActionListener {
    private JButton[] numberButtons;
    private ArrayList<Integer> numberList;
    private JTextArea displayArea;
    private JTextField inputField;
    private JButton mergeSortButton , deleteButton , quickSortButton ,  enterButton ;
    public MainSort() {
        setTitle("Sort Numbers ");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        numberList = new ArrayList<>();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 3, 5, 5));

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            numberButtons[i].setBackground(Color.LIGHT_GRAY);
            numberButtons[i].setForeground(Color.BLACK);
            numberButtons[i].addActionListener(this);
            panel.add(numberButtons[i]);
        }

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(inputField);

        enterButton = new JButton("Enter");
        enterButton.setFont(new Font("Arial", Font.BOLD, 20));
        enterButton.setBackground(Color.CYAN);
        enterButton.addActionListener(this);
        panel.add(enterButton);

        deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Arial", Font.BOLD, 20));
        deleteButton.setBackground(Color.CYAN);
        deleteButton.addActionListener(this);
        panel.add(deleteButton);

        mergeSortButton = new JButton("Merge Sort");
        mergeSortButton.setFont(new Font("Arial", Font.BOLD, 15));
        mergeSortButton.setBackground(Color.CYAN);
        mergeSortButton.addActionListener(this);
        panel.add(mergeSortButton);

        quickSortButton = new JButton("Quick Sort");
        quickSortButton.setFont(new Font("Arial", Font.BOLD, 15));
        quickSortButton.setBackground(Color.CYAN);
        quickSortButton.addActionListener(this);
        panel.add(quickSortButton);

        displayArea = new JTextArea();
        displayArea.setFont(new Font("Arial", Font.PLAIN, 16));
        displayArea.setEditable(false);

        add(panel, BorderLayout.CENTER);
        add(new JScrollPane(displayArea), BorderLayout.NORTH);
    }

    public void actionPerformed(ActionEvent e) {
        QuickSort quickSort = new QuickSort();
        MergeSort mergeSort = new MergeSort();
        JButton source = (JButton) e.getSource();
        if (source == mergeSortButton) {
            mergeSort.sort(numberList);
            displaySorted("Merge Sort");
        } else if (source == quickSortButton) {
            quickSort.sort(numberList);
            displaySorted("Quick Sort");
        } else if (source == enterButton) {
                int number = Integer.parseInt(inputField.getText());
                numberList.add(number);
                inputField.setText("");
                displayNum();
        } else if (source == deleteButton) {
            String text = inputField.getText();
            if (text.length() > 0) {
                inputField.setText(text.substring(0, text.length() - 1));
            }
        } else {
            String text = inputField.getText() + source.getText();
            inputField.setText(text);
        }
    }

    private void displayNum() {
        StringBuilder sb = new StringBuilder("Numbers: ");
        for (int num : numberList) {
            sb.append(num).append(" ");
        }
        displayArea.setText(sb.toString());
    }

    private void displaySorted(String sortMethod) {
        StringBuilder sb = new StringBuilder(sortMethod + " Sorted Numbers: ");
        for (int num : numberList) {
            sb.append(num).append(" ");
        }
        displayArea.setText(sb.toString());
    }

    public static void main(String[] args) {
            MainSort frame = new MainSort();
            frame.setVisible(true);
    }
}
