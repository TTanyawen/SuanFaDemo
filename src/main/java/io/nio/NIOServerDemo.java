package io.nio;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServerDemo {
    public static void main(String[] args) throws IOException {
        //打开ServerSocketChannel
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new java.net.InetSocketAddress(8080));
        serverChannel.configureBlocking(false);//非阻塞模式

        //打开Selector(用来监听多个通道的事件)
        Selector selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);//注册可以接受新连接事件
        while (true) {
            selector.select();//阻塞等待“可以接受新连接”发生
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();//待处理事件
                keyIterator.remove();//从it移除本轮要处理的这个事件
                if (key.isAcceptable()) { //client连接事件
                    SocketChannel client=serverChannel.accept();//尝试连接，没有连接就返回null
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);//注册可读事件，seletor会监听这个连接的可读事件
                }else if(key.isReadable()){
                    SocketChannel client=(SocketChannel)key.channel();
                    ByteBuffer buffer=ByteBuffer.allocate(1024);
                    int bytesRead=client.read(buffer);
                    if(bytesRead==-1){//EOF
                        client.close();
                        System.out.println("读完了，关闭client连接");
                    }else{
                        buffer.flip();
                        String msg=new String(buffer.array(),0,buffer.limit());
                        System.out.println("收到来自client的消息："+msg);

                        //回写client
                        buffer.rewind();
                        client.write(buffer);
                    }
                }
            }
        }
    }
}
