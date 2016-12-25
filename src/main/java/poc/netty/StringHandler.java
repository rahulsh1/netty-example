package poc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * String based handler. Not used in this example.
 */
public class StringHandler extends SimpleChannelInboundHandler<String> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String message) throws Exception {
    System.out.println("In here" + message);
  }
}