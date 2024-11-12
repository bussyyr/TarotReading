package tarotReading;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class TarotCardSelector {
    private final String[] cardNames = {
            "The Magician", "The High Priestess", "The Empress", "The Emperor",
            "The Hierophant", "The Lovers", "The Chariot", "Strength",
            "The Devil", "The Tower",
            "The Star", "The Moon", "The Sun",
            "The World", "The Fool"
    };
    private static final String imagePath = "/Users/buseokcu/Downloads/TarotReading/src/main/java/tarotReading/card.png";
    private ArrayList<String> selectedCards = new ArrayList<>();
    private ArrayList<JButton> cardButtons = new ArrayList<>();


    public void GUI() throws IOException, InterruptedException{
        JFrame frame = new JFrame("Tarot Cards");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JPanel cardsPanel = new JPanel();
        cardsPanel.setLayout(new GridLayout(3, 5));

        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(60, 70, Image.SCALE_SMOOTH); // Görselleri yeniden boyutlandır
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        for (String cardName : cardNames) {
            JButton cardButton = new JButton(scaledIcon);
            cardButton.setActionCommand(cardName);
            cardButton.addActionListener(new CardButtonListener(cardName, selectedCards, cardButtons));
            cardsPanel.add(cardButton);
            cardButtons.add(cardButton);
        }

        frame.add(cardsPanel, BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            try {
                displayReading(frame);
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        frame.add(submitButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void displayReading(JFrame frame) throws IOException, InterruptedException {
        if (selectedCards.size() != 3) {
            JOptionPane.showMessageDialog(frame, "Please select exactly 3 cards.");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String card : selectedCards) {
            stringBuilder.append(card).append(", ");
        }

        String prompt = "Please provide reading for these three tarot cards: " + stringBuilder.toString();

        HuggingFaceAI hg = new HuggingFaceAI();
        String response = hg.HuggingFaceModel(prompt);

        ResultDisplay resultDisplay = new ResultDisplay();
        resultDisplay.showResult(frame, selectedCards, response);
    }
}
