# Tarot Reading Application

This project is a Tarot Reading Application built using Java Swing for the GUI and the Hugging Face API for generating tarot card readings. The primary purpose of this project is to provide users with an interactive way to select tarot cards and receive daily readings.

## Project Overview

The Tarot Reading Application allows users to select three tarot cards from a set of 15 and get a daily reading based on the selected cards. It demonstrates the integration of a graphical user interface with an AI model to generate text-based responses.

### Features

- Select three tarot cards from a grid of 15 cards
- Submit the selected cards to receive a daily reading
- Display the selected cards and the generated reading in a new panel

## Technologies Used

- [Java Swing](https://docs.oracle.com/javase/tutorial/uiswing/): GUI toolkit for Java
- [Hugging Face](https://huggingface.co/): AI model for generating text-based responses

## Installation

To set up the project, follow these steps:

1. Clone this repository:
   ```bash
   git clone https://github.com/bussyyr/tarot-reading.git
   cd tarot-reading
2. Ensure you have the required images for the tarot cards. Place them in the appropriate directory (e.g., /path/to/images/).

3. Update the imagePath variable in TarotCardSelector.java to point to the correct path where your tarot card images are stored.

4. Run the main method in the TarotCardSelector class to start the application.

5. Select three cards and click "Submit" to get your daily tarot reading.

