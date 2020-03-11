import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class Ch02Q01GhoTest {
  @Test
  public void evaluatesExpression() {
    LinkedList<Integer> ll = new LinkedList<Integer>(
        Arrays.asList(79, 73, 72, 72, 69, 75, 71, 78, 68, 80, 63, 76, 80, 70, 72, 74, 71, 68, 80, 79, 82, 69, 76, 70,
            66, 70, 77, 63, 72, 69, 67, 80, 66, 79, 76, 75, 72, 81, 82, 73, 79, 63, 81, 79, 65, 80, 72, 65, 75, 66, 64,
            73, 77, 65, 72, 63, 74, 80, 64, 79, 72, 74, 72, 67, 75, 63, 76, 80, 75, 64, 78, 72, 77, 73, 70, 70, 67, 66,
            70, 73, 67, 73, 78, 82, 69, 68, 74, 78, 73, 74, 75, 65, 72, 71, 80, 74, 72, 69, 69));

    LinkedList<Integer> deletedLl = new LinkedList<Integer>(
        Arrays.asList(79, 73, 72, 69, 75, 71, 78, 68, 80, 63, 76, 70, 74, 82, 66, 77, 67, 81, 65, 64));

    assertTrue(Ch02Q01Gho.deleteDups(ll).equals(deletedLl));
  }
}
