public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    //stringbuffer是可变字符类，自动扩容。
    public boolean isPalindrome(String word) {
        StringBuffer a = new StringBuffer();
        for (int i = 0; i < word.length(); i++) {
            a.append(word.charAt(i));
        }
        if (a == a.reverse()) {
            return true;
        }
        return false;

    }

  //  public boolean isPalindrome2(String word) {
     //   Deque<Character> a = wordToDeque(word);
     //   if (word == null) {
       //     return true;
        //}
        //if (a.removeFirst() != a.removeLast()) {
          //  return false;
        //}
        //return true;
    //}

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        while (d.size() > 1) {
            if (!cc.equalChars(d.removeFirst(), d.removeLast())) {
                return false;
            }
        }
        return true;
    }
}

