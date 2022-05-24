public class HashTable extends Object
{
  private String[] words;
  private int capacity = 3;
  private int itemsStored = 0;
  private final double MAX_LOAD_FACTOR = 0.5;
  
  
  public HashTable()
  {
    words = new String[capacity];
  
  }
private int index(String str){
    int index = str.hashCode() % capacity;
    if (index < 0){
      index += capacity;
    }
    if (words[index] == null) return index;
   else if (words[index] != str){
     while(words[(index+1)%capacity] !=null){
       index++;
     }
   }
    return index;
  }

  //postcondition: Add str to words using str.hashCode() % capacity
  //postcondition: itemsStored has increased by 1 
  public void add(String str)
  {
      int index = this.index(str);
      
      while (words[index] != null){
        index = (index+1)%capacity;;
      }
    // System.out.println(index);
      words[index] = str;
    
      itemsStored++;

    this.checkLoadFactor();  //leave this as the last line of the method
  }

  
  
  public boolean contains(String str)
  {
    //complete this...
    int index = this.index(str);

    if (str.equals(words[index])) return true;
    return false;
  }

  
  //postcondition: return true if str was present and was removed (also decrease itemsStored)
  //return false otherwise
  public boolean remove(String str)
  {
    if (this.contains(str) == false) return false;

    
    words[this.index(str)] = null;
    itemsStored--;
    return true;
    
  }

  
  //return the current number of items stored in the hash table
  public int size()
  {
    //complete this...
    return itemsStored;
  }


    //If the table is less than MAX_LOAD_FACTOR full, do nothing
    //Otherwise, create a string array with roughly twice the capacity
    private void checkLoadFactor()
    {
      if ( (double)itemsStored / (double)capacity > MAX_LOAD_FACTOR)
      {
        // System.out.println(nextPrimeAfter(capacity*2));
        
        capacity = nextPrimeAfter(capacity*2);
        String[] temp = new String[capacity];
        for (int x = 0; x<words.length;x++){
          String s = words[x];
          if (s != null){
            

        int index = s.hashCode() % capacity;
            if (index < 0){
              index += capacity;
            }
             while (temp[index] != null){
        index = (index+1)%capacity;;
      }
            temp[index] = s;
            
          }
        } 
        this.words = temp;
        }
      
      
  }


  
  //==========================================================================================
  //These methods are complete already (I hope)
  //==========================================================================================
  public String toString()
  {
    StringBuffer sb = new StringBuffer(String.format("%8s%16s  Value\n","Index","Hash Code"));
    if (words != null)
    {
      for (int m = 0; m < words.length; m++)
      {
        if (words[m]!= null)
        {
          sb.append(String.format("%8d%16d  "+words[m]+"\n", m, words[m].hashCode()));
        }
      }
    }
    return sb.toString(); 
  }


  
  //precondition : n >= 3
  //postcondition: return the next prime number after n
  private int nextPrimeAfter(int n)
  {
    int a = n;
    if(n % 2 ==0) a++;
    else a+=2;
    while (this.isPrime(a) == false)
    {
       a += 2;
    }
    return a;
  }

  //precondition: n >= 2
  //postcondition: returns whether n is a prime number or not
  private boolean isPrime(int n)
  {
    if (n % 2 == 0) return false;
    int t = 3;
    int stop = (int)Math.round(Math.sqrt(n));
    while (t < stop)
    {
      if (n % t == 0) return false;
      t += 2;
    }
    return true;
  }

  
}