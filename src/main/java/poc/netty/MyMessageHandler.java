package poc.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Handles fragmented data (more > 1024 bytes) and assembles them in one packet on Client disconnect.
 */
public class MyMessageHandler extends ByteToMessageDecoder {

  protected void decode(final ChannelHandlerContext ctx, final ByteBuf in, final List<Object> list)
    throws Exception {
    System.out.println("decode: Got bytes: " + in.readableBytes() + " ctx:" + ctx.channel().id().asShortText());
  }

  public void decodeLast(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
    final int numBytes = in.readableBytes();
    final String data = in.toString(io.netty.util.CharsetUtil.US_ASCII);
    System.out.println("Read total bytes: " + numBytes + " ctx:" + ctx.channel().id().asShortText() + " " + data);
    out.add(in.readBytes(numBytes));
    // No need to release as this will be done on handlerRemoved()
  }

  public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
    System.out.println("channelUnregistered " + ctx.channel().id().asShortText());
  }
}
