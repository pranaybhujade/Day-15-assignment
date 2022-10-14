package com.bridgelabz;

public class MyHashmap<K,V> {
    public static final int numOfBuckets=5;
    public static final int numOfBuckets=10;
    LinkedList<K,V>[] myBucketArray;

    public MyHashmap() {
        this.myBucketArray = new LinkedList[numOfBuckets];
        for (int i = 0; i < numOfBuckets ; i++) {
            myBucketArray[i]=new LinkedList<>();
        }
    }
    public void put(K key, V value){
        MyMapNode<K,V> myMapNode= new MyMapNode<>(key, value);
        int index=getIndex(myMapNode.getKey());
        if (myBucketArray[index]==null) {
            myBucketArray[index]= new LinkedList<>();
            myBucketArray[index].append((MyMapNode<K, V>) myMapNode);
        }else {
            MyMapNode myMapNode1= myBucketArray[index].search(key);
            if (myMapNode1 != null){
                myMapNode1.setValue( (V) (Integer)( (int)myMapNode1.getValue() + 1 ) );
            }else {
                myBucketArray[index].append((MyMapNode<K, V>) myMapNode);
            }
        }
    }
    public int getIndex(Object obj){
        int hashCode=Math.abs(obj.hashCode())%numOfBuckets;
        return hashCode;
    }
    public void print(){
        for (LinkedList linkedList: myBucketArray) {
            linkedList.print();
        }
    }

    public static void main(String[] args) {
        MyHashmap<String,Integer> myHashmap=new MyHashmap<>();
        String sentence="To be or not to be";
        String sentence="Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        String[] wordArray=sentence.split(" ");
        for (String word : wordArray) {
            myHashmap.put(word, 1);
        }
        myHashmap.print();
    }
}
