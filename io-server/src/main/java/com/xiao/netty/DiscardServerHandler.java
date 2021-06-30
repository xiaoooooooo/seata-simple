package com.xiao.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.time.ZonedDateTime;

/**
 * @author xiaojw
 * @describe DiscardServer
 * @date 2021/6/11 17:04
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("disCard server handler is ready");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("sever receive msg:" + msg);
        if("QUERY TIME ORDER".equals(msg)){
        ctx.writeAndFlush(ZonedDateTime.now() + System.lineSeparator());
        }else{
        ctx.writeAndFlush("BAD ORDER");
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server channelReadComplete");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
