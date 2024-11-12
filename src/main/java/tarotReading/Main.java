package tarotReading;

import tarotReading.TarotCardSelector;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                TarotCardSelector cardSelector = new TarotCardSelector();
                cardSelector.GUI();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
