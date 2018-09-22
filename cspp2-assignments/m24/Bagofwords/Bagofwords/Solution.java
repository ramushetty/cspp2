import java.io.*;
import java.util.*;
class files {
	private  ArrayList<HashMap> fnames= new ArrayList<>();
	private HashMap<String, Integer> map;
    private ArrayList<String> valu = new ArrayList<>();



	// void newfiles
	public  void filter(String item) throws IOException {
		map = new HashMap<String, Integer>();
		Scanner txtfile = new Scanner(new File(item));
		while (txtfile.hasNext()) {
			String[] word = txtfile.next().split(" ");
			if (word.length != 0) {
				for (int i = 0; i < word.length; i++) {
				if (map.containsKey(word[i])) {
					int count = map.get(word[i]) + 1;
					map.put(word[i], count);
				} else {
					map.put(word[i], 1);
				}
				}
			} else {
				map.put("0", 0);
			}
			
		}
		txtfile.close();
		fnames.add(map);


	}

    public void bagofwords() {

        ArrayList<int[]> bag = new ArrayList<int[]> ();

        for (HashMap<String, Integer> i : fnames) {
            for (HashMap<String, Integer> j : fnames) {
                int totalcount = 0;
                int count1 = 0;
                int count2 = 0;
                int[] b = new int[3];

                for (String k : i.keySet()) {
                    count1 += i.get(k) * i.get(k);
                    // System.out.println(i.get(k));
                    count2 = 0;
                    for (String l : j.keySet()) {

                        count2 += j.get(l) * j.get(l);
                        if (k.equals(l)) {
                            totalcount += i.get(k) * j.get(l);
                        }
                    }
                }
                b[0] = count1;
                b[1] = count2;
                b[2] = totalcount;
                bag.add(b);
            }
        }
        String v1;
        for (int[] x : bag) {
        	v1 = Math.round((x[2] / (Math.sqrt(x[0]) * Math.sqrt(x[1]))) * 100) + "";
            valu.add(v1);
        }
    }
    public void printall(ArrayList<String> filenames, int size) {
    	int max = 0;
    	String file1 = "";
    	String file2 = "";

    	String[][] mat = new String[size][size];
    	int  k = 0;
    	int k2 = -1;
    	int v = 0;
    	for (int i = 0; i< size; i++) {
    		for (int j = 0; j < size; j++) {
    			if (i == 0 && j == 0) {
	    			mat[i][j] = "\t" + "\t";
	    		} else {

	    			if (i == 0 && j == j) {

		    			mat[i][j] = filenames.get(k) + "\t";
		    			k++;
	    			} else {
	    				if (i >= 1 && j == 0) {
	    					k2++;

	    					mat[i][j] = filenames.get(k2) + "\t";
		    			} else {

		    					mat[i][j] = valu.get(v) + "\t";
			    				// int temp = Integer.parseInt(valu.get(v)).replaceAll("\t", "");
			    				String temp = valu.get(v);
			    				// System.out.println(valu.get(v));
			    				int temp2 = Integer.parseInt(temp);
		    					if (max <= temp2 && temp2 != 100) {
		    						max = temp2;
		    						file1 = mat[i][0];
		    						file2 = mat[0][j];
		    					}
			    				v++;


		    			}
	    			}
	    		}
    		}
    		k = 0;
    	}

    	for (int i = 0; i< size; i++) {
    		for (int j = 0; j < size; j++) {
    			System.out.print(mat[i][j]);
    			
    		}
    		System.out.println();
    	}
    	System.out.println("Maximum similarity is between " + file2 + " and " + file1);
    }
}

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		ArrayList<String> sa = new ArrayList<>();
		ArrayList<String> filename = new ArrayList<>();
		files fa = new files();

		String t = in.nextLine();
		File folder = new File(t);
		File[] listFiles = folder.listFiles();
		if (listFiles.length != 0) {
			String fname;
			int ss = listFiles.length + 1;
			for(File file: listFiles){
				filename.add(file.getName());
				if (file.isFile()) {
					sa.add(t+'\\'+file.getName());
				}

			}


			for (String f : sa) {
				fa.filter(f);
			}
			fa.bagofwords();

			fa.printall(filename, ss);
		} else {
			System.out.println("Empty dictinory");
		}

	}



}
