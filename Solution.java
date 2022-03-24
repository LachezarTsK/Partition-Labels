
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> partitionLabels(String input) {

        final int sizeAlphabet = 26;
        final int ascii_a = 97;
        final int sizeInput = input.length();

        int[] indexLastOccurence = new int[sizeAlphabet];
        for (int i = 0; i < sizeInput; i++) {
            indexLastOccurence[input.charAt(i) - ascii_a] = i;
        }

        List<Integer> sizePartitionedLabels = new ArrayList<>();
        int start = 0, end = 0;

        for (int i = 0; i < sizeInput; i++) {
            end = Math.max(end, indexLastOccurence[input.charAt(i) - ascii_a]);
            if (end == i) {
                sizePartitionedLabels.add(end - start + 1);
                start = i + 1;
            }
        }
        return sizePartitionedLabels;
    }
}
