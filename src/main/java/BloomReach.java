/**
 * @author author_name (vinay.saini@thoughtspot.com)
 */

import java.awt.image.DataBuffer;
import java.lang.ref.Reference;
import java.util.BitSet;

/**
 * class Chunk {
 *       int offset;
 *       int length;
 *       boolean is_last_chunk;
 *       Reference data;
 * }
 * // There is any API from which you can request these chunks
 * // You receive unordered chunks, with overlaps as well
 * // Write a method to construct final block of data.
 * // Note : You can slice data for a given chunks using offset
 */

class Chunk {
      int offset;
      int length;
      boolean is_last_chunk;
      Reference data;
}
