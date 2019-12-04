package by.it.zabauniuk.jd01_06;

public class TaskC1 {
    public static void main(String[] args) {
        String[] lines = createArray();
        int maxLength = findLongerLine(lines);
        linesAdderSpaces(maxLength, lines);
    }

    private static void linesAdderSpaces(int maxLength, String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            if (maxLength > lines[i].length()) {
                int addTo = maxLength - lines[i].length();
                String[] words = lines[i].split(" ");
                for (int i1 = 0; i1 < words.length - 1; i1++) {
                    words[i1] = words[i1].concat(" ");
                }

                int counter = 0;

                do{
                    for (int i1 = 0; i1 < words.length-1; i1++) {
                        words[i1] = words[i1].concat(" ");
                        counter++;
                        if (counter==addTo) break;

                    }
                }while (counter!=addTo);

                lines[i]="";
                for (String word : words) {
                    lines[i] = lines[i].concat(word);
                }
                System.out.println(lines[i]);
            }else System.out.println(lines[i]);


        }
    }

    private static int findLongerLine(String[] lines) {
        int max = lines[0].length();
        for (String line : lines) {
            if (line.length() > max) {
                max = line.length();
            }
        }
        return max;
    }

    private static String[] createArray() {
        return Poem.text.split("[\\n]");
    }

}
