package Test;

import domain.User;
import utils.BlackBox;

/**
 * @ClassName: Test
 * @Description: TODO
 * @author LHY
 * @date 2025/5/16
 * @Version: 1.0
 **/
public class Test {
    public static void main(String[] args) throws Exception {
        User user = (User) BlackBox.getData("service.UserService",
                "login", "gg", "123456");
    }

}
