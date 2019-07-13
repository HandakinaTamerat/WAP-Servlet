import java.util.ArrayList;
import java.util.List;

public class DB {
    public static List<User> users=new ArrayList<>();

    public static  User getUser(String userName){
        for (User us:users){
            if(us.getUserName().equalsIgnoreCase(userName)) {
                return us;
            }
        }
        return null;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void addUser(String userName, String password){
        User user=new User(userName,password);
        users.add(user);
    }
}
