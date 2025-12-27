package io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.TimeUnit;

public class AIOClientDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();

        // 异步连接服务器
        client.connect(new InetSocketAddress("localhost", 8080), null, new CompletionHandler<Void, Void>() {
            @Override
            public void completed(Void result, Void attachment) {
                System.out.println("Connected to server.");

                String message = "Hello AIO Server!";
                ByteBuffer writeBuffer = ByteBuffer.wrap(message.getBytes());

                // 异步写
                client.write(writeBuffer, null, new CompletionHandler<Integer, Object>() {
                    @Override
                    public void completed(Integer bytesWritten, Object attachment) {
                        System.out.println("Message sent to server.");

                        // 写完后准备异步读取服务器回写的数据
                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                        client.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                            @Override
                            public void completed(Integer bytesRead, ByteBuffer buf) {
                                buf.flip();
                                String response = new String(buf.array(), 0, buf.limit());
                                System.out.println("Received from server: " + response);
                            }

                            @Override
                            public void failed(Throwable exc, ByteBuffer buf) {
                                System.out.println("Read failed: " + exc.getMessage());
                            }
                        });
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        System.out.println("Write failed: " + exc.getMessage());
                    }
                });
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                System.out.println("Connect failed: " + exc.getMessage());
            }
        });

        // 主线程可以做其他事情
        while (true) {
            try {
                System.out.println("Client main thread is free to do other work...");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
