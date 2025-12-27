package io.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.TimeUnit;

public class AIOServerDemo {
    public static void main(String[] args) throws Exception {
        // 打开异步服务器通道
        AsynchronousServerSocketChannel serverChannel =
                AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(8080));

        System.out.println("AIO server started on port 8080...");

        // 接收客户端连接（异步，回调处理）
        serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel client, Object attachment) {
                System.out.println("Client connected: " + client);

                // 继续接收下一个客户端
                serverChannel.accept(null, this);

                // 分配缓冲区
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                // 读取客户端数据（异步，回调处理）
                client.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer bytesRead, ByteBuffer buf) {
                        buf.flip();
                        String msg = new String(buf.array(), 0, buf.limit());
                        System.out.println("Received from client: " + msg);

                        // 回写数据
//                        buf.rewind();
                        String toClient="[Server: ] I have receive your msg"+msg+", thanks so much.";
                        ByteBuffer writeBuffer = ByteBuffer.wrap(toClient.getBytes());
                        client.write(writeBuffer, null, new CompletionHandler<Integer,Object>() {
                            @Override
                            public void completed(Integer result, Object attachment) {
                                System.out.println("Echoed back to client.");
                            }

                            @Override
                            public void failed(Throwable exc, Object attachment) {
                                System.out.println("Write failed: " + exc.getMessage());
                            }
                        });
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        System.out.println("Read failed: " + exc.getMessage());
                    }
                });
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("Accept failed: " + exc.getMessage());
            }
        });

        // 主线程可以做其他事情
        while (true) {
            try {
                System.out.println("Server main thread is free to do other work...");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
