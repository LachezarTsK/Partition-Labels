
#include <array>
#include <vector>
using namespace std;

class Solution {
    
public:

    vector<int> partitionLabels(string input) {

        const char ascii_a = 97;
        const size_t sizeAlphabet = 26;
        const size_t sizeInput = input.length();

        array<int, sizeAlphabet> indexLastOccurence{};
        for (int i = 0; i < sizeInput; i++) {
            indexLastOccurence[input[i] - ascii_a] = i;
        }

        vector<int> sizePartitionedLabels{};
        int start = 0, end = 0;

        for (int i = 0; i < sizeInput; i++) {
            end = max(end, indexLastOccurence[input[i] - ascii_a]);
            if (end == i) {
                sizePartitionedLabels.push_back(end - start + 1);
                start = i + 1;
            }
        }
        return sizePartitionedLabels;
    }
};
