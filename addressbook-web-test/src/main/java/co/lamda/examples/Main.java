package co.lamda.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.lang.System.out;

/**
 * Created by natan.radostin on 3/14/2018.
 */
public class Main {

  public static void main(String[] args) {

    List<Integer> values = new ArrayList<>();
    values.addAll(Arrays.asList(new Integer[]{0,1,2,3,4,5,6,7,8,9}));

    for(Integer v : values){
      out.println(v+" ");
    }
    out.println("/////////////////////////////");
    values.forEach(out::print);
    out.println();
    IFuncTest ift = v->v>5;
    for(Integer v:values) {
      if (ift.test(v))
        out.println(v);
    }
    out.println();
    Predicate<Integer> pft = v->v>5;
    values.removeIf(pft);
    values.forEach(out::println);
  }

public static void test(Integer a, Integer b){
    Runnable r = () -> {

    };
}

}


@FunctionalInterface
interface IFuncTest{
  boolean test(Integer value);
}
