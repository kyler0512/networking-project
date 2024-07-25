import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private ServerSocket socketServer = null;
    private Socket socket = null;
    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private PrintWriter printWriter = null;
    private BufferedReader bufferedReader = null;

    public void startServer(int port) {
        try {
            socketServer = new ServerSocket(port);
            System.out.println("Waiting response from Client...");
            socket = socketServer.accept();
            System.out.println("Successfully Connected.");
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            printWriter = new PrintWriter(new OutputStreamWriter(outputStream), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendListFile() {
        List<String> fileNameList = new ArrayList<>();
        fileNameList.add("abc.txt");
        fileNameList.add("test.txt");
        printWriter.println(fileNameList);
    }



    public void closeServer() {
        try {
            socketServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
