package autumn.pinduoduo;

public class P0301 {
    int kvsearch1(int[] kvs, int key) {
        int len = 1;
        for (int i = 0; i < kvs.length; i += len) {
            if (kvs[i] == key) {
                return i;
            } else if (kvs[i] > key) {
                break;
            } else {
                len++;
            }
        }
        return -1;
    }
    int kvsearch2(int[] kvs, int key) {
        int len = getKeyLength(kvs);
        int sKey = 1, mKey = len/2, eKey = len-1;
        while (sKey < eKey) {
            int index = keyIndex(mKey);
            if (kvs[index] == key) {
                return index;
            } else if (kvs[index] < key) {
                sKey = mKey;
            } else {
                eKey = mKey;
            }
            mKey = (sKey+eKey)/2;
        }
        return -1;
    }
    int getKeyLength(int[] kvs) {
        return 0;
    }
    int keyIndex(int key) {
        // 1:0 2:2 3:5 4:9
        return 0;
    }
}