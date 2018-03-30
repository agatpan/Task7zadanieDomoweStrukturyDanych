import domain.*;


import org.assertj.core.util.Lists;
import org.junit.Assert;

import org.junit.Test;
import service.UserService;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;


public class UserServiceTests {



    @Test
    public  void userShouldHaveMoreThanOneAddresses() {

        List<User> userList = new ArrayList<>();
        User user1 = new User().setPersonDetails(new Person().setAddresses(Lists.newArrayList(new Address(), new Address())));
        User user2 = new User().setPersonDetails(new Person().setAddresses(Lists.newArrayList(new Address())));
        userList.add(user1);
        userList.add(user2);

        assertTrue(UserService.findUsersWhoHaveMoreThanOneAddress(userList).size()!=0);
    }

    @Test
    public  void userWhoHaveOneAddress(){
        List<User> userList = new ArrayList<>();
        User user1 = new User().setPersonDetails(new Person().setAddresses(Lists.newArrayList(new Address())));
        User user2 = new User().setPersonDetails(new Person().setAddresses(Lists.newArrayList(new Address())));
        userList.add(user1);
        userList.add(user2);

        assertTrue(UserService.findUsersWhoHaveMoreThanOneAddress(userList).size()==1);
        assertTrue(UserService.findUsersWhoHaveMoreThanOneAddress(userList).get(0).equals(user1));

    }

    @Test
    public void userShouldBeTheOldest() {
        List<User> userList = new ArrayList<>();
        User user1 = new User().setPersonDetails(new Person().setAge(90));
        User user2 = new User().setPersonDetails(new Person().setAge(18));
        User user3 = new User().setPersonDetails(new Person().setAge(5));
        User user4 = new User().setPersonDetails(new Person().setAge(45));
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        assertEquals( true, UserService.findOldestPerson(userList).getAge()==90);
    }
    @Test
    public void userAgeShouldNotBeZero() {
        List<User> userList = new ArrayList<>();
        User user1 = new User().setPersonDetails(new Person().setAge(90));
        User user2 = new User().setPersonDetails(new Person().setAge(0));
        User user3 = new User().setPersonDetails(new Person().setAge(5));
        User user4 = new User().setPersonDetails(new Person().setAge(15));
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        Assert.assertFalse((UserService.findOldestPerson(userList).getAge() == 0));
    }

    @Test
    public void userWithTheLongestUserName() {
        List<User> userList = new ArrayList<>();
        User user1 = new User().setName("Grzegorz");
        User user2 = new User().setName("Ola");
        User user3 = new User().setName("Krzysztof");
        User user4 = new User().setName("Wierzchosława");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        assertTrue(UserService.findUserWithLongestUsername(userList).getName().equals("Wierzchosława"));
    }

    @Test
    public void  userWithTheLongestNameAssertThat(){
        List<User> userList = new ArrayList<>();
        User user1 = new User().setName("Grzegorz");
        User user2 = new User().setName("Ola");
        User user3 = new User().setName("L");
        User user4 = new User().setName("Wierzchosława");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        assertThat(UserService.findUserWithLongestUsername(userList).getName()).isEqualTo("Wierzchosława");

    }

    @Test
    public void userWhoIsAbove18(){

        List<User> userList = new ArrayList<>();
        User user1 = new User().setPersonDetails(new Person().setAge(90));
        User user2 = new User().setPersonDetails(new Person().setAge(57));
        User user3 = new User().setPersonDetails(new Person().setAge(10));
        User user4 = new User().setPersonDetails(new Person().setAge(25));
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        Map<Boolean,List<User>> groupedUsers = UserService.partitionUserByUnderAndOver18(userList);

        assertThat(groupedUsers.get(false)).hasSize(1);
        assertThat(groupedUsers.get(true)).hasSize(3);
    }


    @Test
    public void checkIfAnyUserNameStartedWithA  () {

        List<User> userList = new ArrayList<>();
        User user1 = new User().setName("Ala").setPersonDetails(new Person().setRole(new Role().setPermissions(new ArrayList<>(Arrays.asList(new Permission().setName("z1"))))));
        User user2 = new User().setName("Krztsztof").setPersonDetails(new Person().setRole(new Role().setPermissions(new ArrayList<>(Arrays.asList(new Permission().setName("z1"), new Permission().setName("z2"))))));
        User user3 = new User().setName("Adam").setPersonDetails(new Person().setRole(new Role().setPermissions(new ArrayList<>(Arrays.asList(new Permission().setName("z3"), new Permission().setName("z4"))))));
        User user4 = new User().setName("Kasia").setPersonDetails(new Person().setRole(new Role().setPermissions(new ArrayList<>(Arrays.asList(new Permission().setName("z2"))))));
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);


        assertEquals(true, UserService.getSortedPermissionsOfUsersWithNameStartingWithA(userList).contains("z3"));
        assertFalse(UserService.getSortedPermissionsOfUsersWithNameStartingWithA(userList).contains("z2"));
    }



    @Test
    public void checkIfAnySurnameStartsWithS() {
        List<User> userList = new ArrayList<>();
        userList.add(new User().setPersonDetails(new Person().setSurname("Kowalski").setRole(new Role().setPermissions(Arrays.asList(new Permission().setName("z1"), new Permission().setName("z3"), new Permission().setName("z4"))))));
        userList.add(new User().setPersonDetails(new Person().setSurname("Schmidt").setRole(new Role().setPermissions(Arrays.asList(new Permission().setName("z2"), new Permission().setName("z3"))))));
        userList.add(new User().setPersonDetails(new Person().setSurname("Sur").setRole(new Role().setPermissions(Arrays.asList(new Permission().setName("z1"))))));
        userList.add(new User().setPersonDetails(new Person().setSurname("Nowak").setRole(new Role().setPermissions(Arrays.asList(new Permission().setName("z5"), new Permission().setName("z2"))))));

        UserService.printCapitalizedPermissionNamesOfUsersWithSurnameStartingWithS(userList);
    }




    @Test

    public void shouldReturnGroupedUsersByRole() {
        List<User> userList = new ArrayList<>();
        Role role1 = new Role().setName("r1");
        Role role2 = new Role().setName("r2");
        Role role3 = new Role().setName("r3");
        User user1 = new User().setPersonDetails(new Person().setRole(role1));
        User user2 = new User().setPersonDetails(new Person().setRole(role2));
        User user3 = new User().setPersonDetails(new Person().setRole(role3));
        User user4 = new User().setPersonDetails(new Person().setRole(role3));
        User user5 = new User().setPersonDetails(new Person().setRole(role1));
        User user6 = new User().setPersonDetails(new Person().setRole(role3));
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);

        Map<Role,List<User>> groupedUsers = UserService.groupUsersByRole(userList);

        assertThat(groupedUsers.get(role1)).hasSize(2);
        assertThat(groupedUsers.get(role2)).hasSize(1);
        assertThat(groupedUsers.get(role3)).hasSize(3);



    }




}
