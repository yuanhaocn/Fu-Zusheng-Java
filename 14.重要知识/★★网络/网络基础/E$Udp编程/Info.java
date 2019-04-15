package E$Udp编程;
/**
 * UDP通信
 * 	基于UDP协议的通信方式，称为数据报通信方式
 * 		每个数据发送单元被统一封装成数据包的方式，发送方将数据包发送到网络中，数据包在网络中去寻找他的目的地
 * DatagramSocket:用于发送或者接受数据包
 * DatagramPacket:数据容器（封包）的作用
 * 基本步骤“
 * 		 1)、创建客户端的DatagramSocket，创建时，定义客户端的监听端口
 * 		 2)、创建服务器端的DatagramSocket，创建时，定义服务器端的监听端口
 * 		 3)、在服务器端定义DatagramPacket对象，封装待发送的数据包
 * 		 4)、服务器端将数据包发送出去
 * 		 5)、客户端接收数据包




 *UDP：以数据为中心   非面向连接  不安全 数据可能丢失  效率高
一、类 DatagramSocket DatagramPacket
1、客户端：
   1)、创建客户端   DatagramSocket  类  +指定端口
   2)、准备数据  字节数组
   3)、打包  DatagramPacket +服务器地址 及端口
   4)、发送
   5)、释放资源

2、服务器端：
   1)、创建 服务端  DatagramSocket  类  +指定端口
   2)、准备接受容器 字节数组  封装 DatagramPacket 
   3)、包 接受数据
   4)、分析
   5)、释放资源

 */

public class Info {}
