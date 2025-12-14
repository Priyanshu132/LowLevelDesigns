import strategyImpl.EqualStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SplitSystem system = SplitSystem.getInstance();


        User priyanshu = new User("Priyanshu");
        User aman = new User("Aman");
        User Himanshu = new User("Himanshu");
        List<User> l1 = new ArrayList<>(Arrays.asList(priyanshu,aman,Himanshu));
        Group group1 = new Group(l1,"Go Karting");

        User satyam = new User("Satyam");
        User tushar = new User("Tushar");
        List<User> l2 = new ArrayList<>(Arrays.asList(satyam,aman,tushar));
        Group group2 = new Group(l2,"Manali");

        User sati = new User("Satiram");
        List<User> l3 = new ArrayList<>(Arrays.asList(tushar,sati));

        List<Group> groupList = Arrays.asList(group1,group2);
        System.out.println("----------- Before Expense------------");
        for(Group group : groupList)
            System.out.println("Group -> "+group.getName()+" Has user -> "+group.getUserList());


        List<User> allUsers = new ArrayList<>(Arrays.asList(priyanshu,aman,Himanshu,sati,satyam,tushar));

        for(User user : allUsers)
            System.out.println("User -> "+user);

        // Group 1
        system.addExpense(priyanshu,group1,60,new EqualStrategy(),"Tea");
        system.addExpense(aman,group1,120,new EqualStrategy(),"Maggie");
        system.addExpense(aman,group1,90,new EqualStrategy(),"Cold Drink");
        system.addExpense(Himanshu,group1,2700,new EqualStrategy(),"Tickets");
        system.addExpense(priyanshu,group1,300,new EqualStrategy(),"Uber");

        System.out.println("-------- After Group 1 Expense -------------");
        for(Group group : groupList)
            System.out.println("Group -> "+group.getName()+" Has user -> "+group.getUserList());


        for(User user : allUsers)
            System.out.println("User -> "+user);


        // Group 2
        system.addExpense(satyam,group2,60,new EqualStrategy(),"Tea");
        system.addExpense(satyam,group2,150,new EqualStrategy(),"Maggie");
        system.addExpense(satyam,group2,600,new EqualStrategy(),"Shoes");
        system.addExpense(tushar,group2,1500,new EqualStrategy(),"Clothes");
        system.addExpense(aman,group2,15000,new EqualStrategy(),"Traveller");

        System.out.println("-------- After Group 2 Expense -------------");
        for(Group group : groupList)
            System.out.println("Group -> "+group.getName()+" Has user -> "+group.getUserList());


        for(User user : allUsers)
            System.out.println("User -> "+user);


        // Non Group 1-> can add one time only
        system.addExpense(sati,l3,240,new EqualStrategy(),"chole Bhature");

        System.out.println("-------- After Non Group 1 Expense -------------");
        for(Group group : groupList)
            System.out.println("Group -> "+group.getName()+" Has user -> "+group.getUserList());


        for(User user : allUsers)
            System.out.println("User -> "+user);

        // Non Group -> can add one time only
        Expense expense = system.addExpense(tushar,l3,300,new EqualStrategy(),"Dosa");

        System.out.println("-------- After Non Group 2 Expense -------------");
        for(Group group : groupList)
            System.out.println("Group -> "+group.getName()+" Has user -> "+group.getUserList());


        for(User user : allUsers)
            System.out.println("User -> "+user);


        // adding new member in Group 1
        group1.addUsers(List.of(tushar));
        system.addExpense(tushar,group1,400,new EqualStrategy(),"Dosa");
        System.out.println("-------- After ADDING Tushar from Group 1 Expense -------------");
        for(Group group : groupList)
            System.out.println("Group -> "+group.getName()+" Has user -> "+group.getUserList());


        for(User user : allUsers)
            System.out.println("User -> "+user);

        // removing member in Group 2
        group2.removeUsers(aman);

        System.out.println("-------- After Removing Aman From Group 2 Expense -------------");
        for(Group group : groupList)
            System.out.println("Group -> "+group.getName()+" Has user -> "+group.getUserList());


        for(User user : allUsers)
            System.out.println("User -> "+user);

        System.out.println("---- Adding Nikhil in Non Group Expense ----");
        User nikhil = new User("Nikhil");
        allUsers.add(nikhil);
        system.addMembers(expense,new ArrayList<>(List.of(nikhil)));

        for(User user : allUsers)
            System.out.println("User -> "+user);
    }
}