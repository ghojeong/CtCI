package Q1_03_URLify;
public class QuestionJeon {
    public static String replaceSpaces(String s){
        int begin=0;int end=0;
        String out = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                begin=i;break;
            }
        }
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                end=i;break;
            }
        }
        int flag=0;
        for(int i=begin;i<=end;i++){
            if(s.charAt(i)==' '){
                flag=1;
            }
            else{
                if(flag==1){
                    flag=0;
                    out+="%20";
                }
                out+=s.charAt(i);
            }
        }
        return out;
    }
	public static void main(String[] args) {
		String str = "Mr John Smith    ";
        String out = replaceSpaces(str);
        System.out.println(out);
	}
}
