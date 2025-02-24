package com.eric.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2025-02-24 19:54
 * @since jdk-11.0.14
 */
public class OrderedStream
{
    private final String[] arr;
    private int idx;

    public OrderedStream(int n)
    {
        arr = new String[n + 1];
        idx = 1;
    }

    public List<String> insert(int idKey, String value)
    {
        arr[idKey] = value;
        List<String> list = new ArrayList<>();
        while (idx < arr.length && arr[idx] != null)
        {
            list.add(arr[idx++]);
        }
        return list;
    }
}
