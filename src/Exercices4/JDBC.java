package Exercices4;

import com.mysql.cj.jdbc.Driver;
import java.io.FileWriter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

    public static void main(String[] args) throws SQLException{
        String url = "jdbc:mysql://localhost:3306";
        String uname = "root";
        String password = "";
        String query = "select * from users.users";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url,uname,password);
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            FileWriter fw = new FileWriter("output.json");
            fw.write("[");
            String[] champs = {"","{\n\t\"id\":","\n\t\"login\":","\n\t\"password\":","\n\t\"email\":"};
            while(result.next()){
                String data = "";
                for(int i = 1; i <= 4; i++){
                    if(i== 1) {
                        data += champs[1] + result.getString(i);
                    }
                    else{
                        data +=  champs[i] +  "\"" + result.getString(i) + "\"";
                    }
                    if (i <= 3){
                        data += ",";
                    }
                }
                if(result.isLast()){data += "\n}]";}
                else{data += "\n},";}
                System.out.println(data);
                fw.write(data);
            }
            fw.close();

        }catch (SQLException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
