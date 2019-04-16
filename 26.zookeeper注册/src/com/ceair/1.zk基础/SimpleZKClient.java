package com.ceair.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;


import java.io.IOException;
import java.util.List;

public class SimpleZKClient {
    private static final String connectString="spark1:2181,spark2:2181,spark3:2181";
    private static final int sessionTimeout=2000;
    static ZooKeeper zkClient =null;


    public static void init() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                //收到事件通知后的回调函数（应该是我们自己的事件处理逻辑）
                System.out.println(event.getType()+"---"+event.getPath());
                try {
                    zkClient.getChildren("/",true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 数据的增删改查
     * 非常底层的方法，zk也用这个方法
     */
    //创建数据节点到zk中
    public static void testCreate() throws KeeperException, InterruptedException {
        //参数1，要创建的节点的路径;参数2.节点的数据;参数3，节点的权限;参数4，点的类型
        String nodeCreated = zkClient.create("/eclip", "hellozk".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
         //上传的数据可以使任何类型，但是都要转成byte[]
   }

    //获取子节点
    public  static void getChildren() throws KeeperException, InterruptedException {
        List<String> childrens = zkClient.getChildren("/", true);
        for (String child:childrens){
            System.out.println("获得的子节点"+child);
        }
        Thread.sleep(30000);
    }

    //判断znode是否存在
    public void testExist() throws KeeperException, InterruptedException {
        Stat status = zkClient.exists("/eclipse", false);
        System.out.println(status==null?"not exist":"exist");
    }
    //获取znode的数据
    public static void getData() throws Exception {
        byte[] data = zkClient.getData("/eclips", false, new Stat());
        //获取到的数据可以使任何类型
        System.out.println(new String(data,"utf-8"));
    }

    //删除znode
    public static void deleteZnode() throws KeeperException, InterruptedException {
        //参数2指定要删除的版本，-1表示删除所有版本
        zkClient.delete("/eclipse",-1);

    }
    //修改数据
    public static void setData() throws Exception {
        zkClient.setData("/app1","imissou a".getBytes(),-1);
    }
    public static void main(String[] args) throws Exception {
        init();
        testCreate();
        //getChildren();
    }
}
