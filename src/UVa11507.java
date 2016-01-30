import java.util.Scanner;

/**
 * Created by Trung on 30/1/16.
 */
public class UVa11507 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        while (length != 0) {
            String curPos = "+x";
            for (int i = 0; i < length - 1; i++) {
                String bend = sc.next();
                if (bend.equals("No")) continue;
                if (bend.equals("+y")) {
                    if (curPos.equals("+x")) {
                        curPos = "+y";
                    } else if (curPos.equals("+y")) {
                        curPos = "-x";
                    } else if (curPos.equals("-x")) {
                        curPos = "-y";
                    } else if (curPos.equals("-y")) {
                        curPos = "+x";
                    }
                } else if (bend.equals("-y")) {
                    if (curPos.equals("+x")) {
                        curPos = "-y";
                    } else if (curPos.equals("-y")) {
                        curPos = "-x";
                    } else if (curPos.equals("-x")) {
                        curPos = "+y";
                    } else if (curPos.equals("+y")) {
                        curPos = "+x";
                    }
                } else if (bend.equals("+z")) {
                    if (curPos.equals("+x")) {
                        curPos = "+z";
                    } else if (curPos.equals("+z")) {
                        curPos = "-x";
                    } else if (curPos.equals("-x")) {
                        curPos = "-z";
                    } else if (curPos.equals("-z")) {
                        curPos = "+x";
                    }
                } else {
                    if (curPos.equals("+x")) {
                        curPos = "-z";
                    } else if (curPos.equals("-z")) {
                        curPos = "-x";
                    } else if (curPos.equals("-x")) {
                        curPos = "+z";
                    } else if (curPos.equals("+z")) {
                        curPos = "+x";
                    }
                }
            }
            System.out.println(curPos);
            length = sc.nextInt();
        }
    }
}
