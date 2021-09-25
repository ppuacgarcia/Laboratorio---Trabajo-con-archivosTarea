/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_con_archivos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class Manager {
    public  Manager(){
       
   }
    public void insert(String name, int phn,byte age){
        this.InsertBySize(name, phn, age);
        InsertByBin(name, phn, age);
    }
    private void InsertBySize(String name,int phn,byte age){
       try {
           RandomAccessFile archive=new RandomAccessFile("schedule.bin","rw");
           archive.seek(archive.length());
           if(name.length()<34){
               int n=name.length();
               for(int i=0;i<(35-n);i++)
               name+=" ";
           }
           archive.writeBytes(name);
           archive.writeInt(phn);
           archive.writeByte(age);
           archive.close();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
       }catch(IOException ex){
           Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
       }       
   }
    private void InsertByBin(String name,int phn,byte age){
        try {
            try (RandomAccessFile fl = new RandomAccessFile("BasicSchedule.bin","rw")) {
                fl.seek(fl.length());
                fl.writeBytes(name);
                fl.writeChar((char)' ');
                fl.writeInt(phn);
                fl.writeChar((char)' ');
                fl.writeByte(age);
                fl.writeBoolean(true);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /*public void ReadByBin(){
        try {
            RandomAccessFile fl=new RandomAccessFile("BasicSchedule.bin","rw");
            int p=0;
            while(fl.read()!=01){
                fl.seek(fl.getFilePointer()-1);
               if(p==0){
                    System.out.print(""+(char) fl.read());
                    if(fl.read()==03){
                        p=1;
                    }
                    fl.seek(fl.getFilePointer()-1);
               }else if(p==1){
                   System.out.print("");
                   fl.seek(fl.getFilePointer()+1);
                   System.out.print("-"+fl.read());
                  
               }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
   public void ReadBySize(){
   
       try {
            RandomAccessFile archive=new RandomAccessFile("schedule.bin","r");
            //archive.seek(0);
            int j=0;
           
            for(int i=0;i<archive.length()-1;i++){
                byte l[]=new byte[35];
                archive.read(l);
                System.out.println("nombre:"+new String(l));
                int phn=archive.readInt();
                System.out.println("numero telefonico: "+phn);    
                int  age=archive.readByte();
                System.out.println("edad: "+age);
                j=j+40;
                i=j;
            }
                
                
            
        } catch (FileNotFoundException ex) {
            System.err.println("deben existir datos ingresados anterior");
        }catch(IOException ex){
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
   }*/
   
}
