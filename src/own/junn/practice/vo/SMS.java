package own.junn.practice.vo;

public class SMS {
    private String usercode;
    private String deptcode;
    private String msg;
    private String reserved_time;

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getReserved_time() {
        return reserved_time;
    }

    public void setReserved_time(String reserved_time) {
        this.reserved_time = reserved_time;
    }
}
