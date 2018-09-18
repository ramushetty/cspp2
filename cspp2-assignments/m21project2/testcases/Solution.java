import java.util.ArrayList;
import java.util.Scanner;

class foodLog {
	String nameoffooditem;
	String fquantity;
	String fctime;
	String fdate;
	foodLog(String nameoffooditem1, String quantity1, String fdate1, String time1) {
		this.nameoffooditem = nameoffooditem1;
		this.fquantity = quantity1;
		this.fctime = time1;
		this.fdate = fdate1;

	}
	String getnameoffooditem() {
		return nameoffooditem;
	}
	String getfquantity() {
		return fquantity;
	}
	String getfctime() {
		return fctime;
	}
	String getfdate() {
		return fdate;
	}
	void tostring() {
		System.out.println("Date:" + fdate);
		System.out.println("Time:" + fctime);
		System.out.println("Name:" + nameoffooditem);
		System.out.println("Quantity:" + fquantity);

		
		

	}


}

class waterlog {
	String wdate;
	String wquantity;
	waterlog(String quantity, String date) {
		this.wdate = date;
		this.wquantity = quantity;
	}
	String getwdate() {
		return wdate;
	}
	String getwquantity() {
		return wquantity;
	}
	// String getwtime() {
	// 	return wtime;
	// }
	void tostring() {
		System.out.println("Date:" + wdate);
		System.out.println("Quantity:" + wquantity + "ml");
	}
}

class physicalactivitylog {
	String activityname;
	String adate;
	String starttime;
	String endtime;
	String notes;
	physicalactivitylog(String activityname1, String notes1, String adate1, String starttime1, String endtime1) {
		this.activityname = activityname1;
		this.adate = adate1;
		this.starttime = starttime1;
		this.endtime = endtime1;
		this.notes = notes1;

	}
	String getactivityname() {
		return activityname;
	}
	String getadate() {
		return adate;
	}
	String getstarttime() {
		return starttime;
	}
	String getendtime() {
		return endtime;
	}
	String getnotes() {
		return notes;
	}
	void tostring() {
		System.out.println("Name:" + activityname);
		System.out.println("Notes:" + notes);
		System.out.println("Date:" + adate);
		System.out.println("starttime:" + starttime);
		System.out.println("Endtime:" + endtime);
	}
}

class weightLog {
	String weight;
	String fatpercent;
	String weightdate;
	String wtime;
	weightLog(String date1, String time1, String weight, String fatpercent1) {
		this.weight = weight;
		this.fatpercent = fatpercent1;
		this.weightdate = date1;
		this.wtime = time1;
	}
	String getweight() {
		return weight;
	}
	String getfatpercent() {
		return fatpercent;
	}
	String getweightdate() {
		return weightdate;
	}
	String getwtime() {
		return wtime;
	}
	void tostring() {
		System.out.println("Date:" + weightdate);
		System.out.println("Time:" + wtime);
		System.out.println("Weight:" + weight);
		System.out.println("Fat:" + fatpercent);
	}
}

class sleepLog {
	String ssdate;
	// String sedate;
	String sstarttime;
	String sendtime;
	sleepLog(String sdate1, String stime1, String stime2) {
		this.ssdate = sdate1;
		// this.sedate = sdate2;
		this.sstarttime = stime1;
		this.sendtime = stime2;
	}
	String getssdate() {
		return ssdate;
	}
	// String getsedate() {
	// 	return sedate;
	// }
	String getsstarttime() {
		return sstarttime;
	}
	String getsendtime() {
		return sendtime;
	}
	void tostring() {
		System.out.println("Date:" + ssdate);
		System.out.println("Starttime:" + sstarttime);
		System.out.println("Endtime:" + sendtime);
	}
}

