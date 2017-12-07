package gupta.speechtag;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String inputedStrings[] = new String[5];
		ArrayList<String> outputTags = new ArrayList<>();
		//POS Tagger
		MaxentTagger tagger = new MaxentTagger("taggers/english-left3words-distsim.tagger");
		System.out.println("Enter the first word.");
		inputedStrings[0] = reader.readLine();
		System.out.println("Enter the second word.");
		inputedStrings[1] = reader.readLine();
		System.out.println("Enter the third word.");
		inputedStrings[2] = reader.readLine();
		System.out.println("Enter the fourth word");
		inputedStrings[3] = reader.readLine();
		System.out.println("Enter the fifth word");
		inputedStrings[4] = reader.readLine();
		String taggedInputtedStrings[] = new String[5];
		for (int i = 0; i < inputedStrings.length; i++) {
			String stringToAdd = tagger.tagString(inputedStrings[i]);
			//System.out.println(stringToAdd);
			taggedInputtedStrings[i] = stringToAdd;
			stringToAdd = stringToAdd.substring(stringToAdd.indexOf("_"));
			//System.out.println(stringToAdd);
			outputTags.add(stringToAdd);
		}
		//System.out.println(outputTags);
		String diffWord = "";
		Set<String> printed = new HashSet<>();
		for (String s : outputTags) {
			
			if (printed.add(s)) {
				int freq1 = Collections.frequency(outputTags, s);
				/*System.out.println(freq1);
				System.out.println(s);*/
				if (freq1 == 1) {
					for (int i = 0; i < inputedStrings.length; i++) {
						if (taggedInputtedStrings[i].contains(s)) {
							diffWord = inputedStrings[i];
						}
					}
				}
				else {
					diffWord="NONE";
				}
			}
		}
		System.out.println(diffWord);

	}

}
