import domain.*;


import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.UserService;

import javax.jws.soap.SOAPBinding;
import java.util.*;

public class UserServiceTests {



    @Test
    public  void userShouldHaveMoreThanOneAddresses() {
        User user = new User().setPersonDetails(new Person().setAddresses(Lists.newArrayList(new Address(), new Address())));

       Assert.assertTrue(user.getPersonDetails().getAddresses().size() > 1 );
    }

    @Test
    public  void userWhoHaveOnoAddress(){
        User user = new User().setPersonDetails(new Person().setAddresses(Lists.newArrayList(new Address())));

        Assert.assertFalse(user.getPersonDetails().getAddresses().size() > 1);

    }

    @Test
    public void userShouldBeTheOldest() {
        User user = new User().setPersonDetails(new Person().setAge(90));

        Assert.assertEquals( true, user.getPersonDetails().getAge() > 80);
    }
    @Test
    public void userShouldBeZero() {
        User user = new User().setPersonDetails(new Person().setAge(0));

        Assert.assertFalse((user.getPersonDetails().getAge() != 0));
    }

    @Test
    public void userWithTheLongestUserName() {
        User user = new User().setName("Wierzchosława");

        Assert.assertTrue(user.getName().length() > 10);
    }

    @Test
    public void  userWithTheShortestName(){
        User userm = new User().setName("1");

        Assert.assertTrue(userm.getName().length()<= 1);

    }

    @Test
    public void userWhoIsAbove18(){
        User user =new User().setPersonDetails(new Person().setAge(19));

        Assert.assertTrue(user.getPersonDetails().getAge() >18);
    }

    @Test
    public void userWhoIsUnder18(){
        User user1 = new User().setPersonDetails(new Person().setAge(17));
        User user2 = new User().setPersonDetails(new Person().setAge(18));

        Assert.assertFalse(user1.getPersonDetails().getAge()>18);
        Assert.assertEquals(18, user2.getPersonDetails().getAge());
    }



    @Test
    public void checkIfAnyUserNameStartedWithA  () {
        User user1 = new User().setPersonDetails(new Person().setName("A%"));
        User user2 = new User().setPersonDetails(new Person().setName("Kasia"));

        Assert.assertTrue(user1.getPersonDetails().getName().toLowerCase().startsWith("a"));
        Assert.assertFalse(user2.getPersonDetails().getName().toLowerCase().startsWith("a"));
    }



    @Test
    public void checkIfAnySurnameStartsWithS() {
        User user = new User().setPersonDetails(new Person().setSurname("S%"));
        User user1 = new User().setPersonDetails(new Person().setSurname("Kowalski"));

        Assert.assertTrue(user.getPersonDetails().getSurname().toLowerCase().startsWith("s"));
        Assert.assertFalse(user1.getPersonDetails().getSurname().toLowerCase().startsWith("s"));
    }



    @Test
    public void ifUserIsUnder18(){
       User user1 = new User().setPersonDetails(new Person().setAge(4));
       User user2 = new User().setPersonDetails(new Person().setAge(19));

       Assert.assertTrue(user1.getPersonDetails().getAge()<18);
       Assert.assertFalse(user2.getPersonDetails().getAge()<18);

    }

   /* @Test

    public void shouldReturnGroupedUsersByRole() {
        Role role1 = new Role().setName("r1");
        Role role2 = new Role().setName("r2");
        Role role3 = new Role().setName("r3");

        User user1 = new User().setPersonDetails(new Person().setRole(role1));
        User user2 = new User().setPersonDetails(new Person().setRole(role2));
        User user3 = new User().setPersonDetails(new Person().setRole(role3));
        User user4 = new User().setPersonDetails(new Person().setRole(role3));
        User user5 = new User().setPersonDetails(new Person().setRole(role1));

        Map<Role, User> usersByRole = new HashMap<>();
        usersByRole.put(role1, user1);
        usersByRole.put(role1, user5);
        usersByRole.put(role2, user2);
        usersByRole.put(role3, user3);
        usersByRole.put(role3, user4);

        Assert.assertEquals(true, usersByRole.containsKey(role1).size() = 2);





    }*/




}
