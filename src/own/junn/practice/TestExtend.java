package own.junn.practice;

import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;

import java.util.HashMap;

public class TestExtend {
    public static void main(String[] args) {
        Parents parents = new Parents("susan", "500");
        Son son = new Son("john", "0", "sosabal", "soccer");
        Daughter daughter = new Daughter("jessy", "0", "sosabal", "running");
        Parents parents2 = new Son("mac", "0", "pyeong", "basketball");
        Parents parents3 = new Daughter("alba", "0", "pyeong", "basketball");

        HashMap<Integer, Parents> map = new HashMap<>();

        map.put(1, parents);
        map.put(2, son);
        map.put(3, daughter);
        map.put(4, parents2);
        map.put(5, parents3);

        for (Parents unit : map.values()) {
            unit.show();
        }
    }

    private static class Parents {
        private String name;
        private String salary;

        public Parents(String name, String salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public void show() {
            System.out.println(this.name + ":" + this.salary);
        }
    }

    private static class Son extends Parents {
        private String schoolName;
        private String hobby;

        public Son(String name, String salary, String schoolName, String hobby) {
            super(name, salary);
            this.schoolName = schoolName;
            this.hobby = hobby;
        }

        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }

        public String getHobby() {
            return hobby;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }

        public void show() {
            System.out.println(this.schoolName + ":" + this.hobby);
        }
    }

    private static class Daughter extends Parents {
        private String schoolName;
        private String hobby;

        public Daughter(String name, String salary, String schoolName, String hobby) {
            super(name, salary);
            this.schoolName = schoolName;
            this.hobby = hobby;
        }

        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }

        public String getHobby() {
            return hobby;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }

        public void show() {
            System.out.println(this.schoolName + ":" + this.hobby);
        }
    }
}
