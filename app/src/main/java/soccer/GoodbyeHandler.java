package soccer;

public class GoodbyeHandler implements Command{
  @Override
  public void service() {
    System.out.println("안녕히가십시오!");
  }
}
