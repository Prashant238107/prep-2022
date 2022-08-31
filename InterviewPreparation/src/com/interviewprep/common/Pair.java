package com.interviewprep.common;

import java.util.Comparator;

public class Pair implements Comparator<Pair>, Comparable<Pair> {
    public int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair pair) {
        return this.first > pair.first ? 0 : -1;
    }

    @Override
    public int compare(Pair pair1, Pair pair2) {
        return pair1.first > pair2.first ? 0 : -1;
    }
}
