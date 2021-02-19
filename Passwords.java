// To creat a programme to craet a password;
public class Passwords {

protected static final int MAX_INT = java.lang.Integer.MAX_VALUE;

protected static final int MIN_INT = java.lang.Integer.MIN_VALUE;

protected static final long MAX_LONG = java.lang.Long.MAX_VALUE;

protected static final long MIN_LONG = java.lang.Long.MIN_VALUE;

protected static final double PI = java.lang.Math.PI;

protected static final double E = java.lang.Math.E;

private static java.util.Scanner mash_console_scanner 
               = new java.util.Scanner(System.in);

private static void mash_debug_user_suspend() {
               
            }

private static void mash_debug_user_resume() {
               
               
            }

public static void main(java.lang.String[] mash_args_param) 
         throws java.lang.Exception {
            
{
Passwords.alphabetarray();
}

         }


protected static void alphabetarray()  {
java.lang.System.out.print("Length: ");
int i = mash_console_scanner.nextInt();
java.lang.String[] chararray = new java.lang.String[76];
chararray[0] = "a";
chararray[1] = "b";
chararray[2] = "c";
chararray[3] = "d";
chararray[4] = "e";
chararray[5] = "f";
chararray[6] = "g";
chararray[7] = "h";
chararray[8] = "i";
chararray[9] = "j";
chararray[10] = "k";
chararray[11] = "l";
chararray[12] = "m";
chararray[13] = "n";
chararray[14] = "o";
chararray[15] = "p";
chararray[16] = "q";
chararray[17] = "r";
chararray[18] = "s";
chararray[19] = "t";
chararray[20] = "u";
chararray[21] = "v";
chararray[22] = "w";
chararray[23] = "x";
chararray[24] = "y";
chararray[25] = "z";
chararray[26] = "A";
chararray[27] = "B";
chararray[28] = "C";
chararray[29] = "D";
chararray[30] = "E";
chararray[31] = "F";
chararray[32] = "G";
chararray[33] = "H";
chararray[34] = "I";
chararray[35] = "J";
chararray[36] = "K";
chararray[37] = "L";
chararray[38] = "M";
chararray[39] = "N";
chararray[40] = "O";
chararray[41] = "P";
chararray[42] = "Q";
chararray[43] = "R";
chararray[44] = "S";
chararray[45] = "T";
chararray[46] = "U";
chararray[47] = "V";
chararray[48] = "W";
chararray[49] = "X";
chararray[50] = "Y";
chararray[51] = "Z";
chararray[52] = "!";
chararray[53] = "@";
chararray[54] = "#";
chararray[55] = "$";
chararray[56] = "%";
chararray[57] = "^";
chararray[58] = "&";
chararray[59] = "*";
chararray[60] = "(";
chararray[61] = ")";
chararray[62] = "-";
chararray[63] = "_";
chararray[64] = "=";
chararray[65] = "+";
chararray[66] = "0";
chararray[67] = "1";
chararray[68] = "2";
chararray[69] = "3";
chararray[70] = "4";
chararray[71] = "5";
chararray[72] = "6";
chararray[73] = "7";
chararray[74] = "8";
chararray[75] = "9";
java.lang.System.out.print("Password:");
for (int j = 0; j < i; j = j + 1)
{
int a = Passwords.iRandom(0, 75);
java.lang.System.out.print(chararray[a]);
}
java.lang.System.out.println("");
}

protected static int iRandom(int a, int b)  {
return (int) (java.lang.Math.random() * (b - a + 1) + a);
}
}
