package Exercices4;

public class Ex4 {
    public static void main(String[] args){
        User user = new User("Test","TwT","test@gmail.com");
        User user2 = DAO_CRUD.getUserById(1);
        DAO_CRUD.addUser(user);
        System.out.println();
        DAO_CRUD.deleteUser(7);
    }
}
