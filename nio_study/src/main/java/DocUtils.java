import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-10-31 00:35
 * @desc:
 */
public class DocUtils {


        public static void main(String[] args)
        {
            try
            {
                String pdfFile = "/Users/wenxinliu/Documents/技术琐话/2B产品经理的自我修养.pdf";
                PDDocument doc = PDDocument.load(new File(pdfFile));
                int pagenumber = doc.getNumberOfPages();
                pdfFile = pdfFile.substring(0, pdfFile.lastIndexOf("."));
                String fileName = pdfFile + ".docx";
                File file = new File(fileName);
                if (!file.exists())
                {
                    file.createNewFile();
                }
                FileOutputStream fos = new FileOutputStream(fileName);
                Writer writer = new OutputStreamWriter(fos, "UTF-8");
                PDFTextStripper stripper = new PDFTextStripper();
                stripper.setSortByPosition(true);// 排序
                stripper.setStartPage(1);// 设置转换的开始页
                stripper.setEndPage(pagenumber);// 设置转换的结束页
                stripper.writeText(doc, writer);
                writer.close();
                doc.close();
                System.out.println("pdf转换word成功！");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
}
