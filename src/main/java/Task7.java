import domain.*;
import service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task7 {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        // 1szy uzytkownik
        User user1 = new User();
        user1.setName("Arek");
        user1.setPassword("pass1");
        Person personDetails1 = new Person();
        personDetails1.setAge(21);
        personDetails1.setName("Arek");
        personDetails1.setSurname("Sowa");
        Permission uprawnienie1 = new Permission();
        uprawnienie1.setName("up1");
        Permission uprawnienie2 = new Permission();
        uprawnienie2.setName("up2");
        List<Permission> uprawnienia = Arrays.asList(uprawnienie1, uprawnienie2);
        Role rola1 = new Role();
        rola1.setName("rola1");
        rola1.setPermissions(uprawnienia);

        personDetails1.setRole(rola1);
        personDetails1.setPhoneNumbers(Arrays.asList("0000", "1111", "9999"));
        Address adres1 = new Address();
        adres1.setCity("city");
        adres1.setCountry("country");
        adres1.setFlatNumber(1);
        adres1.setHouseNumber(1);
        adres1.setPostCode("9999");
        adres1.setStreetName("street");

        Address adres2 = new Address();
        adres2.setCity("city");
        adres2.setCountry("country");
        adres2.setFlatNumber(1);
        adres2.setHouseNumber(1);
        adres2.setPostCode("9999");
        adres2.setStreetName("street");

        personDetails1.setAddresses(Arrays.asList(adres1, adres2));

        user1.setPersonDetails(personDetails1);

        // 2gi uzytkownik
        User user2 = new User();
        user2.setName("user2");
        user2.setPassword("pass2");
        Person personDetails2 = new Person();
        personDetails2.setAge(17);
        personDetails2.setName("Marek2");
        personDetails2.setSurname("Sowa2");
        Permission uprawnienie3 = new Permission();
        uprawnienie3.setName("up1");

        List<Permission> uprawnienia2 = Arrays.asList(uprawnienie3);
        Role rola2 = new Role();
        rola2.setName("rola2");
        rola2.setPermissions(uprawnienia2);

        personDetails2.setRole(rola2);
        personDetails2.setPhoneNumbers(Arrays.asList("0000", "1111", "9999"));
        Address adres3 = new Address();
        adres3.setCity("city");
        adres3.setCountry("country");
        adres3.setFlatNumber(1);
        adres3.setHouseNumber(1);
        adres3.setPostCode("9999");
        adres3.setStreetName("street");


        personDetails2.setAddresses(Arrays.asList(adres3));

        user2.setPersonDetails(personDetails2);

        // 3gi uzytkownik
       User user3 = new User();
        user3.setName("Agnieszka");
        user3.setPassword("pass3");
        Person personDetails3 = new Person();
        personDetails3.setAge(30);
        personDetails3.setName("Agnieszka");
        personDetails3.setSurname("Diamond");
        Permission uprawnienie4 = new Permission();
        Permission uprawnienie5 = new Permission();
        uprawnienie4.setName("up5");
        uprawnienie5.setName("up6");

        List<Permission> uprawnienia3 = Arrays.asList(uprawnienie4, uprawnienie5);
        Role rola3 = new Role();
        rola3.setName("rola3");
        rola3.setPermissions(uprawnienia3);

        personDetails3.setRole(rola3);
        personDetails3.setPhoneNumbers(Arrays.asList("01234", "4444", "0987"));
        Address adres4 = new Address();
        adres4.setCity("city");
        adres4.setCountry("country");
        adres4.setFlatNumber(4);
        adres4.setHouseNumber(4);
        adres4.setPostCode("8765");
        adres4.setStreetName("street");


        personDetails3.setAddresses(Arrays.asList(adres4));

        user3.setPersonDetails(personDetails3);

        users.add(user1);
        users.add(user2);
        users.add(user3);


        // cd tworzenia listy

        System.out.println(UserService.findUsersWhoHaveMoreThanOneAddress(users));
        System.out.println(UserService.findOldestPerson(users));
        System.out.println(UserService.findUserWithLongestUsername(users));
        System.out.println(UserService.getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18(users));
        System.out.println(users.get(1).getPersonDetails().getRole().getPermissions());
        System.out.println(UserService.getSortedPermissionsOfUsersWithNameStartingWithA(users));

    }
}
