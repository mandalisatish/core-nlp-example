

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class SentimentAnalysis 
{

    public static void main(String[] args) {

        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

        //String text = "Hello this is John. I don`t like this place.";
        String text = "Hello this is John. I live in Hyderabad. I read comic books in young age." +
                "This book is not worth to read. I'm not at all satisfied." +
                "But I like only 11th chapter. It's interesting. Coming to last two " +
                "chapters it's bit confusing and not up to the mark. " +
                "This author wrote decent books in past days.";
        CoreDocument coreDocument = new CoreDocument(text);

        stanfordCoreNLP.annotate(coreDocument);

        List<CoreSentence> sentences = coreDocument.sentences();

        for(CoreSentence sentence : sentences) {

            String sentiment = sentence.sentiment();

            System.out.println("Sentiment Type: " + sentiment + ", Statement: "+ sentence);

        }
        //Output:
        //Sentiment Type: Neutral	, Statement: Hello this is John.
        //Sentiment Type: Neutral	, Statement: I don`t like this place.



    }

}
