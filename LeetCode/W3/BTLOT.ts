// Binary Tree Level Order Traversal
// Given the root of a binary tree, 
// return the level order traversal of its nodes' values. (i.e., from left to right, level by level).


//  Definition for a binary tree node.
 class TreeNode {
      val: number
      left: TreeNode | null
      right: TreeNode | null
      constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
           this.left = (left===undefined ? null : left)
          this.right = (right===undefined ? null : right)
      }
  }

function levelOrder(root: TreeNode | null): number[][] {

  const result: number[][] = [];

  if (!root) {
    return result;
  }
  
  let queue: TreeNode[] = [root];

  while(queue.length) {
    
    let currentLevel: number[] = [];
    const levelSize: number = queue.length;

    for (let i=0; i<levelSize; i++) {

      const node = queue.shift();
      currentLevel.push(node.val);

      if (node.left){
        queue.push(node.left);
      };

      if (node.right) {
        queue.push(node.right);
      };

    }
    
    result.push(currentLevel)
  }

  return result;
};


// Faster solution:

function levelOrder(root: TreeNode | null): number[][] {

  const result: number[][] = [];

  if (!root) {
    return result;
  }
  
  let queue: TreeNode[] = [root];
  let front = 0;
  let end = queue.length;

  while(front < end) {
    
    let currentLevel: number[] = [];
    const levelSize: number = end - front;

    for (let i=0; i<levelSize; i++) {

      const node = queue[front];
      front++;
      currentLevel.push(node.val);

      if (node.left){
        queue.push(node.left);
        end++;
      };

      if (node.right) {
        queue.push(node.right);
        end++;
      };
    }
    
    result.push(currentLevel)
  }

  return result;
};