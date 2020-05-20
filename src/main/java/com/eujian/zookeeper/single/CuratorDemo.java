package com.eujian.zookeeper.single;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorDemo {

    static String host = "192.168.2.128:2181,192.168.2.129:2181,192.168.2.130:2181";
    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(host,
                5000, 5000,
                new ExponentialBackoffRetry(1000,3));
        curatorFramework.start();

        curatorFramework.setData().forPath("/demo", "麦克雷3".getBytes());
    }
}
