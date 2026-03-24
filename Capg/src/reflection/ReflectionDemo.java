package reflection;

import java.lang.reflect.Field;

public class ReflectionDemo {

    public static void main(String[] args) throws Exception {

        Employee emp = new Employee(101, "Shivam", 50000);

        Class<?> cls = emp.getClass();

        System.out.println("Class Name: " + cls.getName());

        Field[] fields = cls.getDeclaredFields();

        for(Field f : fields) {
            f.setAccessible(true);
            System.out.println(f.getName() + " : " + f.get(emp));
        }
    }
}