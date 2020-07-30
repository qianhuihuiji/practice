package Geektime.JavaInterview.Episode11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * java Interview episode 11 {@link @https://time.geekbang.org/column/article/8369}
 *
 * @author nofirst
 * @date 2020-07-30 16:44
 */
public class DemoServer extends Thread{
    private ServerSocket serverSocket;
    public int getPort() {
        return  serverSocket.getLocalPort();
    }

    public void run() {
        try {
            // 服务器端启动 ServerSocket，端口 0 表示自动绑定一个空闲端口
            serverSocket = new ServerSocket(0);
//            while (true) {
//                // 调用 accept 方法，阻塞等待客户端连接
//                Socket socket = serverSocket.accept();
//
//                // 当连接建立后，启动一个单独线程负责回复客户端请求
//                RequestHandler requestHandler = new RequestHandler(socket);
//                requestHandler.start();
//            }

            // 线程池技术进行优化
            ExecutorService executor = Executors.newFixedThreadPool(8);
            while (true) {
                Socket socket = serverSocket.accept();
                RequestHandler requestHandler = new RequestHandler(socket);

                executor.execute(requestHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        DemoServer server = new DemoServer();
        server.start();

        // 利用 Socket 模拟了一个简单的客户端，只进行连接、读取、打印
        try (Socket client = new Socket(InetAddress.getLocalHost(), server.getPort())) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));

            bufferedReader.lines().forEach(s -> System.out.println(s));
        }
    }
}


