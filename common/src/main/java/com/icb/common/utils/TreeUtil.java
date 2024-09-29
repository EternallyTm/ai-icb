package com.icb.common.utils;

import com.icb.common.model.TreeNode;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;
import java.util.function.Predicate;

/**
 * @Description: 树工具类
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午9:21 2023/7/10
 */
public class TreeUtil {

    /**
     * 构建树形结构的列表
     *
     * @param itemList 树节点列表
     * @param rootId   根节点ID
     * @param <IdType> ID 类型
     * @param <TreeType> 树节点类型
     * @return 根节点列表
     */
    public static <IdType, TreeType extends TreeNode<IdType, TreeType>> List<TreeType> buildTreeList(List<TreeType> itemList, IdType rootId) {
        if (CollectionUtils.isEmpty(itemList)) {
            return Collections.emptyList();
        }

        Map<IdType, TreeType> itemMap = new HashMap<>();
        List<TreeType> treeList = new SortedLinkedList<>();

        for (TreeType item : itemList) {
            itemMap.put(item.getId(), item);
        }

        for (TreeType item : itemList) {
            IdType parentId = item.getPid();
            if (parentId != null && parentId.equals(rootId)) {
                treeList.add(item);
            } else if (itemMap.containsKey(parentId)) {
                TreeType parent = itemMap.get(parentId);
                Collection<TreeType> children = parent.getChildren();
                if (children == null) {
                    children = new SortedLinkedList<>();
                    parent.setChildren(children);
                }
                children.add(item);
            }
        }
        itemMap.clear();
        return treeList;
    }

    /**
     * 构建树形结构的列表
     *
     * @param itemList 树节点列表
     * @param <IdType> ID 类型
     * @param <TreeType> 树节点类型
     * @return 根节点列表
     */
    public static <IdType, TreeType extends TreeNode<IdType, TreeType>> List<TreeType> buildTreeList(List<TreeType> itemList) {
        if (CollectionUtils.isEmpty(itemList)) {
            return Collections.emptyList();
        }
        Map<IdType, TreeType> itemMap = new HashMap<>();
        for (TreeType item : itemList) {
            itemMap.put(item.getId(), item);
        }
        itemList.removeIf(t -> {
            IdType pid = t.getPid();
            if (itemMap.containsKey(pid)) {
                TreeType parent = itemMap.get(pid);
                Collection<TreeType> children = parent.getChildren();
                if (children == null) {
                    children = new SortedLinkedList<>();
                    parent.setChildren(children);
                }
                children.add(t);
                return true;
            }
            return false;
        });
        itemMap.clear();
        return itemList;
    }

    /**
     * 构建带有根节点的树形结构
     *
     * @param list 树节点列表
     * @param root 根节点
     * @param <TreeType> 树节点类型
     * @return 带有根节点的树
     */
    public static <TreeType extends TreeNode> TreeType buildRootTree(List<TreeType> list, TreeType root) {
        root.setChildren(buildTreeList(list, root.getId()));
        return root;
    }

    /**
     * 过滤树形结构及其子节点
     *
     * @param treeCollection 树节点集合
     * @param predicate      过滤条件
     * @param <TreeType>     树节点类型
     */
    public static <TreeType extends TreeNode> void filterTreeIncludeChildren(Collection<TreeType> treeCollection, Predicate<TreeType> predicate) {
        if (CollectionUtils.isEmpty(treeCollection)) {
            return;
        }
        treeCollection.removeIf(r -> {
            if (predicate.test(r)) {
                return false;
            }
            Collection<TreeType> children = r.getChildren();
            filterTreeIncludeChildren(children, predicate);
            return CollectionUtils.isEmpty(children);
        });
    }

    /**
     * 将树形结构转换为列表形式
     *
     * @param tree 树节点列表
     * @param <TreeType> 树节点类型
     * @return 转换后的列表
     */
    public static <TreeType extends TreeNode> List<TreeType> treeTransList(List<TreeType> tree) {
        List<TreeType> result = new ArrayList<>();
        Stack<TreeType> executeCurStack = new Stack<>();
        for (TreeType item : tree) {
            result.add(item);
            if (CollectionUtils.isEmpty(item.getChildren())) {
                continue;
            }
            item.getChildren().forEach(child -> executeCurStack.push((TreeType) child));
            item.setChildren(null);
            while (!executeCurStack.isEmpty()) {
                if (!CollectionUtils.isEmpty(executeCurStack.peek().getChildren())) {
                    Collection<TreeType> children = executeCurStack.peek().getChildren();
                    executeCurStack.peek().setChildren(null);
                    children.forEach(child -> executeCurStack.push(child));
                    continue;
                }
                result.add(executeCurStack.pop());
            }
        }
        return result;
    }

    /**
     * 过滤树形结构
     *
     * @param treeCollection 树节点集合
     * @param predicate      过滤条件
     * @param <TreeType>     树节点类型
     */
    public static <TreeType extends TreeNode> void filterTree(Collection<TreeType> treeCollection, Predicate<TreeType> predicate) {
        if (CollectionUtils.isEmpty(treeCollection)) {
            return;
        }
        treeCollection.removeIf(r -> {
            Collection<TreeType> children = r.getChildren();
            filterTree(children, predicate);
            if (CollectionUtils.isEmpty(children)) {
                return false;
            }
            return !predicate.test(r);
        });
    }

    /**
     * 排序的链表
     *
     * @param <TreeType> 树节点类型
     */
    static class SortedLinkedList<TreeType extends TreeNode> extends LinkedList<TreeType> {

        @Override
        public boolean add(TreeType treeType) {
            if (size() == 0) {
                add(0, treeType);
                return true;
            } else {
                TreeType value = treeType;
                int x;
                for (x = size(); x > 0; x--) {
                    if (value.compareTo(get(x - 1)) > 0) {
                        break;
                    }
                }
                add(x, value);
                return true;
            }
        }
    }
}
