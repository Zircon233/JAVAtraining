package Guess;

import java.util.Scanner;

public class Guess {

    private int rangeStart ;
    private int rangeEnd ;

    private int guessTotal;

    private int totalGameCount;

    private int totalCorrectCount;

    private int guessLeft;

    private boolean stopGame;


    public void guessInit() {
        stopGame = false;
        Scanner in = new Scanner(System.in);
        System.out.println("输入1进行游戏设置");
        String isSet = in.next();
        handleGameQuit(isSet);
        boolean setSuccess = false;
        while ((handleGameStart(isSet) && (!setSuccess))) {

            setSuccess = setRangeAndGuessTotal(handleGameStart(isSet));
        }


    }

    public void guessGameStart() {
        Scanner in = new Scanner(System.in);
        System.out.println("=================== 猜 数 字 ===================");
        System.out.println("输入1以开始游戏,输入-1随时结束游戏。");
        String isStart = in.next();
        while (handleGameStart(isStart) && (!stopGame)) {
            guessInit();
            guessLeft = this.guessTotal;
            int num = generateGuessNumber();

            System.out.println("数字已经生成，数字在" + rangeStart + "到" + rangeEnd + "之间，" +
                    "不包括这两个数。共有" + guessTotal + "次猜测的机会。");
            gameToGuess(num);
        }


    }

    public boolean guessGameStop(int num) {
        if (num == -1)
            return true;
        else
            return false;
    }

    public void gameToGuess(int num) {
        boolean gameStart = true;
        Scanner in = new Scanner(System.in);
        boolean guessCorrect = false;
        stopGame = guessGameStop(num);
        while (guessLeft > 0 && ((!stopGame))) {
            System.out.println("还有" + guessLeft + "次机会，请输入猜测的数字，回车确认");
            int guessNum = in.nextInt();
            handleGameQuit(Integer.toString(this.rangeStart));
            stopGame = guessGameStop(guessNum);
            if (guessNum <= rangeStart || guessNum >= rangeEnd) {
                System.out.println("请输入在" + rangeStart + "到" + rangeEnd + "之间，的数字，不包括这两个数。");
                continue;
            }
            if (gameStart) {
                this.totalGameCount++;
                gameStart = false;
            }
            guessLeft--;
            if (guessNum == num) {
                totalCorrectCount++;
                guessCorrect = true;
                System.out.println("恭喜你猜对了！这次的数字就是" + num +
                        "。本次你共猜了" + (guessTotal - guessLeft) + "次。");

                break;
            } else if (guessNum > num) {
                System.out.println("猜测的数字比目标数字大。");
            } else {
                System.out.println("猜测的数字比目标数字小。");
            }
        }
        if (!guessCorrect) {
            System.out.println("本次的目标数字是" + num + "。这次没有猜中。");

        }
    }

    public boolean setRangeAndGuessTotal(boolean isSet) {
        if (isSet) {
            Scanner in = new Scanner(System.in);
            System.out.println("请输入开始范围");
            this.rangeStart = in.nextInt();
            handleGameQuit(Integer.toString(this.rangeStart));
            while (this.rangeStart <= 0) {
                System.out.println("请输入大于0的数。");
                System.out.println("请输入开始范围");
                this.rangeStart = in.nextInt();
                handleGameQuit(Integer.toString(this.rangeStart));
            }

            System.out.println("请输入结束范围");
            this.rangeEnd = in.nextInt();
            handleGameQuit(Integer.toString(this.rangeEnd));
            while (this.rangeEnd <= 0) {
                System.out.println("请输入大于0的数。");
                System.out.println("请输入结束范围");
                this.rangeEnd = in.nextInt();
                handleGameQuit(Integer.toString(this.rangeEnd));
            }



            if (this.rangeStart < this.rangeEnd) {
                System.out.println("请输入需要猜测的次数");
                this.guessTotal = in.nextInt();
                handleGameQuit(Integer.toString(this.guessTotal));
                return true;
            } else if (this.rangeStart > this.rangeEnd) {
                int temp;
                temp = this.rangeStart;
                this.rangeStart = this.rangeEnd;
                this.rangeEnd = temp;
                System.out.println("开始数大于截止数，已自动互换");
                System.out.println("请输入需要猜测的次数");
                this.guessTotal = in.nextInt();
                handleGameQuit(Integer.toString(this.guessTotal));
                return true;
            } else if (this.rangeStart == this.rangeEnd) {
                System.out.println("两个数大小相同，请重新输入范围");
                return false;
            }
        }
        return false;
    }

    public int generateGuessNumber() {
        int guessLeft = guessTotal;
        int mod = rangeEnd - rangeStart;
        double randNum = Math.random();
        int num = ((int) (randNum * rangeEnd * 100)) % mod;
        num += rangeStart;
        if (num <= rangeStart) {
            num = rangeStart + 1;
        }
        if (num >= rangeEnd) {
            num = rangeEnd - 1;
        }
        return num;
    }


    private boolean handleGameStart(String question) {
        String[] canStart = new String[]{"1"};
        for (int k = 0; k < canStart.length; k++)
            if (question.startsWith(canStart[k]))
                return true;
        return false;
    }

    private void handleGameQuit(String Stop) {
        if ("-1".equals(Stop))
            System.exit(0);
    }
}