package bull.algorithm.line;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.*;

/**
 * 关键点：双向链表、Map -->主题还是双线链表的：
 * （1）优先级更新操作：删除某一节点(头部<无需处理></>；中部；尾部)；将该节点插入头部；
 * （2）满了之后尾结点删除
 */

public class LRUCache {
    Map<Integer, Node> cache;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int key = random.nextInt(200);
            int value = random.nextInt(200);
            out.println("set key: " + key);
            cache.debug("start ");
            cache.set(key, value);
            cache.debug("end ");
            out.println("set key end ####### ");
        }
        cache.cache.keySet().forEach(key -> {
            out.println("get key: " + key);
            cache.debug("start ");
            out.println("value " + cache.get(key));
            cache.debug("end ");
        });
    }

    public Integer get(int key) {
        if (Objects.isNull(cache.get(key))) {
            return null;
        }
        Node node = cache.get(key);
        update(node);
        return cache.get(key).value;

    }

    public void debug(String mark) {
        Node debug = head;
        List<Integer> keys = new ArrayList<>();
        while (Objects.nonNull(debug)) {
            keys.add(debug.key);
            debug = debug.post;
        }
        out.println(mark + " size: " + keys.size() + "; keys = " + keys.stream().map(String::valueOf)
                .collect(Collectors.joining(",")));
    }

    public void set(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        Node node = cache.get(key);
        // 插入
        if (Objects.isNull(node)) {
            node = new Node();
            node.key = key;
            node.value = value;
            node.prev = null;
            node.post = null;
            add(node);
        } else { //更新
            node.value = value;
            update(node);
        }
    }

    private void add(Node node) {
        if (cache.size() == capacity) {
            removeTail();
        }
        cache.put(node.key, node);
        if (Objects.isNull(head)) {
            head = node;
            tail = node;
        } else {
            node.post = head;
            head.prev = node;
            head = node;
            head.prev = null;
        }
    }

    private void update(Node node) {
        if (head.key.equals(node.key)) {
            return;
        }
        Node prev = node.prev;
        Node post = node.post;
        // 头节点
        if (Objects.isNull(prev)) {
            // 不处理
        }
        // 中间节点
        if (Objects.nonNull(prev)
                && Objects.nonNull(post)) {
            //删除
            prev.post = post;
            post.prev = prev;
            //插入头部
            node.post = head;
            head.prev = node;
            head = node;
            node.prev = null;
        }
        // 尾节点(非头节点)
        if (Objects.nonNull(prev)
                && Objects.isNull(post)) {
            //删除
            prev.post = null;
            tail = prev;
            //插入头部
            node.post = head;
            head.prev = node;
            head = node;
            node.prev = null;
        }
    }

    private void removeTail() {
        cache.remove(tail.key);
        Node prev = tail.prev;
        if (Objects.nonNull(prev)) {
            prev.post = null;
            tail = prev;
        } else {
            head = null;
            tail = null;
        }
    }

    class Node {
        private Integer key;
        private Integer value;
        private Node prev;
        private Node post;
    }
}