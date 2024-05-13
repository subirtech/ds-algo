package com.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. Text Justification
 */
public class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        int currLength = 0;
        int spaceCount = -1;
        int totalSpace = 0;
        int extraSpace = 0;
        int wordCount = 0;
        List<String> result = new ArrayList<>();
        int k = 0;
        StringBuilder sb = null;
        int i = 0;
        for (; i < words.length; ) {
            if ((currLength + words[i].length() + spaceCount + 1) <= maxWidth) {
                currLength = currLength + words[i].length();
                spaceCount++;
                i++;
                wordCount++;
                continue;
            }

            extraSpace = (maxWidth - (currLength + spaceCount));
            totalSpace = spaceCount + extraSpace;
            if (wordCount > 1) {
                spaceCount = totalSpace / (wordCount - 1);
                extraSpace = totalSpace % (wordCount - 1);
            } else {
                spaceCount = totalSpace;
                extraSpace = 0;
            }
            sb = new StringBuilder();
            int m = 0;
            for (int j = k; j < i; j++) {
                sb.append(words[j]);
                if (j == i - 1 && wordCount > 1)
                    continue;
                if (m < extraSpace) {
                    sb.append(" ");
                    m++;
                }
                for (int l = 0; l < spaceCount; l++)
                    sb.append(" ");
            }
            k = i;
            spaceCount = -1;
            extraSpace = 0;
            totalSpace = 0;
            currLength = 0;
            wordCount = 0;
          //  System.out.println(sb.toString());
            result.add(sb.toString());
        }
        // input finished
        if (k != i) {
            sb = new StringBuilder();
            for (int j = k; j < i; j++) {
                sb.append(words[j]);
                if (sb.length() < maxWidth)
                    sb.append(" ");
            }
            for (int n = sb.length(); n < maxWidth; n++)
                sb.append(" ");

            result.add(sb.toString());
        }


        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"};
        List<String> result = fullJustify(words, 16);
        System.out.println(result);
    }
}
