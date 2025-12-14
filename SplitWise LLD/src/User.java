import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {

    private long id;
    private String name;
    private float totalAmount;
    private Map<User,Float> perUserAmount;
    private List<Group> groups;

    public User(String name) {
        this.name = name;
        this.id = System.currentTimeMillis();
        this.totalAmount = 0.0f;
        this.perUserAmount = new HashMap<>();
        this.groups = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTotalAmount() {
        return totalAmount;
    }


    public void addCredit(List<User> users,float amount) {

        for(User user : users){
            if(user.getName().equalsIgnoreCase(this.getName()))
                continue;
            float already = perUserAmount.getOrDefault(user,0f);
            perUserAmount.put(user,already+amount);
            totalAmount += amount;
            addDebit(user,amount);
        }
    }

    private void addDebit(User user, float amount) {
       user.totalAmount -= amount;
       float already = user.perUserAmount.getOrDefault(this,0f);
       user.perUserAmount.put(this,already - amount);
    }

    public void removeCredit(List<User> users,float amount) {

        for(User user : users){
            if(user.getName().equalsIgnoreCase(this.getName()))
                continue;
            perUserAmount.computeIfPresent(user,(u, balance) -> balance - amount);
            totalAmount -= amount;
        }
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {

        Map<String,Float> cre = perUserAmount.entrySet().stream().collect(Collectors.toMap(e->e.getKey().getName(), Map.Entry::getValue));
        return "User{" +
                "name='" + name + '\'' +
                ", totalAmount=" + totalAmount +
                ", user =" + cre +
                '}';
    }
}
