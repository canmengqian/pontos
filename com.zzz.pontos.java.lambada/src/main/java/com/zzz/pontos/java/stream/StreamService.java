package com.zzz.pontos.java.stream;

import lombok.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ClassName StreamService
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/4 9:20
 * @Version 1.0.0
 **/
public class StreamService {

    @Test
    public  void testList() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        strings.stream().filter(str->{
            return str.startsWith("a");
        }).forEachOrdered(System.out::println);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
      List<Integer> rs= numbers.stream().map(num->num*num).sorted().collect(Collectors.toList());
        System.out.println(rs.size());
      long count=  numbers.stream().flatMapToInt(num-> IntStream.of(num*num)).boxed().count();
        System.out.println(count);

        System.out.println("-------------------limit使用-------------------");
        numbers.stream().flatMapToInt(num-> IntStream.of(num*num)).limit(5).sorted().forEach(stream->{
            System.out.println(stream);
        });
        System.out.println("-------------------使用并行流处理-------------------");
        numbers.stream().parallel().filter(number->{return number>3;}).sorted(Comparator.comparingInt(Integer::intValue).reversed()).map((num)-> num*num).forEach(System.out::println);
        System.out.println("-------------------Collectors-------------------");
        // HashMap出现冲突 进行value向前覆盖
        HashMap<Integer,Integer> map = (HashMap<Integer, Integer>) numbers.stream().filter(num->{return num>=3;}).collect(Collectors.toMap(Integer::intValue,Integer::intValue,(v1,v2)->{return v2;}));
        System.out.println("转map:"+map.toString());
       HashSet<Integer> set = (HashSet<Integer>) numbers.stream().collect(Collectors.toSet());
        System.out.println("转set:"+set.toString());
        System.out.println("-------------------统计-------------------");
        IntSummaryStatistics statistics = numbers.stream().filter(num->{return num>=3;}).mapToInt((x)->x).summaryStatistics();
        System.out.println("统计平均值:"+statistics.getAverage());
        System.out.println("统计最大值:"+statistics.getMax());
        System.out.println("统计最小值:"+statistics.getMin());
        System.out.println("统计元素个数:"+statistics.getCount());
        statistics.accept(10);
        System.out.println("统计元素个数:"+statistics.getCount());
    }
    @Test
    public void test_optional() throws MyException {
        User user1 = null;
        User user2 = User.builder().age(25).name("张三").build();
      //TODO  Optional<User> optionalUser = Optional.of(user1);//使用of会抛出空指针异常
       // Assertions.assertNull(optionalUser.get()) ;
      user1 =   Optional.ofNullable(user1).orElse(user2);
        System.out.println(user1.toString());
        user1 = Optional.ofNullable(user1).orElseGet(()->{return  user2;});
        System.out.println(user1.toString());
        user1 = null;
        /**
         * 自定义异常
         */
       /*user1= Optional.ofNullable(user1).orElseThrow(MyException::new);
        System.out.println(user1.toString());
        Assertions.assertNull(user1);*/
    }

}
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
class  User {
    private String name ;
    private int  age ;
}

class MyException extends   Throwable {
    @Override
    public String getMessage() {
        return "自定义异常";
    }
}