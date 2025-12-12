package basicTool;

import java.util.Optional;

/*
1. 调用
    Optional.ofNullable 为null不抛异常
    Optional.of 为null直接抛异常
2. 使用map 拿到想要的字段
3. 使用orElse处理为null的情况

 */
public class OptionalDemo {
    public static void main(String[] args) {
        User0 u=new User0("ttt",18);
        String name= Optional.ofNullable(u)
                .map(User0::getName)
                .orElse("unknown");
    }
}
class User0{
    String name;
    int age;

    public User0(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}