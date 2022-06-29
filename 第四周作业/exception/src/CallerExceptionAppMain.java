import MyExceptions.MyException;

public class CallerExceptionAppMain {
    public static void main(String[] args) throws ClassNotFoundException, MyException {
        makeCall();
    }

    private static void makeCall() throws ClassNotFoundException, MyException {
        // >> TODO 检查异常强制处理，需要明确的throws或者catch
        Caller1 caller1 = new Caller1();
        System.out.println("调用开始");
        caller1.call2Exception();
        System.out.println("调用结束");
    }
}