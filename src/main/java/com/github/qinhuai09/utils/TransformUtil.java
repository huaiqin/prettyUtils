package com.github.qinhuai09.utils;

import org.apache.commons.beanutils.PropertyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据转换工具类,可将bean的属性相互复制
 */
public class TransformUtil<T1, T2> {

    /**
     * 将source属性的值复制给target
     *
     * @param source
     * @param target
     * @param <T1>
     * @param <T2>
     */
    public static <T1, T2> void transform(T1 source, T2 target) {
        try {
            PropertyUtils.copyProperties(target, source);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量将sources属性的值复制给targets
     *
     * @param sources
     * @param <T1>
     * @param <T2>
     * @return
     */
    public static <T1, T2> List<T2> transforms(List<T1> sources, Class<T2> classObj) {
        List<T2> targets = new ArrayList<T2>();
        try {
            for (T1 source : sources) {
                T2 target = classObj.newInstance();
                transform(source, target);
                targets.add(target);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return targets;
    }

}
