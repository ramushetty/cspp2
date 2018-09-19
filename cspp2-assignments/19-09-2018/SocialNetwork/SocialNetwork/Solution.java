
import java.util.*;
/**
 * Class for socialnetwork.
 */
class socialnetwork {
	HashMap<String, ArrayList<String>> social;	
	/**
	 * Constructs the object.
	 */
	socialnetwork() {
	social = new HashMap<String, ArrayList<String>>();

	}
	/**
	 * { adds new name }.
	 *
	 * @param      name   The name
	 * @param      names  The names
	 */
	public void addnew(String name, String[] names) {
		social.putIfAbsent(name, new ArrayList<String>(Arrays.asList(names)));
		
	}
	/**
	 * { prints names connected to given name}.
	 *
	 * @param      name  The name
	 */
	public void getconnections(String name) {
		if (social.containsKey(name)) {
			System.out.println(social.get(name));
		} else {
			System.out.println("Not a user in Network");
		}
	}
	/**
	 * { prints common friends in name1 and name2 }.
	 *
	 * @param      name1  The name 1
	 * @param      name2  The name 2
	 */
	public void getcommon(String name1, String name2) {
		ArrayList<String> commonlist = new ArrayList<>();
			for (String a : social.get(name1)) {
				// System.out.println(a);
				for (String e : social.get(name2)) {
					if (a.equals(e)) {
						commonlist.add(e);
					}
				}
			}
			System.out.println(commonlist);
		
	}
	/**
	 * { adds another connection }.
	 *
	 * @param      name     The name
	 * @param      newname  The newname
	 */
	public void addconnection(String name, String newname) {
		if (social.containsKey(name)) {
			social.get(name).add(newname);
		} else {
			System.out.println("Not a user in Network");
		}

	}
	/**
	 * { prints all connections in dictonary }.
	 */
	public void printall() {
		 ArrayList<String> sortedKeys = 
                    new ArrayList<String>(social.keySet()); 
          
        Collections.sort(sortedKeys); 
        String s = "";
        for (String x : sortedKeys)  {
            // System.out.println("Key = " + x +  
            //             ", Value = " + map.get(x));   
            s += x + ":" + social.get(x) + ", "; 
        }
        System.out.println(s.substring(0, s.length() - 2));
    }
}
/**
 * Class for solution.
 */
public class Solution {
	public static void main(String[] args) {
		socialnetwork s = new socialnetwork();
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
				switch (tokens[0]) {
					case "getConnections":
						s.getconnections(tokens[1]);
						break;
					case "addConnections":
						s.addconnection(tokens[1], tokens[2]);
						break;
					case "CommonConnections":
						s.getcommon(tokens[1], tokens[2]);
						break;
					case "Network":
						s.printall();
						break;
					case "Create":
						int x = Integer.parseInt(tokens[1]);

						int i = 1;
						while (i <= x) {
							String linee = scan.nextLine();
							String[] tokenss = linee.replace(".", "").split(" is connected to ");
							String[] to = tokenss[1].split(", ");
							if (to.length > 1) {
								
								s.addnew(tokenss[0], to);
							} else {
								s.addconnection(tokenss[0], tokenss[1]);
							}
							i++;
							if (i == x + 1) {
								break;
							}
						}
				}		
		}
	}
}