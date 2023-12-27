#ifndef LINKED_LIST_H_
#define LINKED_LIST_H_

typedef struct LinkedList LinkedList_T;

LinkedList_T *newLinkedList();

LinkedList_T *newLinkedListFromArray(void *arr, int size);

void *get(LinkedList_T *list, int index);

void add(LinkedList_T *list, void *value);

void *remove(LinkedList_T *list, int index);

int size(LinkedList_T *list);

char *toString(LinkedList_T *list, char *(*formatter)(void *));

#endif
