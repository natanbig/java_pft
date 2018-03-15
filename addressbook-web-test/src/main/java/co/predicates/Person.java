package co.predicates;

/**
 * Created by natan.radostin on 3/11/2018.
 */
public class Person {

  private String name;
  private int age;

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Person{");
    sb.append("name='").append(name).append('\'');
    sb.append(", age=").append(age);
    sb.append('}');
    return sb.toString();
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {

    return name;
  }

  public int getAge() {
    return age;
  }

  public Person(String name, int age) {

    this.name = name;
    this.age = age;
  }
}
