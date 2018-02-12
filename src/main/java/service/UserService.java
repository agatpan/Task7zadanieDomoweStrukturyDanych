package service;

import domain.Permission;
import domain.User;
import domain.Person;
import domain.Role;

import java.util.*;

public class UserService {

    public static List<User> findUsersWhoHaveMoreThanOneAddress(List<User> users) {
        List<User> listaOdfiltrowana = new ArrayList<>();
        for (User user : users) {
            if (user.getPersonDetails().getAddresses().size() > 1) {
                listaOdfiltrowana.add(user);
            }
        }

        return listaOdfiltrowana;
    }

    public static Person findOldestPerson(List<User> users) {
        Person person = users.get(0).getPersonDetails();
        for (User user : users) {
            if (user.getPersonDetails().getAge() > person.getAge()) {
                person = user.getPersonDetails();
            }
        }
        return person;
    }

    public static User findUserWithLongestUsername(List<User> users) {
        User userWithLongestUsername = users.get(0);
        for (User user : users) {
            if (userWithLongestUsername.getName().length() < user.getName().length()) {
                userWithLongestUsername = user;
            }
        }
        return userWithLongestUsername;
    }

    public static String getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18(List<User> users) {
        StringBuilder names = new StringBuilder();
        for (User user : users) {
            if (user.getPersonDetails().getAge() > 18) {
                Person person = user.getPersonDetails();
                names.append(person.getName()).append(",").append(person.getSurname()).append(",");
            }
        }
        return names.toString();
    }

    public static List<String> getSortedPermissionsOfUsersWithNameStartingWithA(List<User> users) {
        TreeSet<String> permissions = new TreeSet<>();
        for (User user : users) {
            if (user.getName().toLowerCase().startsWith("a")) {
                for (Permission permission : user.getPersonDetails().getRole().getPermissions()) {
                    permissions.add(permission.getName());
                }
            }
        }
        return new ArrayList<>(permissions);
    }

    public static void printCapitalizedPermissionNamesOfUsersWithSurnameStartingWithS(List<User> users) {
        List<String> permissions = new ArrayList<>();
        for (User user : users) {
            if (user.getPersonDetails().getSurname().toLowerCase().startsWith("s")) {
                for (Permission permission : user.getPersonDetails().getRole().getPermissions()) {
                    permissions.add(permission.getName().toUpperCase());
                }
            }
        }
        System.out.println(permissions);
    }

    public static Map<Role, List<User>> groupUsersByRole(List<User> users) {
        Map<Role, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            groupedUsers.computeIfAbsent(user.getPersonDetails().getRole(), k -> new ArrayList<>());
            groupedUsers.get(user.getPersonDetails().getRole()).add(user);
            groupedUsers.put(user.getPersonDetails().getRole(), groupedUsers.get(user.getPersonDetails().getRole()));
        }
        return groupedUsers;
    }

    public static Map<Boolean, List<User>> partitionUserByUnderAndOver18(List<User> users) {
        Map<Boolean,List<User>> groupedUsers = new HashMap<>();
        for (User user : users){
            if(user.getPersonDetails().getAge() >= 18){
                groupedUsers.computeIfAbsent(true, k -> new ArrayList<>());
                groupedUsers.get(true).add(user);
                groupedUsers.put(true,groupedUsers.get(true));
            } else {
                groupedUsers.computeIfAbsent(false, k -> new ArrayList<>());
                groupedUsers.get(false).add(user);
                groupedUsers.put(false,groupedUsers.get(false));
            }
        }
        return groupedUsers;
    }
}