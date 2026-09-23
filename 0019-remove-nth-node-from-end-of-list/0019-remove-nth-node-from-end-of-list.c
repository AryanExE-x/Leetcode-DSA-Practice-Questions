/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    struct ListNode* dummy = malloc(sizeof(struct ListNode));
    dummy->next = head;

    struct ListNode* fast = dummy;
    struct ListNode* slow = dummy;

    // Move fast k steps
    for (int i = 1; i <= n; i++)
    {
        fast = fast->next;
    }

    // Move both until fast.next reaches NULL
    while (fast->next!= NULL)
    {
        fast = fast->next;
        slow = slow->next;
    }

    // slow->next is the node to delete
    struct ListNode* temp = slow->next;

    slow->next = temp->next;

    free(temp);

    head = dummy->next;
    free(dummy);

    return head;
}