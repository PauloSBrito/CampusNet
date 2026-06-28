from email import header
from sys import exception


class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
        self.previous = None
class DoublyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    #O(n) linear time
    def __repr__(self):
        if self.head is None:
            return "Linked list is empty"
        else:
            last = self.head

            return_str = f"[{last.value}"

            while last.next:
                last = last.next
                return_str += f", {last.value}"
            return_str += "]"

            return return_str

    # 0(n) linear time
    def __contains__(self, value):
        last = self.head
        while last is not None:
            if last.value == value:
                return True
            last = last.next
        return False

    #O (n) linear time
    def __len__(self):
        last = self.head
        count = 0
        while last is not None:
            count += 1
            last = last.next
        return count

    #O(n) linear time
    def append(self, value):
        if self.head is None:
            self.head = Node(value)
        else:
            last = self.head
            while last.next:
                last = last.next
            last.next = Node(value)

    #(1) constant time
    def prepend(self, value):
        first = Node(value)
        first.next = self.head
        self.head = first
    def insert(self, value, index):
        elem = Node(value)
        if index == 0:
            self.prepend(elem)
        else:
            if self.head.next is None:
                raise ValueError("Linked list is empty")
            else:
                last = self.head

                for i in range(index - 1):
                    if last.next is None:
                        raise ValueError("Index out of bounds")
                    last = last.next
                new = Node(value)
                new.next = last.next
                last.next = new
    # O(n) linear time
    def delete(self, value):
        last = self.head
        if last is not None:
            if last.value == value:
                self.head = last.next
            else:
                while last.next:
                    if last.next.value == value:
                        last.next = last.next.next
                        break
    # O(n) linear time
    def pop(self, index):
        if self.head is None:
            raise ValueError("Linked list is empty")
        else:
            last = self.head
            for i in range(index - 1):
                if last.next is None:
                    raise ValueError("Index out of bounds")
                last = last.next
            if last.next is None:
                raise ValueError("Index out of bounds")
            else:
                last.next = last.next.next

    # O (n) linear time
    def get(self, index):
        if self.head is None:
            raise ValueError("Linked list is empty")
        else:
            last = self.head
            for i in range(index -1):
                if last.next is None:
                    last = last.next
            return last.value

    def print_list(self):
        if self.head is None:
            print("Linked list is empty")
        else:
            last = self.head
            # Enquanto o nó atual não for nulo, continuamos o percurso
            while last is not None:
                # Imprime o valor do nó atual (equivalente ao imprimir(pont↑.info))
                print(f"[{last.value}]", end=" -> ")
                # Move para o próximo nó (equivalente ao pont := pont↑.prox)
                last = last.next
            print("None")  # Indica o fim da lista (λ)
if __name__ == "__main__":
    ll = LinkedList()

    ll.append(1)
    ll.append(2)
    ll.append(3)

    ll.prepend(4)
    print(ll)
    ll.insert(0, 2)
    ll.insert(0, 5)
    print(ll)
    ll.delete(4)
    print(ll)
    ll.pop(2)
    print(ll)