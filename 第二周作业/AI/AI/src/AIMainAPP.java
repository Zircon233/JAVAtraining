import java.util.Scanner;

public class AIMainAPP {
    public static void main(String[] args) {
        AI ai = new AI();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("AI成精了！请输入你的问题。输入exit以随时跑路。");
            String input = in.next();
            if ("exit".equals(input)) {
                System.out.println("后会有期！");
                break;
            }
            String answer = ai.answer(input);
            System.out.println(answer);
        }

    }
}