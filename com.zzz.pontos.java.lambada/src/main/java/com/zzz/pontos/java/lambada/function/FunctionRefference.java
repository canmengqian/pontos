package com.zzz.pontos.java.lambada.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 方法引用
 */
public class FunctionRefference {
    static class Car {
        //Supplier是jdk1.8的接口，这里和lamda一起使用了
        public static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        public static void collide(final Car car) {
            System.out.println("Collided " + car.toString());
        }

        public void follow(final Car another) {
            System.out.println("Following the " + another.toString());
        }

        public void repair() {
            System.out.println("Repaired " + this.toString());
        }

        public void repair(Car car) {
            System.out.println("Repaired 2" + this.toString());
        }
    }

    @Test
    public void test() {
        FunctionRefference.Car car = Car.create(Car::new);
        List<Car> cars = Arrays.asList(car);
        cars.forEach(Car::collide);
        cars.forEach(Car::repair);
        // cars.forEach(Car::follow); // 编译报错
        // 通过实例进行引用
        cars.forEach(car::follow);
    }
}
