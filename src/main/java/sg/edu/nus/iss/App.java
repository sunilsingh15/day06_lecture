package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Set<String> formattedWords = new HashSet<>();

        String[] stopWords = {
            "a", "about", "above", "after", "again", "against", "all", "am", "an", "and", "any", "are", "aren't", "as", "at", "be",
            "because", "been", "before", "being", "below", "between", "both", "but", "by", "can't", "cannot", "could",
            "couldn't", "did", "didn't", "do", "does", "doesn't", "doing", "don't", "down", "during", "each", "few", "for", "from",
            "further", "had", "hadn't", "has", "hasn't", "have", "haven't", "having", "he", "he'd", "he'll",
            "he's", "her", "here", "here's", "hers", "herself", "him", "himself", "his", "how", "how's", "i", "i'd", "i'll",
            "i'm", "i've", "if", "in", "into", "is", "isn't", "it", "it's", "its", "itself", "let's", "me", "more",
            "most", "mustn't", "my", "myself", "no", "nor", "not", "of", "off", "on", "once", "only", "or", "other", "ought",
            "our", "ours", "ourselves", "out", "over", "own", "same", "shan't", "she", "she'd", "she'll", "she's", "should",
            "shouldn't", "so", "some", "such", "than", "that", "that's", "the", "their", "theirs", "them", "themselves", "then",
            "there", "there's", "these", "they", "they'd", "they'll", "they're", "they've", "this", "those", "through", "to",
            "too", "under", "until", "up", "very", "was", "wasn't", "we", "we'd", "we'll", "we're", "we've", "were",
            "weren't", "what", "what's", "when", "when's", "where", "where's", "which", "while", "who", "who's", "whom", "why",
            "why's", "with", "won't", "would", "wouldn't", "you", "you'd", "you'll", "you're", "you've", "your", "yours",
            "yourself", "yourselves"
        };

        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);
        Scanner scanWord = new Scanner(br);

        String word;

        while (scanWord.hasNext()) {
            word = scanWord.next();

            boolean isStopWord = false;

            for (String stopw : stopWords) {
                if (stopw.equals(word)) {
                    isStopWord = true;
                    break;
                }
            } if (!isStopWord) {
                    word = word.replaceAll("\\p{Punct}", " ");
                    word = word.toLowerCase();
                    formattedWords.addAll(Arrays.asList(word.split("\\s+")));
            }      
        }
        System.out.println(formattedWords.size());
        scanWord.close();
        fr.close();
    }
}
