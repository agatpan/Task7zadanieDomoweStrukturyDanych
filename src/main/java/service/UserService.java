package service;

import domain.Permission;
import domain.User;
import domain.Person;
import domain.Role;

import java.util.*;

public class UserService  {

    public static List<User> findUsersWhoHaveMoreThanOneAddress(List<User> users) {

        List<User> usersWhoHaveMoreThanOneAdress = new ArrayList<>();
        for (User user : users){
            if (user.getPersonDetails().getAddresses().size() > 1){
                usersWhoHaveMoreThanOneAdress.add(user);
            }
        }
        return usersWhoHaveMoreThanOneAdress;
    }

    public static Person findOldestPerson(List<User> users) {

        Person theOldestPerson = users.get(0).getPersonDetails();
        for (User user : users) {

            if (user.getPersonDetails().getAge() > theOldestPerson.getAge()) {
                theOldestPerson = user.getPersonDetails();
            }

        }

        return theOldestPerson;
    }

    public static User findUserWithLongestUsername(List<User> users) {

       User userWithLongestUsername = users.get(0);
        for (User user : users){
            if (user.getName().length() > userWithLongestUsername.getName().length()){
                userWithLongestUsername = user;

            }
        }

        return userWithLongestUsername;
    }

    // zamieniałam tutaj zmiena se Stringa na Listę Stringów??? skoro moge posiadac więcej niż jednego dorosłego
    public static List<String> getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18(List<User> users) {

        List<String> nameAndSurnameUsersAbove18 = new ArrayList<>();
        for (User user : users){
            if (user.getPersonDetails().getAge() > 18){
                nameAndSurnameUsersAbove18.add(user.getPersonDetails().getName() + ", " + user.getPersonDetails().getSurname());
            }
        }

        return nameAndSurnameUsersAbove18;
    }

    // zmieniłam z Listy na TreeSeta??? Nie udało mi się tego jakoś posortować przez Colections.sort()???
    public static TreeSet<List<Permission>> getSortedPermissionsOfUsersWithNameStartingWithA(List<User> users) {

        TreeSet<List<Permission>> sortedPermissinsOfUsersWhithNameStartinsWithA = new TreeSet<>();
        for (User user : users) {
            if (user.getName().startsWith("A"));
           sortedPermissinsOfUsersWhithNameStartinsWithA.add(user.getPersonDetails().getRole().getPermissions());
        }


        return sortedPermissinsOfUsersWhithNameStartinsWithA;
    }

    public static void printCapitalizedPermissionNamesOfUsersWithSurnameStartingWithS(List<User> users) {

        String capitalizedPermissionNamesOfUsersWithSurnameWithS;
        for (User user: users){
            if ( user.getPersonDetails().getSurname().startsWith("S"));
           capitalizedPermissionNamesOfUsersWithSurnameWithS =  user.getPersonDetails().getRole().getName().toUpperCase();
        }

    }

    public static Map<Role, User> groupUsersByRole(List<User> users) {

        Map<Role, User> usersByRole = new HashMap<>();
        for (User user : users){
            usersByRole.put(user.getPersonDetails().getRole(), user);
        }

        return usersByRole;
    }

    public static Map<Boolean, User> partitionUserByUnderAndOver18(List<User> users) {

        Map<Boolean, User> usersUnderAndOver18 = new HashMap<>();

        for (User user :users){


            if (user.getPersonDetails().getAge() > 18 ){
                boolean over18 = true;
               usersUnderAndOver18.put(over18, user);
            }
            else{
               boolean over18= false;
               usersUnderAndOver18.put(over18, user);}
        }


        return usersUnderAndOver18;
    }


}
