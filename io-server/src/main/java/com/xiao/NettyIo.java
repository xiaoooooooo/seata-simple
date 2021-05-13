package com.xiao;

import io.netty.channel.DefaultSelectStrategyFactory;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SelectStrategyFactory;
import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.boot.web.embedded.netty.NettyWebServer;

/**
 * @author xiaojw
 * @describe netty
 * @date 2021/4/23 14:31
 */
public class NettyIo
{
    public static void main(String[] args) {
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();

    }
}
