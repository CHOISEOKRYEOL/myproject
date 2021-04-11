package soccer;

public class HelloHandler implements Command {

  @Override
  public void service() {
    System.out.println("안녕하십시오!");
  }
}
