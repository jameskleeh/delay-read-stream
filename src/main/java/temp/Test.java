package temp;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class Test {

    @Post(consumes = MediaType.APPLICATION_OCTET_STREAM)
    @ExecuteOn(TaskExecutors.IO)
    String test(@Body InputStream inputStream) {
        try {
            Thread.sleep(10000);
            System.out.println("first reading");
            int size = 1024;
            byte[] buf = new byte[size];
            int total = 0;
            int len;
            while ((len = inputStream.read(buf, 0, size)) != -1) {
                System.out.println("reading");
                total += len;
            }
            return "Uploaded " + total + " bytes";
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return "failed";
    }
}
