package utils;

import lombok.AllArgsConstructor;

/**
 * @author vinay.saini
 * @created 13/07/2020 - 3:45 PM
 */

@AllArgsConstructor
public class Range {

    public int index1;
    public int index2;

    public Range getFirstHalf() {
        int mid = ( index1 + index2 ) / 2;
        return new Range(index1, mid);
    }

    public Range getSecondtHalf() {
        int mid = ( index1 + index2 ) / 2;
        return new Range(mid + 1, index2);
    }

    public boolean equals(Range range) {
        return this.index1 == range.index1 && this.index2 == range.index2;
    }

    public boolean spill(Range range) {
        // Inside
        if(this.index1 <= range.index1 && range.index2 <= this.index2) return false;
        if(this.index1 > range.index2 || range.index1 > this.index2) return false;
        return true;
    }

    public boolean overlap(Range range) {
        if(range.index2 < this.index1 || range.index1 > this.index2) return false;
        return true;
    }

    public boolean contains(int index) {
        if(this.index1 <= index && this.index2 >= index ) return true;
        return false;
    }

    public int getLength() {
        return index2 - index1 + 1;
    }
}
