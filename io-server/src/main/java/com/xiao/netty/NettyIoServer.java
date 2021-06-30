package com.xiao.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.nio.channels.ServerSocketChannel;

/**
 * @author xiaojw
 * @describe netty
 * @date 2021/4/23 14:31
 */
public class NettyIoServer
{

    private void run(int port) throws InterruptedException {
        NioEventLoopGroup  boss = new NioEventLoopGroup();
        NioEventLoopGroup  worker = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();
        b.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ch.pipeline()
                                .addLast(new FixedLengthFrameDecoder(10))
                                .addLast(new StringDecoder())
                                .addLast(new DiscardServerHandler());
                    }
                }).option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true);
        ChannelFuture f = b.bind(port).sync();
        System.out.println("ServerBootstrap配置启动完成");
        f.channel().closeFuture().sync();
    }

    public static void main(String[] args) throws InterruptedException {
        NettyIoServer server = new NettyIoServer();
        server.run(9004);
    }
}
