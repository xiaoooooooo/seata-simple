package com.order.leet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaojw
 * @describe Node
 * @date 2021/1/28 16:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Node<V> {
    private V val;
    private Node pre;
    private Node next;
}
