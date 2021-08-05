package own.junn.practice;

import own.junn.practice.vo.AT;
import own.junn.practice.vo.Message;
import own.junn.practice.vo.SMS;

public class TestMain {
    public static void main(String[] args) {
        Message<SMS> smsMessage = new Message<>();
        Message<AT> atMessage = new Message<>();

        SMS sms = new SMS();
        sms.setUsercode("suremtest5");
        sms.setDeptcode("3p-yfe-ol");
        sms.setMsg("test sms");
        sms.setReserved_time("000000000000");

        smsMessage.setMessage(sms);
    }
}
