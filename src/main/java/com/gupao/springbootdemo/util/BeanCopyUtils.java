package com.gupao.springbootdemo.util;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * ClassName: BeanCopyUtils. <br/> Description: JavaBean属性拷贝工具类. <br/> Date: 2018-06-05. <br/>
 *
 * @author Chunjie He
 * @version 1.0.0
 * @since 1.7
 */
public class BeanCopyUtils {

    /**
     * 将对象属性拷贝到目标类型的同名属性字段中
     */
    public static <T> T copyProperties(Object source, Class<T> targetClazz) {
        if (source == null) {
            return null;
        }
        T target = null;
        try {
            target = targetClazz.newInstance();
            BeanUtils.copyProperties(source, target);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return target;
    }

    /**
     * 将对象属性拷贝到目标类型的同名属性字段中
     */
    public static <T> T copyProperties(Object source, T target) {
        if (source == null) {
            return null;
        }
        BeanUtils.copyProperties(source, target);
        return target;
    }


    /**
     * 云从大脑-将list的对象拷贝到目标类型对象中
     */
    public static <V, E> List<E> copy(Collection<V> list, Class<E> clazz) {
        List<E> result = new ArrayList<>(12);

        if (!CollectionUtils.isEmpty(list)) {
            for (V source : list) {
                E target = null;
                try {
                    target = (E) clazz.newInstance();
                    BeanUtils.copyProperties(source, target);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                result.add(target);
            }
        }

        return result;
    }
}
