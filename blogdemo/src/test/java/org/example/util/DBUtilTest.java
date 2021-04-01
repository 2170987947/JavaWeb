package org.example.util;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/30 12:38
 */
public class DBUtilTest {
    @Test
    public void testGetConnection() {
        Connection connection = DBUtil.getConnection();
        Assert.assertNotNull(connection);
    }
}
