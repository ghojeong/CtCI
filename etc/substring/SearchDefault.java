package etc.substring;

public class SearchDefault implements SearchInterface {
  public int search(String str, String subStr) {
    return str.indexOf(subStr);
  }
}
