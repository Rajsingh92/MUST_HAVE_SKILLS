//  Design HashMap  | Adobe, Amazon, Apple, Microsoft |

public class Main {

    public static class HashMap < K, V > {
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList < HMNode > [] buckets; // N = buckets.length

        public HashMap() {
            initbuckets(4);
            size = 0;
        }

        public void put(K key, V value) throws Exception {
            int bi = hashFunction(key);
            int di = findInBucket(bi, key);

            if (di == -1) {
                HMNode node = new HMNode(key, value);
                buckets[bi].addLast(node);
                size++;
            } else {
                HMNode node = buckets[bi].get(di);
                node.value = value;
            }

            double lambda = size * 1.0 / buckets.length;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public V get(K key) throws Exception {
            int bi = hashFunction(key);
            int di = findInBucket(bi, key);

            if (di == -1) {
                return null;
            } else {
                HMNode node = buckets[bi].get(di);
                return node.value;
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = findInBucket(bi, key);

            if (di == -1) {
                return false;
            } else {
                return true;
            }
        }

        public V remove(K key) throws Exception {
            int bi = hashFunction(key);
            int di = findInBucket(bi, key);

            if (di == -1) {
                return null;
            } else {
                HMNode node = buckets[bi].remove(di);
                size--;
                return node.value;
            }
        }

        public ArrayList < K > keyset() throws Exception {
            ArrayList < K > set = new ArrayList < > ();

            for (int bi = 0; bi < buckets.length; bi++) {
                for (HMNode node: buckets[bi]) {
                    set.add(node.key);
                }
            }

            return set;
        }

        public int size() {
            return size;
        }

        public void display() {
            System.out.println("Display Begins");
            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket" + bi + " ");
                for (HMNode node: buckets[bi]) {
                    System.out.print(node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }
        // returns bucket index for a key
        private int hashFunction(K key) {
            int hc = key.hashCode();
            int bi = Math.abs(hc) % buckets.length;
            return bi;
        }

        // return data index for a bucket and key
        private int findInBucket(int bi, K key) {
            int di = 0;
            for (HMNode node: buckets[bi]) {
                if (node.key.equals(key)) {
                    return di;
                }
                di++;
            }

            return -1;
        }

        // when lambda crosses a threshold
        private void rehash() throws Exception {
            LinkedList < HMNode > [] oba = buckets;
            initbuckets(2 * oba.length);
            size = 0;

            for (int bi = 0; bi < oba.length; bi++) {
                for (HMNode onode: oba[bi]) {
                    put(onode.key, onode.value);
                }
            }
        }

        private void initbuckets(int N) {
            buckets = new LinkedList[N];
            for (int bi = 0; bi < buckets.length; bi++) {
                buckets[bi] = new LinkedList < > ();
            }
        }
    }
}