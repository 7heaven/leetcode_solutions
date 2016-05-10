package com.sevenheaven.leetcode.associate;

import java.util.List;

/**
 * Created by 7heaven on 16/5/10.
 */
public interface NestedInteger {
    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();
}