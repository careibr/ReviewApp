import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ReviewAppGUI extends JFrame {

    // --- CHRISTMAS PALETTE ---
    private static final Color COLOR_PINE = new Color(35, 90, 50);       // Dark Green
    private static final Color COLOR_BERRY = new Color(178, 34, 34);     // Santa Red
    private static final Color COLOR_SNOW = new Color(250, 250, 250);    // White
    private static final Color COLOR_GOLD = new Color(255, 215, 0);      // Gold
    private static final Color COLOR_COAL = new Color(50, 50, 50);       // Dark Gray

    // --- FONTS ---
    private static final Font HEADER_FONT = new Font("Serif", Font.BOLD | Font.ITALIC, 36);
    private static final Font TEXT_FONT = new Font("SansSerif", Font.BOLD, 16);
    private static final Font BUTTON_FONT = new Font("SansSerif", Font.BOLD, 14);

    // --- UI COMPONENTS ---
    private CardLayout cardLayout;
    private JPanel mainPanel;

    // Quiz Components
    private JTextArea promptArea;
    private JTextArea explanationArea;
    private JRadioButton[] choiceButtons;
    private ButtonGroup buttonGroup;
    private JButton actionButton;
    private JLabel topicLabel;
    private JProgressBar progressBar;

    // Result Components
    private JLabel scoreLabel; // <--- FIXED: Re-added this missing connector!

    // --- GAME STATE ---
    private QuestionBank bank;
    private ArrayList<Questions> currentQuiz;
    private int currentQuestionIndex;
    private int score;
    private boolean isAnswerSubmitted;

    public ReviewAppGUI() {
        // 1. Window Setup
        setTitle("🎄 AP CSA Winter Wonderland 🎄");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);

        // 2. Initialize Data
        bank = new QuestionBank();

        // 3. Setup Main Layout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add a thick "Candy Cane" border around the entire app
        mainPanel.setBorder(createCandyCaneBorder(5));

        // 4. Add Screens
        mainPanel.add(createMenuPanel(), "MENU");
        mainPanel.add(createQuizPanel(), "QUIZ");
        mainPanel.add(createResultPanel(), "RESULTS");

        add(mainPanel);
        setVisible(true);
    }

    // --- SCREEN 1: THE NORTH POLE MENU ---
    private JPanel createMenuPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(COLOR_PINE);

        // Header
        JLabel title = new JLabel("🎅 Santa's AP CSA List 🎅", SwingConstants.CENTER);
        title.setFont(HEADER_FONT);
        title.setForeground(COLOR_SNOW);
        title.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        panel.add(title, BorderLayout.NORTH);

        // Button Grid
        JPanel buttonGrid = new JPanel(new GridLayout(2, 3, 20, 20));
        buttonGrid.setBackground(COLOR_PINE);
        buttonGrid.setBorder(BorderFactory.createEmptyBorder(10, 40, 40, 40));

        String[] topics = {"Arrays 🎁", "Loops ❄️", "If/Else 🕯️", "Lists 🦌", "Classes 🏠", "All Toys 🧸"};
        String[] keywords = {"arrays", "loops", "conditionals", "arraylists", "classes", "all"};

        for (int i = 0; i < topics.length; i++) {
            JButton btn = new JButton(topics[i]);
            String keyword = keywords[i];

            styleFestiveButton(btn, COLOR_BERRY, COLOR_SNOW);
            btn.addActionListener(e -> startQuiz(keyword));
            buttonGrid.add(btn);
        }

        panel.add(buttonGrid, BorderLayout.CENTER);
        return panel;
    }

    // --- SCREEN 2: THE SLEIGH RIDE (QUIZ) ---
    private JPanel createQuizPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(COLOR_SNOW);

        // Top: Topic & Progress
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(COLOR_PINE);

        topicLabel = new JLabel("Topic: ");
        topicLabel.setFont(TEXT_FONT);
        topicLabel.setForeground(COLOR_GOLD);
        topicLabel.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));

        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setForeground(COLOR_BERRY);
        progressBar.setBackground(COLOR_SNOW);
        progressBar.setBorder(BorderFactory.createEmptyBorder(5, 15, 15, 15));

        topBar.add(topicLabel, BorderLayout.NORTH);
        topBar.add(progressBar, BorderLayout.SOUTH);
        panel.add(topBar, BorderLayout.NORTH);

        // Center: Question
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(COLOR_SNOW);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        // Prompt Area
        promptArea = new JTextArea(4, 20);
        promptArea.setLineWrap(true);
        promptArea.setWrapStyleWord(true);
        promptArea.setEditable(false);
        promptArea.setFont(new Font("Serif", Font.BOLD, 20));
        promptArea.setBackground(new Color(255, 250, 240));
        promptArea.setForeground(COLOR_COAL);
        promptArea.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(COLOR_GOLD, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        centerPanel.add(promptArea);
        centerPanel.add(Box.createVerticalStrut(20));

        // Choices
        choiceButtons = new JRadioButton[5];
        buttonGroup = new ButtonGroup();

        for (int i = 0; i < choiceButtons.length; i++) {
            choiceButtons[i] = new JRadioButton();
            choiceButtons[i].setVisible(false);
            choiceButtons[i].setBackground(COLOR_SNOW);
            choiceButtons[i].setForeground(COLOR_PINE);
            choiceButtons[i].setFont(TEXT_FONT);
            choiceButtons[i].setFocusPainted(false);

            buttonGroup.add(choiceButtons[i]);
            centerPanel.add(choiceButtons[i]);
            centerPanel.add(Box.createVerticalStrut(10));
        }

        // Explanation
        explanationArea = new JTextArea(3, 20);
        explanationArea.setLineWrap(true);
        explanationArea.setWrapStyleWord(true);
        explanationArea.setEditable(false);
        explanationArea.setFont(new Font("SansSerif", Font.ITALIC, 14));
        explanationArea.setBackground(COLOR_SNOW);
        explanationArea.setForeground(COLOR_BERRY);
        centerPanel.add(Box.createVerticalStrut(15));
        centerPanel.add(explanationArea);

        panel.add(centerPanel, BorderLayout.CENTER);

        // Bottom: Action Button
        actionButton = new JButton("🎁 Unwrap Answer");
        styleFestiveButton(actionButton, COLOR_PINE, COLOR_SNOW);
        actionButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        actionButton.addActionListener(e -> handleActionButton());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(COLOR_SNOW);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        bottomPanel.add(actionButton);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        return panel;
    }

    // --- SCREEN 3: THE TREE (RESULTS) ---
    private JPanel createResultPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(COLOR_BERRY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20);

        JLabel gameOver = new JLabel("🍪 Quiz Complete! 🥛");
        gameOver.setFont(HEADER_FONT);
        gameOver.setForeground(COLOR_SNOW);
        panel.add(gameOver, gbc);

        gbc.gridy++;
        // Initialize the class variable here
        scoreLabel = new JLabel("Score: 0/0");
        scoreLabel.setFont(new Font("Serif", Font.BOLD, 28));
        scoreLabel.setForeground(COLOR_GOLD);
        panel.add(scoreLabel, gbc);

        gbc.gridy++;
        JButton homeBtn = new JButton("🛷 Sleigh Back to Menu");
        styleFestiveButton(homeBtn, COLOR_SNOW, COLOR_PINE);
        homeBtn.addActionListener(e -> cardLayout.show(mainPanel, "MENU"));
        panel.add(homeBtn, gbc);

        return panel;
    }

    // --- LOGIC ---

    private void startQuiz(String topic) {
        currentQuiz = bank.getQuestionByTopic(topic);

        if (currentQuiz.isEmpty()) {
            JOptionPane.showMessageDialog(this, "The elves couldn't find any questions for that topic!");
            return;
        }

        // Randomize questions
        Collections.shuffle(currentQuiz);

        currentQuestionIndex = 0;
        score = 0;

        // Setup Progress Bar
        progressBar.setMinimum(0);
        progressBar.setMaximum(currentQuiz.size());
        progressBar.setValue(0);

        loadQuestion();
        cardLayout.show(mainPanel, "QUIZ");
    }

    private void loadQuestion() {
        isAnswerSubmitted = false;
        actionButton.setText("🎁 Unwrap Answer");
        actionButton.setEnabled(true);
        explanationArea.setText("");
        buttonGroup.clearSelection();

        Questions q = currentQuiz.get(currentQuestionIndex);

        topicLabel.setText("🎄 CURRENT TOPIC: " + q.getTopic().toUpperCase());
        promptArea.setText(q.getPrompt());

        String[] choices = q.getChoices();
        for (int i = 0; i < choiceButtons.length; i++) {
            if (i < choices.length) {
                choiceButtons[i].setForeground(COLOR_PINE);
                choiceButtons[i].setText(choices[i]);
                choiceButtons[i].setVisible(true);
                choiceButtons[i].setEnabled(true);
            } else {
                choiceButtons[i].setVisible(false);
            }
        }
    }

    private void checkAnswer() {
        int selectedIndex = -1;
        for (int i = 0; i < choiceButtons.length; i++) {
            if (choiceButtons[i].isSelected()) {
                selectedIndex = i;
                break;
            }
        }

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Don't be a Grinch! Pick an answer.");
            return;
        }

        Questions q = currentQuiz.get(currentQuestionIndex);
        boolean correct = q.isCorrect(selectedIndex);

        if (correct) {
            score++;
            explanationArea.setText("🌟 CORRECT! 🌟\n" + q.getExplanation());
            explanationArea.setForeground(new Color(34, 139, 34)); // Green
        } else {
            explanationArea.setText("🌑 INCORRECT (Coal for you)\n" + q.getExplanation());
            explanationArea.setForeground(COLOR_BERRY); // Red
        }

        for (int i = 0; i < choiceButtons.length; i++) {
            choiceButtons[i].setEnabled(false);
            if (q.isCorrect(i)) {
                choiceButtons[i].setForeground(new Color(34, 139, 34));
                choiceButtons[i].setText(choiceButtons[i].getText() + " ✅");
            }
        }

        isAnswerSubmitted = true;
        progressBar.setValue(currentQuestionIndex + 1);

        if (currentQuestionIndex == currentQuiz.size() - 1) {
            actionButton.setText("🏁 Finish Sleigh Ride");
        } else {
            actionButton.setText("🦌 Next Question");
        }
    }

    private void handleActionButton() {
        if (!isAnswerSubmitted) {
            checkAnswer();
        } else {
            currentQuestionIndex++;
            if (currentQuestionIndex < currentQuiz.size()) {
                loadQuestion();
            } else {
                showResults();
            }
        }
    }

    private void showResults() {
        String message = "Final Score: " + score + " / " + currentQuiz.size();

        double percentage = (double) score / currentQuiz.size();
        if(percentage == 1.0) message += "\n🌟 PERFECT! YOU'RE ON THE NICE LIST! 🌟";
        else if(percentage > 0.7) message += "\n🎅 Great job!";
        else message += "\n❄️ Better luck next year!";

        scoreLabel.setText("<html><center>" + message.replace("\n", "<br>") + "</center></html>");
        cardLayout.show(mainPanel, "RESULTS");
    }

    // --- STYLING HELPERS ---

    private void styleFestiveButton(JButton btn, Color bg, Color fg) {
        btn.setFont(BUTTON_FONT);
        btn.setBackground(bg);
        btn.setForeground(fg);
        btn.setFocusPainted(false);
        btn.setOpaque(true);
        btn.setBorderPainted(true);
        btn.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(COLOR_GOLD, 2),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
    }

    private Border createCandyCaneBorder(int thickness) {
        Border red = new LineBorder(COLOR_BERRY, thickness);
        Border white = new LineBorder(COLOR_SNOW, thickness);
        return BorderFactory.createCompoundBorder(red,
                BorderFactory.createCompoundBorder(white, red));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReviewAppGUI());
    }
}