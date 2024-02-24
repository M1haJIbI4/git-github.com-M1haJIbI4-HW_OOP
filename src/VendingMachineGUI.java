import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineGUI extends JFrame {
    private List<Product> products;
    private JList<Product> productList;
    private JTextField cashField;
    private JButton buyButton;

    public VendingMachineGUI() {
        products = new ArrayList<>();
        products.add(new Product("Вода", 85));
        products.add(new Product("Чипсы", 175.6));
        products.add(new Product("Батончик", 200));
        productList = new JList<>(products.toArray(new Product[0]));
        cashField = new JTextField(10);
        buyButton = new JButton("Купить товар");

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = productList.getSelectedIndex();
                if (selectedIndex != -1) {
                    Product selectedProduct = products.get(selectedIndex);
                    double cash = Double.parseDouble(cashField.getText());
                    if (cash >= selectedProduct.getPrice()) {
                        JOptionPane.showMessageDialog(VendingMachineGUI.this, "Вы купили " + selectedProduct.getName());
                    } else {
                        JOptionPane.showMessageDialog(VendingMachineGUI.this, "Нужно больше золота.");
                    }
                } else {
                    JOptionPane.showMessageDialog(VendingMachineGUI.this, "Выберите товар");
                }
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(productList), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Введите сумму: "));
        inputPanel.add(cashField);
        inputPanel.add(buyButton);

        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Продукты (автомат сдачи не даёт!)");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new VendingMachineGUI();
    }
}