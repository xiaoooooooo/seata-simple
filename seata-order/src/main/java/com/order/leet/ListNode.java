package com.order.leet;

import lombok.Builder;
import lombok.Data;

/**
 * @author xiaojw
 * @describe ListNode
 * @date 2021/1/26 17:49
 */
@Data
@Builder
public class ListNode {
    int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
