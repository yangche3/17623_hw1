package SimpleJavaTextEditor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
public class FEditTest {
    private JTextArea textArea;

    @BeforeEach
    void setUp() {
        textArea = new JTextArea();
        textArea.setText("""
                class Test{ \s
                    public static void main(String args[]){ \s
                     System.out.println("Hello Java"); \s
                    } \s
                } \s""");
    }

    @Test
    void testClear(){
        FEdit.clear(textArea);
        Assertions.assertEquals("", textArea.getText());
    }
}
