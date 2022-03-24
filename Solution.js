
/**
 * @param {string} input
 * @return {number[]}
 */
var partitionLabels = function (input) {
    
    const sizeAlphabet = 26;
    const ascii_a = 97;
    const sizeInput = input.length;

    const indexLastOccurence = new Array(sizeAlphabet).fill(0);
    for (let i = 0; i < sizeInput; i++) {
        indexLastOccurence[input.codePointAt(i) - ascii_a] = i;
    }

    const sizePartitionedLabels = [];
    let start = 0, end = 0;

    for (let i = 0; i < sizeInput; i++) {
        end = Math.max(end, indexLastOccurence[input.codePointAt(i) - ascii_a]);
        if (end === i) {
            sizePartitionedLabels.push(end - start + 1);
            start = i + 1;
        }
    }
    return sizePartitionedLabels;
};
