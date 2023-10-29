package SimpleJavaTextEditor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindTest {

    private Find find;
    private JTextArea textArea;

    @BeforeEach
    void setUp() {
        textArea = new JTextArea();
        textArea.setText("class Test{  \n" +
                "    public static void main(String args[]){  \n" +
                "     System.out.println(\"Hello Java\");  \n" +
                "    }  \n" +
                "}  ");
        find = new Find(textArea);

    }

    @Test
    void testFind() {
        find.textF.setText("static");
        find.find();
        assertEquals(25, find.select_start);
    }

    @Test
    void testReplace() {
        find.textF.setText("Java");
        find.textR.setText("World");
        find.replace();
        assertEquals(textArea.getText(),"class Test{  \n" +
                "    public static void main(String args[]){  \n" +
                "     System.out.println(\"Hello World\");  \n" +
                "    }  \n" +
                "}  ");
    }

    @Test
    void testFindNext() {
        find.textF.setText("nonexistent");
        find.findNext();
        assertEquals(-1, find.select_start);
    }
}

