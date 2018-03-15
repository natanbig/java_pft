package co.predicates;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by natan.radostin on 3/11/2018.
 */
public class Program {

  public static void main(String[] args) {


    List<Person> persons = new ArrayList<>();
    persons.add(new Person("Natan",35));
    persons.add(new Person("Vladimir",46));
    persons.add(new Person("Sivan", 34));


   // for(Person p:persons)
     // out.println(p);
    //persons.stream().forEach( p->out.println(p));
    persons.stream().
            filter(p->p.getAge()>=35).
            sorted((p1,p2)->p1.getName().compareTo(p2.getName())).
            map(p->p.getName()).
            forEach(out::println);


  }
}
