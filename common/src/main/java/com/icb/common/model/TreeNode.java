package com.icb.common.model;

import java.util.Collection;

public interface TreeNode<IdType, TreeType extends TreeNode> extends Comparable<TreeType> {

    IdType getPid();

    IdType getId();

    Collection<TreeType> getChildren();

    void setChildren(Collection<TreeType> children);

    default Integer getOrderNum() {
        return null;
    }

    default int compareTo(TreeType o) {
        if (o == null) {
            return -1;
        }

        Integer thisSortIndex = this.getOrderNum();
        Integer otherSortIndex = o.getOrderNum();

        if (thisSortIndex == null && otherSortIndex == null) {
            return 0;
        } else if (thisSortIndex == null) {
            return -1;
        } else if (otherSortIndex == null) {
            return 1;
        }

        return Integer.compare(thisSortIndex, otherSortIndex);
    }


}
