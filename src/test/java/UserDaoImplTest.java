import com.webapp.dao.UserDao;
import com.webapp.dao.impl.UserDaoImpl;
import com.webapp.pojo.User;
import org.junit.Before;
import org.junit.Test;

public class UserDaoImplTest {
    private UserDao userDao = new UserDaoImpl();

    @Before
    public void init() {
        System.out.println("-------- test UserDao --------");
    }

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
    public void queryByEmailTest() {
        String email = "xpy@buaa.edu.cn";
        User user = userDao.queryByEmail(email);
        assert user != null;
        assert user.getPassword().equals("xpyxpyxpy");
        email = "yyy";
        user = userDao.queryByEmail(email);
        assert user == null;
    }

    @Test
    public void saveUserTest() {
        User user = new User(18373737, "wyx", "wyxwyxwyx");
        user.setEmail("12345@buaa.edu.cn");
        userDao.saveUser(user);
        user = userDao.queryByUsernameAndPassword("wyx", "wyxwyxwyx");
        assert user != null;
        System.out.println("user: " + user.getName());
        System.out.println("id: " + user.getSchoolId());
        System.out.println("password: " + user.getPassword());
    }

    @Test
    public void modifyUserTest() {
        String email = "12345@buaa.edu.cn";
        User user = userDao.queryInfoByEmail(email);
        assert user != null;
        user.setProfile("hhh");
        assert userDao.modifyUser(user);
        user = userDao.queryInfoByEmail(email);
        assert user.getProfile().equals("hhh");
        assert !userDao.modifyUser(null);
    }
}
