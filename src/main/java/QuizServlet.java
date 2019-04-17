

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="QuizServlet", urlPatterns = {"/quiz"})
public class QuizServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String[] questions = {"3,1,4,1,5", "1,1,2,3,5", "1,4,9,16,25", "2,3,5,7,11", "1,2,4,8,16"};
        int[] answers = {9,8,36,13,32};
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
//   try{
       int count=2;
       String guess= request.getParameter("answer");
       out.println("<h1>The Number Quiz</h1>");
       out.print("<form action=\"quiz\"><br/>");

//       int i=0;
//       while (!("".equals(questions[i]))){
//           if (Integer.valueOf(guess) == answers[i]){



               for (int i=0;i<answers.length;i++){
                   if(Integer.valueOf(guess)==answers[i]){
                       count++;
                       out.println("Your current score is "+count+"<br>");
                   }
               }

        out.println("Guess the next number in the sequence.<br/>");
        out.println(questions[0]+"<br/>");
        out.println("Your answer: <input name=\"answer\"><br/>");
        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("</form>");


               out.println(guess);
//           }
//           i++;
//       }
//   }catch(Exception e){
//       out.println("Sth is wrong !!");
//   }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}