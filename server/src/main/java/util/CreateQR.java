package util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class CreateQR {
    /**
     * 传入的是二维码要存储的信息
     * @param text
     * @param filePath
     * @throws WriterException
     * @throws IOException
     */
    public static void generateQRCodeImage(String text,String filePath)throws WriterException, IOException{
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE,200,200);
        /*
        下载到web根目录可以直接访问
         */
        Path path = FileSystems.getDefault().getPath("D:\\STUDY\\1Android\\QRA\\QR\\server\\src\\main\\webapp\\"+filePath);
        MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);
    }

    public static void main(String[] args) throws IOException, WriterException {
        generateQRCodeImage("what fuck!!!","nihao.png");
    }

}
