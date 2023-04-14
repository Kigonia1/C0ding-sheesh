// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        char[] message = "Hallo Linus!".toCharArray();
        int[] keys = new int[message.length];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = Encryption.nextInt(Encryption.a, Encryption.b, Encryption.m, Encryption.x); // use the instance to call nextInt() method
        }
        int[] encrypted = Encryption.encrypt(message, keys);
        char[] decrypted = Encryption.decrypt(encrypted, keys);
        System.out.print("Original message: ");
        Encryption.printCharArray(message);
        System.out.print("Encrypted message: ");
        for (int i = 0; i < encrypted.length; i++) {
            System.out.print(encrypted[i] + " ");
        }
        System.out.println();
        System.out.print("Decrypted message: ");
        Encryption.printCharArray(decrypted);
    }
}