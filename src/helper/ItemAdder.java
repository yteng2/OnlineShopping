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
		String name = "Dell - Inspiron 15.6\" Laptop - Intel Core i5 - 8GB Memory - NVIDIA GeForce GTX 1050 Ti - 256GB Solid State Drive - Black";
		String detal = "Windows 10 operating system\r\n" + 
				"Windows 10 brings back the Start Menu from Windows 7 and introduces new features, like the Edge Web browser that lets you markup Web pages on your screen. Learn more ›\r\n" + 
				"\r\n" + 
				"15.6\" Full HD display\r\n" + 
				"The 1920 x 1080 resolution boasts impressive color and clarity. IPS technology for wide viewing angles. Energy-efficient LED backlight.\r\n" + 
				"\r\n" + 
				"7th Gen Intel® Core™ i5-7300HQ mobile processor\r\n" + 
				"Smart quad-core processing performance. Intel Turbo Boost Technology delivers dynamic extra power when you need it, while increasing energy efficiency when you don't.\r\n" + 
				"\r\n" + 
				"8GB system memory for advanced multitasking\r\n" + 
				"Substantial high-bandwidth RAM to smoothly run your games and photo- and video-editing applications, as well as multiple programs and browser tabs all at once.\r\n" + 
				"\r\n" + 
				"256GB solid state drive (SSD)\r\n" + 
				"While offering less storage space than a hard drive, a flash-based SSD has no moving parts, resulting in faster start-up times and data access, no noise, and reduced heat production and power draw on the battery.\r\n" + 
				"\r\n" + 
				"NVIDIA GeForce GTX 1050 Ti graphics\r\n" + 
				"Backed by 4GB GDDR5 dedicated video memory for a fast, advanced GPU to fuel your games.";
				
		Item i1 = new Item(0,name,699.99,10,"computer,laptop",detal);
		File file = new File("laptop5.jpg");
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
