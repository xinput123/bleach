package com.xinput.bleach.util.bean;

import net.sf.cglib.beans.BeanMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Bean对象<==>Map
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-09-15 13:51
 */
public class BeanMapUtils {

    /**
     * 对象转Map
     *
     * @param object
     * @return
     */
    public static Map<String, Object> toMap(Object object) {
        Map<String, Object> map = new HashMap<>();
        if (object != null) {
            BeanMap.create(object).forEach(
                    (key, value) -> map.put(String.valueOf(key), value)
            );
        }
        return map;
    }

    /**
     * map转对象
     *
     * @param map
     * @param beanClass
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T toBean(Map map, Class<T> beanClass) {
        return BeanUtils.convertor(map, beanClass);
    }
}
