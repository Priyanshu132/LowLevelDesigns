import strategy.SplitStrategy;

import java.util.List;

public class SplitSystem {

    public static volatile SplitSystem instance;

    private SplitSystem(){
    }

    public static SplitSystem getInstance(){
        if(instance == null){
            synchronized (SplitSystem.class){
                if(instance == null)
                    instance = new SplitSystem();
            }
        }
        return instance;
    }

    public Expense addExpense(User paidBy, List<User> users, float amount, SplitStrategy splitStrategy, String name){
        Expense expense = new Expense(name,users,amount,paidBy,splitStrategy);
        return expense;
    }

    public Expense addExpense(User paidBy,Group group,float amount,SplitStrategy splitStrategy,String name){
        Expense expense = new Expense(name,group,amount,paidBy,splitStrategy);
        return expense;
    }

    public Expense addMembers(Expense expense,List<User> users) {
        expense.addUsers(users);
        return expense;
    }

    public Expense removeMembers(Expense expense,List<User> users){
        expense.removeUsers(users);
        return expense;
    }

}
