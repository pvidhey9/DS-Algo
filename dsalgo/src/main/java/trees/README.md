## Trees
A non linear data structure unlike arrays or linked lists. More of a hierarchical structure,
to depict the relation between different components/parts.
Example : File system of a computer
- Trees with ordering provide you a slightly better access/search
- Trees provide moderate insertion/deletion - faster than arrays but slower than linked lists
- Binary Tree is a variation of Tree that has only two children at most. 
  1. Maximum number of nodes at level 'L' of a BTree is 2^L
  2.  Maximum number of nodes in a binary tree of height H is 2^(H+1) - 1
  
## Traversals
### Breadth First Search
- Also called level order traversal, coz you are touching the entire breadth of the tree for every step
- For level order traversal of a tree, use a queue, coz you wanna remember the last few node you visited!

### Depth First Search
- Depth because you go deep into the tree and then come back up again
- Inorder Traversal (Left - Root - Right)
- Preorder Traversal (Root - Left - Right)
- Postorder Traversal (Left - Right - Root)

- All traversals take O(n) time as they visit each node exactly once!
- However, level order traversal uses some extra space in the form of queue.
  - O(w) is SpaceCompl, where w is maximum width.
  - Maximum width can be 2^h  
- While depth order traversal uses a stack internally for the method calls.
  - O(h) is SpaceComp, where h is the height of the tree
  - Height of Balanced binary tree is Log n, while for a skewed tree its n
