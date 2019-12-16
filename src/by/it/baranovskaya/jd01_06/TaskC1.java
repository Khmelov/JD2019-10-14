package by.it.baranovskaya.jd01_06;


    public class TaskC1 {

        public static void main(String[] args) {
            String[] line = Poem.text.split("\n");
            int maximum = lengthMax(line);
            isEqualLength(line, maximum);
        }

        private static int lengthMax(String[] line) {
            int max = line[0].length();
            for (String s : line) {
                if (max < s.length()) {
                    max = s.length();
                }
            }
            return max;
        }

        private static void isEqualLength(String[] line, int maximum) {
            for (int i = 0; i < line.length; i++) {
                if (line[i].length() < maximum) {
                    int count = maximum - line[i].length();
                    String[] words = line[i].split("[ ]");

                    for (int j = 0; j < words.length - 1; j++) {
                        words[j] = words[j].concat(" ");
                    }

                    int k = 0;

                    do {
                        for (int j = 0; j < words.length - 1; j++) {
                            words[j] = words[j].concat(" ");
                            k++;
                            if(k==count) break;
                        }
                    } while (k!=count);

                    line[i] = "";

                    for (String word : words) {
                        line[i] = line[i].concat(word);
                    }
                    System.out.println(line[i]);
                } else System.out.println(line[i]);
            }
        }
    }