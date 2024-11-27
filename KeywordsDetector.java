public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
                "Our product will transform the market",
                "Programming is both painful and engaging",
                "This has nothing to do with machine learning",
                "We need to leverage our core competencies",
                "Let's talk about data and algorithms",
                "Chatbots are great but must be used carefully",
                "This blockchain-based solution will disrupt the industry",
                "The team showed great Synergy in the last project",
                "Use simple words without hype and fluff",
                "Our new technology presents a significant paradigm shift",
                "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        for (int i = 0; i < sentences.length; i++) {
            String[] words = sentenceToWords(sentences[i]);

            for (int j = 0; j < words.length; j++) {
                String word = words[j].toLowerCase();

                for (int k = 0; k < keywords.length; k++) {
                    if (word.equals(keywords[k].toLowerCase())) {

                        System.out.println(sentences[i]);
                    }
                }
            }
        }
    }

    private static String[] sentenceToWords(String sentence) {
        int spaceCounter = 0;

        for (int c = 0; c < sentence.length(); c++) {
            if (sentence.charAt(c) == ' ') {
                spaceCounter++;
            }
        }

        String[] words = new String[spaceCounter + 1];
        int wordIndex = 0;

        while (sentence.contains(" ")) {
            int spaceIndex = sentence.indexOf(" ");
            words[wordIndex++] = sentence.substring(0, spaceIndex); // Get word before the first space
            sentence = sentence.substring(spaceIndex + 1); // Remove the processed word
        }

        words[wordIndex] = sentence;
        return words;
    }
}


