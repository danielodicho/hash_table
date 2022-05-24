public class Main extends Object
{
  public static void main(String[] args)
  {
    HashTable h = new HashTable();
    // System.out.println("FB".hashCode());
    // System.out.print("Ea".hashCode());
    h.add("Ea");
    h.add("C");
        h.add("FB");
    h.add("C");
    h.add("C");
    h.add("C");
    h.add("C");
    h.add("C");
    h.add("C");

    System.out.println(h);

    System.out.println(h.contains("C"));
    
    
  }
}