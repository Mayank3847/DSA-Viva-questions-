public class String_ReversedWord {
    public static String reverseWordsInString(String sentence){
        sentence=sentence.trim();
        String reversedSentence="";
        int length=sentence.length();
        int end=length;
        for(int i = length-1;i>=0;i--){
           
            if(sentence.charAt(i)==' ' || i==0){
                int start;
                if(i==0){
                    start=i;
                }else{
                    start=i+1;
                }
                
                String word = sentence.substring(start, end);
            
                // Step 5: Skip empty words caused by consecutive spaces
                if (!word.isEmpty()) {
                    reversedSentence += word + " ";
                }
                end=i;
            }
        }
        return reversedSentence.trim();
    }
    public static String reverseWordsInStringOptimized(String sentence){
        String[] words = sentence.trim().split("\\s+");

        StringBuilder reversedSentence=new StringBuilder();
        for(int i =words.length-1;i>=0;i--){
            reversedSentence.append(words[i]);
            if(i!=0){
                reversedSentence.append(" ");

            }
        }
        return reversedSentence.toString(); 
    }
    public static void main(String[] args) {
        String sentence = "Hello World    from Mayank  ";
        String result = reverseWordsInString(sentence);
        System.out.println(result);
        // String sentence1 = "Hello World    from Mayank";
        String result1 = reverseWordsInStringOptimized(sentence);
        System.out.println(result1);
    }
    
}
