import java.util.Arrays;
import java.util.Random;

public class Dichotomy
{
  // Values range for the random array generation
  private static int randomArrayLength = 1000;
  private static int randomArrayValuesMin = 0;
  private static int randomArrayValuesMax = 1000;
  
  // Values range for the testing
  private static int testArrayLength = 10;
  private static int testArrayValuesMin = 0;
  private static int testArrayValuesMax = 1000;
  
  // Custom values
  private static int[] customArray = {2, 59, 87, 64, 123, 89, 45, 265, 364, 127};
  private static int[] customTestArray = {87, 56, 23};
  
  public static void main(String[] args)
  {
    Random randomNumber = new Random();
    // Generate random number list
    System.out.println("Generating random number list...");
    int[] randomArray = new int [randomArrayLength];
    for (int i = 0; i < randomArrayLength; i++)
      randomArray[i] = randomNumber.nextInt((randomArrayValuesMax - randomArrayValuesMin) + 1) + randomArrayValuesMin;
    Arrays.sort(randomArray);

    // Test with random values
    System.out.println("Generating random number testing list...");
    int[] testArray = new int [testArrayLength];
    for (int i = 0; i < testArrayLength; i++)
      testArray[i] = randomNumber.nextInt((testArrayValuesMax - testArrayValuesMin) + 1) + testArrayValuesMin;

    System.out.println("Testing values of the random number list...");
    for (int i = 0; i < testArrayLength; i++)
      algo(randomArray, testArray[i]);
    
    // Sort the custom array
    Arrays.sort(customArray);
    
    // Test with custom set of values
    System.out.println("Testing values of the custom number list...");
    for (int i = 0; i < customTestArray.length; i++) {
      algo(customArray, customTestArray[i]);
    }
    
    // Test with argument value
    if (args.length == 1) {
    	System.out.println("Testing value passed as an argument...");
    	algo(customArray, Integer.parseInt(args[0]));
    }
  }
  
  static boolean findValue(int[] array, int value, int leftIndex, int rightIndex)
  {
    // Get the middle index between left and right indexes
    int index = (leftIndex + rightIndex) / 2;
    
    // Show the process
    // System.out.println("left index = " + leftIndex + " | right index = " + rightIndex + " | test index = " + index + " | test index number = " + array[index]);
    
    if (value == array[index])
      return true;
    else if (index == leftIndex && index == rightIndex)
      return false;
    else if (value > array[index])
      return findValue(array, value, index + 1, rightIndex);
    return findValue(array, value, leftIndex, index);
  }
  
  static void algo(int[] array, int value) {
    
    if (array.length == 0)
      System.out.println("The number " + value + " does not appear in the list.");
    else if (findValue(array, value, 0, array.length - 1) == true)
      System.out.println("The number " + value + " does appear in the list.");
    else
      System.out.println("The number " + value + " does not appear in the list.");
  }
}
