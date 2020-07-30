package Geektime.JavaInterview.Episode11;

import java.io.PrintWriter;
import java.net.Socket;

/**
 * RequestHandler
 *
 * @author nofirst
 * @date 2020-07-30 17:28
 */
public class RequestHandler extends Thread {
    private Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream())) {
            out.println("hello world");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
