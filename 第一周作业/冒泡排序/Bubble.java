import java.util.Scanner;

public class Bubble {
    public static void main(String[] args) {
        //输入
        Scanner in = new Scanner(System.in);
        System.out.println("请输入：");
        String inputStr = in.nextLine();
        char[] inputArray = inputStr.toCharArray();

        //冒泡
        for (int i = 0; i < inputArray.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < inputArray.length - 1 - i; j++) {
                if (inputArray[j] > inputArray[j + 1]) {
                    char t = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = t;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

        //输出
        System.out.print("有序字符串：");
        for (int i = inputArray.length - 1; i >= 0; i--) {
            System.out.print(inputArray[i]);
        }
        System.out.print("\nASCII码：[");
        for (int i = inputArray.length - 1; i >= 0; i--) {
            System.out.print((int) inputArray[i] + ",");
        }
        System.out.println("\b]");
    }
}
