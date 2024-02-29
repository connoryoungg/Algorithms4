import java.util.LinkedList;
import java.util.Queue;

public class DNAToRNA {

    public static String convertDNAToRNA(String dnaSequence) {
        Queue<Character> queue = new LinkedList<>();
        String finalSequence = "";

        for (char nucleotide : dnaSequence.toCharArray()) {
            if (nucleotide == 'A') {
                queue.add('A');
            } else if (nucleotide == 'T') {
                queue.add('U');
            } else if (nucleotide == 'C') {
                queue.add('C');
            } else if (nucleotide == 'G') {
                queue.add('G');
            } else {
                // for invalid characters
                System.out.println("Invalid nucleotide: " + nucleotide);
            }
        }

        // create rna string
        while (!queue.isEmpty()) {
            finalSequence += queue.poll();
        }

        return finalSequence;
    }

    public static void main(String[] args) {
        String dnaSequence = "AGCTGGGAAACGTAGGCCTA";
        String dnaSequence2 = "TTTTTTTTTTGGCGCG";
        String dnaSequence3 = "CTTTGGGACTAGTAACCCATTTCGGCT";
        String rnaSequence = convertDNAToRNA(dnaSequence);
        String rnaSequence2 = convertDNAToRNA(dnaSequence2);
        String rnaSequence3 = convertDNAToRNA(dnaSequence3);

        System.out.println("DNA Sequence: " + dnaSequence);
        System.out.println("RNA Sequence: " + rnaSequence);

        System.out.println("DNA Sequence: " + dnaSequence2);
        System.out.println("RNA Sequence: " + rnaSequence2);

        System.out.println("DNA Sequence: " + dnaSequence3);
        System.out.println("RNA Sequence: " + rnaSequence3);
    }
}

