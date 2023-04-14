public class Encryption {
    public static int x = 3;
    public static final int a = 7;
    public static final int b = 28;
    public static final int m = 256;

    public static int nextInt(int a, int b, int m, int x){
        x = (a * x + b) % m;
        return x;
    }

    public static void printCharArray(char[] letter){ //nimmt cha array "value"
        System.out.print("{");
        for(int i = 0; i < letter.length; i++){
            System.out.print("'" + letter[i] + "'");
            if (i < letter.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("} --> \"");
        for(int j = 0; j < letter.length; j++){
            System.out.print(letter[j]);
        }
        System.out.print("\"\n");       
    }

    public static int[] encrypt(char[] letters, int[] keys){
        int[] encrypted = new int[letters.length];
        for(int i = 0; i < letters.length; i++){
            int enci = 0;
            int k_i = keys[i];
            int c_i = letters[i];
            if(i == 0){
                enci = c_i ^ k_i;
            }else{
                enci = c_i ^ k_i  ^ encrypted[i - 1];
            }
            encrypted[i] = enci;
        }
        return encrypted;
    }

    public static char[] decrypt(int[] letters, int[] keys){
        char[] decrypted = new char[letters.length];
        int past = 0;
        for(int i = 0; i < letters.length; i++){
            int k_i = keys[i % keys.length];
            int decimal = letters[i];
            if(i > 0){
                decimal ^= past;
            }
            decimal ^= k_i;
            past = letters[i] ^ k_i;
            decrypted[i] = (char) decimal;
        }
        return decrypted;
    }
}
