package structe_data.eleven_hash_table;

/**
 * Created by taowei on 2017/7/23.
 * 2017-07-23 12:55
 * Algorithm
 * structe_data.eleven_hash_table
 */

public class HashTableX {
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;
    public HashTableX(int size){
        arraySize = size;
        hashArray = new DataItem[size];
        nonItem = new DataItem(-1);
    }
    //hash函数
    public int hashFunc(int key){
        return key % arraySize;
    }

    public void insert(DataItem item){
        int key = item.getKey();
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null &&
                hashArray[hashVal].getKey() != -1){
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public DataItem delete(int key){
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null){
            if(hashArray[hashVal].getKey() == key){
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key){
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null){
            if(hashArray[hashVal].getKey() == key){
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }
}
