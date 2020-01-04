import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import org.junit.Test;

import javax.imageio.stream.FileCacheImageInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-07-19 10:33
 * @desc:
 */
public class ChannelTest {


    @Test
    public void test()throws Exception {


        FileInputStream inputStream =new FileInputStream("1.jpg");
        FileOutputStream outputStream =new FileOutputStream("2.jpg");

       FileChannel inputStreamChannel= inputStream.getChannel();
       FileChannel outputStreamChannel= outputStream.getChannel();


        ByteBuffer byteBuffer =ByteBuffer.allocate(1024);


       while(inputStreamChannel.read(byteBuffer)!=-1){

           byteBuffer.flip();



           outputStreamChannel.write(byteBuffer);

           byteBuffer.clear();

       }
        System.out.println("写入完成");




    }

}
