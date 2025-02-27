package org.tuc.linearhashing;

import org.tuc.interfaces.SearchInsert;
import org.tuc.utils.*;


public class LinearHashing implements SearchInsert
{

	private HashBucket[] hashBuckets;	// pointer to the hash buckets

	private float maxThreshold;		// max load factor threshold
	private float minThreshold;		// min load factor threshold

	private int bucketSize;		// max number of keys in each bucket
	private int keysNum;			// number of keys currently stored in the table
	private int keySpace;			// total space the hash table has for keys
	private int p;				// pointer to the next bucket to be split
	private int n;				// current number of buckets
	private int j;				// the n used for the hash function
	private int minBuckets;			// minimum number of buckets this hash table can have

	private int hashFunction(int key){	// Returns a hash based on the key

		int retval;

		retval = key%this.j;
		if (retval < 0)
			retval *= -1;
		if (retval >= p){
		  return retval;
		}
		else {
			 retval = key%(2*this.j);
			 if (retval < 0)
				 retval *= -1;
	         return retval;
		}
	}

	private float loadFactor() {		// Returns the current load factor of the hash table.

		return ((float)this.keysNum)/((float)this.keySpace);
	}

	private void bucketSplit() {		// Splits the bucket pointed by p.

		int i;
		HashBucket[] newHashBuckets;

		newHashBuckets= new HashBucket[n+1];
		for (i = 0; i < this.n; i++){
		   newHashBuckets[i] = this.hashBuckets[i];
		}

		hashBuckets = newHashBuckets;
		hashBuckets[this.n] = new HashBucket(this.bucketSize);
		this.keySpace += this.bucketSize;
		this.hashBuckets[this.p].splitBucket(this, 2*this.j, this.p, hashBuckets[this.n]);
		this.n++;
		if (this.n == 2*this.j) {
		  this.j = 2*this.j;
		  this.p = 0;
		}
		else {
		    this.p++;
		}
	}

	private void bucketMerge() { 		// Merges the last bucket that was split

		int i;

		HashBucket[] newHashBuckets;
		newHashBuckets= new HashBucket[n-1];
		for (i = 0; i < this.n-1; i++) {
		   newHashBuckets[i] = this.hashBuckets[i];
		}
		if (this.p == 0) {
		  this.j = (this.n)/2;
		  this.p = this.j-1;
		}
		else {
		  this.p--;
		}
		this.n--;
		this.keySpace -= this.bucketSize;
		this.hashBuckets[this.p].mergeBucket(this, hashBuckets[this.n]);
		hashBuckets = newHashBuckets;
	}

	public LinearHashing(int itsBucketSize, int initPages) { 	// Constructor.

		int i;

		bucketSize = itsBucketSize;
		keysNum = 0;
		p = 0;
		n = initPages;
		j = initPages;
		minBuckets = initPages;
		keySpace = n*bucketSize;
		maxThreshold = (float)0.8;
		minThreshold = (float)0.7;

		if ((bucketSize == 0) || (n == 0)) {
		  System.out.println("error: space for the table cannot be 0");
		  System.exit(1);
		}
		hashBuckets = new HashBucket[n];
		for (i = 0; i < n; i++) {
		   hashBuckets[i] = new HashBucket(bucketSize);
	}
}

	public int getBucketSize() {return bucketSize;}
	public int getKeysNum() {return keysNum;}
	public int getKeySpace() {return keySpace;}
	public void setBucketSize(int size) {bucketSize = size;}
	public void setKeysNum(int num) {keysNum = num;}
	public void setKeySpace(int space) {keySpace = space;}

	public void insert(int key) {	// Insert a new key.

		this.hashBuckets[this.hashFunction(key)].insertKey(key, this);
		if (this.loadFactor() > maxThreshold){
		  this.bucketSplit();
		}
	}

	public void delete(int key) {	// Delete a key.

		this.hashBuckets[this.hashFunction(key)].deleteKey(key, this);
		if (this.loadFactor() > maxThreshold){
		  this.bucketSplit();
		}
		else if ((this.loadFactor() < minThreshold) && (this.n > this.minBuckets)){
			 this.bucketMerge();
		}
	}
	

	
	public boolean search(int key) {		// Search for a key.

		return this.hashBuckets[this.hashFunction(key)].searchKey(key, this);
	}

	public void printHash() {

		int i;

		for (i = 0; i < this.n; i++) {
		   System.out.println("Bucket[" + i + "]");
		   this.hashBuckets[i].printBucket(this.bucketSize);
		}
	}

	@Override
	public boolean searchKey(int key) {
		// TODO Auto-generated method stub
		return search(key);
	}



} // LinearHashing class

