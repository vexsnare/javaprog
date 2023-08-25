package utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author vinay.saini
 * @created 15/07/2020 - 4:47 PM
 */
@Data
@AllArgsConstructor
public class Pair<T1, T2> {
    public T1 first;
    public T2 second;
}