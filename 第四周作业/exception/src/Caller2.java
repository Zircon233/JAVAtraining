import MyExceptions.MyException;
import MyExceptions.MyRuntimeException;

public class Caller2 {
    Caller3 caller3 = new Caller3();

    public void call3RTException() {
        System.out.println("Caller2.call3RTException开始");
//        caller3.callThrowRTException();
        try {
            caller3.callThrowRTException();
        } catch (MyRuntimeException ex) {
            System.out.println("got exception in caller2: " + ex.getMessage());
        }

        System.out.println("Caller2.Caller2call3RTException结束");

    }

    public void call3Exception() throws  MyException {
        System.out.println("Caller2.call3Exception开始");
        try{
            caller3.callThrowException();

        }catch (MyException ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("Caller2.call3Exception结束");
    }
}