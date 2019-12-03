package ru.krasnov;

public class BinarySearchTree<K extends Comparable, V> {

    private BTSNode root;

    public void put(K key, V value) {
        if (root == null)
            root = new BTSNode(key, value);
        else
            root.put(key, value);
    }

    public Object get(K key) {
        return root == null ? null : root.get(key);
    }


    private class BTSNode<K extends Comparable, V> {
        private K key;
        private V value;
        private BTSNode left, right;

        public BTSNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void put(K key, V value) {
            if (key.compareTo(this.key) < 0) {
                if (left == null)
                    left = new BTSNode(key, value);
                else
                    left.put(key, value);
            }
            else if (key.compareTo(this.key) >0) {
                if (right == null)
                    right = new BTSNode(key, value);
                else
                    right.put(key, value);
            }
            else {
                this.value = value;
            }

        }

        public Object get(K key) {
            if (this.key.equals(key))
                return value;

            if (key.compareTo(this.key) < 0)
                return left == null ? null : left.get(key);
            else
                return right == null ? null: right.get(key);
        }
    }
}
