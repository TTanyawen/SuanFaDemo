package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClientDemo {
    public static void main(String[] args) throws IOException {
        //打开客户端SocketChannel并连接server
        SocketChannel client=SocketChannel.open(new InetSocketAddress("localhost",8080));
        client.configureBlocking(false);//非阻塞模式

        //发信息
        String message="hello i'm Angela";
        ByteBuffer buffer=ByteBuffer.wrap(message.getBytes());
        client.write(buffer);//非阻塞写入

        buffer.clear();
        int bytesRead;
        //等待server返回的信息
        while((bytesRead=client.read(buffer))<=0){//等待（看出来NIO也不是不阻塞，而是轮询查看数据是否有准备好）

        }
        buffer.flip();
        System.out.println("client收到："+new String(buffer.array(),0,buffer.limit()));
        client.close();
    }
}
