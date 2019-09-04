Problem:

>Given a graph without any loop, find the max score for a path.

The X in the graph means the barrier so the graph should be taken as separate parts.

Need to find the one path with the max gain of scores.


>1  X  X  1

>4  X  7  X

>X  5  6  5

>X  9  X  4


The max gain in this graph is 29, either is 9->5->6->5->4 or reversed.