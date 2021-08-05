package own.junn.practice.vo;

public class Message<T> {
    private T t;

    public T getMessage() {
        return t;
    }

    public void setMessage(T t) {
        this.t = t;
    }
}
