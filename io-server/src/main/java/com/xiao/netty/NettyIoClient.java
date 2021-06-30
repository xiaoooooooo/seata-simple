package com.xiao.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author xiaojw
 * @describe NettyIoClient
 * @date 2021/6/15 17:18
 */
public class NettyIoClient {
    private void run() throws InterruptedException {
        NioEventLoopGroup worker = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(worker)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_KEEPALIVE,false)
                .handler(new ChannelInitializer<>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ch.pipeline().addLast(new FixedLengthFrameDecoder(10))
                                .addLast(new StringDecoder())
                                .addLast(new DiscardClientHandler());
                    }
                });
        ChannelFuture f = b.connect("127.0.0.1", 9004).sync();
        System.out.println("Bootstrap配置启动完成");
        f.channel().closeFuture().sync();
    }

    public static void main(String[] args) throws InterruptedException {
        NettyIoClient client = new NettyIoClient();
        client.run();
    }
}
