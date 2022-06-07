import java.util.Scanner;

public class NumGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //游戏设置
        int rangeStart = 30;
        int rangeEnd = 50;
        int guessTotal = 5;

        //游戏统计
        int totalGameCount = 0;
        int correctCount = 0;

        //结束游戏
        boolean gameEnd = false;

        while (!gameEnd) {
            //生成指定范围内的随机数
            int mod = rangeEnd - rangeStart;
            if (rangeEnd <= 0 || rangeStart <= 0) {
                System.out.println("开始和结束必须是正数或0");
            }
            if (mod <= 1) {
                System.out.println("非法的数字范围：(" + rangeStart + "," + rangeEnd + ")");
            }
            int bigRandom = (int) (Math.random() * rangeEnd * 100);
            int numberToGuess = (bigRandom % mod) + rangeStart;
            if (numberToGuess <= rangeStart) {
                numberToGuess = rangeStart + 1;
            }
            if (numberToGuess >= rangeEnd) {
                numberToGuess = rangeEnd - 1;
            }

            //剩余的猜测次数
            int leftToGuess = guessTotal;

            boolean currentGameCounted = false;
            boolean correctGuess = false;

            System.out.println("请输入猜测的数字，范围为（" + rangeStart + "," + rangeEnd + ")。输入-1即结束游戏");
            while (leftToGuess > 0) {
                System.out.println("剩余猜测次数" + leftToGuess + "次，请输入本次猜测的数字：");
                int guess = in.nextInt();
                if (guess < 0) {
                    gameEnd = true;
                    System.out.println("用户选择结束游戏。");
                    break;
                }
                if (!currentGameCounted) {
                    totalGameCount++;
                    currentGameCounted = true;
                }
                leftToGuess--;
                if (guess > numberToGuess) {
                    System.out.println("输入的数字比目标数字大");
                } else if (guess < numberToGuess) {
                    System.out.println("输入的数字比目标数字小");
                } else {
                    System.out.println("输入正确！");
                    correctCount++;
                    correctGuess = true;
                    break;
                }
            }
            if (!correctGuess) {
                System.out.println("本次游戏正确结果为" + numberToGuess);
            }
            System.out.println("共进行了" + totalGameCount + "次游戏，其中猜中了" + correctCount + "次");
        }
    }
}
