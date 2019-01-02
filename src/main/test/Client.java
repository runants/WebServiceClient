import com.mama.entity.User;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.WebServiceClient;

/**
 * @Author: Ant
 * @Date: 2018/12/14 15:37
 * @Version 1.0
 */
public class Client {

    @Test
    public void toSave(){

        User user = new User();
        user.setId(100);
        user.setUsername("Jerry");
        user.setCity("gz");

        WebClient.create("http://localhost:8111/rs/userService/user").type(MediaType.APPLICATION_JSON).post(user);
    }

    @Test
    public  void getUserById(){

        User user = WebClient
                .create("http://localhost:8111/rs/userService/user/2")
                .accept(MediaType.APPLICATION_JSON)
                .get(User.class);


        System.out.println(user);
    }

    @Test
    public void getDeleteById(){


       WebClient.create("http://localhost:8111/rs/userService/user/2").type(MediaType.APPLICATION_JSON).delete();

    }


}
