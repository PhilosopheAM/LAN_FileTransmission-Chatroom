package FileTransmission;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;
 
public class Send {
    public static void main(String[] args) {
        File filesrc;       //需要传送的文件
        Socket socket;  //套接字
        FileInputStream open;   //读取文件
        FileOutputStream out;   //传送文件
        Scanner sc;//键盘录入
        Date start;
        Date end;
 
        try {
            System.out.println("[欢迎使用局域网发送系统,仅支持单文件发送]");
            System.out.print("请输入你要发送的文件路径!");
            System.out.println("(注意格式:文件路径+后缀名!)");
            //需要传输的文件
            sc = new Scanner(System.in);
            String src = sc.nextLine();
 
            filesrc = new File(src);//键盘录入需要传输的文件路径
            open = new FileInputStream(filesrc);//创建文件输入流
            //连接服务器
            System.out.println("请输入服务器的ip地址");
            sc = new Scanner(System.in);
            String url = sc.nextLine();
 
//            System.out.println("请输入服务器的端口号");
//            sc = new Scanner(System.in);
//            int port = sc.nextInt();
 
            socket = new Socket(url, 2017);//创建socket
 
            out = (FileOutputStream)socket.getOutputStream();//创建文件输出流
 
            //开始传送
            byte[] b = new byte[1024];
            int n = open.read(b);//首次传送
 
//            int start = (int)System.currentTimeMillis();
            start = new Date();//首次时间
            while (n != -1) {
                out.write(b, 0, n);
 
                n = open.read(b);
            }
//            int end = (int)System.currentTimeMillis();
            end = new Date();
            long l = Send.printSplitTime(start, end);
            SimpleDateFormat formatter =  new SimpleDateFormat("HH:mm:ss");
            formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
            String hms = formatter.format(l);
 
            System.out.println( "发送成功,耗时：" + hms);
            System.out.println("谢谢使用");
            //关闭流
            out.close();
            socket.close();
            open.close();
        } catch (Exception e) {
            System.out.println("文件路径或者ip有误");
        }
    }
    public static long printSplitTime(Date start, Date end) {
        long interval = (end.getTime() - start.getTime());
        //System.out.println("接口耗时：" + interval + "毫秒");
        return interval;
    }
}