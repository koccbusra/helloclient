package helloclient;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import HelloApp.Hello;
import HelloApp.HelloHelper;

public class ClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Client.java
		try {
		        ORB orb = ORB.init(args, null);

		        // get reference to root naming context
		        org.omg.CORBA.Object ns = orb
		                .resolve_initial_references("NameService");
		        NamingContextExt nc = NamingContextExtHelper.narrow(ns);
		     Hello hl =(Hello) HelloHelper.narrow(nc.resolve_str("ABC"));
		     String r = hl.hellomessage();
		        System.out.println("client" +r );
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		        //.printStackTrace();
		    }
	
			
}}
