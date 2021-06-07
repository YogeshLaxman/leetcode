class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> answer = new ArrayList<>();
        
        int index = 0;
        while(index < words.length) {
            int start = index;
            int wordsLength = words[index].length();
            int numberOfWords = 1;
            while (index + numberOfWords < words.length) {
                if (words[index + numberOfWords].length() + wordsLength + numberOfWords <= maxWidth) {
                    wordsLength += words[index + numberOfWords].length();
                    numberOfWords++;
                } else {
                    break;
                }
            }
            int numSpaces = maxWidth - wordsLength;
            StringBuilder sb = new StringBuilder();
            sb.append(words[index]);
            if (index + numberOfWords == words.length) {
                for (int i=1; i<numberOfWords; i++) {
                    sb.append(" ").append(words[index+i]);
                }
            } else {
                for (int i=1; i<numberOfWords; i++) {
                    double temp = Math.ceil(numSpaces*1.0 / (numberOfWords - i));
                    int spaces = (int) temp;

                    numSpaces -= spaces;

                    for (int j=0; j<spaces; j++) {
                        sb.append(" ");
                    }
                    sb.append(words[index + i]);
                }
            }
            int len = sb.length();
            for (int i=len; i<maxWidth; i++) {
                sb.append(" ");
            }
            answer.add(sb.toString());
            index += numberOfWords;
        }
        return answer;
    }
}