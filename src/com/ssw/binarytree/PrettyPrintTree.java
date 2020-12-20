package src.com.ssw.binarytree;

/**
 * 较为直观的打印一颗树，方便构造其结构
 */
public class PrettyPrintTree {
    class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    public void printTree(Node head) {
        System.out.println("开始打印tree");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    /**
     * @param head   头节点
     * @param height 一个二叉树逆时针90度 从左到右打印为向上的高度
     * @param to     插入的特殊字符
     * @param len    打印的每行长度
     */
    public void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();//32位节点的值
        int lenL = (len - lenM) / 2;//左面需要补全空格的长度
        int lenR = len - lenM - lenL;//右面需要补全空格的长度
        val = getSpace(lenL) + val + getSpace(lenR); //生成17位长度的打印统一规范
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "M", len);
    }


    //补齐空格
    public String getSpace(int num) {
        String space = " ";
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < num; i++) {
            buffer.append(space);
        }
        return buffer.toString();
    }

}
