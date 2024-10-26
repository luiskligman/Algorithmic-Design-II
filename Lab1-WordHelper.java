public class WordHelper {
	public static String[] sortByVowels(String[] words) {

		// Establishing a copy of initial array
		String[] vowelSorted = new String[words.length];

		// Cloning the data to new array
		for (int i = 0; i < words.length; i++) {
			vowelSorted[i] = words[i];
		}

		// Adding weight based on each vowel
		int[] weight = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			// Dummy code I can use to hard check my values

			for (int j = 0; j < words[i].length(); j++) {
				char character = words[i].charAt(j);
				if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u'
						|| character == 'y') {
					weight[i] += 1;
				}
			}
		}

		// Now that weight[i] holds a weighted value we need to order the words by # of vowels
		boolean hasSwapped = true;

		while (hasSwapped == true) {
			hasSwapped = false;
			for (int i = 0; i < words.length - 1; i++) {
				if (weight[i] > weight[i + 1]) {
					// Swap String
					String tempWord = vowelSorted[i + 1];
					vowelSorted[i + 1] = vowelSorted[i];
					vowelSorted[i] = tempWord;

					// Swap Weight
					int tempWeight = weight[i + 1];
					weight[i + 1] = weight[i];
					weight[i] = tempWeight;

					hasSwapped = true;
				}

			}
		}
		return vowelSorted;
	}

	public static String[] sortByConsonants(String[] words) {
		// Establishing a copy of initial array
		String[] conSorted = new String[words.length];

		// Cloning the data to new array
		for (int i = 0; i < words.length; i++) {
			conSorted[i] = words[i];
		}

		// Adding weight based on number of total letter - number of vowels = num of consonants
		int[] weight = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			int[] numOfCon = new int[words.length];
			numOfCon[i] = words[i].length();
			for (int j = 0; j < words[i].length(); j++) {
				char character = words[i].charAt(j);

				if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u'
						|| character == 'y') {
					numOfCon[i] -= 1;

				}
			}
			weight[i] = numOfCon[i];
		}
		// Now that weight[i] holds a weighted value we need to order the words by # of consonants
		boolean hasSwapped = true;

		while (hasSwapped == true) {
			hasSwapped = false;
			for (int i = 0; i < words.length - 1; i++) {
				if (weight[i] > weight[i + 1]) {
					// Swap String
					String tempWord = conSorted[i + 1];
					conSorted[i + 1] = conSorted[i];
					conSorted[i] = tempWord;

					// Swap Weight
					int tempWeight = weight[i + 1];
					weight[i + 1] = weight[i];
					weight[i] = tempWeight;

					hasSwapped = true;
				}

			}
		}
		return conSorted;
	}

	public static String[] sortByLength(String[] words) {
		// Establishing a copy of intial array
		String[] lengthSorted = new String[words.length];

		// Cloning the Data to lengthSorted[]
		for (int i = 0; i < words.length; i++) {
			lengthSorted[i] = words[i];
		}

		// Adding a weight to each word based on number of characters
		int[] weight = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			String wordLength = lengthSorted[i];
			weight[i] = wordLength.length(); // Weight is the number of chars in each word
		}
		
		// Now that weight[i] holds a weighted value we need to order the words by # of chars
		boolean hasSwapped = true;

		while (hasSwapped == true) {
			hasSwapped = false;
			for (int i = 0; i < words.length - 1; i++) {
				if (weight[i] > weight[i + 1]) {
					// Swap String
					String tempWord = lengthSorted[i + 1];
					lengthSorted[i + 1] = lengthSorted[i];
					lengthSorted[i] = tempWord;

					// Swap Weight
					int tempWeight = weight[i + 1];
					weight[i + 1] = weight[i];
					weight[i] = tempWeight;

					hasSwapped = true;
				}
			}
		}
		return lengthSorted;
	}
}
