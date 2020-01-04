import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-07-17 21:29
 * @desc:
 */
public class BufferTest {


    /**
     * position 下一次开始写的起始位置
     * limit 读取的数据长度
     * capacity 容量
     */
    @Test
    public void testBuffer(){

        String str ="abcde";
        ByteBuffer byteBuffer =ByteBuffer.allocate(1024);

        System.out.println("-----allocate-----");
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());

        System.out.println("-----put-----");

        //写入
        byteBuffer.put(str.getBytes());

        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.position());//5
        System.out.println(byteBuffer.limit());

        System.out.println("-----flip-----");

        //读取
        byteBuffer.flip();

        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.position());//0
        System.out.println(byteBuffer.limit());//5


        System.out.println("-----get-----");


        byte []dest =new byte[byteBuffer.limit()];
        byteBuffer.get(dest);
        System.out.println(new String(dest,0,dest.length));

        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.position());//5
        System.out.println(byteBuffer.limit());//5


        System.out.println("-----rewind-----");

        //可重复读
        byteBuffer.rewind();


        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.position());//0
        System.out.println(byteBuffer.limit());//5



        System.out.println("-----clear-----");

        //清空缓冲区，但缓冲区的数据还在，只是被"遗忘"
        byteBuffer.clear();


        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.position());//0
        System.out.println(byteBuffer.limit());//5
        System.out.println((char)byteBuffer.get());//a

    }




}
