package com.xiao;

import org.apache.tomcat.util.net.NioBlockingSelector;
import sun.nio.ch.DirectBuffer;
import sun.nio.ch.WindowsSelectorProvider;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author xiaojw
 * @describe NioServer
 * @date 2021/4/22 17:04
 */
public class NioServer {
    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress(9000));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector,SelectionKey.OP_ACCEPT);
        while(true){
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            if(iterator.hasNext()){
                SelectionKey key = iterator.next();
                if(SelectionKey.OP_ACCEPT == key.interestOps()){
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel socket = channel.accept();
                    socket.configureBlocking(false);
                    socket.register(selector,SelectionKey.OP_READ);
                    System.out.println("注册成功，开始监听");
                    iterator.remove();
                }else if(key.isReadable()){
                    SocketChannel socket = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    StringBuffer stringBuffer = new StringBuffer();
                    if(socket.read(buffer)!=-1){
                        buffer.flip();
                        stringBuffer.append(new String(buffer.array()));
                    }
                    System.out.println("服务端接收到数据："+stringBuffer.toString());
                    socket.register(selector,SelectionKey.OP_WRITE);

                    iterator.remove();
                }
                else if(key.isWritable()){
                    SocketChannel socket = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    StringBuffer stringBuffer = new StringBuffer();
                    if(socket.read(buffer)!=-1){
                        buffer.flip();
                        stringBuffer.append(new String(buffer.array()));
                    }
                    socket.write(ByteBuffer.wrap(stringBuffer.toString().getBytes()));
                    socket.register(selector,SelectionKey.OP_READ);
                    iterator.remove();
                }
                
            }
        }
    }

}
