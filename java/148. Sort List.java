/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return sortAndMerge(head); 
    }

    // 분할정복 시작
    private ListNode sortAndMerge(ListNode head) {
        if (head != null && head.next != null) { // 지금 head 가 마지막인지 파악을 위함. 분할과정의 마지막이면 걍 사용하면 된다.
            ListNode end = findMid(head); // 중간값 구해서
            ListNode start2 = end.next; // 중간값 다음부터 구하는 분할을 찾고
            end.next = null; // 이전 분할에서(중간값 이전까지 찾는것) 뒤에를 찾지 못하게 연결 끊기
            
            ListNode leftMerge = sortAndMerge(head); // 앞에 분할정복 시작
            ListNode rightMerge = sortAndMerge(start2); // 뒤에 분할정복 시작

            return merge(leftMerge, rightMerge); // 머지하는 부분
        }

        return head;
    }

    private ListNode merge(ListNode start, ListNode end) {
        // 비교대상 없으면 있는거 넣어주기
        if(start == null) return end; 
        if(end == null) return start;

        // 최초의 더미노드, 이거 다음부터가 진짜 답이다.
        ListNode dumy = new ListNode(-1);
        ListNode curr = dumy; // 뒤에 while 부터 next 가 생길것이다. 그 next 부터가 실질 답이 된다고 보면 됨.

        while(start != null && end != null) {
            if(start.val <= end.val) { // 정렬 적용. 왼쪽이 더 작으면 그걸 넣어주고 갱신하면 되낟.
                curr.next = start;
                start = start.next;
            } else {
                curr.next = end;
                end = end.next;
            }
            curr = curr.next; // 갱신된 그 값을 넣어주고 다음꺼를 구해주기 위해 shift
        }

        // 하나씩 구해주는거라 앞의 while이 끝나면 하나가 남는다.
        if(start != null) curr.next = start;
        else if(end != null) curr.next = end;

        return dumy.next;
    }

    private ListNode findMid(ListNode head) {
        // 한칸씩 가는거, 두칸씩 가는거 하나씩 두고 두칸씩 가는게 마지막에 도달하면 한칸씩 가는게 중간값이 된다.
        if (head == null) {
            return null;
        }
        ListNode oneStep = head;
        ListNode twoStep = head;

        while(twoStep.next != null && twoStep.next.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }

        return oneStep;
    }
}
