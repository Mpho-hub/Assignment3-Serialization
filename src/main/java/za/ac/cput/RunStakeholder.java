package za.ac.cput;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author mpho
 */
public class RunStakeholder {
  public Object readFromFile() throws FileNotFoundException, IOException, ClassNotFoundException{
       List<Customer> cus =new ArrayList<Customer>();
       List<Supplier> sup =new ArrayList<Supplier>();
      
        try{
             
            FileInputStream fileIn= new FileInputStream("stakeholder.ser");
            ObjectInputStream objIn= new ObjectInputStream(fileIn);
            Object o;
            while(true){
                try{
                    o=objIn.readObject();
                    if(o instanceof Customer){
                        cus.add((Customer)o);
                        
                    }else if(o instanceof Supplier){
                        sup.add((Supplier)o);
                    }
                    
                }catch(EOFException ex){
                  break;  
                }
            }
           System.out.println("============================================ CUSTOMERS =================================================");
           System.out.println("ID   	      Name           Surname   	       Address        Date of birth  	 Credit        Age  ");
           System.out.println("=========================================================================================================");
           for(Customer customer: cus){
                System.out.println(customer);
     
           }
           System.out.println("================================ SUPPLIERS ===================================================");
           System.out.println("ID   	Name                	Prod Type	Description    ");
           System.out.println("==============================================================================================");
           
            for(Supplier suppliers:sup){
                System.out.println(suppliers);
                
            }
            
            objIn.close();
            fileIn.close();
        }catch(IOException | ClassNotFoundException ex){
             
            System.out.println(ex);
           
        }
         return null;
         
    }
  public void createTextFile(){
      
  }
    public static void main(String[]args) throws FileNotFoundException, IOException, ClassNotFoundException{
       CreateStakeholderSer crt= new CreateStakeholderSer();
       RunStakeholder read=new RunStakeholder();
       crt.openFile();
       crt.writeToFile();
       
       read.readFromFile();
       
       
    }
}



    


