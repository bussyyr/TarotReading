package tarotReading;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ResultDisplay {
    private static final String imagePath = "/Users/buseokcu/Downloads/TarotReading/src/main/java/tarotReading/card.png"; // change this to your actual image path

    public void showResult(JFrame frame, List<String> selectedCards, String response) {
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());

        JPanel selectedCardsPanel = new JPanel();
        selectedCardsPanel.setLayout(new FlowLayout());

        for (String card : selectedCards) {
            JLabel cardLabel = new JLabel(new ImageIcon(imagePath + card + ".png"));
            selectedCardsPanel.add(cardLabel);
        }

        JTextArea responseArea = new JTextArea(response);
        responseArea.setLineWrap(true);
        responseArea.setWrapStyleWord(true);
        responseArea.setFont(new Font("Arial", Font.PLAIN, 14));
        responseArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(responseArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        resultPanel.add(selectedCardsPanel, BorderLayout.NORTH);
        resultPanel.add(scrollPane, BorderLayout.CENTER);

        frame.getContentPane().removeAll();
        frame.add(resultPanel);
        frame.revalidate();
        frame.repaint();
    }
}
