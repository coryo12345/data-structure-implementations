#include "linkedlist.h"
#include <stdlib.h>

typedef struct LinkedListNode
{
    void *value;
    LinkedListNode_T *next;
} LinkedListNode_T;

typedef struct LinkedList
{
    int length;
    LinkedListNode_T *head;
} LinkedList_T;

LinkedList_T *newLinkedList()
{
    LinkedList_T *list = (LinkedList_T *)malloc(sizeof(LinkedList_T));
    list->length = 0;
    list->head = NULL;
    return list;
}

LinkedList_T *newLinkedListFromArray(void *arr, int size);

void *get(LinkedList_T *list, int index);

void add(LinkedList_T *list, void *value);

void *remove(LinkedList_T *list, int index);

int size(LinkedList_T *list);

char *toString(LinkedList_T *list, char *(*formatter)(void *));