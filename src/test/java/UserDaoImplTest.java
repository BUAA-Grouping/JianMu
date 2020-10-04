import com.webapp.dao.UserDao;
import com.webapp.dao.impl.UserDaoImpl;
import com.webapp.pojo.User;
import org.junit.Test;

public class UserDaoImplTest {
    private UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsernameTest() {
        User user = userDao.queryUserByUsername("lkl");
        System.out.println("user: " + user.getName());
        System.out.println("id: " + user.getSchoolId());
        System.out.println("password: " + user.getPassword());
        user = userDao.queryUserByUsername("iii");
        assert user == null;
    }

    @Test
    public void queryByUsernameAndPasswordTest() {
        User user = userDao.queryByUsernameAndPassword("lkl", "lklnblklnb");
        System.out.println("user: " + user.getName());
        System.out.println("id: " + user.getSchoolId());
        System.out.println("password: " + user.getPassword());
        user = userDao.queryByUsernameAndPassword("lkl", "lklnb");
        assert user == null;
        user = userDao.queryByUsernameAndPassword("lkll", "lklnblklnb");
        assert user == null;
    }

    @Test
    public void saveUserTest() {
        User user = new User(18373737, "wyx", "wyxwyxwyx");
        userDao.saveUser(user);
        user = userDao.queryByUsernameAndPassword("wyx", "wyxwyxwyx");
        assert user != null;
        System.out.println("user: " + user.getName());
        System.out.println("id: " + user.getSchoolId());
        System.out.println("password: " + user.getPassword());
    }
}
