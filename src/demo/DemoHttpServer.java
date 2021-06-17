package demo;


import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class DemoHttpServer {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8500), 0);
        {
        	HttpContext context = server.createContext("/");
        	context.setHandler(DemoHttpServer::handleRequest);
        }
        {
        	HttpContext context = server.createContext("/foo");
        	context.setHandler(DemoHttpServer::handleRequestFoo);
        }
        {
        	HttpContext context = server.createContext("/bar");
        	context.setHandler(DemoHttpServer::handleRequestBar);
        }
        System.out.println("Starting Server...");
        server.start();
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        String response = "Hi there! " + System.currentTimeMillis();
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
    
    private static void handleRequestFoo(HttpExchange exchange) throws IOException {
        String response = "Foo! " + System.currentTimeMillis();
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }    

    private static void handleRequestBar(HttpExchange exchange) throws IOException {
        String response = "Bar! " + System.currentTimeMillis();
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}
