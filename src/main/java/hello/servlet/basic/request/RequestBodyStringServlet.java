package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletInputStream inputStream = request.getInputStream(); // 메시지 바디의 내용을 byte코드로 바로 얻을수가 있다.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        //btye코드를 String으로 바꾸기위해서 Spring에서 지원하는 StreamUtils 사용
        //inputStream 을 꺼낼때 Encoding 정보가 무엇인지 알려주기위해서 StandardCharsets.UTF_8 작성
        // *항상 byte 코드를 꺼낼때는 Encoding 설정을 해줘야한다.*

        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");
    }
}
