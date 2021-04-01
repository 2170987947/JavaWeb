package org.example.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/30 0:07
 */
public class JSONUtil {
    // 序列化与反序列化----> 1129 个人博客(1)

    private static final ObjectMapper MAPPER = new ObjectMapper();
    /**
     * JSON 序列化: 将 java 对象序列化为 json 字符串
     * @param o java 对象
     * @return json 字符串
     */
    // java 对象序列化为 JSON 对象
    public static String serialize(Object o) {
        try {
            return MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("json 序列化失败");
        }
    }

    /**
     * 反序列化操作: 将输入流 / 字符串发序列化为 java 对象
     * @param is 输入流
     * @param clazz 制定要反序列化的类型
     * @param <T>
     * @return 反序列化的对象
     */
    public static <T> T deserialize(InputStream is, Class<T> clazz) {
        try {
            return MAPPER.readValue(is, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("json 反序列化失败" + clazz.getName());
        }
    }
}
