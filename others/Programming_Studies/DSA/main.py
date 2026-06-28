from platform import node

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
def traversAndPrint(head):
    currentNode = head
    while currentNode:
        print(currentNode.data, end=" -> ")
        currentNode = currentNode.next
    print("null")

node1 = Node(1)
node2 = Node(2)
node3 = Node(3)
node4 = Node(4)
node5 = Node(5)

node.next = node2
node2.next = node3
node3.next = node4
node4.next = node5

traversAndPrint(node1)
traversAndPrint(node2)
traversAndPrint(node3)