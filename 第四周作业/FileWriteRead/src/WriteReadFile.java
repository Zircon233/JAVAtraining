import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class WriteReadFile {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        File targetFile = createFile();
        boolean StopFlag = false;
        while (!StopFlag) {
            System.out.println("rewrite:重写文件\tappend：向文件添加新内容\n" +
                    "read：读文件\tdelete:删除文件\n" + "输入其他任意字符结束");
            String input = in.next().trim();
            switch (input) {
                case "rewrite": {
                    writeToFile(targetFile, false);
                    break;
                }
                case "append": {
                    writeToFile(targetFile, true);
                    break;
                }
                case "read": {
                    ReadClassicWay(targetFile);
                    break;
                }
                case "delete": {
                    deleteFile(targetFile);
                    break;
                }
                default: {
                    StopFlag = true;
                    break;
                }
            }

            System.out.println("程序执行结束");
        }

    }

    /***读取文件***/
    private static void ReadClassicWay(File sourceFile) {
        try (
                FileInputStream fis = new FileInputStream(sourceFile);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(isr)
        ) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line.trim().toUpperCase());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /***写入文件***/
    private static void writeToFile(File targetFile, boolean append) throws IOException {

        try (
                FileOutputStream fos = new FileOutputStream(targetFile, append);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                PrintWriter pw = new PrintWriter(osw);
        ) {
            System.out.println("输入的内容会实时写入文件，如果输入空行则结束");
            while (true) {
                System.out.println("请输入内容");
                String ContentToWrite = new Scanner(System.in).nextLine().trim();
                if (ContentToWrite.trim().isBlank()) {
                    System.out.println("输入结束");
                    break;
                } else {
                    System.out.println("输入内容为" + ContentToWrite);
                    pw.println(ContentToWrite);
                    pw.flush();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /***创建文件***/
    private static File createFile() throws IOException {
        System.out.println("请输入文件名：");
        String fileName = in.nextLine().trim();
        File f = new File("." + File.separator + fileName + ".txt");
        if (f.isFile()) {
            System.out.println("目标文件存在，是否覆盖？\t扣 1 覆盖");
            int overwrite = in.nextInt();
            if (overwrite == 1)
                f.delete();
            else
                return f;
        }
        System.out.println("新文件创建状态：" + f.createNewFile());
        return f;
    }

    private static File deleteFile(File targetFile) throws IOException {
        System.out.println("确认删除？\t扣 1 确认\t否则取消");
        int deleteConfirm = in.nextInt();
        if (deleteConfirm == 1)
            targetFile.delete();
        else
        System.out.println("放弃删除");

        return null;
    }

}