package SimpleJavaTextEditor;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <h1>A class to store the programming language keywords and provide access to them.</h1>
 *
 * <p>
 * Makes multiple language support possible and makes adding new language support convenient. To add
 * more keywords, add a string array and getters to this class. Then, update the switch statement in
 * UI.java.
 * </p>
 */
public class SupportedKeywords {

    private String[] supportedLanguages = {".cpp", ".java"};

    private String[] java = {"abstract", "assert", "boolean", "break", "byte", "case", "catch",
            "char", "class", "const", "continue", "default", "do", "double", "else", "extends",
            "false", "final", "finally", "float", "for", "goto", "if", "implements", "import",
            "instanceof", "int", "System", "out", "print()", "println()", "new", "null", "package",
            "private", "protected", "public", "interface", "long", "native", "return", "short",
            "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws",
            "transient", "true", "try", "void", "volatile", "while", "String"};

    private String[] cpp = {"auto", "const", "double", "float", "int", "short", "struct",
            "unsigned", "break", "continue", "else", "for", "long", "signed", "switch", "void",
            "case", "default", "enum", "goto", "register", "sizeof", "typedef", "volatile", "char",
            "do", "extern", "if", "return", "static", "union", "while", "asm", "dynamic_cast",
            "namespace", "reinterpret_cast", "try", "bool", "explicit", "new", "static_cast",
            "typeid", "catch", "false", "operator", "template", "typename", "class", "friend",
            "private", "this", "using", "const_cast", "inline", "public", "throw", "virtual",
            "delete", "mutable", "protected", "true", "wchar_t"};

    public String[] getSupportedLanguages() {
        return supportedLanguages;
    }

    private String[] brackets = {"{", "("};
    private String[] bCompletions = {"}", ")"};

    public String[] getJavaKeywords() {
        return java;
    }

    public String[] getCppKeywords() {
        return cpp;
    }

    /**
     * Add a new language-specifc keyword 
     * 
     * @param language the language for which we will add keywords
     * @param newKeywords the new keywords to add
     * @return the updated list of keywords, if a change was made
     */
    public String[] addKeywords(String language, String[] newKeywords) {
        String[] existingKeywords = null;

        if (language == supportedLanguages[0])
            existingKeywords = getCppKeywords();
        else if (language == supportedLanguages[1]) {
            existingKeywords = getJavaKeywords();
        } else {
            return null;
        }

        if (existingKeywords != null) {
            for (String newKw : newKeywords) {
                for (String kw : existingKeywords) {
                    if (kw.equals(newKw)) {
                        return existingKeywords;
                    }
                }
            }
        }

        ArrayList<String> list = new ArrayList<>(Arrays.asList(existingKeywords));
        list.addAll(Arrays.asList(newKeywords));

        if (language == supportedLanguages[1]) {
            java = new String[list.size()];
            list.toArray(java);
            return java;
        } else if (language == supportedLanguages[0]) {
            cpp = new String[list.size()];
            list.toArray(cpp);
            return cpp;
        }
        return null;
    }

    public ArrayList<String> getBracketCompletions() {
        ArrayList<String> al = new ArrayList<>();
        for (String completion : bCompletions) {
            al.add(completion);
        }
        return al;
    }

    public ArrayList<String> getBrackets() {
        ArrayList<String> al = new ArrayList<>();
        for (String completion : brackets) {
            al.add(completion);
        }
        return al;
    }

    public ArrayList<String> setKeywords(String[] arr) {
        ArrayList<String> al = new ArrayList<>();
        for (String words : arr) {
            al.add(words);
        }
        return al;
    }

}
