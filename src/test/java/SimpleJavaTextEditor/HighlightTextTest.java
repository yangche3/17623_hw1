package SimpleJavaTextEditor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;


import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class HighlightTextTest {
    private HighlightText highlighter;
    private JTextComponent textComp;

    @BeforeEach
    void setUp() {
        textComp = new JTextArea();
        highlighter = new HighlightText(Color.GRAY);
        textComp.setText("The conclusion is clear: software engineering is difﬁcult, and so is software testing.");
    }

    // White-box tests
    @Test
    void testHighlightText() {
        String[] patterns = {"The","software"};
        highlighter.highLight(textComp, patterns);

        // Check that the text component has highlights
        Highlighter.Highlight[] highlights = textComp.getHighlighter().getHighlights();
        assertEquals(3, highlights.length);

        // Check the start and end offsets of each highlight
        assertEquals(0, highlights[0].getStartOffset());
        assertEquals(3, highlights[0].getEndOffset());

        assertEquals(25, highlights[1].getStartOffset());
        assertEquals(33, highlights[1].getEndOffset());

        assertEquals(69, highlights[2].getStartOffset());
        assertEquals(77, highlights[2].getEndOffset());

    }
}
