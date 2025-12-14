import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Group {

    private long id;

    private List<User> userList;
    private Map<User,Float> amount;
    private String name;

    public Group(List<User> userList, String name) {
        this.id = System.currentTimeMillis();
        this.userList = userList;
        this.name = name;
        this.amount = new HashMap<>();
        for(User user : userList)
            user.getGroups().add(this);
    }

    public long getId() {
        return id;
    }

    public List<User> getUserList() {
        return userList;
    }

    public synchronized void addUsers(List<User> userList) {
        if(Objects.nonNull(this.userList)){
            for(User user : userList){
                this.userList.add(user);
                user.getGroups().add(this);
            }

        }
    }

    public synchronized void removeUsers(User user) {
        if(Objects.nonNull(this.userList)){
            if(amount.getOrDefault(user,0f) == 0f){
                this.userList.remove(user);
                user.getGroups().remove(this);
            }
            else
                System.out.println(user.getName() +" Can not be removes as they need to clear all first");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGroupAmountForUser(float amount){
        for(User user : userList)
            this.amount.put(user,this.amount.getOrDefault(user,0f)+amount);
    }
}
