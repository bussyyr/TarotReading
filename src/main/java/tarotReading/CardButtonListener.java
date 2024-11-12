package tarotReading;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CardButtonListener implements ActionListener {
    private String cardName;
    private List<String> selectedCards;
    private List<JButton> cardButtons;

    public CardButtonListener(String cardName, List<String> selectedCards, List<JButton> cardButtons) {
        this.cardName = cardName;
        this.selectedCards = selectedCards;
        this.cardButtons = cardButtons;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        if (selectedCards.contains(cardName)) {
            selectedCards.remove(cardName);
            source.setEnabled(true);
        } else {
            if (selectedCards.size() < 3) {
                selectedCards.add(cardName);
                source.setEnabled(false);
            }
        }
    }
}
