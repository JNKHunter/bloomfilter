## What is a bloom filter?

A bloom filter is a probabilistic data structure that is useful for collecting a massive set of data and then later determining
if a specific piece of data is a member of the set.

A Java Set (java.util.Set) is the usual and obvious choice for this type of data structure. So why would a bloom filter
be needed? Bloom filters are extremely memory efficient. Where a java.util.Set can take up 200MB and more to store say
1 million UUID's in memory, a bloom filter may use only 1MB to store the elements.
 
The trade-off is that a bloom filter will have false positives when querying a bloom filter for membership of a specific
piece of data. This sounds really bad at first, but can be extremely useful when absolute precision is not needed. For
instance in a web analytics application running Hadoop, you may need to quickly determine if a url has been visited
in between Map Reduce jobs. You can use a bloom filter to keep a running tally of recently visited URLs in memory, and
interrogate the bloom filter for membership of the URL exactly at the time it was visited.

There are lots of great libraries out there that provide bloom filters (Google's guava being one of them). The
implementation here is very naive, and will be improved over time.

For a great introduction to bloom filters:
https://www.youtube.com/watch?v=qBTdukbzc78