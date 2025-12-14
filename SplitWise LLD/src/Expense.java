import strategy.SplitStrategy;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class Expense {

    private long id;
    private String name;
    private Group group;
    private List<User> userList;
    private User paidBy;
    private float totalAmount;
    private SplitStrategy splitStrategy;
    private LocalTime createdTime;

    public Expense(String name, Group group, float totalAmount,User paidBy,SplitStrategy splitStrategy) {
        this.name = name;
        this.paidBy = paidBy;
        this.group = group;
        this.userList = group.getUserList();
        this.totalAmount = totalAmount;
        this.id = System.currentTimeMillis();
        this.createdTime = LocalTime.now();
        this.splitStrategy = splitStrategy;
        float sharePerUser = splitStrategy.getShareAmount(totalAmount,group.getUserList().size());
        updateBalance(sharePerUser);
    }


    public Expense(String name, List<User> userList, float totalAmount,User paidBy,SplitStrategy splitStrategy) {
        this.name = name;
        this.userList = userList;
        this.paidBy = paidBy;
        this.totalAmount = totalAmount;
        this.id = System.currentTimeMillis();
        this.splitStrategy = splitStrategy;
        this.createdTime = LocalTime.now();

        float sharePerUser = splitStrategy.getShareAmount(totalAmount,userList.size());
        updateBalance(sharePerUser);
    }

    private void updateBalance(float sharePerUser) {
        if(Objects.nonNull(group))
            group.addGroupAmountForUser(sharePerUser);
        paidBy.addCredit(userList,sharePerUser);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public synchronized void addUsers(List<User> userList) {
        if(Objects.nonNull(this.userList)){
            float sharePerUserPrevious = splitStrategy.getShareAmount(totalAmount,this.userList.size());
            revertPreviousBalance(sharePerUserPrevious);
            this.userList.addAll(userList);
            float sharePerUser = splitStrategy.getShareAmount(totalAmount,this.userList.size());
            updateBalance(sharePerUser);
        }
    }

    private void revertPreviousBalance(float sharePerUserPrevious) {
        paidBy.removeCredit(userList,sharePerUserPrevious);
    }

    public synchronized void removeUsers(List<User> userList) {
        if(Objects.nonNull(this.userList)){
            float sharePerUserPrevious = splitStrategy.getShareAmount(totalAmount,this.userList.size());
            revertPreviousBalance(sharePerUserPrevious);
            this.userList.removeAll(userList);
            float sharePerUser = splitStrategy.getShareAmount(totalAmount,this.userList.size());
            updateBalance(sharePerUser);
        }
    }

    public Group getGroup() {
        return group;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }
}
