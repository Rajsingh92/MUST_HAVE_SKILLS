import java.util.*;

class ARRAYLIST {
	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<Integer>(5);

		for (int i = 1; i <= list.size(); i++)
			list.add(i);

		//System.out.println(list);
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");

        ArrayList<String> nlist = new ArrayList<>();
  
        nlist.add("val1");
        nlist.add(1, "val2");
        nlist.set(1, "val updated");
        nlist.remove(1);
        nlist.remove("val1");
	}
}
