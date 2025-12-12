package basicTool.jihe;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Stream API
    遍历 forEach 最后使用
    过滤 filter 传入参数和返回布尔值的判断
    排序 sorted
    转换 map
    分组
    聚合
 */

/*
使用
1. 创建stream
    l.stream() 拿到一个Stream<?>对象
2. 中间操作(不会触发执行)
    filter,map,sorted,distinct,limit,skip
3. 终止操作
    forEach,collect,count,refuce,anyMatch

注意
1. stream只能用一次
 */
public class StreamDemo {
    public static void main(String[] args) {
        //1.创建stream
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream = list.stream();

        // forEach遍历
        list.stream().forEach(x->System.out.println(x));

        //filter过滤
        list.stream().filter(x->x>3).forEach(x->System.out.println(x));

        //map 映射/转换 (对每个元素做修改)
        List<String> names = Arrays.asList("Alice", "Bob");
        names.stream()
                .map(name -> name.toUpperCase())
                .forEach(System.out::println);

        List<Integer> list2 = Arrays.asList(1,2,3,4,5);
        list2.stream()
                .map(x->x*10)
                .forEach(System.out::println);

        List<String> list22=list2.stream().map(x->x.toString()).collect(Collectors.toList());
        list22.forEach(System.out::println);

        //sorted
        List<Integer> list3 = Arrays.asList(1,4,3,4,2);
        list3.stream()
                .sorted()
                .forEach(System.out::println);

        List<Integer> list4 = Arrays.asList(1,4,3,4,2);
//        list4.stream().sorted();//这样子没有搜集结果，要加一个终止类的方法才能触发执行
        list4=list4.stream().sorted().collect(Collectors.toList());
        list4.forEach(System.out::println);

        //分组聚合
        List<Person> list5 = Arrays.asList(
                new Person("Alice", "Beijing", 20),
                new Person("Bob",   "Shanghai", 22),
                new Person("Carl",  "Beijing", 25),
                new Person("David", "Shanghai", 28),
                new Person("Eric",  "Beijing", 30)
        );
            //按city分组
        Map<String, List<Person>> groups =
                list5.stream().collect(Collectors.groupingBy(Person::getCity));

            //按城市统计人数
        Map<String, Long> count =
                list5.stream().collect(
                        Collectors.groupingBy(Person::getCity, Collectors.counting())
                );

        //聚合函数 count,sum,max,min
        List<Integer> list6=Arrays.asList(1,2,3,4,5);
        long cnt=list6.stream().filter(x->x>=3).count();
        int sum=list6.stream().mapToInt(x->x).sum();
        int max=list6.stream().max(Integer::compareTo).get();
        int min=list6.stream().min(Integer::compareTo).get();







    }
}
class Person {
    String name;
    String city;
    int age;

    public Person(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }
    public String getCity() { return city; }
    public int getAge() { return age; }
    public String getName() { return name; }
}
