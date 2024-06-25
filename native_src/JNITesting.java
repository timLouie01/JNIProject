import java.util.Scanner;

public class JNITesting {
    static{
        String libName = System.mapLibraryName("native");
        System.out.println("Loading library: " + libName);
        System.out.println("java.library.path: " + System.getProperty("java.library.path"));
        System.loadLibrary("native");
    }

    public static native String reverseString(String inputString);
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter a string to be reversed: ");

        String input = keyboard.nextLine();

        keyboard.close();

        System.out.println(reverseString(input));

    }
}