class fitbyte {
	private ArrayList<foodLog> food;
	private ArrayList<waterlog> water;
	private ArrayList<physicalactivitylog> activitylog;
	private ArrayList<weightLog> weight;
	private ArrayList<sleepLog> sleep;
	private int countwater;
	private int countactivity;
	fitbyte() {
		food = new ArrayList<>();
		water = new ArrayList<>();
		activitylog = new ArrayList<>();
		weight = new ArrayList<>();
		sleep = new ArrayList<>();
		countwater = 0;
		countactivity = 0;
	}
	public void addfood(String[] items) {
		food.add(new foodLog(items[0], items[1], items[2], items[3]));
	}
	public void printfoodlog() {
		System.out.println("Food ");
		for (foodLog e : food) {
			System.out.println(e);

		}
		System.out.println();
	}
	public void addwater(String[] items) {
		water.add(new waterlog(items[0], items[1]));
		countwater++;
	}
	public void printwaterlog() {
		System.out.println("Water");
		for (int i = 0; i < countwater; i++) {
			water.get(i).tostring();
		}
		System.out.println();
	}
	public void addPhysicalActivity(String[] items) {
		activitylog.add(new physicalactivitylog(items[0], items[1], items[2], items[3], items[4]));
		countactivity++;
	}
	public void printactivitylog() {
		System.out.println("PhysicalActivity");
		if (countactivity > 0) {
			for (int i = 0; i < countactivity; i++) {
				activitylog.get(i).tostring();
				System.out.println();
			}
		} else {
			System.out.println("None");
			System.out.println();
		}
		
	}
	public void addweight(String[] items) {
		weight.add(new weightLog(items[0], items[1], items[2], items[3]));
	}

	public void printweightlog() {
		System.out.println("Weight");
		for (weightLog e : weight) {
			e.tostring();
			
		}
		System.out.println();
	}
	public void addsleep(String[] items) {
		sleep.add(new sleepLog(items[0], items[1], items[2]));
	}
	public void printsleeplog() {
		System.out.println("Sleep");
		for(sleepLog e : sleep) {
			e.tostring();
		}
		System.out.println();
	}
	public void printall() {
		System.out.println("Food ");
		for (foodLog e : food) {
			e.tostring();
			

		}
		System.out.println("Water");
		for (int i = 0; i < countwater; i++) {
			water.get(i).tostring();
		}
		System.out.println("PhysicalActivity");
		if (countactivity > 0) {
			for (int i = 0; i < countactivity; i++) {
				activitylog.get(i).tostring();
			}
		} else {
			System.out.println("None");
		}
		System.out.println("Weight");
		for (weightLog e : weight) {
			e.tostring();
		}
		System.out.println("Sleep");
		for(sleepLog e : sleep) {
			e.tostring();
		}
	}
	public void printallsort(String date) {
		System.out.println("Food");
		for (foodLog e : food) {
			if (date.equals(e.getfdate())) {
				e.tostring();
				
			}
		}
		System.out.println("Water");
		for (waterlog e : water) {
			if (date.equals(e.getwdate())) {
				e.tostring();
				
			}
		}
		System.out.println("PhysicalActivity");
		for (physicalactivitylog e : activitylog) {
			if (date.equals(e.getadate())) {
				e.tostring();
			
			}
		}
		System.out.println("Weight");
		for (weightLog e : weight) {
			if (date.equals(e.getweightdate())) {
				e.tostring();
		
			}
		}
		System.out.println("Sleep");
		for (sleepLog e : sleep) {
			if (date.equals(e.getssdate())) {
				e.tostring();
		
			}
		}
	}

}


public final class Solution {
	private Solution() {
	}
		public static void main(String[] args) {
			fitbyte f = new fitbyte();
			Scanner scan = new Scanner(System.in);
			while(scan.hasNext()) {
				String line = scan.nextLine();
				String[] tokens = line.split(" ");
				switch(tokens[0]) {
					case "Food":
						String[] token = tokens[1].split(",");
						f.addfood(token);
						break;
					case "Foodlog":
						f.printfoodlog();
						break;
					case "Water":
						String[] w = tokens[1].split(",");
						f.addwater(w);
						break;
					case "Waterlog":
						f.printwaterlog();
						break;
					case "PhysicalActivity":
						String[] p = tokens[1].split(",");
						f.addPhysicalActivity(p);
						break;
					case "PhysicalActivitylog":
						f.printactivitylog();
						break;
					case "Weight":
						String[] we = tokens[1].split(",");
						f.addweight(we);
						break;
					case "Weightlog":
						f.printweightlog();
						break;
					case "Sleep":
						String[] s = tokens[1].split(",");
						f.addsleep(s);
						break;
					case "Sleeplog":
						f.printsleeplog();
						break;
					case "Summary":
						if(tokens.length == 1) {
							f.printall();
						} else {
							f.printallsort(tokens[1]);
						}

						break;
					default:
						break;

				}
			}
		}
	
}