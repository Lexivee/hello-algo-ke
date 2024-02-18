/**
 * File: preorder_traversal_i_compact.kt
 * Created Time: 2024-01-25
 * Author: curtishd (1023632660@qq.com)
 */

package chapter_backtracking

import utils.TreeNode
import utils.printTree

class preorder_traversal_i_compact {
    companion object {
        var res: MutableList<TreeNode>? = null

        /* 前序遍历：例题一 */
        fun preOrder(root: TreeNode?) {
            if (root == null) {
                return
            }
            if (root.value == 7) {
                // 记录解
                res!!.add(root)
            }
            preOrder(root.left)
            preOrder(root.right)
        }
    }
}

/* Driver Code */
fun main() {
    val root = TreeNode.listToTree(mutableListOf(1, 7, 3, 4, 5, 6, 7))
    println("\n初始化二叉树")
    printTree(root)

    // 前序遍历
    preorder_traversal_i_compact.res = ArrayList()
    preorder_traversal_i_compact.preOrder(root)

    println("\n输出所有值为 7 的节点")
    val vals: MutableList<Int> = ArrayList()
    for (node in preorder_traversal_i_compact.res as ArrayList<TreeNode>) {
        vals.add(node.value)
    }
    println(vals)
}