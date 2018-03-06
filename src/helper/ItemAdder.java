package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import shopping.bean.Item;

public class ItemAdder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "Razer - BlackWidow Chroma V2 Tournament Edition USB Gaming Keyboard - Black";
		String detal = "87 keys\r\n" + 
				"Offer a comfortable typing experience.\r\n" + 
				"\r\n" + 
				"Multimedia controls\r\n" + 
				"Promote simple operation.\r\n" + 
				"\r\n" + 
				"Razer Mechanical switches\r\n" + 
				"Offer rapid response times for quick in-game action.\r\n" + 
				"\r\n" + 
				"Programmable keys\r\n" + 
				"Enable you to reassign keys for enhanced gaming.\r\n" + 
				"\r\n" + 
				"Integrated numeric keypad\r\n" + 
				"Allows simple data entry when you're not gaming for multifunction use.\r\n" + 
				"\r\n" + 
				"USB interface\r\n" + 
				"Enables a simple wired connection to your computer.\r\n" + 
				"\r\n" + 
				"Palm rest\r\n" + 
				"For comfortable use.\r\n" + 
				"\r\n" + 
				"PC and Mac compatible\r\n" + 
				"For use with your existing computer." ;				
		Item i1 = new Item(0,name,139.99,10,"accessory,electronic,keyboard",detal);
		File file = new File("keyboard.jpg");
		byte[] bFile = new byte[(int) file.length()];	 
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        i1.setImage(bFile);
		SessionFactory sf = new Configuration().configure("helper/hibernate1.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(i1);
		/*Item i1 = session.get(Item.class, 1);
		System.out.println(i1);
		try{
            FileOutputStream fos = new FileOutputStream("output.jpg");  //windows
            fos.write(i1.getImage());
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }*/
		session.getTransaction().commit();
		session.close();
		sf.close();
		
		
	}

}
