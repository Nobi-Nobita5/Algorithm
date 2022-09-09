package algorithm.LeetCode;

class Trie_208_前缀树 {
    class TreeNode{
        TreeNode[] next;
        boolean flag;
        public TreeNode(){
            next = new TreeNode[26];//构造函数以自身的类的对象数组实例化成员变量，那么
            flag = false;
        }
    }
    private TreeNode root;
    /** Initialize your data structure here. */
    public Trie_208_前缀树() {
        root = new TreeNode();//那么在这里每创建一个TreeNode对象，会生成一个TreeNode节点，和一个指向TreeNode数组的指针
                            // 数组中的元素为空，和一个flag
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode cur = this.root;
        for(char c:word.toCharArray()){
            if(cur.next[c-'a']==null){
                cur.next[c-'a'] = new TreeNode();
            }
            cur = cur.next[c-'a'];
        }
        cur.flag = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode cur = this.root;
        for(char c:word.toCharArray()){
            if(cur.next[c-'a']==null){
                return false;
            }
            cur = cur.next[c-'a'];
        }
        return cur.flag;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode cur = this.root;
        for(char c:prefix.toCharArray()){
            if(cur.next[c-'a']==null){
                return false;
            }
            cur = cur.next[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
