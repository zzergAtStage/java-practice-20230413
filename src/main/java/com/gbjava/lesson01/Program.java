import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * This is a first program for Java course in GB
 */
public class Program {
    public static void main(String[] args) {
        //System.out.println("\033[H" + "\033[2J");
        System.out.println("Hello world!");// why vscode inserts x:?
        int[] array = new int[] { 1, 2, 4, 5, 6 };
        float e = 2.5f;
        final double pi = 3.14D;
        char[] ch = new char[] { '(', ')', 123 };
        System.out.println("Char: " + ch[1] + ch[2]);
        String printOut = "";
        var implicitTypeCon = 123;
        boolean disn = true ^ false; // This is a sign of disjunction TODO
        System.out.println("disjunction = " + disn);

        // Type of variables
        var typeObj = 123_123_23.34;
        System.out.println(GetType(typeObj) + " " + typeObj);
        for (int i : array) {
            printOut += i;
        }
        System.out.println(printOut);

        // byte operations
        int a = 8;
        System.out.println("a << 1 = " + (a << 1));
        ByteOperationsOr(5, 2);
        ByteOperationsOr(2, 3);
        ByteOperationsAnd(2, 2);

        // work with input stream

        Scanner iScanner = new Scanner(System.in);
        System.out.printf("int a:");
        boolean flag = iScanner.hasNextInt();
        int i = 0;
        if (flag) {
            i = iScanner.nextInt();
        } else {
            System.out.println("Wrong input!");
        }
        System.out.println(i);
        iScanner.close();


        try (FileWriter fw = new FileWriter("GB_java_l01.txt",Charset.forName("UTF-8"))) {
            fw.write("printOut");
            fw.append('\n');
            fw.append('2');
            String tmpS = String.format("\n new int %d",i);
            fw.append(tmpS);
            fw.append("line 3");
            fw.flush();
        
        } catch (Exception ex) {
            System.out.println("Some error: " + ex.getMessage());
        }
    }

    // Methods
    private static void ByteOperationsOr(int a, int b) {
        String s;

        s = String.format("('%1$d' | '%2$d') = ", a, b) + (a | b);
        System.out.println(s);
    }

    private static void ByteOperationsAnd(int a, int b) {
        String s;

        s = String.format("('%1$d' & '%2$d') = ", a, b) + (a & b);
        System.out.println(s);
    }

    static String GetType(Object o) {
        return o.getClass().getSimpleName();
        
    }

}
