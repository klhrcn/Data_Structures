KBestCounter: A Java implementation of a streaming top-k tracker. The KBestCounter class keeps track of the k largest elements seen so far from an input stream of data items. The total number of incoming items is unknown and may be unbounded.

Features
* Generic class supporting any type T that implements Comparable
* Maintains only the top k elements at any time
* Efficient updates using a min-heap (PriorityQueue)
* Does not modify internal state when retrieving results
