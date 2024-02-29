public class RNAToProtein {

    public static String convertRNAToProtein(String rnaSequence) {
        StringBuilder proteinSequence = new StringBuilder();

        for (int i = 0; i < rnaSequence.length(); i += 3) {

            if (i + 3 <= rnaSequence.length()) {
                String codon = rnaSequence.substring(i, i + 3);
                String aminoAcid = getAminoAcid(codon);

                if (aminoAcid != null) {
                    proteinSequence.append(aminoAcid);
                } else {
                    // Handle invalid codons if needed
                    System.out.println("Invalid codon: " + codon);
                }
            } else {
                proteinSequence.append(".");
                break;
            }
        }

        return proteinSequence.toString();
    }

    private static String getAminoAcid(String codon) {

        switch (codon) {
            case "UUU":
            case "UUC":
                return "F";
            case "UUA":
            case "UUG":
            case "CUU":
            case "CUC":
            case "CUA":
            case "CUG":
                return "L";
            case "AUU":
            case "AUC":
            case "AUA":
                return "I";
            case "AUG":
                return "M";
            case "GUU":
            case "GUC":
            case "GUA":
            case "GUG":
                return "V";
            case "UCU":
            case "UCC":
            case "UCA":
            case "UCG":
            case "AGU":
            case "AGC":
                return "S";
            case "CCU":
            case "CCC":
            case "CCA":
            case "CCG":
                return "P";
            case "ACU":
            case "ACC":
            case "ACA":
            case "ACG":
                return "T";
            case "GCU":
            case "GCC":
            case "GCA":
            case "GCG":
                return "A";
            case "UAU":
            case "UAC":
                return "Y";
            case "UAA":
            case "UAG":
            case "UGA":
                return ".";
            case "CAU":
            case "CAC":
                return "H";
            case "CAA":
            case "CAG":
                return "Q";
            case "AAU":
            case "AAC":
                return "N";
            case "AAA":
            case "AAG":
                return "K";
            case "GAU":
            case "GAC":
                return "D";
            case "GAA":
            case "GAG":
                return "E";
            case "UGU":
            case "UGC":
                return "C";
            case "UGG":
                return "W";
            case "CGU":
            case "CGC":
            case "CGA":
            case "CGG":
            case "AGA":
            case "AGG":
                return "R";
            case "GGU":
            case "GGC":
            case "GGA":
            case "GGG":
                return "G";
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        String rnaSequence = "AGCUGGGAAACGUAGGCCUA";
        String rnaSequence2 = "UAAAGAGAAGCCAGC";

        String proteinSequence = convertRNAToProtein(rnaSequence);
        String proteinSequence2 = convertRNAToProtein(rnaSequence2);

        System.out.println("RNA Sequence: " + rnaSequence);
        System.out.println("Protein Sequence: " + proteinSequence);

        // note about RNA sequence 2 - the output on the assignment sheet is incorrect
        //it should be .REAS
        System.out.println("RNA Sequence: " + rnaSequence2);
        System.out.println("Protein Sequence: " + proteinSequence2);
    }
}
