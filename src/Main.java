import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        //task 1
        Predicate<Integer> predicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= 0;
            }
        };

        System.out.println(predicate1.test(-100));
        System.out.println(predicate1.test(100));

        System.out.println("----------------");

        Predicate<Integer> predicate = integer -> integer > 0;
        System.out.println(predicate.test(-8));
        System.out.println(predicate.test(9));

        System.out.println("----------------");


        //task 2

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Hello, " + s);
            }
        };

        consumer.accept("Dima");
        consumer.accept("Jessica");
        System.out.println("----------------");

        Consumer<String> consumer1 = s -> System.out.println("Hello, " + s);
        consumer1.accept("Elena");
        consumer1.accept("Igor");
        System.out.println("----------------");

        //task 3

        Function<Double, Long> function = new Function<Double, Long>() {

            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };

        System.out.println(function.apply(3.787D));
        System.out.println(function.apply(99.1D));
        System.out.println("-----------------");

        Function<Double, Long> function1 = aDouble -> Math.round(aDouble);
        System.out.println(function1.apply(99.1D));
        System.out.println(function1.apply(1.999D));
        System.out.println("------------------");


        //task 4

        Random random = new Random();
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return random.nextInt(100);
            }
        };

        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println("--------------");

        Supplier<Integer> supplier1 = () -> random.nextInt(100);
        System.out.println(supplier1.get());
        System.out.println(supplier.get());
        System.out.println("--------------");

        //task 5

        Predicate<Integer> condition = s -> s >= 18;
        Function<Integer, String> ifTrue = s -> "поздравляем! вы совершеннолетний";
        Function<Integer, String> ifFalse = s -> "вам нужно повзрослеть";

        Function<Integer,String> legalAge = ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(legalAge.apply(22));
        System.out.println(legalAge.apply(10));
        System.out.println(legalAge.apply(18));
    }


    public static Function <Integer, String> ternaryOperator(
        Predicate<? super Integer> condition,
        Function<? super Integer, ? extends String> ifTrue,
        Function<? super Integer, ? extends String> ifFalse) {
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

}
