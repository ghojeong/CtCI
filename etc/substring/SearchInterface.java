package etc.substring;

public interface SearchInterface {
  // 첫 subString의 charAt 위치를 리턴한다.
  // 만약 subString 이 존재하지 않으면 -1을 리턴한다.
  public abstract int search(String str, String subString);
}
