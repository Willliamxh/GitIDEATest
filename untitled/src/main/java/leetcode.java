import java.util.HashMap;
import java.util.Map;

/**
 * @Author 江晟
 * @Description TODO
 * @Date 2021/7/19 16:31
 * @Version 1.0
 */
public class leetcode {
}

/**
 * 定义节点
 */
class Node{
    int key,value;
    Node next,pre;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * 定义双向链表
 */
class DoubleList{
    Node head;
    Node tail;

    public DoubleList() {
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.pre=head;
    }
    //头插
    public void addFirst(Node n){
        n.next=head.next;
        head.next=n;
        n.next.pre=n;
        n.pre=head;
    }

    //删除特定节点 入参就是通过hashmap找到的节点
    public void remove(Node n){
        Node nPre=n.pre;
        Node nNext=n.next;
        nPre.next=n.next;
        nNext.pre=nPre;

    }
    //尾删 这边必须返回对应的节点给hashmap删除用
    public Node removeLast(){
        Node last=tail.pre;
        remove(last);
        return last;
    }

}
class LRUCache {

    int capacity;//容量
    // key -> Node(key, val) 用于映射双向链表中的节点
    Map<Integer, Node> map;
    // node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;


    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<Integer, Node>(capacity);
        cache=new DoubleList();
    }

    public int get(int key) {
        //没找到
        if(!map.containsKey(key)){
            return -1;
        }
        Node res=map.get(key);
        //得到对应的值
        int val=res.value;
        //然后需要将这个node提前
        cache.remove(res);
        cache.addFirst(res);
        return val;
    }

    public void put(int key, int value) {
        Node n=new Node(key,value);
        //如果map中存在着这个key 那就更新这个key
        if(map.containsKey(key)){
            cache.remove(map.get(key));
        }else if(map.size()==capacity){//节点不存在 但是map已经满了
            Node node=cache.removeLast();
            map.remove(node.key);
        }
        //更新链表信息
        cache.addFirst(n);
        //增加hashmap的映射
        map.put(key,n);
    }

}

//
//class LRUCache_2 {
//    class Node {
//        int k, v;
//        Node l, r;
//        Node(int _k, int _v) {
//            k = _k;
//            v = _v;
//        }
//    }
//    int n;
//    Node head, tail;
//    Map<Integer, Node> map;
//    public LRUCache_2(int capacity) {
//        n = capacity;
//        map = new HashMap<Integer, Node>();
//        head = new Node(-1, -1);
//        tail = new Node(-1, -1);
//        head.r = tail;
//        tail.l = head;
//    }
//
//    public int get(int key) {
//        if (map.containsKey(key)) {
//            Node node = map.get(key);
//            refresh(node);
//            return node.v;
//        }
//        return -1;
//    }
//
//    public void put(int key, int value) {
//        Node node = null;
//        if (map.containsKey(key)) {
//            node = map.get(key);
//            node.v = value;
//        } else {
//            if (map.size() == n) {
//                Node del = tail.l;
//                map.remove(del.k);
//                delete(del);
//            }
//            node = new Node(key, value);
//            map.put(key, node);
//        }
//        refresh(node);
//    }
//
//    // refresh 操作分两步：
//    // 1. 先将当前节点从双向链表中删除（如果该节点本身存在于双向链表中的话）
//    // 2. 将当前节点添加到双向链表头部
//    void refresh(Node node) {
//        delete(node);
//        node.r = head.r;
//        node.l = head;
//        head.r.l = node;
//        head.r = node;
//    }
//
//    // delete 操作：将当前节点从双向链表中移除
//    // 由于我们预先建立 head 和 tail 两位哨兵，因此如果 node.l 不为空，则代表了 node 本身存在于双向链表（不是新节点）
//    void delete(Node node) {
//        if (node.l != null) {
//            Node left = node.l;
//            left.r = node.r;
//            node.r.l = left;
//        }
//    }
//}

